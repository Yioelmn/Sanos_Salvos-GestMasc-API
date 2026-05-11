package com.sanosysalvos.gestionmascotas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sanosysalvos.gestionmascotas.model.EtiquetasModel;

@Repository
public interface EtiquetasRepository extends JpaRepository<EtiquetasModel, Long>{
    
}
