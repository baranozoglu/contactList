package com.example.contactlist.service;

import com.example.contactlist.dto.PageableDto;
import com.example.contactlist.entity.People;
import com.example.contactlist.repository.PeopleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

@Service
public class UploadDataServiceImpl implements UploadDataService {

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private GetDataService dataService;

    private Logger logger = LoggerFactory.getLogger(UploadDataServiceImpl.class);

    @Transactional
    @Override
    public List<People> readCsv(String csvName) {
        List<People> peopleList = new ArrayList<>();
        //bufferedReader and inputStream are closed with try-with-resources automatically
        try (InputStream resource = new ClassPathResource("data/" + csvName.replaceAll("[^a-zA-Z0-9]", "")  + ".csv").getInputStream();
             BufferedReader csvReader = new BufferedReader(new InputStreamReader(resource))) {
            String row;
            while ((row = csvReader.readLine()) != null) {
                People people = new People();
                StringBuilder stringBuilder = new StringBuilder();
                String[] data = row.split(",");
                if (data[0].equals("name") || data[1].equals("url"))
                    continue;
                for (int i = 0; i < data.length - 1; i++) {
                    stringBuilder.append(data[i]);
                }
                people.setName(stringBuilder.toString());
                people.setUrl(data[data.length - 1]);
                peopleList.add(people);
            }
            return peopleList;
        } catch (Exception e) {
            logger.error(String.format("Something went wrong: %s", e ));
            return peopleList;
        }
    }

    @Override
    public ResponseEntity<PageableDto<People>> insertPeople(List<People> peopleList) {
        peopleRepository.saveAll(peopleList);
        return dataService.getPeople("", 0, 10);
    }
}
