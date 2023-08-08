package N1;

public class App {

	public static void main(String[] args) {
	Floristeria floristeria = new Floristeria("Hojas");
	
	Arbol arbol1 = new Arbol("Pino", 70, 2.5);
	Flor flor1 = new Flor ("Rosas", 10, "Blancas");
	Decoracion decoracion1 = new Decoracion("Jardinera", 30, "Madera");
	
	floristeria.addProducto(arbol1, 5);
	floristeria.addProducto(flor1, 10);
	floristeria.addProducto(decoracion1, 25);
	
	floristeria.imprimirStock();
	floristeria.imprimirValorTotalStock();
	
	floristeria.retirarProducto(decoracion1, 3);
	
	Ticket ticket1 = new Ticket();
	ticket1.addProducto(arbol1);
	ticket1.addProducto(flor1);
	ticket1.imprimirTicket();

	}

}
