package UD10_05;

import java.util.Random;

public class Password {
	private int longitud;
	private String contraseña;

	public Password() {
		this.longitud = 8;
	}

	public Password(int longitud) {
		this.longitud = longitud;
	}

	// Método que comprueba que la contraseña es fuerte
	public boolean esFuerte(String contraseña, int longitud) {
		char caracter;
		int mayusculas = 0;
		int minusculas = 0;
		int cantidadNumeros = 0;
		// Para hacerlo pasaremos cada caracter de la string y usaremos un contador para asegurarnos que tenemos
		// Más de 2 mayúsculas, más de 1 minúscula y más de 5 números
		for (int i = 0; i < longitud; i++) {
			caracter = contraseña.charAt(i);
			if (Character.isUpperCase(caracter)) {
				mayusculas++;
			}
			if (!Character.isUpperCase(caracter)) {
				minusculas++;
			}
			if (Character.isDigit(caracter)) {
				cantidadNumeros++;
			}
		}
		if (mayusculas > 2 && minusculas > 1 && cantidadNumeros > 5) {
			return true;
		} else {
			return false;
		}
	}
	//Método para generar la contraseña a partir de una String con todos los caracteres
	public String generarPassword(int longitud) {
		int i = 0;
		String contraseñaFinal = "";
		char siguienteCaracter;
		String posiblesCaracteres = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ12345678910";
		while (i < longitud) {
			// Randomizamos entre 0 y 64 para agarrar caracteres de la string de arriba
			Random r = new Random();
			int ran = r.nextInt((64 - 0) + 0);
			siguienteCaracter = posiblesCaracteres.charAt(ran);
			contraseñaFinal = contraseñaFinal + siguienteCaracter;
			i++;
		}

		return contraseñaFinal;
	}

	//Getters y setters.
	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public String getContraseña() {
		return contraseña;
	}

}
