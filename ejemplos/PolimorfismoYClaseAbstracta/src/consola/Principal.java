package consola;

import java.util.ArrayList;

import entidades.*;

public class Principal {

	private static ArrayList<Empleado> emps;
	public static void main(String[] args) {
		emps=new ArrayList<Empleado>();
		cargarEmpleados();
		mostrarSueldos();
	}

	private static void mostrarSueldos() {
		for (Empleado empleado : emps) {
			System.out.println(
					empleado.getApellido()+", "+
					empleado.getNombre()+" tiene un sueldo de: "+
					empleado.getSueldo()
					);
		}
		
	}

	private static void cargarEmpleados() {
		emps.add(new EmpleadoConComision("Juan", "Perez", 1000, 600, 10));
		emps.add(new EmpleadoConPremio("John", "Doe", 300, 1200, 1700));
		emps.add(new EmpleadoConPremio("N", "N", 300, 300, 2000));
		
	}
}
