package com.example.DemoTestContainers.repository;

import com.example.DemoTestContainers.dto.Book;
import com.example.DemoTestContainers.dto.BookDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface BooksRepository  extends JpaRepository<Book,Long> {

       public Page<Book> findByTitle(String title, Pageable pPageable);

}
