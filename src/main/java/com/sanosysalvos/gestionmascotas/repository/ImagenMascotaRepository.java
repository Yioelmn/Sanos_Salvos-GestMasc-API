package com.sanosysalvos.gestionmascotas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sanosysalvos.gestionmascotas.model.ImagenMascotaModel;

public interface ImagenMascotaRepository extends JpaRepository<ImagenMascotaModel, Long> {
}