package misExcepciones;

public class miExcepcion extends Exception {
	private int codigoException;
	
	//Constructor default
	public miExcepcion() {
		
	}
	//Constructor principal para pasarle codigos de error
	public miExcepcion(int codigoError) {
		super();
		this.codigoException=codigoError;
	}
	
	//Método para mostrar mensajes customizados
	//Voy a usar tandas de 10 para los ejercicios.Por ejemplo ejercicio 2, del 200 al 210. Ejercicio 3, del 300 al 310.
	//Si lo utilizara en unidades siguientes usaré las siguientes decenas.
	@Override
	public String getMessage() {
		String mensaje="";
		switch(codigoException) {
		 case 200:
			 mensaje="Mensaje mostrado por pantalla";
			 break;
		 case 201:
			 mensaje="Esto es un objeto Exception";
			 break;
		 case 209:
			 mensaje="Programa terminado";
			 break;
		 case 300:
			 mensaje="Generando numero aleatorio...";
			 break;
		 case 308:
			 mensaje="Es par";
			 break;
		 case 309:
			 mensaje="Es impar";
			 break;
		 case 400:
			 mensaje="Numero incorrecto. Ha de estar entre 1 y 7";
			 break;
		 case 500:
			 mensaje="Introduce un numero positivo";
			 break;
		 case 501:
			 mensaje="La longitud ha de estar entre 8 y 24 caracteres";
			 break;
		}
	return mensaje;
	}
}
