package uce.edu.web.api.auth.representation;

import java.time.LocalDateTime;

import uce.edu.web.api.auth.domain.Vehiculo;

public class VehiculoRepresentation {

	public Integer id;
	public String marca;
	public String chasis;
	public String modelo;
	public LocalDateTime fechaFabriacion;
	public LocalDateTime fechaMatricula;

	public VehiculoRepresentation() {}

	public VehiculoRepresentation(Vehiculo v) {
		if (v == null) return;
		this.id = v.getId();
		this.marca = v.getMarca();
		this.chasis = v.getChasis();
		this.modelo = v.getModelo();
		this.fechaFabriacion = v.getFechaFabriacion();
		this.fechaMatricula = v.getFechaMatricula();
	}

	public Vehiculo mapperToV() {
		Vehiculo v = new Vehiculo();
		v.setId(this.id);
		v.setMarca(this.marca);
		v.setChasis(this.chasis);
		v.setModelo(this.modelo);
		v.setFechaFabriacion(this.fechaFabriacion);
		v.setFechaMatricula(this.fechaMatricula);
		return v;
	}

}
