package UD10_01;

import java.util.Random;

import javax.swing.JOptionPane;

public class AdivinaNumeros {
	
	//Constructo default
	public AdivinaNumeros() {
	}

	//Generamos numero random entre 500 y 1
	public int numeroSecreto() {
		Random r = new Random();
		int numeroSec=r.nextInt(500-1)+1;
		//Este print lo utilizo para hacer comprobaciones rápidas del número secreto, no estaría en un supuesto código final
		System.out.println("Numero random generado"+numeroSec);
		return numeroSec;
	}
	
	//Método para saber si el numero secreto es mayor
	public boolean esMayor(int num,int numSecreto) {
		if(numSecreto>num) {
			return true;
		}else {
			return false;
		}
	//Método para saber si el numero secreto es menor
	}
	public boolean esMenor(int num,int numSecreto) {
		if(numSecreto<num) {
			return true;
		}else {
			return false;
		}
	}
	
	//Método para controlar el número de intentos a la vez que vamos revisando si el numero secreto es mayor o menos al introducido
	//Será un while infinito hasta que adivinemos dicho número.
	public int controlIntentos(int numSecreto) {
		int intentos=0;
		boolean check=true;
		boolean check2=true;
		String numString = null;
		int num = 0;
		//Haremos un while infinito que se ejecutará hasta que adivinemos el número secreto.
		while(check) {
			//Introduciremos numeros para ir adivinando.
			try {
			numString=JOptionPane.showInputDialog("Introduce un numero. Tendras que adivinar el numero secreto entre 1 y 500");
			num =Integer.parseInt(numString);
			check2=true;
			}catch(NumberFormatException e){
				System.out.println("Has escrito letras, por favor introduce un numero entre 1 y 500");
				intentos++;
				check2=false;
			}

			if(num<1||num>500) {
				System.out.println("Por favor introduce un numero valido entre 1 y 500")				;
			}
			//He añadido unos checks para que si entra en el catch no entre a las condiciones y no haga varias veces intentos++
			else if(esMayor(num,numSecreto)&& check2) {
				System.out.println("El numero secreto es mayor que "+num);
				intentos++;
			}else if(esMenor(num,numSecreto)&& check2) {
				System.out.println("El numero secreto es menor que "+num);
				intentos++;
			}else if(check2){
				System.out.println("Muy bien! Adivinaste el número. Era "+numSecreto);
				intentos++;
				check=false;
			}
		}
		return intentos;
	}
	//Método para imprimir el número de intentos como paso final.
	public void totalIntentos() {
		int intentos=this.controlIntentos(numeroSecreto());
		System.out.println("El numero de intentos para adivinarlo ha sido "+intentos);
	}
}
