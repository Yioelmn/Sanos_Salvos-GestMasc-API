package com.sanosysalvos.gestionmascotas.controller;

import com.sanosysalvos.gestionmascotas.model.EtiquetasModel;
import com.sanosysalvos.gestionmascotas.service.EtiquetasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/etiquetas")
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

    @DeleteMapping("/{id}")
    public void eliminarEtiqueta(@PathVariable Long id) {
        etiquetasService.eliminarEtiqueta(id);
    }
}