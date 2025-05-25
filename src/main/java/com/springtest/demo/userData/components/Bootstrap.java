package com.springtest.demo.userData.components;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springtest.demo.userData.entity.Accounts;
import com.springtest.demo.userData.entity.Books;
import com.springtest.demo.userData.entity.Publisher;
import com.springtest.demo.userData.repositories.AccountsRepository;
import com.springtest.demo.userData.repositories.BooksRepository;
import com.springtest.demo.userData.repositories.PublisherRepository;

@Component
public class Bootstrap implements CommandLineRunner {

    AccountsRepository accountsRepository;
    BooksRepository booksRepository;
    PublisherRepository publisherRepository;

    public Bootstrap(
        AccountsRepository acccAccountsRepository, 
        BooksRepository booksRepository,
        PublisherRepository publisherRepository
    ) {
        this.accountsRepository = acccAccountsRepository;
        this.booksRepository = booksRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Accounts account1 = new Accounts("John", "Doe");
        Books book1 = new Books("Book name 1", "12749087");
        Accounts account2 = new Accounts("Jane", "Doe");
        Books book2 = new Books("Book name 2", "129309821");
        Publisher publisher1 = new Publisher(
            "publisher name",
            "address 1",
            "some city",
            "some state",
            "60001",
            "United States"
        );
        publisherRepository.save(publisher1);

    
        book1.getAccounts().add(account1);
        book1.setPublisher(publisher1);
        account1.getBooks().add(book1);
        publisher1.getBooks().add(book1);
    
        accountsRepository.save(account1);
        booksRepository.save(book1);
    
        book2.getAccounts().add(account2);
        book2.setPublisher(publisher1);
        account2.getBooks().add(book2);
        publisher1.getBooks().add(book2);
    
        accountsRepository.save(account2);
        booksRepository.save(book2);
    
        System.out.println("The number of books are:");
        System.out.println(booksRepository.count());
        System.out.println("The number of accounts are:");
        System.out.println(accountsRepository.count());
    
        System.out.println("The number of saved publishers are:" + publisherRepository.count());
        System.out.println("The content of the publisher is: " + publisher1.toString());
        System.out.println("The publisher has the following books");
        publisher1.getBooks().forEach((Books book) -> System.out.println(book.toString()));

    }
    
}
