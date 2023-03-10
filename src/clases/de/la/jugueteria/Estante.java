package clases.de.la.jugueteria;

import tdas.implementaciones.PilaNodos;
import tdas.interfaces.Pila;

public class Estante implements ContenedorInteligente<Juguete, Integer> {

	
	private Pila<Juguete> ubicaciones;
	private int cantidadAlojados;
	private int profundidadEstanteria;

	public Estante(int profundidadEstanteria) {
		this.profundidadEstanteria = profundidadEstanteria;
		this.ubicaciones = new PilaNodos<>();
	}

	
	@Override
	public void guardar(Juguete juguete) throws RuntimeException {

		if (profundidadEstanteria == cantidadAlojados) {
			throw new RuntimeException("No se puede agregar mas juguetes a este estante.");
		}
		ubicaciones.push(juguete);
		cantidadAlojados++;
	}

	
	@Override
	public Juguete retirarPorId(Integer id) {
		Juguete retorno = null;
		Pila<Juguete> aux = new PilaNodos<>();
		while (retorno == null && !this.ubicaciones.isEmpty()) {
			Juguete jugueteAuxiliar = ubicaciones.pop();
			if (jugueteAuxiliar.coincideId(id)) {
				retorno = jugueteAuxiliar;
			} else {
				aux.push(jugueteAuxiliar);
			}
		}

		while (!aux.isEmpty()) {
			ubicaciones.push(aux.pop());
		}

		return retorno;
	}

}
