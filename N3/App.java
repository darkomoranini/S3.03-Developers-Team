package N3;
import java.util.*;
import com.mongodb.client.*;

public class App {

	public static void main(String[] args) {

		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase database = mongoClient.getDatabase("floristeria");
		MongoCollection<Document> stockCollection = database.getCollection("productos");

		Floristeria floristeria = new Floristeria("Hojas");

		Arbol arbol1 = new Arbol("Pino", 70, 2.5);
		Flor flor1 = new Flor ("Rosas", 10, "Blancas");
		Decoracion decoracion1 = new Decoracion("Jardinera", 30, "Madera");

		floristeria.addProducto(arbol1, 5);
		floristeria.addProducto(flor1, 10);
		floristeria.addProducto(decoracion1, 25);

		guardarStockMongoDB(stockCollection, floristeria.stock);

		floristeria.imprimirStock();
		floristeria.imprimirValorTotalStock();

		floristeria.retirarProducto(decoracion1, 3);

		cargarStockMongoDB(stockCollection, floristeria.stock);

		Ticket ticket1 = new Ticket();
		ticket1.addProducto(arbol1);
		ticket1.addProducto(flor1);
		ticket1.imprimirTicket();

	}
	public static void cargarStockMongoDB(MongoCollection<Document> stockCollection, Map<String, Integer> stock) {
		stock.clear();
		stockCollection.find().forEach(document -> {
			String producto = document.getString("producto");
			int cantidad = document.getInteger("cantidad");
			stock.put(producto, cantidad);
		});
		System.out.println("Stock cargado desde MongoDB.");
	}

	public static void guardarStockMongoDB(MongoCollection<Document> stockCollection, Map<String, Integer> stock) {
		stockCollection.deleteMany(new BasicDBObject()); // Eliminar todos los documentos existentes

		for (Map.Entry<String, Integer> entry : stock.entrySet()) {
			Document document = new Document()
					.append("producto", entry.getKey())
					.append("cantidad", entry.getValue());
			stockCollection.insertOne(document);
		}

		System.out.println("Stock guardado en MongoDB.");
	}
}
