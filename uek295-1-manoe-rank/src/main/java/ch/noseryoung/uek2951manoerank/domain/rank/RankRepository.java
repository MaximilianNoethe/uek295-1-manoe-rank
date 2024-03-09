package ch.noseryoung.uek2951manoerank.domain.rank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RankRepository extends JpaRepository<Rank, Integer> {

}


