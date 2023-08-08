package N1;

import java.util.HashMap;

public class Floristeria {
	String nombre;
    HashMap<String, Integer> stock;
    double valorTotalStock;

    public Floristeria(String nombre) {
    	this.nombre=nombre;
    	this.stock = new HashMap<>();
    	this.valorTotalStock=0;
    }

    public void addProducto(Producto producto, int cantidad) {
    	stock.put(producto.nombre, stock.getOrDefault(producto.nombre, 0)+cantidad);
    	valorTotalStock +=producto.precio*cantidad;
    }

    public void retirarProducto(Producto producto, int cantidad) {
    	if(stock.containsKey(producto.nombre)) {
    		int cantidadActual = stock.get(producto.nombre);
    		if(cantidadActual >= cantidad) {
    			stock.put(producto.nombre, cantidadActual-cantidad);
    			valorTotalStock -= producto.precio * cantidad;
    		}else {
    			System.out.println("No hay stock para retirar.");
    		}
    	}else {
    		  System.out.println("El producto no se encuentra");
    	}
    }

    public void imprimirStock() {
        System.out.println("Stock de la floristeria " + nombre + ":");
        for (String producto : stock.keySet()) {
            System.out.println(producto + " - Quantitat: " + stock.get(producto));
        }
    }
    public void imprimirValorTotalStock() {
        System.out.println("Valor total del stock de la floristeria " + nombre + ": " + valorTotalStock);
    }
}
