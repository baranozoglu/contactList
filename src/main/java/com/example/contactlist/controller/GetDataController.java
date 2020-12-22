package com.example.contactlist.controller;

import com.example.contactlist.dto.PageableDto;
import com.example.contactlist.entity.People;
import com.example.contactlist.service.GetDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping
public class GetDataController {

    @Autowired
    private GetDataService peopleService;

    @GetMapping(value = "/people")
    @ResponseBody
    public ResponseEntity<PageableDto<People>> getPeople(@RequestParam(required = false) String name,
                                                         @RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "10") int size) {
        ResponseEntity<PageableDto<People>> response = peopleService.getPeople(name, page, size);
        return response == null ? new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR) : response;
    }
}
