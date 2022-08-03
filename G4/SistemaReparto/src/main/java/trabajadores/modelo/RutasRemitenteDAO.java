

package trabajadores.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trabajadores.controlador.RutasRemitente;

 /**
 * @author H. Leonel Dominguez C.
 * @github https://github.com/leoneldc
 */

public class RutasRemitenteDAO {
    
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    public static String idruta, idasignacion;
    private static final String SQL_INSERT = "INSERT into Rutas_Remitente(fkpilveh,Estrr) values(?,?)";
    private static final String SQL_DELETE = "DELETE from Rutas_Remitente where pkidruta = ?";
    private static final String SQL_UPDATE = "UPDATE Rutas_Remitente SET fkpilveh=?, Estrr=? WHERE pkidruta=?";
    
    public List<RutasRemitente> select() {
        String SQL_SELECT = "SELECT * FROM Rutas_Remitente WHERE pkidruta LIKE '%" + idruta + "%' OR fkpilveh LIKE '%" + idasignacion + "%'";
        RutasRemitente rutas = null;
        List<RutasRemitente> listaRemitente = new ArrayList<RutasRemitente>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idAsn = rs.getString("pkidruta");
                String idVehiculo = rs.getString("fkpilveh");
                String estado = rs.getString("Estrr");
                rutas = new RutasRemitente();
                rutas.setIdRuta(idAsn);
                rutas.setIdAsignacion(idVehiculo);
                rutas.setEstado(estado);
                listaRemitente.add(rutas);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return listaRemitente;
    }
    
    public int insert(RutasRemitente asignacion) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, asignacion.getIdAsignacion());
            stmt.setString(2, asignacion.getEstado());
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
    
    public int delete(RutasRemitente asignacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, asignacion.getIdRuta());
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
    
    public int update(RutasRemitente asignacion) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, asignacion.getIdAsignacion());
            stmt.setString(2, asignacion.getEstado());
            stmt.setString(3, asignacion.getIdRuta());
//          System.out.println(stmt);
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
