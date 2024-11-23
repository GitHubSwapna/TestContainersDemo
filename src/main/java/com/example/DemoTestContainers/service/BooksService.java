package com.example.DemoTestContainers.service;

import com.example.DemoTestContainers.dto.Book;
import com.example.DemoTestContainers.dto.BookDTO;
import com.example.DemoTestContainers.dto.BookResponse;
import com.example.DemoTestContainers.repository.BooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
//@AllArgsConstructor
@RequiredArgsConstructor
public class BooksService {

    private final BooksRepository booksRepository;


    @Value("${books.page.number}")
    private Integer pageNumber;

    @Value("${books.page.size}")
    private Integer pageSize;

    public BookResponse getBooksByTitle(String title)
    {
        int pageNo = pageNumber < 1 ? 0 : pageNumber -1 ;
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.Direction.DESC, "title");
        Page<Book> page = booksRepository.findByTitle(title,pageable);
        return  new BookResponse(page);
    }

    public BookResponse getBooks()
    {
        int pageNo = pageNumber < 1 ? 0 : pageNumber -1 ;
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.Direction.DESC, "title");
        Page<Book> page = booksRepository.findAll(pageable);
        return  new BookResponse(page);

    }

    public Book createBook(Book b)
    {

        Book b1 = booksRepository.save(b);

        return b1;


    }

}
