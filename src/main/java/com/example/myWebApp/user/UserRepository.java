package com.example.myWebApp.user;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Integer> {
    public Long countById(Integer id);
}
