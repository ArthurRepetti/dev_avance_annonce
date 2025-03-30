package arepetti.annonces.dtos;

import arepetti.annonces.utils.enums.Role;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UtilisateurDTO {
    private Integer idUtilisateur;
    @NotBlank(message = "Le pseudo est obligatoire.")
    private String pseudo;
    @NotNull(message = "Le rôle est obligatoire.")
    private Role role;
}
