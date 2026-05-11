package com.sanosysalvos.gestionmascotas.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sanosysalvos.gestionmascotas.model.MascotaModel;
import com.sanosysalvos.gestionmascotas.repository.MascotaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    public List<MascotaModel> obtenerMascotas(){
        return mascotaRepository.findAll();
    }

    public MascotaModel obtenerMascotaPorId(Long id){
        return mascotaRepository.findById(id).orElse(null);
    }

    public MascotaModel guardarMascota(MascotaModel mascota){
        return mascotaRepository.save(mascota);
    }

    public MascotaModel actualizarMascota(Long id, MascotaModel mascotaActualizada){

        MascotaModel mascotaExistente = mascotaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));

        mascotaExistente.setNombre(mascotaActualizada.getNombre());
        mascotaExistente.setEspecie(mascotaActualizada.getEspecie());
        mascotaExistente.setRaza(mascotaActualizada.getRaza());
        mascotaExistente.setSexo(mascotaActualizada.getSexo());
        mascotaExistente.setEdad(mascotaActualizada.getEdad());
        mascotaExistente.setLatitud(mascotaActualizada.getLatitud());
        mascotaExistente.setLongitud(mascotaActualizada.getLongitud());
        mascotaExistente.setComuna(mascotaActualizada.getComuna());

        mascotaExistente.setEtiquetas(mascotaActualizada.getEtiquetas());

        return mascotaRepository.save(mascotaExistente);
    }

    public void eliminarMascota(Long id){
        mascotaRepository.deleteById(id);
    }

}