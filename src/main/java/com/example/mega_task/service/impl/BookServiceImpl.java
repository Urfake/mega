package com.example.mega_task.service.impl;

import com.example.mega_task.entities.Book;
import com.example.mega_task.models.BookModel;
import com.example.mega_task.repos.BookRepository;
import com.example.mega_task.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;
    @Override
    public Book createBook(BookModel bookModel) {
        Book book = new Book();

        book.setTitle(bookModel.getTitle());
        book.setAvailable(true);
        bookRepository.save(book);
        return book;
    }

    @Override
    public List<Book> createBooks(List<BookModel> bookModels) {
        List<Book> books = new ArrayList<>();

        for (BookModel bookModel : bookModels){
            Book book = new Book();
            book.setTitle(bookModel.getTitle());
            book.setAvailable(bookModel.isAvailable());

            books.add(book);
        }
        return books;
    }

    @Override
    public Optional<Book> getById(Long id) {
        try{
            return bookRepository.findById(id);
        } catch (Exception e){
            throw new RuntimeException("Failed to find book by ID: " + e.getMessage());
        }
    }

    @Override
    public Book updateBook(Long id, BookModel bookModel) {
        Book book = bookRepository.findById(id).get();

        book.setTitle(bookModel.getTitle());
        book.setAvailable(bookModel.isAvailable());
        if (book.getOwner() != null){
            book.setOwner(bookRepository.findById(bookModel.getOwnerId()).get().getOwner());
        }
        else book.setOwner(null);

        bookRepository.save(book);
        return book;
    }

    @Override
    public Book deleteBook(Long id) {
        Book book = bookRepository.findById(id).get();
        bookRepository.delete(book);
        return book;
    }
}
