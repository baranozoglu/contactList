package com.example.contactlist.entity;

import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Table(name = "People", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "url"}))
@Entity
@Data
@EnableAutoConfiguration
public class People {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;
}
