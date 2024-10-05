package com.example.mega_task.service;

import com.example.mega_task.entities.Book;
import com.example.mega_task.models.BookModel;

import java.util.List;

public interface BookService {

    Book createBook(BookModel bookModel);

    List<Book> createBooks(List<BookModel> bookModels);

    Book getById(Long id);

    Book updateBook(BookModel bookModel);

    Book deleteBook(BookModel bookModel);


}
