package com.example.contactlist.service;

import com.example.contactlist.dto.PageableDto;
import com.example.contactlist.entity.People;
import com.example.contactlist.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GetDataServiceImpl implements GetDataService {
    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public ResponseEntity<PageableDto<People>> getPeople(String name, int page, int size) {
        try {
            Pageable paging = PageRequest.of(page, size);
            Page<People> peoplePage;
            peoplePage = this.getPeopleByName(name == null ? "" : name, paging);

            PageableDto<People> peoplePageableDto = new PageableDto<>();
            peoplePageableDto.setDataList(peoplePage.getContent());
            peoplePageableDto.setCurrentPage(peoplePage.getNumber());
            peoplePageableDto.setTotalItems(peoplePage.getTotalElements());
            peoplePageableDto.setTotalPages(peoplePage.getTotalPages());

            return new ResponseEntity<>(peoplePageableDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Page<People> getPeopleByName(String name, Pageable paging) {
        return peopleRepository.findByName(name, paging);
    }

    @Override
    public Page<People> getAllPeople(Pageable paging) {
        return peopleRepository.findAll(paging);
    }

}
