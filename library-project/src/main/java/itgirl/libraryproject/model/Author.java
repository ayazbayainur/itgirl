package itgirl.libraryproject.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname", nullable = false)
    @Setter
    private String name;

    @Column(nullable = false)
    @Setter
    private String surname;

    @Column
    private Boolean active;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books = new ArrayList<>();



}
