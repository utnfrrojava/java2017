package entidades;

public abstract class Empleado {

	private String nombre;
	private String apellido;
	private double sueldoBase;
	private double importeVentas;
	
	public double getImporteVentas() {
		return importeVentas;
	}
	public void setImporteVentas(double ventas) {
		this.importeVentas = ventas;
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
	public double getSueldoBase() {
		return sueldoBase;
	}
	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	
	public abstract double getSueldo();
	
	public Empleado(String nombre, String apellido, double sueldoBase, double importeVentas){
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setSueldoBase(sueldoBase);
		this.setImporteVentas(importeVentas);
	}
}
