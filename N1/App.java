package N1;

import java.io.*;
import java.util.*;

public class App {

	public static void main(String[] args) {
		Floristeria floristeria = new Floristeria("Hojas");

		Arbol arbol1 = new Arbol("Pino", 70, 2.5);
		Flor flor1 = new Flor ("Rosas", 10, "Blancas");
		Decoracion decoracion1 = new Decoracion("Jardinera", 30, "Madera");

		floristeria.addProducto(arbol1, 5);
		floristeria.addProducto(flor1, 10);
		floristeria.addProducto(decoracion1, 25);

		guardarStockTxt(floristeria.stock);
		
		floristeria.imprimirStock();
		floristeria.imprimirValorTotalStock();

		floristeria.retirarProducto(decoracion1, 3);

		cargarStockTxt(floristeria.stock);
		
		Ticket ticket1 = new Ticket();
		ticket1.addProducto(arbol1);
		ticket1.addProducto(flor1);
		ticket1.imprimirTicket();

	}
	 public static void cargarStockTxt(Map<String, Integer> stock) {
	        try {
	            BufferedReader archivo = new BufferedReader(new FileReader("stock.txt"));
	            String linea;
	            while ((linea = archivo.readLine()) != null) {
	                String[] partes = linea.split(":");
	                stock.put(partes[0], Integer.parseInt(partes[1]));
	            }
	            archivo.close();
	            System.out.println("Stock cargado desde archivo.");
	        } catch (IOException e) {
	            System.out.println("Error al cargar el stock: " + e.getMessage());
	        }
	    }

	    public static void guardarStockTxt(Map<String, Integer> stock) {
	        try {
	            FileWriter archivo = new FileWriter("stock.txt");
	            for (Map.Entry<String, Integer> entry : stock.entrySet()) {
	                archivo.write(entry.getKey() + ":" + entry.getValue() + "\n");
	            }
	            archivo.close();
	            System.out.println("Stock guardado en archivo.");
	        } catch (IOException e) {
	            System.out.println("Error al guardar el stock: " + e.getMessage());
	        }
	    }



}
