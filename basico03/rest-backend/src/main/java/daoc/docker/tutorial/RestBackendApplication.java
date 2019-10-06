package daoc.docker.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RestBackendApplication {

	@Autowired
	EstudianteRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(RestBackendApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		repository.save(new Estudiante("Tres", "333"));
//		repository.save(new Estudiante("Cuatro", "444"));
//		repository.findAll().forEach(e -> System.out.println(e));
//		System.out.println("---");
//		repository.findByNombreContaining("n").forEach(e -> System.out.println(e));
//		System.out.println("---");
//		repository.findByNombreContaining("D").forEach(e -> System.out.println(e));
//  }
}
