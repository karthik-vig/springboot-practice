package com.springtest.demo.userData.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springtest.demo.userData.entity.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
    
}
