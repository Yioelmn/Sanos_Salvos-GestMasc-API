package com.sanosysalvos.gestionmascotas.controller;

import com.sanosysalvos.gestionmascotas.model.EtiquetasModel;
import com.sanosysalvos.gestionmascotas.service.EtiquetasService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/etiquetas")
public class EtiquetasController {

    private final EtiquetasService etiquetasService;

    public EtiquetasController(EtiquetasService etiquetasService) {
        this.etiquetasService = etiquetasService;
    }

    @GetMapping
    public List<EtiquetasModel> obtenerTodas() {
        return etiquetasService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Optional<EtiquetasModel> obtenerPorId(@PathVariable Long id) {
        return etiquetasService.obtenerPorId(id);
    }

    @PostMapping
    public EtiquetasModel crearEtiqueta(@RequestBody EtiquetasModel etiqueta) {
        return etiquetasService.crearEtiqueta(etiqueta);
    }

    @PutMapping("/{id}")
    public EtiquetasModel actualizarEtiqueta(
        @PathVariable Long id,
        @RequestBody EtiquetasModel etiqueta) {
            return etiquetasService.actualizarEtiquetas(id, etiqueta);
        }

    @DeleteMapping("/{id}")
    public void eliminarEtiqueta(@PathVariable Long id) {
        etiquetasService.eliminarEtiqueta(id);
    }
}