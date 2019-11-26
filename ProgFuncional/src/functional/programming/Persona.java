package functional.programming;

import java.util.List;

import functional.programming.enums.Genero;

public class Persona {
	public String nombre;
	public Genero genero;
	public int edad;
	public List<String> telefonos;
	
	public Persona(String nombre, Genero genero, int edad, List<String> telefonos) {
		this.nombre = nombre;
		this.genero = genero;
		this.edad = edad;
		this.telefonos = telefonos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public List<String> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<String> telefonos) {
		this.telefonos = telefonos;
	}
}
 