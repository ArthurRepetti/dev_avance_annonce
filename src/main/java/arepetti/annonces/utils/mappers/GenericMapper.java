package arepetti.annonces.utils.mappers;

public interface GenericMapper<E, D> {
    D toDto(E entity);
    E toEntity(D dto);
}
