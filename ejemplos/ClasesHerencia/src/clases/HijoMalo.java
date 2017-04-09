package clases;

public class HijoMalo extends Padre {

	private String apellido;

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
	
	public HijoMalo(String apellido){
		super("Hijo");
		this.setApellido(apellido);
	}
	
	@Override
	public String getDesc(){
		return "Datos: "+this.getNombre()+" "+this.getApellido();
	}
}
