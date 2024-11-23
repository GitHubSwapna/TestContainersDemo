package com.example.DemoTestContainers.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Book {


        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @Column(name = "id", nullable = false)
        private Long id;
        @Column(name = "title", nullable = false)
        private String title;
        @Column(name = "author", nullable = false)
        private String author;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Book book)) return false;
            return Objects.equals(id, book.id) && Objects.equals(title, book.title);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, title);
        }

    }

