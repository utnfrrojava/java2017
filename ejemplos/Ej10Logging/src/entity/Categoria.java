package entity;

public class Categoria {
	private int id;
	private String descripcion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString(){
		return this.getDescripcion();
	}
	
	@Override
	public boolean equals(Object o){
		return (o instanceof Categoria && ((Categoria)o).getId()==this.getId());
	}
	
	@Override
	public int hashCode(){
		return ((Integer)this.getId()).hashCode();
	}

}
