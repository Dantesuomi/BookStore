package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Year;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Book {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO);
    private Long id;
    private String title;
    private Double price;
    private String bookAuthor;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Year publicationYear;
}
