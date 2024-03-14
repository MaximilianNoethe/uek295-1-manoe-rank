package ch.noseryoung.uek2951manoerank.domain.user;


import ch.noseryoung.uek2951manoerank.domain.role.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "id_role", referencedColumnName = "role_id")
    private Role userRole;


}

