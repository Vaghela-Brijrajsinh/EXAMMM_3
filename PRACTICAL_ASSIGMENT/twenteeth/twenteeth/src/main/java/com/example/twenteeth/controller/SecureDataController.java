package com.example.twenteeth.controller;

import com.example.twenteeth.entity.Note;
import com.example.twenteeth.repository.NoteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/secure/data")
public class SecureDataController {

    private final NoteRepository noteRepository;

    public SecureDataController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    // GET
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {

        return ResponseEntity.ok(noteRepository.findAll());
    }

    // POST
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {

        Note savedNote = noteRepository.save(note);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedNote);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(
            @PathVariable Long id,
            @RequestBody Note updatedNote) {

        return noteRepository.findById(id)
                .map(note -> {

                    note.setText(updatedNote.getText());

                    Note savedNote = noteRepository.save(note);

                    return ResponseEntity.ok(savedNote);
                })
                .orElseGet(() ->
                        ResponseEntity.notFound().build()
                );
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {

        if (!noteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        noteRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}