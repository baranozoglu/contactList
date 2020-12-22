package com.example.contactlist;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class MockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void peopleEndPointTestWithName() throws Exception {
        this.mockMvc.perform(get("/people?name=simpson")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"dataList\": [\n" +
                        "        {\n" +
                        "            \"id\": 1,\n" +
                        "            \"name\": \"Homer Simpson\",\n" +
                        "            \"url\": \" https://vignette.wikia.nocookie.net/simpsons/images/b/bd/Homer_Simpson.png/revision/latest/scale-to-width-down/72?cb=20140126234206\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 2,\n" +
                        "            \"name\": \"Marge Simpson\",\n" +
                        "            \"url\": \" https://vignette.wikia.nocookie.net/simpsons/images/4/4d/MargeSimpson.png/revision/latest/scale-to-width-down/78?cb=20180314071936\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 3,\n" +
                        "            \"name\": \"Bart Simpson\",\n" +
                        "            \"url\": \" https://vignette.wikia.nocookie.net/simpsons/images/6/65/Bart_Simpson.png/revision/latest/scale-to-width-down/87?cb=20180319061933\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 4,\n" +
                        "            \"name\": \"Lisa Simpson\",\n" +
                        "            \"url\": \" https://vignette.wikia.nocookie.net/simpsons/images/5/57/Lisa_Simpson2.png/revision/latest/scale-to-width-down/74?cb=20180319000458\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 5,\n" +
                        "            \"name\": \"Maggie Simpson\",\n" +
                        "            \"url\": \" https://vignette.wikia.nocookie.net/simpsons/images/8/89/Maggie.png/revision/latest/scale-to-width-down/87?cb=20090115172358\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 6,\n" +
                        "            \"name\": \"Abraham Simpson II\",\n" +
                        "            \"url\": \" https://vignette.wikia.nocookie.net/simpsons/images/a/a9/Abraham_Simpson.png/revision/latest/scale-to-width-down/75?cb=20151011181838\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 265,\n" +
                        "            \"name\": \"Homer Simpson\",\n" +
                        "            \"url\": \" https://vignette.wikia.nocookie.net/simpsons/images/b/bd/Homer_Simpson.png/revision/latest/scale-to-width-down/58?cb=20140126234206\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 266,\n" +
                        "            \"name\": \"Marge Simpson\",\n" +
                        "            \"url\": \" https://vignette.wikia.nocookie.net/simpsons/images/0/0b/Marge_Simpson.png/revision/latest/scale-to-width-down/56?cb=20180626055729\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 267,\n" +
                        "            \"name\": \"Bart Simpson\",\n" +
                        "            \"url\": \" https://vignette.wikia.nocookie.net/simpsons/images/6/65/Bart_Simpson.png/revision/latest/scale-to-width-down/70?cb=20180319061933\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 268,\n" +
                        "            \"name\": \"Lisa Simpson\",\n" +
                        "            \"url\": \" https://vignette.wikia.nocookie.net/simpsons/images/e/ec/Lisa_Simpson.png/revision/latest/scale-to-width-down/58?cb=20130818181431\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"currentPage\": 0,\n" +
                        "    \"totalItems\": 60,\n" +
                        "    \"totalPages\": 6\n" +
                        "}"));
    }

    @Test
    public void peopleEndPointTestWithNameAndPage() throws Exception {
        this.mockMvc.perform(get("/people?name=simpson&page=1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"dataList\": [\n" +
                        "        {\n" +
                        "            \"id\": 269,\n" +
                        "            \"name\": \"Maggie Simpson\",\n" +
                        "            \"url\": \" https://vignette.wikia.nocookie.net/simpsons/images/9/9d/Maggie_Simpson.png/revision/latest/scale-to-width-down/70?cb=20130424150432\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 270,\n" +
                        "            \"name\": \"Abraham Simpson II\",\n" +
                        "            \"url\": \" https://vignette.wikia.nocookie.net/simpsons/images/a/a9/Abraham_Simpson.png/revision/latest/scale-to-width-down/61?cb=20151011181838\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 271,\n" +
                        "            \"name\": \"Mona Simpson\",\n" +
                        "            \"url\": \" https://vignette.wikia.nocookie.net/simpsons/images/5/52/IMG_1693.PNG/revision/latest/scale-to-width-down/36?cb=20170103165130\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 273,\n" +
                        "            \"name\": \"Abbie Simpson\",\n" +
                        "            \"url\": \" https://vignette.wikia.nocookie.net/simpsons/images/0/0c/Abbie.png/revision/latest/scale-to-width-down/97?cb=20130325071151\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 274,\n" +
                        "            \"name\": \"Picard Simpson\",\n" +
                        "            \"url\": \" https://vignette.wikia.nocookie.net/simpsons/images/8/82/Bart%27s_eldest_son.png/revision/latest/scale-to-width-down/36?cb=20141028004949\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 275,\n" +
                        "            \"name\": \"Kirk Simpson\",\n" +
                        "            \"url\": \" https://vignette.wikia.nocookie.net/simpsons/images/f/fb/Bart%27s_youngest_son.png/revision/latest/scale-to-width-down/45?cb=20141028004843\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 280,\n" +
                        "            \"name\": \"Dulcine Simpson\",\n" +
                        "            \"url\": \" https://vignette.wikia.nocookie.net/simpsons/images/e/e2/29.jpg/revision/latest?cb=20110224131420\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 281,\n" +
                        "            \"name\": \"Eckhardt Simpson\",\n" +
                        "            \"url\": \" https://vignette.wikia.nocookie.net/simpsons/images/1/1f/Ekhardt.jpg/revision/latest?cb=20110516202257\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 286,\n" +
                        "            \"name\": \"Hortense Simpson\",\n" +
                        "            \"url\": \" https://vignette.wikia.nocookie.net/simpsons/images/2/2f/Hortense_simpson.jpg/revision/latest/scale-to-width-down/97?cb=20130302185112\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 287,\n" +
                        "            \"name\": \"Hubert Simpson\",\n" +
                        "            \"url\": \" https://vignette.wikia.nocookie.net/simpsons/images/8/8b/Hubert.JPG/revision/latest/scale-to-width-down/97?cb=20081020213512\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"currentPage\": 1,\n" +
                        "    \"totalItems\": 60,\n" +
                        "    \"totalPages\": 6\n" +
                        "}"));;
    }

    @Test
    public void peopleEndPointTestWithNameAndPageAndSize() throws Exception {
        this.mockMvc.perform(get("/people?name=simpson&page=2&size=2")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"dataList\": [\n" +
                        "        {\n" +
                        "            \"id\": 5,\n" +
                        "            \"name\": \"Maggie Simpson\",\n" +
                        "            \"url\": \" https://vignette.wikia.nocookie.net/simpsons/images/8/89/Maggie.png/revision/latest/scale-to-width-down/87?cb=20090115172358\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 6,\n" +
                        "            \"name\": \"Abraham Simpson II\",\n" +
                        "            \"url\": \" https://vignette.wikia.nocookie.net/simpsons/images/a/a9/Abraham_Simpson.png/revision/latest/scale-to-width-down/75?cb=20151011181838\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"currentPage\": 2,\n" +
                        "    \"totalItems\": 60,\n" +
                        "    \"totalPages\": 30\n" +
                        "}"));;
    }
}