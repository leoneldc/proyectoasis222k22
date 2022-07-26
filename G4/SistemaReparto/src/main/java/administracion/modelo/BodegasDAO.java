

package administracion.modelo;

import administracion.controlador.Bodegas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 /**
 * @author leeluis
 */

public class BodegasDAO {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    public static String codigoBodega, nombreBodega;
    private static final String SQL_INSERT = "INSERT into Bodegas(fkidencargado,Direcbdg,CapaMaxbdg,Estbdg) values(?,?,?,?)";
    private static final String SQL_DELETE = "DELETE from Bodegas where pkidbodega = ?";
    private static final String SQL_UPDATE = "UPDATE Bodegas SET fkidencargado=?, Direcbdg=?, CapaMaxbdg=?, Estbdg=? WHERE pkidbodega=?";
    private static final String SQL_SELECTTA = "SELECT * FROM Bodegas WHERE pkidbodega = ?";
    private static final String SQL_SELECTL = "SELECT * FROM Bodegas WHERE fkidencargado = ?";
    
    public List<Bodegas> select() {
        String SQL_SELECT = "SELECT * FROM Bodegas WHERE pkidbodega LIKE '%" + codigoBodega + "%' OR Direcbdg LIKE '%" + nombreBodega + "%'";
        Bodegas bodegas = null;
        List<Bodegas> listadoBodegas = new ArrayList<Bodegas>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("pkidbodega");
                String encargado = rs.getString("fkidencargado");
                String direccion = rs.getString("Direcbdg");
                String capacidad = rs.getString("Capabdg");
                String max = rs.getString("CapaMaxbdg");
                String estado = rs.getString("Estbdg");
                bodegas = new Bodegas();
                bodegas.setId(id);
                bodegas.setEncargado(encargado);
                bodegas.setDireccion(direccion);
                bodegas.setCapacidad(capacidad);
                bodegas.setMax(max);
                bodegas.setEstado(estado);
                listadoBodegas.add(bodegas);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return listadoBodegas;
    }
    
    public int insert(Bodegas bodega) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, bodega.getEncargado());
            stmt.setString(2, bodega.getDireccion());
            stmt.setString(3, bodega.getMax());
            stmt.setString(4, bodega.getEstado());
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

    public int delete(Bodegas bodega) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, bodega.getId());
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
    
    public int update(Bodegas bodega) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, bodega.getEncargado());
            stmt.setString(2, bodega.getDireccion());
            stmt.setString(3, bodega.getMax());
            stmt.setString(4, bodega.getEstado());
            stmt.setString(5, bodega.getId());
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
