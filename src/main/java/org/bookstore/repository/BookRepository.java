package org.bookstore.repository;

import org.bookstore.entities.Book;
import org.bookstore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<User, Long> {

    Book getBookById(Long id);

    List<Book> getBooksByIdIsNotNull();

    List<Book> findByTitleContainingIgnoreCase(String query);

}