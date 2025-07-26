package com.springtest.demo.userData.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springtest.demo.userData.repositories.AccountsRepository;

@Controller
public class AuthorController {
    
    private AccountsRepository accountsRepository;

    AuthorController(
        AccountsRepository accountsRepository
    ) {
        this.accountsRepository = accountsRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {

        model.addAttribute("authors", accountsRepository.findAll());

        return "authors/list";
    }
}
