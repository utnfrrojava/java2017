package entidades;

public class EmpleadoConPremio extends Empleado {
	private static double importeMinimoVentas=1000;
	
	private double importePremio;
	
	
	
	public double getImportePremio() {
		return importePremio;
	}

	public void setImportePremio(double importePremio) {
		this.importePremio = importePremio;
	}

	@Override
	public double getSueldo() {
		if(this.getImporteVentas()>importeMinimoVentas){
			return this.getSueldoBase()+this.getImportePremio();
		}else{
			return this.getSueldoBase();
		}
	}
	
	public EmpleadoConPremio(String nombre, String apellido, double sueldoBase, double importeVentas, double importePremio){
		super(nombre,apellido,sueldoBase,importeVentas);
		this.setImportePremio(importePremio);
		
	}

}
