package ch.noseryoung.uek2951manoerank.domain.role;

import ch.noseryoung.uek2951manoerank.domain.authority.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {


    @Autowired
    private RoleRepository repository;

}