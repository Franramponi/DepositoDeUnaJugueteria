package clases.de.la.jugueteria;

import tdas.implementaciones.ListaOrdenadaNodos;

public class ListaOrdenadaDeJuguetesPorId extends ListaOrdenadaNodos<Integer, Juguete> {

	@Override
	public int compare(Juguete dato1, Juguete dato2) {
		return dato1.getId() - dato2.getId();
	}

	@Override
	public int compareByKey(Integer clave, Juguete elemento) {
		return clave - elemento.getId();
	}
}
