package com.example.nine.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nine.model.Book;

@RestController
@RequestMapping("/api/books")
public class BookRestController {

    private List<Book> books = new ArrayList<>();

    // POST
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {

        book.setId(books.size() + 1);
        books.add(book);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(book);
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {

        return ResponseEntity.ok(books);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id) {

        for (Book book : books) {
            if (book.getId() == id) {
                return ResponseEntity.ok(book);
            }
        }

        return ResponseEntity.notFound().build();
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(
            @PathVariable int id,
            @RequestBody Book newBook) {

        for (Book book : books) {

            if (book.getId() == id) {

                book.setTitle(newBook.getTitle());
                book.setAuthor(newBook.getAuthor());
                book.setPrice(newBook.getPrice());

                return ResponseEntity.ok(book);
            }
        }

        return ResponseEntity.notFound().build();
    }

    // DELETE
    // DELETE
@DeleteMapping("/{id}")
public ResponseEntity<String> deleteBook(@PathVariable int id) {

    for (Book book : books) {

        if (book.getId() == id) {

            books.remove(book);

            return ResponseEntity.ok("Book Deleted Successfully");
        }
    }

    return ResponseEntity.notFound().build();
}
}