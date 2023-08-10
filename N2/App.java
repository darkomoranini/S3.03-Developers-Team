package N2;
import java.sql.*;
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

		guardarStockMySQL(floristeria.stock);
		
		floristeria.imprimirStock();
		floristeria.imprimirValorTotalStock();

		floristeria.retirarProducto(decoracion1, 3);

		cargarStockMySQL(floristeria.stock);
		
		Ticket ticket1 = new Ticket();
		ticket1.addProducto(arbol1);
		ticket1.addProducto(flor1);
		ticket1.imprimirTicket();

	}
	public static void cargarStockMySQL(Map<String, Integer> stock) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Floristeria", "root", "12345678");
            String query = "SELECT producto, cantidad FROM stock";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                String producto = resultSet.getString("producto");
                int cantidad = resultSet.getInt("cantidad");
                stock.put(producto, cantidad);
            }
            
            resultSet.close();
            statement.close();
            connection.close();
            
            System.out.println("Stock cargado desde MySQL.");
        } catch (SQLException e) {
            System.out.println("Error al cargar el stock desde MySQL: " + e.getMessage());
        }
    }

	 public static void guardarStockMySQL(Map<String, Integer> stock) {
	        try {
	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Floristeria", "root", "12345678");
	            String deleteQuery = "DELETE FROM stock";
	            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
	            deleteStatement.executeUpdate();
	            
	            String insertQuery = "INSERT INTO stock (producto, cantidad) VALUES (?, ?)";
	            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
	            
	            for (Map.Entry<String, Integer> entry : stock.entrySet()) {
	                insertStatement.setString(1, entry.getKey());
	                insertStatement.setInt(2, entry.getValue());
	                insertStatement.executeUpdate();
	            }
	            
	            insertStatement.close();
	            deleteStatement.close();
	            connection.close();
	            
	            System.out.println("Stock guardado en MySQL.");
	        } catch (SQLException e) {
	            System.out.println("Error al guardar el stock en MySQL: " + e.getMessage());
	        }
	    }

}
