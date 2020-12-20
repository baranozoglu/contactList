package com.example.contactList.service;

import com.example.contactList.entity.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface DataService {
    Page<People> getAllPeople(Pageable paging);
    Page<People> getPeopleByName(String name, Pageable paging);
    ResponseEntity<Map<String, Object>> getPeople(String name, int page, int size);
}
