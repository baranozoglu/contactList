package com.example.contactList.controller;

import com.example.contactList.service.DataService;
import com.example.contactList.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @GetMapping(value = "/upload")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> uploadPeople(String csvName) {
        return uploadService.insertPeople(uploadService.readCsv(csvName));
    }
}
