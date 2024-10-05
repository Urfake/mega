package com.example.mega_task.service.impl;

import com.example.mega_task.entities.Book;
import com.example.mega_task.entities.Owner;
import com.example.mega_task.models.BookModel;
import com.example.mega_task.models.OwnerModel;
import com.example.mega_task.repos.OwnerRepository;
import com.example.mega_task.service.BookService;
import com.example.mega_task.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    OwnerRepository ownerRepository;
    @Autowired
    BookService bookService;


    @Override
    public Owner createOwner(OwnerModel ownerModel) {
        Owner owner = new Owner();
        owner.setName(ownerModel.getName());
        List<BookModel> bookModels = ownerModel.getBookModels();
        if (bookModels != null){
            bookModels.forEach(bookModel -> bookModel.setOwnerId(ownerModel.getId()));

            List<Book> books = bookService.createBooks(bookModels);
            if (books != null){
                owner.setBookList(books);
                books.forEach(book -> book.setOwner(owner));
            }
        }

        return owner;
    }

    @Override
    public Owner getById(Long id) {
        return ownerRepository.findById(id).get();
    }

    @Override
    public Owner updateOwner(OwnerModel ownerModel) {
        Owner owner = ownerRepository.findById(ownerModel.getId()).get();
        owner.setName(ownerModel.getName());

        return owner;
    }

    @Override
    public Owner deleteOwner(OwnerModel ownerModel) {
        Owner owner = ownerRepository.findById(ownerModel.getId()).get();
        ownerRepository.delete(owner);
        return owner;
    }
}
