package arepetti.annonces.controllers;

import arepetti.annonces.dtos.AnnonceDTO;
import arepetti.annonces.services.interfaces.AnnonceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/annonces")
public class AnnonceController {

    private final AnnonceService annonceService;

    public AnnonceController(AnnonceService annonceService) {
        this.annonceService = annonceService;
    }

    @GetMapping
    public List<AnnonceDTO> getAllAnnonces() {
        return annonceService.getAllAnnonces();
    }

    @GetMapping("/{id}")
    public AnnonceDTO getAnnonceById(@PathVariable Integer id) {
        return annonceService.getAnnonceById(id);
    }

    @GetMapping("/recentes")
    public List<AnnonceDTO> getAnnoncesRecentFirst() {
        return annonceService.getAnnoncesRecentFirst();
    }

    @GetMapping("/anciennes")
    public List<AnnonceDTO> getAnnoncesOldFirst() {
        return annonceService.getAnnoncesOldFirst();
    }

    @PostMapping
    public AnnonceDTO createAnnonce(@Valid @RequestBody AnnonceDTO annonceDTO) {
        return annonceService.createAnnonce(annonceDTO);
    }
}
