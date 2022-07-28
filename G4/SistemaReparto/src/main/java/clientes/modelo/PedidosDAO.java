

package clientes.modelo;

import clientes.controlador.Pedidos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 /**
 * @author H. Leonel Dominguez C.
 * @github https://github.com/leoneldc
 */

public class PedidosDAO {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    public static String codigoTrabajador, nombreTrabajador;
    private static final String SQL_INSERT = "INSERT into Pedidos(fpkidcliente,fechapdd,Rempdd,Destpdd,Zonapdd,Nompdd,Telpdd,Tampdd) values(?,?,?,?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE from Pedidos where pkidpedido = ?";
    private static final String SQL_UPDATE = "UPDATE Pedidos SET fpkidcliente=?, fechapdd=?, Rempdd=?, Destpdd=?, Zonapdd=?, Nompdd=?, Telpdd=?, Tampdd=?, Estpdd WHERE pkidpedido=?";
    private static final String SQL_SELECTTA = "SELECT * FROM Pedidos WHERE pkidpedido = ?";
    private static final String SQL_SELECTL = "SELECT * FROM Pedidos WHERE fpkidcliente = ?";
    
    public int insert(Pedidos pedidos) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, pedidos.getId());
            stmt.setString(2, pedidos.getFecha());
            stmt.setString(3, pedidos.getDireR());
            stmt.setString(4, pedidos.getDireD());
            stmt.setString(5, pedidos.getZonaD());
            stmt.setString(6, pedidos.getNomD());
            stmt.setString(7, pedidos.getTelD());
            stmt.setString(8, pedidos.getTamP());
            //System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            //System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
}
