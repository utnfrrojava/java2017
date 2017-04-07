package ejemploBase;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		
		ArrayList<Integer> nros = new ArrayList<Integer>();
		nros.add(11);
		nros.add(18);
		nros.add(1);
		
		/*for (int i = 0; i < nros.size(); i++) {
			Integer n = nros.get(i);
			System.out.println(n);
		}*/
		
		mostrar(nros);
		
		nros.add(1, 22);
		
		mostrar(nros);
		
		nros.remove(0);
		
		mostrar(nros);
		
	}

	private static void mostrar(ArrayList<Integer> nros) {
		System.out.println("####################");
		for (Integer n : nros) {
			System.out.println(n);
		}
	}
}
