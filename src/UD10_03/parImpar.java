package UD10_03;

import java.util.Random;
import misExcepciones.miExcepcion;

public class parImpar {

	//Constructor default
	public parImpar() {
		
	}
	
	//Método para generar un número aleatorio. Mostraremos a través del lanzamiento de una excepción
	//el mensaje 300, es decir "Generando numero aleatorio", cuando se asegure que el número está entre 0 y 999
	public int generar() {
		int rand = 0;
			try {
				Random r = new Random();
				rand=r.nextInt(999-0)+0;
				if(rand>=0 && rand<=999) {throw new miExcepcion(300);}
			}catch(miExcepcion ex){
				System.out.println(ex.getMessage());
			}
		System.out.println("El numero aleatorio generado es "+rand);
		return rand;
	}
	//Método para agarrar el número aleatorio y ver si es par o impar. En caso que sea par mostrará la excepción 308, impar 309
	public void esPar() {
		try {
			if(generar()%2==0) { throw new miExcepcion(308);}
			else {throw new miExcepcion(309);}
		}catch(miExcepcion ex){
			System.out.println(ex.getMessage());
		}
	}
}
