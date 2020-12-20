package com.example.contactList.service;

import com.example.contactList.entity.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface PeopleService {
    List<People> readCsv(String csvName);
    Page<People> getAllPeople(Pageable paging);
    Page<People> getPeopleByName(String name, Pageable paging);
    ResponseEntity<Map<String, Object>> insertPeople(List<People> peopleList);
    ResponseEntity<Map<String, Object>> getPeople(String name, int page, int size);
}
