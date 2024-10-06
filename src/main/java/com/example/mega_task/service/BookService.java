package com.example.mega_task.service;

import com.example.mega_task.entities.Book;
import com.example.mega_task.models.BookModel;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Book createBook(BookModel bookModel);

    List<Book> createBooks(List<BookModel> bookModels);

    Optional<Book> getById(Long id);

    Book updateBook(Long id, BookModel bookModel);

    Book deleteBook(Long id);


}
