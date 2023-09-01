package com.workintech.Library.Rest.Api.service;

import com.workintech.Library.Rest.Api.entity.Book;
import com.workintech.Library.Rest.Api.entity.Category;

import java.util.List;

public interface BookService {
    List<Book> find();
    Book findById(int id);
    Book save(Book book);
    void delete(Book book);
}

