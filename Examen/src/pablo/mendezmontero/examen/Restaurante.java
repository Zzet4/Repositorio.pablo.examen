package pablo.mendezmontero.examen;

import curso_java.utilidades.Utils;

public class Restaurante {

	public static void main(String[] args) {
//CREACIÓN DE OBJETOS
		
		//Creación de objetos de la clase Plato
			Plato combinado1 = new Plato("1. Lomo con patatas y huevo frito.", 10.50, true);
			Plato combinado2 = new Plato("2. Bacon con patatas y huevo frito.", 10.50, true);
			Plato combinado3 = new Plato("3. Entrecot con ensalada y patatas fritas.", 13.50, false);
			Plato combinado4 = new Plato("1. Merluza a la plancha con ensalada.", 10.50, true);
			Plato combinado5 = new Plato("2. Emperador con ensalada y patatas fritas.", 12.50, true);
			
			//Creamos los arrays de platos para la carta.
				Plato [] arrCarnes = new Plato[3]; //Aquí declaro el array de forma indirecta.
					arrCarnes[0] = combinado1;
					arrCarnes[1] = combinado2;
					arrCarnes[2] = combinado3;	
				Plato [] arrPescados = {combinado4, combinado5}; //Aquí declaro el array de forma directa.
			

		//Creación de objetos de la clase Bebida
			Bebida refresco = new Bebida("1. Refresco", 3.00);
			Bebida cerveza = new Bebida("2. Cerveza", 2.50);
			//Creamos el array de bebidas para la carta.
				Bebida [] arrBebidas = new Bebida[2];
					arrBebidas[0] = refresco;
					arrBebidas[1] = cerveza;
			
			
		
		//Creación de objetos de la clase Carta
			Carta carnes = new Carta("Carta de carnes", arrCarnes, cerveza);
			Carta pescados = new Carta("Carta de Pescados", arrPescados, refresco);

			//Creamos un array con todas las cartas para mostrar el cartel en la entrada
			Carta [] arrCartas = new Carta[2];
				arrCartas[0] = carnes;
				arrCartas[1] = pescados;
			
		
		//Creación de objetos de la clase Restaurante
			Restaurante casaPaco = new Restaurante("Casa Paco");
			
			
//LLAMADAS A METODOS.
			
		casaPaco.muestraCartas(carnes, pescados, arrBebidas); //Aquí lo hago con array de bebidas.
		casaPaco.eligeCarta(carnes, pescados, cerveza, refresco); //Aquí lo hago sin array de bebidas.
		
		
		

	}
//-----------------------------------------------------------------------------------------------------------------------------
//ATRIBUTOS
	private String nombre;

	
	
//GETTERS & SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	
//CONSTRUCTORES
	public Restaurante(String nombre) {
		super();
		this.nombre = nombre;
	}
	
//----------------------------------------------------------------------------------------------------------------------------
	
//MÉTODOS.
	
	
	public void eligeCarta (Carta cartaCarnes, Carta cartaPescados, Bebida cerveza, Bebida refresco) {
		int opcionMP = Utils.scanInt("\n\n\tSeleccione que carta desea consultar:\n\n\t\t1. Carta de Carnes.\n\t\t2. Carta de Pescados.\n\t\t3. Salir.\n");
		
		switch (opcionMP) {
		case 1:// Carta de Carnes.
			System.out.println("Usted ha seleccionado la " + cartaCarnes.getNombre() + "\n");
			double sumaPrecio = 0;
			for (Plato plato : cartaCarnes.getPlatos()) {
				if(plato.isDisponible()==true) {
				System.out.println("\t" + plato.getNombre() + "-----" + plato.getPrecio()  + "€");
				sumaPrecio += plato.getPrecio();
				System.out.println("\t Con una bebida a elegir entre cerveza o refresco\n\t\tCerveza ---- " + cerveza.getPrecio() + "€"
						+ "\n\t\tRefresco ---- " + refresco.getPrecio() + "€\n");
				sumaPrecio += cerveza.getPrecio() + refresco.getPrecio();
				}
			}
		
			System.out.println("El precio total de la carta de las carnes es " + sumaPrecio);
			
			break;
		case 2:// Carta de Pescados
			System.out.println("Usted ha seleccionado la " + cartaPescados.getNombre() + "\n");
			double sumaPrecio2 = 0;
			for (Plato plato : cartaPescados.getPlatos()) {
				if(plato.isDisponible()==true) {
				System.out.println("\t" + plato.getNombre() + "-----" + plato.getPrecio()  + "€");
				sumaPrecio2 += plato.getPrecio();
				System.out.println("\t Con una bebida a elegir entre cerveza o refresco\n\t\tCerveza ---- " + cerveza.getPrecio() + "€"
						+ "\n\t\tRefresco ---- " + refresco.getPrecio() + "€\n");
				
				sumaPrecio2 += cerveza.getPrecio() + refresco.getPrecio();
				}
			}
			System.out.println("El precio total de la carta de las carnes es " + sumaPrecio2);
			
			break;
		case 3:// Salir.
			System.out.println("\n Esperamos que tenga un buen día.\n\n\tHasta pronto!!");
			break;


		}
	}
	
	
	public void muestraCartas (Carta cartaCarnes, Carta cartaPescados, Bebida [] arrBebidas) {
		
		System.out.println("\n\t------ BIENVENIDO AL RESTAURANTE CASA PACO ------\n\n\tEste es el listado de nuestros productos\n");
				
		
		System.out.println(cartaCarnes.getNombre());
			for (Plato dato : cartaCarnes.getPlatos()) {
				if(dato.isDisponible()==true) {
				System.out.println("\t" + dato.getNombre() );
				}
			}
		System.out.println(cartaPescados.getNombre());
			for (Plato plato : cartaPescados.getPlatos()) {
				if(plato.isDisponible()==true) {
				System.out.println("\t" + plato.getNombre());
				}
			}
		System.out.println("Carta de bebidas");
			for (Bebida dato : arrBebidas) {
				System.out.println("\t" + dato.getNombre());
			}
		
	}
}
	
	
	
	
	
	
	

