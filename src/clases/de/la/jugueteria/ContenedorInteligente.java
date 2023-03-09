package clases.de.la.jugueteria;

public interface ContenedorInteligente<T, K> {
	
	public void guardar(T elemento);
	
	public T retirarPorId(K id);
}
