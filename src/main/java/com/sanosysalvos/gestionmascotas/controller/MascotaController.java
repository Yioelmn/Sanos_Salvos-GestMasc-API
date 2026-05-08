package com.sanosysalvos.gestionmascotas.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sanosysalvos.gestionmascotas.model.MascotaModel;
import com.sanosysalvos.gestionmascotas.service.MascotaService;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @GetMapping
    public List<MascotaModel> obtenerMascota(){
        return mascotaService.obtenerMascotas();
    }

    @GetMapping("/{id}")
    public MascotaModel obtenerMascotaPorId(@PathVariable Long id){
        return mascotaService.obtenerMascotaPorId(id);
    }

    @PostMapping
    public MascotaModel crearMascota(@RequestBody MascotaModel mascota){
        return mascotaService.guardarMascota(mascota);
    }

    // Actualizar mascota
    @PutMapping("/{id}")
    public MascotaModel actualizarMascota(@PathVariable Long id, @RequestBody MascotaModel mascota){
        return mascotaService.actualizarMascota(id, mascota);
    }

    // Eliminar mascota
    @DeleteMapping("/{id}")
    public String eliminarMascota(@PathVariable Long id){
        mascotaService.eliminarMascota(id);
        return "Mascota eliminada correctamente";
    }

}