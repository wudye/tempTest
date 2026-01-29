package com.mwu.microservicedemo.service;

import com.mwu.microservicedemo.entity.Book;
import com.mwu.microservicedemo.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import java.util.Optional;


public class BookServiceTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        // Initialize mocks before each test
        org.mockito.MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetBookById() {
        Book book = new Book("Spring Boot", "John Doe", "1234567890");
        book.setId(1L);
        Mockito.when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        Optional<Book> findedBook = bookService.getBookById(1L);
        Assertions.assertEquals("spring boot", findedBook.get().getTitle().toLowerCase());

    }


}
