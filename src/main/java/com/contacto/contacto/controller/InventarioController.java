package com.contacto.contacto.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.contacto.contacto.model.InventarioModel;
import com.contacto.contacto.service.InventarioService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/inventario")
public class InventarioController {

    private final InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @PostMapping("/register")
    public ResponseEntity<InventarioModel> register(@RequestBody InventarioModel inventario) {
        return ResponseEntity.ok(inventarioService.register(inventario));
    }

    @GetMapping("/all")
    public ResponseEntity<List<InventarioModel>> getAllInventarios() {
        System.out.println("getAllInventarios ejecutando");
        return ResponseEntity.ok(inventarioService.getAllInventarios());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<InventarioModel> updateInventario(@PathVariable("id") long id, @RequestBody InventarioModel inventario) {
        return ResponseEntity.ok(inventarioService.updateInventario(id, inventario));
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<InventarioModel> getInventarioById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(inventarioService.getInventarioById(id));
    }

    @GetMapping("/producto/{idProducto}")
    public ResponseEntity<List<InventarioModel>> getByIdProducto(@PathVariable("idProducto") Long idProducto) {
        return ResponseEntity.ok(inventarioService.getInventariosByIdProducto(idProducto));
    }

    @GetMapping("/almacen/{idAlmacen}")
    public ResponseEntity<List<InventarioModel>> getByIdAlmacen(@PathVariable("idAlmacen") Long idAlmacen) {
        return ResponseEntity.ok(inventarioService.getInventariosByIdAlmacen(idAlmacen));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInventario(@PathVariable("id") Long id) {
        inventarioService.deleteInventario(id);
        return ResponseEntity.ok("Inventario eliminado correctamente");
    }

    @GetMapping("/buscar")
public ResponseEntity<List<InventarioModel>> buscar(
        @RequestParam(value = "productoId", required = false) Long productoId,
        @RequestParam(value = "tallaId", required = false) Long tallaId,
        @RequestParam(value = "categoriaId", required = false) Long categoriaId
) {
    List<InventarioModel> resultado = inventarioService.buscar(productoId, tallaId, categoriaId);
    return ResponseEntity.ok(resultado);
}
}
