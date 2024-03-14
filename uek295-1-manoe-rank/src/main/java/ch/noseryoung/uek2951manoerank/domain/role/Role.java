package ch.noseryoung.uek2951manoerank.domain.role;


import ch.noseryoung.uek2951manoerank.domain.authority.Authority;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Identity ->
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "name")
    private String roleName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "rank_roles_authorities",
            joinColumns = {
                    @JoinColumn(name = "id_role", referencedColumnName = "role_id"),
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "id_authority", referencedColumnName = "authority_id")
            }
    )
    private Set<Authority> roleAuth; // set -> similar to List.
}
