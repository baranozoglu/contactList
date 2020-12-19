package com.example.contactList.service;

import com.example.contactList.entity.People;

import java.util.List;

public interface FileUploadService {
    List<People> readCsv(String csvName);
    void insertPeople(List<People> peopleList);
}
