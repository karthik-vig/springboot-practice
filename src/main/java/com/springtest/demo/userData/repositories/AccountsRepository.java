package com.springtest.demo.userData.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springtest.demo.userData.entity.Accounts;

public interface AccountsRepository extends CrudRepository<Accounts, Long> {
}
