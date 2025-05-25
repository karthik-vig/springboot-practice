package com.springtest.demo.userData.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springtest.demo.userData.entity.Books;

public interface BooksRepository extends CrudRepository<Books, Long> {
}
