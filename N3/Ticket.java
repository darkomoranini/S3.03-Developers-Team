package N3;

import java.util.ArrayList;

public class Ticket {
	ArrayList<Producto>listaProductos;
	double importeTotal;

	public Ticket() {
		listaProductos = new ArrayList<Producto>();
		importeTotal = 0;
	}
	public void addProducto(Producto producto) {
		listaProductos.add(producto);
		importeTotal += producto.precio;
	}
	public void imprimirTicket() {
		System.out.println("Ticket de compra:");
		for (Producto producto : listaProductos) {
			System.out.println(producto.nombre + " - Preu: " + producto.precio);
		}
		System.out.println("Total a pagar: " + importeTotal);
	}
}

