package clases.de.la.jugueteria;

public class Pelota extends Juguete {
	
	private static final String LA_SUPERFICIE_NO_PUEDE_SER_NULA = "La superficie no puede ser nula";
	private static final String MSG_PELOTA = "La pelota cuesta %.2f pesos, es del tipo %s ademas es de la marca %s y tiene un id %d\n";
	
	
	private TipoDePelota tipo;
	
	public Pelota(int id, String marca, TipoDePelota superficie, float precio) {
		super(id, marca, precio);
		this.setTipo(superficie);
	}

	
	private void setTipo(TipoDePelota tipo) {
		if (tipo == null) {
			throw new IllegalArgumentException(LA_SUPERFICIE_NO_PUEDE_SER_NULA);
		}
		this.tipo = tipo;
	}
	
	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		System.out.printf(MSG_PELOTA, this.getPrecio(), this.tipo.getDescripcion(), this.getMarca(), this.getId());
	}
}
