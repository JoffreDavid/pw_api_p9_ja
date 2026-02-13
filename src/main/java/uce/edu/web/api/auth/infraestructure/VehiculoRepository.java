package uce.edu.web.api.auth.infraestructure;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import uce.edu.web.api.auth.domain.Vehiculo;

@ApplicationScoped
public class VehiculoRepository implements PanacheRepository<Vehiculo> {

	public Vehiculo buscarPorChasis(String chasis) {
		return find("chasis", chasis).firstResult();
	}

}
