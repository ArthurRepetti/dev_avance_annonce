package arepetti.annonces.services;

import arepetti.annonces.dtos.AnnonceDTO;
import arepetti.annonces.entities.Annonce;
import arepetti.annonces.entities.Utilisateur;
import arepetti.annonces.repositories.AnnonceRepository;
import arepetti.annonces.repositories.UtilisateurRepository;
import arepetti.annonces.services.impls.AnnonceServiceImpl;
import arepetti.annonces.utils.mappers.AnnonceMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AnnonceServiceImplTest {

    @Mock
    private AnnonceRepository annonceRepository;

    @Mock
    private UtilisateurRepository utilisateurRepository;

    @Mock
    private AnnonceMapper annonceMapper;

    @InjectMocks
    private AnnonceServiceImpl annonceService;

    @Test
    void createAnnonce_Success() {
        // Arrange
        AnnonceDTO inputDto = new AnnonceDTO();
        inputDto.setIdUtilisateur(1);

        Utilisateur auteur = new Utilisateur();
        Annonce entity = mock(Annonce.class);
        Annonce savedAnnonce = new Annonce();
        AnnonceDTO expectedDto = new AnnonceDTO();

        when(annonceMapper.toEntity(inputDto)).thenReturn(entity);
        when(utilisateurRepository.findById(1)).thenReturn(Optional.of(auteur));
        when(annonceRepository.save(entity)).thenReturn(savedAnnonce);
        when(annonceMapper.toDto(savedAnnonce)).thenReturn(expectedDto);

        // Act
        AnnonceDTO result = annonceService.createAnnonce(inputDto);

        // Assert
        assertEquals(expectedDto, result);
        verify(entity).setUtilisateur(auteur);
        verify(entity).setDate(any(LocalDateTime.class));
    }

    @Test
    void getAnnoncesRecentFirst_Success() {
        // Arrange
        LocalDateTime now = LocalDateTime.now();
        Annonce annonce1 = new Annonce();
        annonce1.setDate(now.minusDays(1));

        Annonce annonce2 = new Annonce();
        annonce2.setDate(now);

        List<Annonce> annonces = Arrays.asList(annonce2, annonce1); // Déjà ordonné DESC

        when(annonceRepository.findAllByOrderByDateDesc()).thenReturn(annonces);
        when(annonceMapper.toDto(any(Annonce.class)))
                .thenAnswer(invocation -> {
                    Annonce a = invocation.getArgument(0);
                    AnnonceDTO dto = new AnnonceDTO();
                    dto.setDate(a.getDate()); // Ou setDateCreation selon votre DTO
                    return dto;
                });

        // Act
        List<AnnonceDTO> result = annonceService.getAnnoncesRecentFirst();

        // Assert
        assertEquals(2, result.size());
        assertTrue(result.get(0).getDate().isAfter(result.get(1).getDate()));
    }
}
