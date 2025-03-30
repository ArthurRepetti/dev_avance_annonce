package arepetti.annonces.repositories;

import arepetti.annonces.entities.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnnonceRepository extends JpaRepository<Annonce, Integer> {

    @Query("SELECT a FROM Annonce a ORDER BY a.date DESC")
    List<Annonce> findAllByOrderByDateDesc();

    @Query("SELECT a FROM Annonce a ORDER BY a.date ASC")
    List<Annonce> findAllByOrderByDateAsc();
}
