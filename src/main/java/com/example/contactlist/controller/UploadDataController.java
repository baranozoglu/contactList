package com.example.contactlist.controller;

import com.example.contactlist.dto.PageableDto;
import com.example.contactlist.entity.People;
import com.example.contactlist.service.UploadDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping
public class UploadDataController {

    @Autowired
    private UploadDataService uploadService;

    @GetMapping(value = "/upload")
    @ResponseBody
    public ResponseEntity<PageableDto<People>> uploadPeople(String csvName) {
        return uploadService.insertPeople(uploadService.readCsv(csvName));
    }
}
