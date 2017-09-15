package entity;

import java.io.Serializable;

public class Persona implements Serializable{
	private int id;
	private String nombre;
	private String apellido;
	private String dni;
	private boolean habilitado;
	private Categoria categoria;
	private String user;
	private String pass;
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Categoria getCategoria(){
		return categoria;
	}
	
	public void setCategoria(Categoria categoria){
		this.categoria=categoria;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	public Persona (String dni, String nombre, String apellido, boolean habilitado){
		this.setDni(dni);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setHabilitado(habilitado);
	}
	
	public Persona(){}
	
	@Override
	public boolean equals(Object p){
		return (p instanceof Persona) &&
			 (((Persona)p).getDni().equals(this.getDni()));
					

	}
}





