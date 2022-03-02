package com.spring.blog.repository;

import com.spring.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {


    Optional<User> findByUserName(String username);
}
