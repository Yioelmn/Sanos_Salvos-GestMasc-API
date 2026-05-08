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

        MascotaModel mascota = mascotaRepository.findById(id).orElse(null);

        if(mascota != null){

            mascota.setNombre(mascotaActualizada.getNombre());
            mascota.setEspecie(mascotaActualizada.getEspecie());
            mascota.setRaza(mascotaActualizada.getRaza());
            mascota.setSexo(mascotaActualizada.getSexo());
            mascota.setEdad(mascotaActualizada.getEdad());
            mascota.setEtiquetas(mascotaActualizada.getEtiquetas());

            return mascotaRepository.save(mascota);
        }

        return null;
    }

    public void eliminarMascota(Long id){
        mascotaRepository.deleteById(id);
    }

}