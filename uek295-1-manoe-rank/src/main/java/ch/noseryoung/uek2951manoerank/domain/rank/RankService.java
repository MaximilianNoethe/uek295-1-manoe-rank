package ch.noseryoung.uek2951manoerank.domain.rank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.management.InstanceAlreadyExistsException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;


@Service
public class RankService {
    @Autowired
    private RankRepository repository;

    public List<Rank> getAll() {
        return repository.findAll();
    }

    public Rank getById(int id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("The id " + id + " doesn't exist."));
    }

    public Rank addRank(Rank newRank) throws InstanceAlreadyExistsException {
        Rank existingRank = repository.findByRank(newRank.getRank());
        if (existingRank != null) {
            throw new InstanceAlreadyExistsException("A book with this rank already exists.");
        }
        return repository.save(newRank); // save -> Saves the new rank into database
    }

    public Rank updateRank(Rank rank, int id) throws InstanceAlreadyExistsException {
        if (!repository.existsById(id)) {
            throw new InstanceAlreadyExistsException("The id " + id + " does not exist.");
        }
        rank.setId(id);
        return repository.save(rank);
    }

    public void deleteRank(int id) {
        repository.deleteById(id);
    }

}
