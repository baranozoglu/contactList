package com.example.contactlist.service;

import com.example.contactlist.dto.PageableDto;
import com.example.contactlist.entity.People;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UploadDataService {
    List<People> readCsv(String csvName);
    ResponseEntity<PageableDto<People>> insertPeople(List<People> peopleList);
}
