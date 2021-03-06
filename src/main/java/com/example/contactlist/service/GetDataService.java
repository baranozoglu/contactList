package com.example.contactlist.service;

import com.example.contactlist.dto.PageableDto;
import com.example.contactlist.entity.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface GetDataService {
    Page<People> getPeopleByName(String name, Pageable paging);
    ResponseEntity<PageableDto<People>> getPeople(String name, int page, int size);
}
