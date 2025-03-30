package arepetti.annonces.services;

import arepetti.annonces.dtos.UtilisateurDTO;
import arepetti.annonces.entities.Utilisateur;
import arepetti.annonces.repositories.UtilisateurRepository;
import arepetti.annonces.services.impls.UtilisateurServiceImpl;
import arepetti.annonces.utils.mappers.UtilisateurMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UtilisateurServiceImplTest {
    @Mock
    private UtilisateurRepository utilisateurRepository;

    @Mock
    private UtilisateurMapper utilisateurMapper;

    @InjectMocks
    private UtilisateurServiceImpl utilisateurService;

    @Test
    void getUtilisateurById_Success() {
        Integer id = 1;
        Utilisateur utilisateur = new Utilisateur();
        UtilisateurDTO expectedDto = new UtilisateurDTO();

        when(utilisateurRepository.findById(id)).thenReturn(Optional.of(utilisateur));
        when(utilisateurMapper.toDto(utilisateur)).thenReturn(expectedDto);
        
        UtilisateurDTO result = utilisateurService.getUtilisateurById(id);
        
        assertEquals(expectedDto, result);
        verify(utilisateurRepository).findById(id);
    }

    @Test
    void getUtilisateurById_NotFound() {
        Integer id = 99;
        when(utilisateurRepository.findById(id)).thenReturn(Optional.empty());
        
        assertThrows(RuntimeException.class, () -> utilisateurService.getUtilisateurById(id));
    }

    @Test
    void createUtilisateur_Success() {
        UtilisateurDTO inputDto = new UtilisateurDTO();
        Utilisateur entity = new Utilisateur();
        Utilisateur savedEntity = new Utilisateur();
        UtilisateurDTO expectedDto = new UtilisateurDTO();

        when(utilisateurMapper.toEntity(inputDto)).thenReturn(entity);
        when(utilisateurRepository.save(entity)).thenReturn(savedEntity);
        when(utilisateurMapper.toDto(savedEntity)).thenReturn(expectedDto);
        
        UtilisateurDTO result = utilisateurService.createUtilisateur(inputDto);
        
        assertEquals(expectedDto, result);
        verify(utilisateurRepository).save(entity);
    }
}
