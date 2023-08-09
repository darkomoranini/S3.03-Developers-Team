package N1;

public class Decoracion extends Producto {
	String material;
	
	public Decoracion(String nombre, double precio, String material) {
		super(nombre, precio);
		this.material=material;
	}
	
}

