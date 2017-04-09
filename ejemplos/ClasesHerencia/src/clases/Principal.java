package clases;

public class Principal {

	public static void main(String[] args) {
		
		Padre p= new Padre();
		Hijo h= new Hijo();
		Padre h2=new Hijo();
		HijoMalo hm1 = new HijoMalo("Malo pero no tanto");
		Padre hm2 = new HijoMalo("Malo");
		
		/*p.setNombre("Papá");
		h.setNombre("Hijo");
		h2.setNombre("H2");
		hm1.setNombre("Hijo");*/
		//hm1.setApellido("Malo pero no tanto");

		///hm2.setNombre("Hijo");
		//((HijoMalo)hm2).setApellido("Malo");

		
		
		Padre.setNombreClase("Clase Padre");
		Hijo.setNombreClase("Clase Hijo");
		
		System.out.println("######### p #########");
		System.out.println(p.getDesc());
		System.out.println(Padre.getNombreClase());
		System.out.println("######### h #########");
		System.out.println(h.getDesc());
		System.out.println(Hijo.getNombreClase());
		System.out.println(h.algo());
		
		System.out.println("######### h2 #########");
		System.out.println(h2.getDesc());
		
		System.out.println("######### hm1 #########");
		System.out.println(hm1.getDesc());
		
		System.out.println("######### hm2 #########");
		System.out.println(hm2.getDesc());
		
	}

}
