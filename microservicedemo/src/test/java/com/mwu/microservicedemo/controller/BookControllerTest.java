package com.mwu.microservicedemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mwu.microservicedemo.entity.Book;
import com.mwu.microservicedemo.repository.BookRepository;
import com.mwu.microservicedemo.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired MockMvc mockMvc;
    @Autowired
    private BookService bookService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository.deleteAll();
        Book book = new Book("Spring Boot", "John Doe",
                "1234567890");
        bookRepository.save(book);
    }
    
    @Test
    public void testCreateBook() throws Exception{
        Book book = new Book();
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        book.setIsbn("1234567890");
        mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post("/api/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isOk());
    }

    @Test void findAll() throws Exception {
        MvcResult mc = mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk())
                .andReturn();
        System.out.println(mc.getResponse().getContentAsString());
        System.out.println("===================");
        System.out.println(mc);

    }
}
