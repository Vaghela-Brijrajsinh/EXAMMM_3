package com.example.twenteeth.repository;

import com.example.twenteeth.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}