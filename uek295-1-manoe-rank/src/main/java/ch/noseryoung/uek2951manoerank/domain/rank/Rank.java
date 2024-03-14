package ch.noseryoung.uek2951manoerank.domain.rank;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;


@Getter
@Setter
@Entity
@Table(name = "rank")
public class Rank {

    @Id
    @Column(name = "rank_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Positive(message = "Your ranking needs to be positive.")
    @NotNull(message = "Your rank need to be filled in.")
    @Column(name = "rank")
    private int rank;


    @PositiveOrZero(message = "Your buy count needs to be positive.")
    @Column(name = "buy_count")
    private int buyCount;


    @Column(name = "book_name")
    @Size(min = 1, max = 200, message = "Keep your book in character limit.")
    private String bookName;


    public Rank(int rank, int buyCount, String bookName) {
        this.rank = rank;
        this.buyCount = buyCount;
        this.bookName = bookName;
    }


    public Rank() {

    }
}
