package com.betterfy.repository;

import com.betterfy.entity.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by nik on 1/5/17.
 */

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {


    public User findByfirstName(String firstName);

}