package com.example.contactList.service;

import com.example.contactList.entity.People;
import com.example.contactList.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public List<People> readCsv(String csvName) {
        List<People> peopleList = new ArrayList<>();
        try {
            InputStream resource = new ClassPathResource("data/" + csvName + ".csv").getInputStream();
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
        peopleRepository.saveAll(peopleList);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getPeople(String name, int page, int size) {
        try {
            Pageable paging = PageRequest.of(page, size);
            Page<People> peoplePage;
            if (name != null && !name.isEmpty()) {
                peoplePage = this.getPeopleByName(name, paging);
            } else {
                peoplePage = this.getAllPeople(paging);
            }
            Map<String, Object> response = new HashMap<>();
            List<People> peopleList = peoplePage.getContent();
            response.put("peopleList", peopleList);
            response.put("currentPage", peoplePage.getNumber());
            response.put("totalItems", peoplePage.getTotalElements());
            response.put("totalPages", peoplePage.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Page<People> getPeopleByName(String name, Pageable paging) {
        return peopleRepository.findByName(name, paging);
    }

    @Override
    public Page<People> getAllPeople(Pageable paging) {
        return peopleRepository.findAll(paging);
    }

}
