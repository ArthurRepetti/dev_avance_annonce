package arepetti.annonces.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "annonce")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_annonce")
    private Integer idAnnonce;

    @Column(name = "titre", nullable = false)
    private String titre;

    @Column(name = "texte", columnDefinition = "TEXT")
    private String texte;

    @Column(name = "date_creation", nullable = false)
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;
}
