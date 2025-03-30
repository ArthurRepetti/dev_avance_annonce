package arepetti.annonces.services.interfaces;

import arepetti.annonces.dtos.UtilisateurDTO;

import java.util.List;

public interface UtilisateurService {
    List<UtilisateurDTO> getAllUtilisateurs();
    UtilisateurDTO getUtilisateurById(Integer id);
    UtilisateurDTO createUtilisateur(UtilisateurDTO utilisateurDTO);
}
