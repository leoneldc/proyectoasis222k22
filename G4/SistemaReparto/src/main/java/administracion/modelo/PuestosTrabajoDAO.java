

package administracion.modelo;

import administracion.controlador.PuestosTrabajo;
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

public class PuestosTrabajoDAO {

    public static String codigoPuestoT, nombrePuestoT;
    private static final String SQL_INSERT = "INSERT into Puestos_trabajo(Nompt,Descpt,Estpt) values(?,?,?)";
    private static final String SQL_DELETE = "DELETE from Puestos_trabajo where pkidpuestotrabajo = ?";
    private static final String SQL_UPDATE = "UPDATE Puestos_trabajo SET Nompt=?, Descpt=?, Estpt=? WHERE pkidpuestotrabajo=?";
    private static final String SQL_SELECTV = "SELECT * FROM Puestos_trabajo WHERE pkidpuestotrabajo=?";
    
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    public List<PuestosTrabajo> select() {
        String SQL_SELECT = "SELECT * FROM Puestos_trabajo WHERE pkidpuestotrabajo LIKE '%" + codigoPuestoT + "%' OR Nompt LIKE '%" + nombrePuestoT + "%'";
        PuestosTrabajo puestosT = null;
        List<PuestosTrabajo> listaPuestosT = new ArrayList<PuestosTrabajo>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("pkidpuestotrabajo");
                String nombre = rs.getString("Nompt");
                String descripcion = rs.getString("Descpt");
                String estado = rs.getString("Estpt");
                puestosT = new PuestosTrabajo();
                puestosT.setId(id);
                puestosT.setNombre(nombre);
                puestosT.setDescripcion(descripcion);
                puestosT.setEstado(estado);
                listaPuestosT.add(puestosT);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return listaPuestosT;
    }
    
    public int insert(PuestosTrabajo puestoT) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, puestoT.getNombre());
            stmt.setString(2, puestoT.getDescripcion());
            stmt.setString(3, puestoT.getEstado());
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

    public int delete(PuestosTrabajo puestoT) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, puestoT.getId());
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
    
    public int update(PuestosTrabajo puestoT) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, puestoT.getNombre());
            stmt.setString(2, puestoT.getDescripcion());
            stmt.setString(3, puestoT.getEstado());
            stmt.setString(4, puestoT.getId());
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
        
    public PuestosTrabajo selectV(PuestosTrabajo puestoT) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECTV);
            stmt.setString(1, puestoT.getId());
            //System.out.println(stmt);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("pkidpuestotrabajo");
                String nombre = rs.getString("Nompt");
                String descripcion = rs.getString("Descpt");
                String estado = rs.getString("Estpt");
                puestoT.setId(id);
                puestoT.setNombre(nombre);
                puestoT.setDescripcion(descripcion);
                puestoT.setEstado(estado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return puestoT;
    }
    
}
