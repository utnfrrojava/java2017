package clases;

public class Principal {

	public static void main(String[] args) {
		
		Padre p= new Padre();
		Hijo h= new Hijo();
		Padre h2= new Hijo();
		
		p.setNombre("Papá");
		h.setNombre("Hijo");
		Padre.setNombreClase("Clase Padre");
		Hijo.setNombreClase("Clase Hijo");
		
		System.out.println(p.getDesc());
		System.out.println(h.getDesc());
		System.out.println(h2.getDesc());
		System.out.println(h.algo());
		System.out.println(((Hijo)h2).algo());
	}

}
