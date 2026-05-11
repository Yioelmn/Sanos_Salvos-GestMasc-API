package com.sanosysalvos.gestionmascotas.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sanosysalvos.gestionmascotas.model.ImagenMascotaModel;
import com.sanosysalvos.gestionmascotas.repository.ImagenMascotaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ImagenMascotaService {

    @Autowired
    private ImagenMascotaRepository imagenMascotaRepository;

    public List<ImagenMascotaModel> obtenerImagenes(){
        return imagenMascotaRepository.findAll();
    }

    public ImagenMascotaModel obtenerImagenMascotaPorId(Long id){
        return imagenMascotaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Imagen no encontrada"));
    }

    public ImagenMascotaModel guardarImagen(ImagenMascotaModel imagen){
        return imagenMascotaRepository.save(imagen);
    }

    public void eliminarImagen(Long id){
        imagenMascotaRepository.deleteById(id);
    }
}