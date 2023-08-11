package org.bookstore.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Year;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.bookstore.enums.Genre;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @NotEmpty
    private String title;
    @NotNull
    @NotEmpty
    private Double price;
    @NotNull
    @NotEmpty
    private String author;
    @NotNull
    @NotEmpty
    private Genre genre;
    @NotNull
    @NotEmpty
    private Year publicationYear;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
