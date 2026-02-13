package uce.edu.web.api.auth.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Vehiculo")
@SequenceGenerator(name = "vehiculo_sec", sequenceName = "vehiculo_secuencia", allocationSize = 1)
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehiculo_sec")
    private Integer id;

    private String marca;
    private String chasis;
    private String modelo;
    private LocalDateTime fechaFabriacion;
    private LocalDateTime fechaMatricula;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDateTime getFechaFabriacion() {
        return fechaFabriacion;
    }

    public void setFechaFabriacion(LocalDateTime fechaFabriacion) {
        this.fechaFabriacion = fechaFabriacion;
    }

    public LocalDateTime getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(LocalDateTime fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

}
