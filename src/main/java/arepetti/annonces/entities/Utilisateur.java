package arepetti.annonces.entities;

import arepetti.annonces.utils.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "utilisateur")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilisateur")
    private Integer idUtilisateur;

    @Column(name = "pseudo", nullable = false, unique = true)
    private String pseudo;

    @Column(name = "mdp", nullable = true)
    private String mdp;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;
}
