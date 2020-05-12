package com.codeclan.example.filesfolders.repositories;

import com.codeclan.example.filesfolders.models.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
}
