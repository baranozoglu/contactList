package com.example.contactlist;

import com.example.contactlist.repository.PeopleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UploadTest {

    @Autowired
    private PeopleRepository peopleRepository;

    @Test
    public void uploadDatabaseTest() throws Exception {
        assertThat(peopleRepository.findAll()).hasSize(816);
    }

}
