package com.example.contactList.service;

import com.example.contactList.entity.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UploadDataService {
    List<People> readCsv(String csvName);
    ResponseEntity<Map<String, Object>> insertPeople(List<People> peopleList);
}
