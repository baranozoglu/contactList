package com.example.contactList;

import com.example.contactList.controller.UploadDataController;
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
	public CommandLineRunner Upload(UploadDataController uploadController) {
		return args->{uploadController.uploadPeople("people");};
	}
}
