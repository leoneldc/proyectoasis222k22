

package trabajadores.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trabajadores.controlador.RutaPedido;

 /**
 * @author H. Leonel Dominguez C.
 * @github https://github.com/leoneldc
 */

public class RutaPedidoDAO {

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    private static final String SQL_CONFIRMACION = "SELECT validarEspacioEnCamion(?)";
    private static final String SQL_SELECT = "SELECT * FROM asignacion_ruta_pedido WHERE fpkidruta = ?";
    private static final String SQL_INSERT = "INSERT INTO asignacion_ruta_pedido(fpkidruta, fpkidpedido) VALUES(?,?)";
    private static final String SQL_DELETE = "DELETE from asignacion_ruta_pedido WHERE pkidasignacion = ?";
    
    
    
    public float queryA(String ruta) {
        float respuesta = 0;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_CONFIRMACION);
            stmt.setString(1, ruta);
            //System.out.println(stmt);
            rs = stmt.executeQuery();
            while (rs.next()) {
                respuesta = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return respuesta;
    }
        
    public List<RutaPedido> query(RutaPedido asignacion) {
        List<RutaPedido> listadoAsignaciones = new ArrayList<RutaPedido>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setString(1, asignacion.getIdRuta());
            //System.out.println(stmt);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idAsignacion = rs.getString("pkidasignacion");
                String idRuta = rs.getString("fpkidruta");
                String idPedido = rs.getString("fpkidpedido");
                asignacion = new RutaPedido();
                asignacion.setIdAsignacion(idAsignacion);
                asignacion.setIdRuta(idRuta);
                asignacion.setIdPedido(idPedido);
                listadoAsignaciones.add(asignacion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return listadoAsignaciones;
    }
    
    public int insert(RutaPedido asignacion) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, asignacion.getIdRuta());
            stmt.setString(2, asignacion.getIdPedido());
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

    public int delete(RutaPedido asignacion) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, asignacion.getIdAsignacion());
            //System.out.println(stmt);
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
}
