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
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataServiceImpl implements DataService {
    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public ResponseEntity<Map<String, Object>> getPeople(String name, int page, int size) {
        try {
            Pageable paging = PageRequest.of(page, size);
            Map<String, Object> response = new HashMap<>();
            Page<People> peoplePage;
            if (name != null && !name.isEmpty()) {
                peoplePage = this.getPeopleByName(name, paging);
            } else {
                peoplePage = this.getAllPeople(paging);
            }
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
