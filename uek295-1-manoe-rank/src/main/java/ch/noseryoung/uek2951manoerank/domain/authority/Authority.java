package ch.noseryoung.uek2951manoerank.domain.authority;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "authority")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_id")
    private Integer authorityId;

    @Column(name = "name")
    private String authorityName;
}