package com.tugasdocker6.deploy.repository;

import com.tugasdocker6.deploy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
