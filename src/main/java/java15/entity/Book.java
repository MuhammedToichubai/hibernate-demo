package java15.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Book {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_id_gen"
    )
    @SequenceGenerator(
            name = "book_id_gen",
            sequenceName = "book_seq_name",
            allocationSize = 1
    )
    private Long id;
    @Column(name = "name", length = 50)
    private String title;
    @Column(name = "author_full_name", unique = true)
    private String authorFullName;
    private BigDecimal price;

    public Book(String title, String authorFullName, BigDecimal price) {
        this.title = title;
        this.authorFullName = authorFullName;
        this.price = price;
    }
}
