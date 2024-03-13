package ch.noseryoung.uek2951manoerank.domain.rank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class RankService {
    @Autowired
    private RankRepository repository;

    public List<Rank> getAll() {
        return repository.findAll();
    }

    public Rank getById(int id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Rank with id " + id + " could not be found."));
    }

    public Rank addRank(Rank newRank) throws InstanceAlreadyExistsException {
        Rank existingRank = repository.findByRank(newRank.getRank());
        if (existingRank != null) {
            throw new InstanceAlreadyExistsException("A book with this rank already exists.");
        }
        return repository.save(newRank); // save -> Saves the new rank into database
    }

    public Rank updateRank(Rank rank, int id) throws InstanceNotFoundException, InstanceAlreadyExistsException {
        Rank existingRank = repository.findByRank(rank.getRank());
        if (!repository.existsById(id)) { // existsById -> Boolean to look if the id exists or not.
            throw new InstanceNotFoundException("Rank with id " + id + " could not be found.");
        } else if (existingRank != null) {
            throw new InstanceAlreadyExistsException("A book with this rank already exists. Change the other rank before updating this book.");
        }
        rank.setId(id);
        return repository.save(rank);
    }

    public void deleteRank(int id) throws InstanceNotFoundException {
        if (!repository.existsById(id)) {
            throw new InstanceNotFoundException("Rank with id " + id + " could not be found.");
        }

        repository.deleteById(id);
    }

}
