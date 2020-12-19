package com.example.contactList.controller;

import com.example.contactList.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/file")
public class FileUploadController{
    @Autowired
    private FileUploadService fileUploadService;

    @GetMapping(value = "/upload")
    @ResponseBody
    public void fileUpload(String csvName) {
        fileUploadService.insertPeople(fileUploadService.readCsv(csvName));
    }
}
