package ch.noseryoung.uek2951manoerank.domain.rank;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
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

    @NotNull
    @Column(name = "rank")
    private int rank;

    @NotNull
    @PositiveOrZero
    @Column(name = "buy_count")
    private int buyCount;


    @Column(name = "book_name")
    @Size(min = 1, max = 200, message = "Your book surpasses the character limit.")
    private String bookName;


    public Rank(int rank, int buyCount, String bookName) {
        this.rank = rank;
        this.buyCount = buyCount;
        this.bookName = bookName;
    }


    public Rank() {

    }
}
