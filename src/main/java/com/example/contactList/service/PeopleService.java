package com.example.contactList.service;

import com.example.contactList.entity.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface PeopleService {
    List<People> readCsv(String csvName);
    void insertPeople(List<People> peopleList);
    Page<People> getPeopleByName(String name, Pageable paging);
    Page<People> getAllPeople(Pageable paging);
    ResponseEntity<Map<String, Object>> getPeople(String name, int page, int size);
}
