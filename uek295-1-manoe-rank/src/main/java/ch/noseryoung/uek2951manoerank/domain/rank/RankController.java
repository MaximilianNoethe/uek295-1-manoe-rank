package ch.noseryoung.uek2951manoerank.domain.rank;


import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/rank")
public class RankController {
    @Autowired
    private RankService service;


    @GetMapping("/all")
    @PreAuthorize("hasAuthority('GET')")
    @Operation(summary = "Get all ranks", description = "Takes all rated book and returns a JSON with the status code 200")
    public List<Rank> getAll() { // -> List -> A list from Rank
        return service.getAll();
    }

    @GetMapping("/{rankId}")
    @PreAuthorize("hasAuthority('GET')")
    @Operation(summary = "Get a rank by id", description = "Takes a singular ranked book and returns a JSON with the status code 200")
    public ResponseEntity<Rank> getById(@PathVariable("rankId") int id) throws InstanceNotFoundException {
        Rank rank = service.getById(id);
        return ResponseEntity.ok().body(service.getById(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('POST')")
    @Operation(summary = "Creates a new rank", description = "Creates a new rank and provide it with an auto generated id")
    public ResponseEntity<Rank> addRank(@Valid @RequestBody Rank newRank) throws InstanceAlreadyExistsException {
        return ResponseEntity.status(201).body(service.addRank(newRank));
    }

    @PutMapping("/{rankId}")
    @PreAuthorize("hasAuthority('PUT')")
    @Operation(summary = "Updates rank by id", description = "Updates the data of selected rank by its id and returns a JSON with the status code 200")
    public ResponseEntity<Rank> updateRank(@Valid @PathVariable("rankId") int id, @RequestBody Rank rank) throws InstanceNotFoundException, InstanceAlreadyExistsException {
        return ResponseEntity.status(200).body(service.updateRank(rank, id));
    }


    @DeleteMapping("/{rankId}")
    @PreAuthorize("hasAuthority('DELETE')")
    @Operation(summary = "Deletes a rank by id", description = "Deletes a rank by its id and returns a string that says \"The id \" + id + \" has been deleted\"")
    public String deleteRank(@Valid @PathVariable("rankId") int id) throws InstanceNotFoundException {
        service.deleteRank(id);
        return "The id " + id + " has been deleted";
    }


    @ExceptionHandler(InstanceAlreadyExistsException.class)
    public ResponseEntity<String> rankInstanceAlreadyExistsException(InstanceAlreadyExistsException iaee) { // iaee -> InstanceAlreadyExistsException
        return ResponseEntity.status(409).body(iaee.getMessage());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> rankMethodArgumentNotValidException(MethodArgumentNotValidException manve) {
        return ResponseEntity.status(400).body((manve.getFieldError()).getDefaultMessage());
    }


    @ExceptionHandler(InstanceNotFoundException.class)
    public ResponseEntity<String> rankInstanceNotFoundException(InstanceNotFoundException infe) {
        return ResponseEntity.status(404).body(infe.getMessage());
    }


}
