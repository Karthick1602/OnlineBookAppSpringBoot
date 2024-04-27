package com.online.bookapp.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.online.bookapp.domain.ERoles;
import com.online.bookapp.domain.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERoles name);
}