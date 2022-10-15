package UD10_04;

import javax.swing.JOptionPane;
import misExcepciones.miExcepcion;

public class calculoSimple {

	public calculoSimple() {

	}

	// Métodos de las operaciones que realizan la operación concreta y muestran por
	// pantalla el resultado.
	public double suma(double a, double b) {
		double resultado = a + b;
		System.out.println("El resultado de la suma es " + resultado);
		return resultado;
	}

	public double resta(double a, double b) {
		double resultado = a - b;
		System.out.println("El resultado de la resta es " + resultado);
		return resultado;
	}

	public double multiplicacion(double a, double b) {
		double resultado = a * b;
		System.out.println("El resultado de la multiplicacion es " + resultado);
		return resultado;
	}

	// He limitado la división a enteros para hacer pruebas al dividir entre 0.
	// Explicado en el case 4 del método calcular.
	public double division(int a, int b) {
		int resultado = a / b;
		System.out.println("El resultado de la division es " + resultado);
		return resultado;
	}

	public double potencia(double a, double b) {
		double resultado = Math.pow(a, b);
		System.out.println("El resultado de la potencia es " + resultado);
		return resultado;
	}

	public double raizCuadrada(double a) {
		double resultado = Math.sqrt(a);
		System.out.println("El resultado de la raiz cuadrada es " + resultado);
		return resultado;
	}

	public double raizCubica(double a) {
		double resultado = Math.pow(a, 1.0 / 3.0);
		System.out.println("El resultado de la raiz cubica es " + resultado);
		return resultado;
	}

	// Método para elegir el cálculo que incluirá todos los controles de excepción
	// para asegurarse que los datos introducidos son correctos.
	public void calcular() {
		String aString;
		String bString;
		int eleccion = 0;
		double resultado = 0;
		try {
			String eleccionString = JOptionPane
					.showInputDialog("Elije una opción\n1.Suma\n2.Resta\n3.Multiplicacion\n4.Division\n5.Potencia"
							+ "\n6.Raiz cuadrada\n7.Raiz cubica");
			eleccion = Integer.parseInt(eleccionString);
			// En caso de que la opción elegida no sea un número entre 1 y 7 saltará una
			// excepción custom que te lo indica.
			if (eleccion < 1 || eleccion > 7) {
				throw new miExcepcion(400);
			}
			// En caso de que al escoger la opción hayamos algo que no sea un número entero
			// nos saltará la excepción definida
		} catch (NumberFormatException e) {
			System.out.println("No has escrito un numero entero, por favor introduce uno valido");
		} catch (miExcepcion ex) {
			System.out.println(ex.getMessage());
		}
		switch (eleccion) {
		case 1:
			try {
				aString = JOptionPane.showInputDialog("Elije el primer numero de la suma");
				double a = Double.parseDouble(aString);
				bString = JOptionPane.showInputDialog("Elije el segundo numero de la suma");
				double b = Double.parseDouble(bString);
				resultado = suma(a, b);
				// Nos aseguraremos de nuevo que el parámetro del usuario es un número valido,
				// un double en este caso. Haremos esto en absolutamente todos las opciones.
				// Además si el usuario cancela en medio de la operación le mostraremos
				// Saliendo...
			} catch (NumberFormatException e) {
				System.out.println("Parametro no valido, por favor introduce un numero");
			} catch (NullPointerException e) {
				System.out.println("Saliendo...");
			}
			break;
		case 2:
			try {
				aString = JOptionPane.showInputDialog("Elije el primer numero de la resta");
				double a = Double.parseDouble(aString);
				bString = JOptionPane.showInputDialog("Elije el segundo numero de la resta");
				double b = Double.parseDouble(bString);
				resultado = resta(a, b);
			} catch (NumberFormatException e) {
				System.out.println("Parametro no valido, por favor introduce un numero");
			} catch (NullPointerException e) {
				System.out.println("Saliendo...");
			}
			break;
		case 3:
			try {
				aString = JOptionPane.showInputDialog("Elije el primer numero de la multiplicacion");
				double a = Double.parseDouble(aString);
				bString = JOptionPane.showInputDialog("Elije el segundo numero de la multiplicacion");
				double b = Double.parseDouble(bString);
				resultado = multiplicacion(a, b);
			} catch (NumberFormatException e) {
				System.out.println("Parametro no valido, por favor introduce un numero");
			} catch (NullPointerException e) {
				System.out.println("Saliendo...");
			}
			break;
		// En el caso de la división lo he limitado a números enteros para probar la
		// excepción ArithmeticException que salta al dividir un numero entre 0. Solo
		// ocurre con numeros enteros, con doubles simplemente el resultado es infinity.
		case 4:
			try {
				aString = JOptionPane.showInputDialog("Elije el primer numero de la division");
				int a = Integer.parseInt(aString);
				bString = JOptionPane.showInputDialog("Elije el segundo numero de la division");
				int b = Integer.parseInt(bString);
				resultado = division(a, b);
			} catch (NumberFormatException e) {
				System.out.println("Parametro no valido, por favor introduce un numero entero");
			} catch (ArithmeticException e) {
				System.out.println("En java no podemos dividir entre 0");
			} catch (NullPointerException e) {
				System.out.println("Saliendo...");
			}
			break;
		case 5:
			try {
				aString = JOptionPane.showInputDialog("Elije el primer numero de la potencia");
				double a = Double.parseDouble(aString);
				bString = JOptionPane.showInputDialog("Elije el segundo numero de la potencia");
				double b = Double.parseDouble(bString);
				resultado = potencia(a, b);
			} catch (NumberFormatException e) {
				System.out.println("Parametro no valido, por favor introduce un numero");
			} catch (NullPointerException e) {
				System.out.println("Saliendo...");
			}
			break;
		case 6:
			try {
				aString = JOptionPane.showInputDialog("Elije un numero para hacer su raiz cuadrada");
				double a = Double.parseDouble(aString);
				// Si el numero introducido es negativo lanzaremos la excepción
				// ArithmeticException ya que no es posible hacer dicho cálculo.
				if (a < 0) {
					throw new ArithmeticException();
				}
				resultado = raizCuadrada(a);
			} catch (NumberFormatException e) {
				System.out.println("Parametro no valido, por favor introduce un numero");
			} catch (ArithmeticException e) {
				System.out.println("No se puede hacer la raiz cuadrada de un numero negativo");
			} catch (NullPointerException e) {
				System.out.println("Saliendo...");
			}

			break;
		case 7:
			try {
				aString = JOptionPane.showInputDialog("Elije un numero para hacer su raiz cubica");
				double a = Double.parseDouble(aString);
				// Si el numero introducido es negativo lanzaremos la excepción
				// ArithmeticException ya que no es posible hacer dicho cálculo.
				if (a < 0) {
					throw new ArithmeticException();
				}
				resultado = raizCubica(a);
			} catch (NumberFormatException e) {
				System.out.println("Parametro no valido, por favor introduce un numero");
			} catch (ArithmeticException e) {
				System.out.println("No se puede hacer la raiz cubica de un numero negativo");
			} catch (NullPointerException e) {
				System.out.println("Saliendo...");
			}
			break;
		}
	}
}