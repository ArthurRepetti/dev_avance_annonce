package arepetti.annonces.utils.mappers;

import arepetti.annonces.dtos.AnnonceDTO;
import arepetti.annonces.entities.Annonce;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = UtilisateurMapper.class)
public interface AnnonceMapper extends GenericMapper<Annonce, AnnonceDTO> {

    AnnonceMapper INSTANCE = Mappers.getMapper(AnnonceMapper.class);

    @Mapping(source = "utilisateur.idUtilisateur", target = "idUtilisateur")
    AnnonceDTO toDto(Annonce annonce);

    @Mapping(target = "utilisateur", ignore = true) // Géré séparément dans le service
    Annonce toEntity(AnnonceDTO annonceDTO);
}
