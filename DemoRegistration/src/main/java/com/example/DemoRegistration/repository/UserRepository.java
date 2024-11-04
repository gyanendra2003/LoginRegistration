package com.example.DemoRegistration.repository;

import com.example.DemoRegistration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
