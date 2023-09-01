package com.workintech.Library.Rest.Api.controller;

import com.workintech.Library.Rest.Api.entity.Author;
import com.workintech.Library.Rest.Api.entity.Book;
import com.workintech.Library.Rest.Api.service.AuthorService;
import com.workintech.Library.Rest.Api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/author")
public class AuthorController {
    private AuthorService authorService;
    private BookService bookService;

    @Autowired
    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<Author> find() {
        return authorService.find();
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable int id) {
        return authorService.findById(id);
    }

    @PostMapping("/")
    public Author save(@RequestBody Author author) {
        System.out.println(author.getBookList());
        return authorService.save(author);
    }
    @PostMapping("/{bookId}")
    public Author saveByBookId(@RequestBody Author author, @PathVariable int bookId){
        Book book = bookService.findById(bookId);
        author.getBookList().add(book);
        book.setAuthor(author);
        return authorService.save(author);
    }

    @PutMapping("/{id}")
    public Author update(@RequestBody Author author, @PathVariable int id) {
        Author foundAuthor = authorService.findById(id);
        if (foundAuthor != null) {
            author.setId(id);
            return authorService.save(author);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Author delete(@PathVariable int id) {
        Author author = authorService.findById(id);
        authorService.delete(author);
        return author;
    }
}
