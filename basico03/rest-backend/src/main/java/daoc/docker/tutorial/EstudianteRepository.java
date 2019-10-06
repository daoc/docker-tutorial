package daoc.docker.tutorial;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EstudianteRepository extends CrudRepository<Estudiante, Long> {
	List<Estudiante> findByNombreContaining(String nombre);
}
