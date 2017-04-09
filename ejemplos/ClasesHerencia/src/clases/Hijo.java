package clases;

public class Hijo extends Padre {

	public Hijo(){
		this.setNombre("Hijo por defecto");
	}
	public Hijo(String nombre){
		this.setNombre(nombre);
	}
	
	@Override
	public String getDesc(){
		return super.getDesc()
				+ " de la clase "+ Hijo.getNombreClase();
	}
	
	public String algo(){
		return "algo";
	}

}
