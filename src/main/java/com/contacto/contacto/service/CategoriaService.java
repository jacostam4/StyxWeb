package com.contacto.contacto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.contacto.contacto.model.CategoriaModel;
import com.contacto.contacto.repository.CategoriaRepository;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaModel register(CategoriaModel categoria) {
        return categoriaRepository.save(categoria);
    }

    public CategoriaModel findById(long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public List<CategoriaModel> getAllCategorias() {
        return categoriaRepository.findAll();
    }
    
    public CategoriaModel updateCategoria(long id, CategoriaModel categoria) {
        return categoriaRepository.findById(id).map(existeCategoria -> {
            existeCategoria.setNombre(categoria.getNombre());
            return categoriaRepository.save(existeCategoria);
        }).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
    }
}
