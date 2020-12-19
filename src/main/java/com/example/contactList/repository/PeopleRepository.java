package com.example.contactList.repository;

import com.example.contactList.entity.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Long> {
    Page<People> findByName(String name, Pageable pageable);
}
