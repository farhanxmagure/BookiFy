package com.app.Security.repository;

import com.app.Security.data.ERole;
import com.app.Security.data.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}