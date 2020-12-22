package com.example.contactlist.repository;

import com.example.contactlist.entity.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PeopleRepository extends JpaRepository<People, Long> {

    @Query("Select p from People p where lower(p.name) like lower(concat('%', :name,'%'))")
    Page<People> findByName(@Param("name") String name,@Param("pageable") Pageable pageable);

}
