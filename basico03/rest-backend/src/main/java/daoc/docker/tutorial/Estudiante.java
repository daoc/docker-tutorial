package daoc.docker.tutorial;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Estudiante {
	
	Estudiante() {}
	
	public Estudiante(String nombre, String cedula) {
		this.nombre = nombre;
		this.cedula = cedula;
	}
	
	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private String cedula;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	@Override
	public String toString() {
		return String.format("Estudiante: %d / %s / %s", getId(), getCedula(), getNombre());
	}
}
