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

    public Rank addRank(Rank newRank) {
        return repository.save(newRank); // save -> Saves the new rank into database
    }

    public Rank updateRank(Rank rank, int id) throws InstanceAlreadyExistsException {
        if (!repository.existsById(rank.getId())) {
            return repository.save(rank);
        } else if (Objects.equals(rank.getId(), id)) {
            throw new InstanceAlreadyExistsException("The id " + id + " already exists.");
        }
        return null;
    }

    public void deleteRank(int id){
        repository.deleteById(id);
    }



}
