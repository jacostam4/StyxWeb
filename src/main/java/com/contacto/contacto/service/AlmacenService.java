package com.contacto.contacto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.contacto.contacto.model.AlmacenModel;
import com.contacto.contacto.repository.AlmacenRepository;

@Service
public class AlmacenService {

    private final AlmacenRepository almacenRepository;

    public AlmacenService(AlmacenRepository almacenRepository) {
        this.almacenRepository = almacenRepository;
    }
   
    //obtener todos los almacenes
    public List<AlmacenModel> getAllAlmacenes() {
        return almacenRepository.findAll();
    }

    //obtener almacen por id
    public AlmacenModel getAlmacenById(Long id) {
        return almacenRepository.findByIdAlmacen(id).orElse(null);
    }

    
}
