package com.codeclan.example.filesfolders.repositories;

import com.codeclan.example.filesfolders.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
