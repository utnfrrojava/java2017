package controlers;

import java.util.ArrayList;

import data.DataCategoria;
import data.DataPersona;
import entity.Categoria;
import entity.Persona;

public class CtrlABMPersona {

	private DataPersona dataPer;
	private DataCategoria dataCat;
	
	
	public CtrlABMPersona(){
		dataPer = new DataPersona();
		dataCat = new DataCategoria();
	}
	
	public void add(Persona p) throws Exception{
		dataPer.add(p);
	}
	
	public void delete(Persona p)throws Exception{
		dataPer.remove(p);
	}
	
	public void update(Persona p)throws Exception{
		dataPer.update(p);
	}
	
	public Persona getByDni(Persona p) throws Exception{
		return this.dataPer.getByDni(p);
		
	}
	
	public Persona getByDni(String dni)throws Exception{
		Persona p=new Persona();
		p.setDni(dni);
		return getByDni(p);
	}
	
	public Persona getByNombreApellido(Persona p) throws Exception{
		return dataPer.getByNombreApellido(p);		
	}
	
	public ArrayList<Persona> getAll()throws Exception{
		return dataPer.getAll();
	}
	
	public ArrayList<Categoria> getCategorias() throws Exception{
		return dataCat.getAll();
	}
	
	public Persona login(Persona per) throws Exception{
		return dataPer.getLogedUser(per);
	}
}
