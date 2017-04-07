package clases;

public class Padre {

	private String nombre;
	private static String nombreClase;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public static String getNombreClase() {
		return nombreClase;
	}
	public static void setNombreClase(String nombreClase) {
		Padre.nombreClase = nombreClase;
	}
	
	public String getDesc(){
		return "Objeto: "+this.getNombre();
	}
	
}
