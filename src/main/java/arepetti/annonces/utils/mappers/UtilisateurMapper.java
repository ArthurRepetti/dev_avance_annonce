package arepetti.annonces.utils.mappers;

import arepetti.annonces.dtos.UtilisateurDTO;
import arepetti.annonces.entities.Utilisateur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper extends GenericMapper<Utilisateur, UtilisateurDTO> {

    UtilisateurMapper INSTANCE = Mappers.getMapper(UtilisateurMapper.class);

    UtilisateurDTO toDto(Utilisateur utilisateur);

    @Mapping(target = "mdp", ignore = true)
    Utilisateur toEntity(UtilisateurDTO utilisateurDTO);
}
