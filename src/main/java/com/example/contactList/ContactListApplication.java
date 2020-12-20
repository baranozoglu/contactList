package com.example.contactList;

import com.example.contactList.controller.UploadController;
import com.example.contactList.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ContactListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactListApplication.class, args);
	}

	@Bean
	public CommandLineRunner Upload(UploadController uploadController) {
		return args->{uploadController.uploadPeople("people");};
	}
}
