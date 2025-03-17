package com.VijayProject.FullStack_Backend.repository;

import com.VijayProject.FullStack_Backend.model.User; // Correct import
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositary extends JpaRepository<User, Long> {  // Correct entity used
}
