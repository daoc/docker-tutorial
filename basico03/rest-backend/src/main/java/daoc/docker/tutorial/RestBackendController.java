package daoc.docker.tutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestBackendController {

	@Autowired
	EstudianteRepository repository;
	
	@GetMapping("/estud")
	public List<Estudiante> getEstudiantes() {
		List<Estudiante> todos = new ArrayList<>();
		repository.findAll().forEach(todos::add);
		return todos;
	}
	
	@GetMapping("/estud/{id}")
	public Estudiante getEstud(@PathVariable("id") long id) {
		Optional<Estudiante> val = repository.findById(id);
		if(val.isPresent()) {
			return val.get();
		}
		return null;
	}
	
	@GetMapping("/estudNom/{nombre}")
	public List<Estudiante> getEstudNombre(@PathVariable("nombre") String texto) {
		return repository.findByNombreContaining(texto);
	}
	
	@PostMapping("/estud")
	public ResponseEntity<?> postEstud(@RequestBody Estudiante estud) {
		repository.save(estud);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/estud")
	public ResponseEntity<?> putEstud(@RequestBody Estudiante newEstud) {
		Estudiante estud = getEstud(newEstud.getId());
		if(estud != null) {
			estud.setCedula(newEstud.getCedula());
			estud.setNombre(newEstud.getNombre());
			repository.save(estud);
		} else {
			postEstud(newEstud);
		}
		return ResponseEntity.ok().build();
	}	
	
	@DeleteMapping("/estud/{id}")
	public ResponseEntity<?> deleteEstud(@PathVariable("id") long id) {
		repository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
