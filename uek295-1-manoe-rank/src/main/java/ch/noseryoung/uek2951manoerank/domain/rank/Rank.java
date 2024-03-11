package ch.noseryoung.uek2951manoerank.domain.rank;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "rank")
public class Rank {

    @Id
    @Column(name = "rank_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "rank")
    private int rank;


    @Column(name = "buy_count")
    private int buyCount;


    @Column(name = "book_name")

    private String bookName;


    public Rank(int id, int rank, int buyCount, String bookId) {
        this.id = id;
        this.rank = rank;
        this.buyCount = buyCount;
        this.bookName = bookId;

    }

    public Rank() {

    }
}
