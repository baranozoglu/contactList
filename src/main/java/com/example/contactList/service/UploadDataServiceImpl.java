package com.example.contactList.service;

import com.example.contactList.entity.People;
import com.example.contactList.repository.PeopleRepository;
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

    @Transactional
    @Override
    public List<People> readCsv(String csvName) {
        List<People> peopleList = new ArrayList<>();
        try {
            InputStream resource = new ClassPathResource("data/" + csvName + ".csv").getInputStream();
            BufferedReader csvReader = new BufferedReader(new InputStreamReader(resource));
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
            csvReader.close();
            return peopleList;
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e);
            return peopleList;
        }
    }

    @Override
    public ResponseEntity<Map<String, Object>> insertPeople(List<People> peopleList) {
            peopleRepository.saveAll(peopleList);
            return dataService.getPeople("",0,10);
    }
}
