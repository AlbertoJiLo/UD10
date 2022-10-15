package UD10_02;

import misExcepciones.miExcepcion;

public class excepcionCustom {
	//Método con un bucle de trys en el que le pasaremos distintos códigos de error para que nos devuelva todos los mensajes
	public void bucleTrys() {
		int i=0;
		while(i<3) {
			try {
				if(i==0) {throw new miExcepcion(200);}
				if(i==1) {throw new miExcepcion(201);}
				if(i==2) {throw new miExcepcion(209);}
			}catch(miExcepcion ex) {
				System.out.println(ex.getMessage());
			}
		i++;
		}
	}
}
