package com.sanosysalvos.gestionmascotas.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mascota")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MascotaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de la mascota es obligatorio")
    private String nombre;

    @NotBlank(message = "La especie de la mascota es obligatoria")
    private String especie;

    @NotBlank(message = "La raza de la mascota es obligatoria")
    private String raza;

    @NotBlank(message = "El sexo de la mascota es obligatoria")
    private String sexo;

    @NotNull(message = "La edad de la mascota es obligatoria")
    private int edad;

    @ManyToMany
    @JoinTable(
    name = "mascota_etiqueta",
    joinColumns = @JoinColumn(name = "mascota_id"),
    inverseJoinColumns = @JoinColumn(name = "etiqueta_id")
    )
    private List<EtiquetasModel> etiquetas;

    @JsonManagedReference
    @OneToMany(mappedBy = "mascota")
    private List<ImagenMascotaModel> imagenes;

}
