package persistencia;

import conexion.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersistenciaBD implements Almacenamiento {
    @Override
    public void registrar(String registro) {
        String sql = "INSERT INTO registro (fecha_pedido, monto_total) VALUES (?, ?)";

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            String[] partes = registro.split("\\|\\|");
            statement.setString(1, partes[0]); //fecha pedido
            statement.setString(2, partes[1]); //monto total

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
