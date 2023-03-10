package clases.de.la.jugueteria;

public class Peluche extends Juguete {

	
	private String modelo;

	
	public Peluche(int id, String marca, String modelo, float precio) {
		super(id, marca, precio);
		this.setModelo(modelo);
	}

	
	private void setModelo(String modelo) {
		if (modelo == null || modelo.isEmpty()) {
			throw new IllegalArgumentException("Modelo de peluche invalido.");
		}
		this.modelo = modelo;
	}

	
	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		System.out.printf("El peluche cuesta %.2f es de modelo %s es de la marca %s y tiene un id %d\n", this.getPrecio(), this.modelo, this.getMarca(), this.getId());
	}
}
