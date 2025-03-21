package com.contacto.contacto.repository;

import com.contacto.contacto.model.ContactModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ContactRepository extends JpaRepository<ContactModel, Long> {
    Optional<ContactModel> findByEmail(String email);
}
