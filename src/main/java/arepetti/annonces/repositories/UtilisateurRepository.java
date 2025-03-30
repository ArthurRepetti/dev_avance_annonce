package arepetti.annonces.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import arepetti.annonces.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
}
