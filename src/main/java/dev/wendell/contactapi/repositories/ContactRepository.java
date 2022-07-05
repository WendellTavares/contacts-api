package dev.wendell.contactapi.repositories;

import dev.wendell.contactapi.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findAllByOrderByNomeAsc();

    @Query("SELECT obj  FROM Contact obj WHERE obj.status = :status ORDER BY obj.nome")
    List<Contact> findAllByStatusIs(boolean status);
}
