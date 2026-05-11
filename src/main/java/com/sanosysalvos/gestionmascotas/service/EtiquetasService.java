package com.sanosysalvos.gestionmascotas.service;

import com.sanosysalvos.gestionmascotas.model.EtiquetasModel;
import com.sanosysalvos.gestionmascotas.repository.EtiquetasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtiquetasService {

    private final EtiquetasRepository etiquetasRepository;

    public EtiquetasService(EtiquetasRepository etiquetasRepository) {
        this.etiquetasRepository = etiquetasRepository;
    }

    public List<EtiquetasModel> obtenerTodas() {
        return etiquetasRepository.findAll();
    }

    public Optional<EtiquetasModel> obtenerPorId(Long id) {
        return etiquetasRepository.findById(id);
    }

    public EtiquetasModel crearEtiqueta(EtiquetasModel etiqueta) {
        return etiquetasRepository.save(etiqueta);
    }

    public EtiquetasModel actualizarEtiquetas(Long id, EtiquetasModel etiquetaActualizada){

        EtiquetasModel etiquetaExistente = etiquetasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Etiqueta no encontrada"));
                etiquetaExistente.setNombre_etiqueta(
                    etiquetaActualizada.getNombre_etiqueta()
                );
        return etiquetasRepository.save(etiquetaExistente);
    }

    public void eliminarEtiqueta(Long id) {
        etiquetasRepository.deleteById(id);
    }
}