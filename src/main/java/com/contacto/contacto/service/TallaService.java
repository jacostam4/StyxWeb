package com.contacto.contacto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.contacto.contacto.model.TallaModel;
import com.contacto.contacto.repository.TallaRepository;

@Service
public class TallaService {
    private final TallaRepository tallaRepository;
    
    public TallaService(TallaRepository tallaRepository) {
        this.tallaRepository = tallaRepository;
    }


    //obtener todas las tallas
    public List<TallaModel> getAllTallas() {
        return tallaRepository.findAll();
    }
}
