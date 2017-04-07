package ejemplo;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		int i =10;
		int[] nros =new int[10];
		for (int j = 0; j < i; j++) {
			System.out.println("Hola Mundo "+j);
			
			if(j%2==0){
				System.out.println("Par");
			}
			nros[j]=2*j;
		}
		
		for (int nro : nros) {
			System.out.println(nro);
		}
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Ingrese dato");
		String dato = s.nextLine();
		
		int b=i+Integer.parseInt(dato);
		
		System.out.println("La suma i+b es: "+b);
		
		s.close();
		

	}

}
