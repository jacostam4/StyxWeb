package com.contacto.contacto.service;

import com.contacto.contacto.model.ContactModel;
import com.contacto.contacto.repository.ContactRepository;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    // Eliminar PasswordEncoder del constructor
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public ContactModel register(ContactModel contact) {
        // Guardar la contraseña en texto plano (⚠️ NO recomendado para producción)
        return contactRepository.save(contact);
    }

    public Optional<ContactModel> findByEmail(String email, String rawPassword) {
        return contactRepository.findByEmail(email)
            .filter(contact -> contact.getPassword().equals(rawPassword)); // Comparación directa (No seguro)
    }
}
