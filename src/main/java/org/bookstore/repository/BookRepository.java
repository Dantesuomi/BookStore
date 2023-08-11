package org.bookstore.repository;

import org.bookstore.entities.Book;
import org.bookstore.entities.User;
import org.bookstore.enums.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface BookRepository extends JpaRepository<User, Long> {

    /*Book getBookById(Long id);

    List<Book> getBooksByIdIsNotNull();

    List<Book> findByTitleContainingIgnoreCase(String query);

    List<Book> findByGenreContainingIgnoreCase(Genre genre);

    List<Book> findByAuthorContainingIgnoreCase(String query);
*/
}
