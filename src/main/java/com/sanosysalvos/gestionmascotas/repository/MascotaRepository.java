package com.sanosysalvos.gestionmascotas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sanosysalvos.gestionmascotas.model.MascotaModel;

@Repository
public interface MascotaRepository extends JpaRepository<MascotaModel, Long>{
    
}
