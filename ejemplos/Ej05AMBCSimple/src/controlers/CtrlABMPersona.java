package controlers;

import java.util.ArrayList;

import entity.Persona;

public class CtrlABMPersona {

	private ArrayList<Persona> pers;
	
	public CtrlABMPersona(){
		pers= new ArrayList<Persona>();
		pers.add(new Persona("12121212","Juan", "Perez",true));
		pers.add(new Persona("13131313","Fulano", "De Tal",true));
	}
	
	public void add(Persona p) {
		this.pers.add(p);
	}
	
	public void delete(Persona p){
		//this.pers.remove(this.getByDni(p));
		this.pers.remove(p);
	}
	
	public void update(Persona p){
		this.delete(p);
		this.add(p);
	}
	
	public Persona getByDni(Persona p){
		return this.pers.get(this.pers.indexOf(p));
		//return this.getByDni(p.getDni());
	}
	
	public Persona getByDni(String dni){
		Persona p=new Persona();
		p.setDni(dni);
		return getByDni(p);
		/*for (int i=0; i < this.pers.size(); i++){
			if(pers.get(i).getDni().equals(dni)) {
				return pers.get(i);
				
			}
		}
		return null; //ver error si falta
		*/
	}
	
	public Persona getByNombreApellido(Persona p){
		
		for (int i=0; i < this.pers.size(); i++){
			if(pers.get(i).getNombre().equalsIgnoreCase(p.getNombre())
				&& pers.get(i).getApellido().equalsIgnoreCase(p.getApellido())) {
				return pers.get(i);		
			}
		}
		return null; //ver error si falta
		
	}
	
	public ArrayList<Persona> getAll(){
		return this.pers;
	}
}
