package com.example.DemoTestContainers;

import com.example.DemoTestContainers.dto.Book;

import com.example.DemoTestContainers.repository.BooksRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoTestContainersApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTestContainersApplication.class, args);
	}

	@Autowired
	BooksRepository booksRepository;

	@PostConstruct
	public void saveData(){

		Book b1 = new Book();
		b1.setTitle("eatthatfrog");
		b1.setAuthor("Miller");
		booksRepository.save(b1);
		Book b2 = new Book();
		b2.setTitle("moneymgmt");
		b2.setAuthor("John");
		booksRepository.save(b2);
		Book b3 = new Book();
		b3.setTitle("auto");
		b3.setAuthor("Ananda");
		booksRepository.save(b3);
		Book b4 = new Book();
		b4.setTitle("eatthatfrog");
		b4.setAuthor("john");
		booksRepository.save(b4);

		Book b5 = new Book();
		b5.setTitle("eatthatfrog");
		b5.setAuthor("john");
		booksRepository.save(b5);
	}

}
