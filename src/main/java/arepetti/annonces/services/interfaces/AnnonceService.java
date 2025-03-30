package arepetti.annonces.services.interfaces;

import arepetti.annonces.dtos.AnnonceDTO;

import java.util.List;

public interface AnnonceService {
    List<AnnonceDTO> getAllAnnonces();
    AnnonceDTO getAnnonceById(Integer id);
    List<AnnonceDTO> getAnnoncesRecentFirst();
    List<AnnonceDTO> getAnnoncesOldFirst();
    AnnonceDTO createAnnonce(AnnonceDTO annonceDTO);
}
