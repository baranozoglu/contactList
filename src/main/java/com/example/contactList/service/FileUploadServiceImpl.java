package com.example.contactList.service;

import com.example.contactList.entity.People;
import com.example.contactList.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public List<People> readCsv(String csvName) {
        List<People> peopleList = new ArrayList<>();
        try {
            InputStream resource = new ClassPathResource("data/" + csvName).getInputStream();
            BufferedReader csvReader = new BufferedReader(new InputStreamReader(resource));
            String row;
            while ((row = csvReader.readLine()) != null) {
                People people = new People();
                String[] data = row.split(",");
                if (data[0].equals("name") || data[1].equals("url"))
                    continue;
                people.setName(data[0]);
                people.setUrl(data[1]);
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
    public void insertPeople(List<People> peopleList) {
        try {
            peopleRepository.saveAll(peopleList);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e);
        }
    }
}
