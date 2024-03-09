package ch.noseryoung.uek2951manoerank.domain.rank;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/rank")
public class RankController {
    @Autowired
    private RankService service;


    @GetMapping("/all")
    public List<Rank> getAll() {
        return service.getAll();
    }


    @GetMapping("/{rankId}")
    public ResponseEntity<Rank> getById(@PathVariable("rankId") int id) {
        Rank rank = service.getById(id);
        return ResponseEntity.ok().body(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Rank> addRank(Rank newRank) {
        return ResponseEntity.status(201).body(service.addRank(newRank));
    }

    @PutMapping("/{rankId")
    public ResponseEntity<Rank> updateRank(@PathVariable("rankId") int id, Rank rank) throws InstanceAlreadyExistsException {
        return ResponseEntity.status(200).body(service.updateRank(rank, id));
    }


    @DeleteMapping("/{rankId")
    public String deleteRank(@PathVariable("rankId") int id) {
        service.deleteRank(id);
        return "The id " + id + " has been deleted";
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> rankNoSuchElementException(NoSuchElementException nsee) { // nsee -> NoSuchElementException
        return ResponseEntity.status(404).body(nsee.getMessage());
    }

    @ExceptionHandler(InstanceAlreadyExistsException.class)
    public ResponseEntity<String> rankInstanceAlreadyExistsException(InstanceAlreadyExistsException iaee) { // iaee -> InstanceAlreadyExistsException
        return ResponseEntity.status(409).body(iaee.getMessage());
    }

}
