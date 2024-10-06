package com.example.mega_task.controllers;


import com.example.mega_task.entities.Book;
import com.example.mega_task.models.BookModel;
import com.example.mega_task.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<Book> create(@RequestBody BookModel bookModel){
        Book savedBook = bookService.createBook(bookModel);
        return ResponseEntity.ok(savedBook);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        Optional<Book> bookOptional = bookService.getById(id);
        return bookOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Book> updateProduct(@PathVariable Long id, @RequestBody BookModel bookModel) {
        Book book = bookService.updateBook(id, bookModel);
        return ResponseEntity.ok(book);
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Book> deleteProduct(@PathVariable Long id) {
        Book book = bookService.deleteBook(id);
        return ResponseEntity.ok(book);
    }
}
