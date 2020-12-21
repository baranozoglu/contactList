package com.example.contactList.controller;

import com.example.contactList.service.GetDataService;
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
public class GetDataController {

    @Autowired
    private GetDataService peopleService;

    @GetMapping(value = "/people")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getPeople(@RequestParam(required = false) String name,
                                                         @RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "10") int size) {
        return peopleService.getPeople(name, page, size);
    }
}
