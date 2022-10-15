package UD10_05;

import javax.swing.JOptionPane;
import misExcepciones.miExcepcion;

public class MainApp05 {
	public static void main(String[] args) {
		String numeroArraysString;
		int numeroArrays = 0;
		String longitudString;
		int longitud = 0;
		boolean check = false;
		// Nos aseguraremos de que el usuario introduzca un número válido.
		while (!check) {
			check = true;
			try {
				numeroArraysString = JOptionPane.showInputDialog("Introduce cuantas contraseñas quieres");
				numeroArrays = Integer.parseInt(numeroArraysString);
				if (numeroArrays < 0) {
					throw new miExcepcion(500);
				}
				// Que sea un número
			} catch (NumberFormatException e) {
				System.out.println("Por favor introduce un numero valido");
				check = false;
				// Y que no sea negativo
			} catch (miExcepcion ex) {
				System.out.println(ex.getMessage());
				check = false;
			}
		}
		check=false;
		//Y nos aseguramos de que también introduzca una longitud válida
		while (!check) {
			check = true;
			try {
				longitudString = JOptionPane.showInputDialog("Indica la longitud de los passwords");
				longitud = Integer.parseInt(longitudString);
				if (longitud < 8 || longitud > 24) {
					throw new miExcepcion(501);
				}
				// Que sea un número
			} catch (NumberFormatException e) {
				System.out.println("Por favor introduce un numero valido");
				check = false;
				// Y que esté entre 8 y 24
			} catch (miExcepcion ex) {
				System.out.println(ex.getMessage());
				check = false;
			}
		}
		//Creamos dos arrays, uno con contraseñas y otro con booleanos para saber si son fuertes. Después las listaremos.
		String password;
		Password arrayPasswords[] = new Password[numeroArrays];
		boolean arrayBooleanos[] = new boolean[numeroArrays];
		for (int i = 0; i < numeroArrays; i++) {
			arrayPasswords[i] = new Password(longitud);
			password = arrayPasswords[i].generarPassword(longitud);
			arrayBooleanos[i] = arrayPasswords[i].esFuerte(password, longitud);
			if (arrayBooleanos[i]) {
				System.out.println("La contraseña " + password + " es fuerte.");
				System.out.println(password + "	" + arrayBooleanos[i] + "\n");
			} else {
				System.out.println("La contraseña " + password + " es debil.");
				System.out.println(password + "	" + arrayBooleanos[i] + "\n");
			}
		}
	}
}
