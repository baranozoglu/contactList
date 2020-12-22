package com.example.contactlist;

import com.example.contactlist.controller.GetDataController;
import com.example.contactlist.dto.PageableDto;
import com.example.contactlist.entity.People;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ContactListApplicationTests {

	@Test
	void contextLoads(){
		List<People> peopleList = new ArrayList<>();
		peopleList.add(new People((long) 1,"Homer Simpson", "https://vignette.wikia.nocookie.net/simpsons/images/b/bd/Homer_Simpson.png/revision/latest/scale-to-width-down/72?cb=20140126234206"));
		peopleList.add(new People((long) 2,"Marge Simpson", "https://vignette.wikia.nocookie.net/simpsons/images/4/4d/MargeSimpson.png/revision/latest/scale-to-width-down/78?cb=20180314071936"));
		peopleList.add(new People((long) 3,"Bart Simpson", "https://vignette.wikia.nocookie.net/simpsons/images/6/65/Bart_Simpson.png/revision/latest/scale-to-width-down/87?cb=20180319061933"));
		peopleList.add(new People((long) 4,"Lisa Simpson", "https://vignette.wikia.nocookie.net/simpsons/images/5/57/Lisa_Simpson2.png/revision/latest/scale-to-width-down/74?cb=20180319000458"));
		peopleList.add(new People((long) 5,"Maggie Simpson", "https://vignette.wikia.nocookie.net/simpsons/images/8/89/Maggie.png/revision/latest/scale-to-width-down/87?cb=20090115172358"));

		PageableDto<People> peoplePageableDto = new PageableDto<>();
		peoplePageableDto.setDataList(peopleList);
		peoplePageableDto.setCurrentPage(0);
		peoplePageableDto.setTotalItems(60L);
		peoplePageableDto.setTotalPages(12);

		GetDataController getDataController = new GetDataController();
		ResponseEntity<PageableDto<People>> responseEntity =  getDataController.getPeople("homer",0,5);
		assertEquals(new ResponseEntity<>(peoplePageableDto, HttpStatus.OK),responseEntity);
	}

}
