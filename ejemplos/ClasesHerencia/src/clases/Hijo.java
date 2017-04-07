package clases;

public class Hijo extends Padre {

	public String getDesc(){
		return super.getDesc()
				+ " de la clase "+ Hijo.getNombreClase();
	}
	
	public String algo(){
		return "algo";
	}
}
