package com.springtest.demo.userData.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springtest.demo.userData.repositories.BooksRepository;

@Controller
public class BookController {

    private final BooksRepository booksRepository;

    public BookController(
        BooksRepository booksRepository
    ) {
        this.booksRepository = booksRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books", booksRepository.findAll());

        return "books/list";
    }
}