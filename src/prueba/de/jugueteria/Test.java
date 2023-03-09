package prueba.de.jugueteria;

import clases.de.la.jugueteria.Juguete;
import clases.de.la.jugueteria.Jugueteria;
import clases.de.la.jugueteria.Pelota;
import clases.de.la.jugueteria.Peluche;
import clases.de.la.jugueteria.TipoDePelota;
import clases.de.la.jugueteria.Titere;

public class Test {

	private static final int ONCE = 11;
	private static int id = 10;

	public static void main(String[] args) {
		
		Jugueteria jugueteria = new Jugueteria();
		guardarJuguetes(jugueteria);
		
		int unId= 55;
		System.out.println(jugueteria.existeJuguete(unId) ? "El juguete id " + unId + " esta depositado":"El producto id " + unId + " NO esta depositado");
		unId= 23;
		System.out.println(jugueteria.existeJuguete(unId) ? "El juguete id " + unId + " esta depositado":"El producto id " + unId + " NO esta depositado");
		
		procesarCompras(jugueteria);
		jugueteria.mostrarVentas();

	}

	private static void procesarCompras(Jugueteria jugueteria) {
		System.out.println("--------------------------------------------");
		System.out.println("Se comienza a comprar juguetes");
		System.out.println("--------------------------------------------");
		comprar(jugueteria, 12);
		comprar(jugueteria, 13);
		comprar(jugueteria, 28);
		comprar(jugueteria, 15);
		System.out.println("Final del compras");
		System.out.println("--------------------------------------------");
	}

	private static void comprar(Jugueteria jugueteria, int id) {
		Juguete juguete = jugueteria.retirarPorId(id);
		if (juguete != null) {
			System.out.println("Se compro el producto id: " + id);
			juguete.mostrar();
		} else { 
			System.out.println("No se pudo comprar producto id: " + id);
		}		
	}

	private static void guardarJuguetes(Jugueteria jugueteria) {
		System.out.println("Guardando juguetes en la jugueteria");
		System.out.println("--------------------------------------------");
		
		guardarPeluche(jugueteria, id++, "Baloo", "Us Open", 1200.9f);
		guardarTitere(jugueteria, id++, "Bandai", 100, 2304.7f);
		guardarPelota(jugueteria, id++, "Wilson", TipoDePelota.FUTBOL, 1234.5f);
		guardarPeluche(jugueteria, id++, "", "Us Open 2", 1700.9f);
		guardarTitere(jugueteria, id++, "Pinoche", 105, 2304.7f);
		guardarPeluche(jugueteria, id++, "Marvel", "All Team", 2300.5f);
		guardarTitere(jugueteria, id++, "Prince", 98, 2304.7f);
		guardarPelota(jugueteria, id++, "Wilson", TipoDePelota.GOLF, 1234.5f);
		guardarPeluche(jugueteria, id++, "Hasbro", null, 2300.5f);
		guardarTitere(jugueteria, id++, "Babies", 544, 2301.7f);
		guardarPelota(jugueteria, id++, "Wilson", null, 1234.5f);
		for (int i = 0; i < ONCE; i++) {
			guardarPelota(jugueteria, id++, "Wimbledon", TipoDePelota.TENIS, 1234.5f);
		}
		guardarPeluche(jugueteria, id++, "Wilson", "Australian Bag", 2300.5f);
		System.out.println("Fin del guardado");
		System.out.println("--------------------------------------------");
	}

	private static void guardarPeluche(Jugueteria deposito, int id, String marca, String modelo, float precio) {
		try {
			Juguete p = new Peluche(id, marca, modelo, precio);
			deposito.guardar(p);
			System.out.println("Peluche depositado id: "  + id);
		} catch (RuntimeException e) {
			System.out.println("Error depositando Peluche: " + e.getMessage());
		}
	}

	private static void guardarTitere(Jugueteria deposito, int id, String marca, int tamanio, float precio) {
		try {
			Juguete p = new Titere(id, marca, tamanio, precio);
			deposito.guardar(p);
			System.out.println("Titere depositado id: "  + id);
		} catch (RuntimeException e) {
			System.out.println("Error depositando titere: " + e.getMessage());
		}
	}

	private static void guardarPelota(Jugueteria deposito, int id, String marca, TipoDePelota superficie, float precio) {
		try {
			Juguete p = new Pelota(id, marca, superficie, precio);
			deposito.guardar(p);
			System.out.println("Pelota depositada id: "  + id);
		} catch (RuntimeException e) {
			System.out.println("Error depositando pelota: " + e.getMessage());
		}
	}

}