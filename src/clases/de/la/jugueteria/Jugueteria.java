package clases.de.la.jugueteria;

import tdas.interfaces.ListaOrdenada;

public class Jugueteria implements ContenedorInteligente<Juguete, Integer> {

	private static final int ALTO_ESTANTERIA = 6;
	private static final int ANCHO_ESTANTERIA = 3;
	private static final int PROFUNDIDAD_ESTANTERIA = 4;
	private static final int FILA_TITERE = 0;
	private static final int FILA_PELOTA = 2;
	private static final int FILA_PELUCHE = 1;

	
	private Estante[][] estanteria;
	private ListaOrdenada<Integer, Juguete> juguetesEnTienda;
	private float ventasTotales;

	
	public Jugueteria() {
		inicializarEstanteria(PROFUNDIDAD_ESTANTERIA);
		this.juguetesEnTienda = new ListaOrdenadaDeJuguetesPorId();
	}

	
	private void inicializarEstanteria(int profundidadEstanteria) {
		estanteria = new Estante[ALTO_ESTANTERIA][ANCHO_ESTANTERIA];

		for (int i = 0; i < estanteria.length; i++) {
			for (int j = 0; j < estanteria[i].length; j++) {
				estanteria[i][j] = new Estante(profundidadEstanteria);
			}
		}
	}

	
	@Override
	public void guardar(Juguete juguete) throws RuntimeException {

		int fila = calcularFila(juguete);
		int idxColumna = 0;
		boolean depositado = false;

		do {
			try {
				estanteria[fila][idxColumna].guardar(juguete);
				depositado = true;
				this.juguetesEnTienda.add(juguete);
			} catch (RuntimeException e) {
				idxColumna++;
			}
		} while (idxColumna < estanteria[fila].length && !depositado);

		if (!depositado) {
			throw new RuntimeException("No se pudo depositar el juguete.");
		}
	}

	
	private int calcularFila(Juguete juguete) {
		int fila;
		if (juguete instanceof Pelota) {
			fila = FILA_PELOTA;
		} else if (juguete instanceof Titere) {
			fila = FILA_PELUCHE;
		} else if (juguete instanceof Peluche) {
			fila = FILA_TITERE;
		} else {
			throw new RuntimeException("Tipo de juguete invalido");
		}
		return fila;
	}

	
	public boolean existeJuguete(int idJuguete) {
		return this.juguetesEnTienda.exists(idJuguete);
	}

	
	@Override
	public Juguete retirarPorId(Integer id) {
		Juguete juguete = this.juguetesEnTienda.removeByKey(id);
		if (juguete != null) {
			sacarDeLaEstanteria(juguete);
			this.ventasTotales += juguete.getPrecio();
		}
		return juguete;
	}

	
	private void sacarDeLaEstanteria(Juguete juguete) {
		
		int fila = calcularFila(juguete);
		int idxColumna = 0;
		boolean retirado = false;
		while (!retirado && idxColumna < this.estanteria[fila].length) {
			if (estanteria[fila][idxColumna].retirarPorId(juguete.getId()) != null) {
				retirado = true;
			}
			idxColumna++;
		}
	}

	public void mostrarVentas() {
		System.out.println("El total de ventas fue de " + this.ventasTotales);
		System.out.println("--------------------------------------------");
	}
}
