package com.example.contactlist;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.contactlist.controller.GetDataController;
import com.example.contactlist.controller.UploadDataController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private GetDataController getDataController;

    @Autowired
    private UploadDataController uploadDataController;

    @Test
    public void getDataControllerContextLoads() throws Exception {
        assertThat(getDataController).isNotNull();
    }

    @Test
    public void uploadDataControllerContextLoads() throws Exception {
        assertThat(uploadDataController).isNotNull();
    }

}
