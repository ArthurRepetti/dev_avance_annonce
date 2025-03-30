package arepetti.annonces.services.impls;

import arepetti.annonces.dtos.AnnonceDTO;
import arepetti.annonces.entities.Annonce;
import arepetti.annonces.entities.Utilisateur;
import arepetti.annonces.repositories.AnnonceRepository;
import arepetti.annonces.repositories.UtilisateurRepository;
import arepetti.annonces.services.interfaces.AnnonceService;
import arepetti.annonces.utils.mappers.AnnonceMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnonceServiceImpl implements AnnonceService {

    private final AnnonceRepository annonceRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final AnnonceMapper annonceMapper;

    public AnnonceServiceImpl(AnnonceRepository annonceRepository, UtilisateurRepository utilisateurRepository, AnnonceMapper annonceMapper) {
        this.annonceRepository = annonceRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.annonceMapper = annonceMapper;
    }

    @Override
    public List<AnnonceDTO> getAllAnnonces() {
        return annonceRepository.findAll()
                .stream()
                .map(annonceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AnnonceDTO getAnnonceById(Integer id) {
        Annonce annonce = annonceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Annonce non trouvée"));
        return annonceMapper.toDto(annonce);
    }

    @Override
    public List<AnnonceDTO> getAnnoncesRecentFirst() {
        return annonceRepository.findAllByOrderByDateDesc()
                .stream()
                .map(annonceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AnnonceDTO> getAnnoncesOldFirst() {
        return annonceRepository.findAllByOrderByDateAsc()
                .stream()
                .map(annonceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AnnonceDTO createAnnonce(AnnonceDTO annonceDTO) {
        Annonce annonce = annonceMapper.toEntity(annonceDTO);

        // Gestion de l'auteur
        Utilisateur auteur = utilisateurRepository.findById(annonceDTO.getIdUtilisateur())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        annonce.setUtilisateur(auteur);

        annonce.setDate(LocalDateTime.now());
        annonce = annonceRepository.save(annonce);
        return annonceMapper.toDto(annonce);
    }
}
