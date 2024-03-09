package ch.noseryoung.uek2951manoerank.domain.rank;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;


@Getter
@Entity
public class Rank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int rank;

    private int buyCount;

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
