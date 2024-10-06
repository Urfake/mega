package com.example.mega_task.service.impl;

import com.example.mega_task.entities.Book;
import com.example.mega_task.repos.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void shouldReturnBooksFilteredByGenre() {
        Long id = 1L;
        List<Book> books = createBooks();

        Mockito.when(bookRepository.findById(id)).thenReturn(Optional.ofNullable(books.get(id.intValue())));

        Optional<Book> result = bookService.getById(id);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(Optional.ofNullable(books.get(id.intValue())), result);
    }

    private List<Book> createBooks() {
        Book firstBook = new Book();
        Book secondBook = new Book();

        firstBook.setId(1L);
        firstBook.setTitle("11 of September");
        firstBook.setAvailable(true);

        secondBook.setId(2L);
        secondBook.setTitle("Data science");
        secondBook.setAvailable(true);

        List<Book> bookList = new ArrayList<>();
        bookList.add(firstBook);
        bookList.add(secondBook);
        return bookList;
    }
}