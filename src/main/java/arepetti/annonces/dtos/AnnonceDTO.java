package arepetti.annonces.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnnonceDTO {
    private Integer idAnnonce;
    @NotBlank(message = "Le titre est obligatoire.")
    private String titre;
    @NotBlank(message = "Le texte est obligatoire.")
    private String texte;
    private LocalDateTime date;
    @NotNull(message = "Un utilisateur doit être associé à l'annonce.")
    private Integer idUtilisateur;
}
