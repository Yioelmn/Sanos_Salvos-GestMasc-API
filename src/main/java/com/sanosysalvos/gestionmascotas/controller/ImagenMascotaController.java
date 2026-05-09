package com.sanosysalvos.gestionmascotas.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sanosysalvos.gestionmascotas.model.ImagenMascotaModel;
import com.sanosysalvos.gestionmascotas.service.ImagenMascotaService;


@RestController
@RequestMapping("/api/imagenes-mascota")
public class ImagenMascotaController {

    @Autowired
    private ImagenMascotaService imagenMascotaService;

    @GetMapping
    public List<ImagenMascotaModel> obtenerImagenes(){
        return imagenMascotaService.obtenerImagenes();
    }

    @DeleteMapping("/{id}")
    public void eliminarImagen(@PathVariable Long id){
        imagenMascotaService.eliminarImagen(id);
    }
}