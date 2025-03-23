package com.contacto.contacto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.contacto.contacto.model.RolModel;
import com.contacto.contacto.repository.RolRepository;

@Service
public class RolService {
    private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public RolModel register(RolModel rol) {
        return rolRepository.save(rol);
    }

    public List<RolModel> getAllRoles() {
        return rolRepository.findAll();
    }

    public RolModel getRolById(Long id) {
        Optional <RolModel> rol = rolRepository.findById(id);
        if (rol.isPresent()) {
            return rol.get();
        }
        else {
            throw new RuntimeException("Rol no encontrado");
        }        
    }

    public RolModel updateRol(Long id, RolModel rol) {
        return rolRepository.findById(id).map(existeRol -> {
            existeRol.setNombre(rol.getNombre());
            return rolRepository.save(existeRol);
        }).orElseThrow(() -> new RuntimeException("Rol no encontrado"));
    }


}
