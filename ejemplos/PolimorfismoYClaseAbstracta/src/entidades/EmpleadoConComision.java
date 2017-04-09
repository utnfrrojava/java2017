package entidades;

public class EmpleadoConComision extends Empleado {

	private double porcentajeComision;
	
	public double getPorcentajeComision() {
		return porcentajeComision;
	}


	public void setPorcentajeComision(double porcentajeComision) {
		this.porcentajeComision = porcentajeComision;
	}


	@Override
	public double getSueldo(){
		return this.getSueldoBase() +
				(this.getImporteVentas()*this.getPorcentajeComision()/100);
	}
	
	public EmpleadoConComision(String nombre, String apellido, double sueldoBase, double importeVentas, double porcentajeComision){
		super(nombre,apellido,sueldoBase,importeVentas);
		this.setPorcentajeComision(porcentajeComision);		
	}


}
