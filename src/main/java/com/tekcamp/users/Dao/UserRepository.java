package com.tekcamp.users.Dao;

import org.springframework.data.repository.CrudRepository;

import com.tekcamp.users.Model.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
