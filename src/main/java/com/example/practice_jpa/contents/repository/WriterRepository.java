package com.example.practice_jpa.contents.repository;

import com.example.practice_jpa.contents.model.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface WriterRepository extends JpaRepository<Writer,Long> {
    Optional<Writer> findByEmail(String email);
}
