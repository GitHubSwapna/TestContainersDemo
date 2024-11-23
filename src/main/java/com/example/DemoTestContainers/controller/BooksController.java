package com.example.DemoTestContainers.controller;

import com.example.DemoTestContainers.dto.Book;
import com.example.DemoTestContainers.dto.BookDTO;
import com.example.DemoTestContainers.dto.BookResponse;
import com.example.DemoTestContainers.service.BooksService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;

    @GetMapping("/{title}")
    public BookResponse getBooksByTitle(@PathVariable String title)
    {
        return booksService.getBooksByTitle(title);
    }

    @GetMapping("/all")
    public BookResponse getBooks()
    {
        return booksService.getBooks();
    }

    @PostMapping("/create")
    public BookDTO createBook(@RequestBody @Valid BookDTO dto)
    {
        ObjectMapper map = new ObjectMapper();

        Book c = booksService.createBook(map.convertValue(dto, Book.class));
        return map.convertValue(c, BookDTO.class);
    }




}
