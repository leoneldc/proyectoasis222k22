

package administracion.modelo;

import administracion.controlador.Trabajadores;
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

public class TrabajadoresDAO {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    public static String codigoTrabajador, nombreTrabajador;
    private static final String SQL_INSERT = "INSERT into Trabajadores(fkidpuestotrabajo,Nomtbd,Apelltbd,Usernametbd,Passwordtbd,Emailtbd,Esttbd) values(?,?,?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE from Trabajadores where pkidtrabajador = ?";
    private static final String SQL_UPDATE = "UPDATE Trabajadores SET fkidpuestotrabajo=?, Nomtbd=?, Apelltbd=?, Usernametbd=?, Passwordtbd=?, Emailtbd=?, Esttbd=? WHERE pkidtrabajador=?";
    private static final String SQL_SELECTTA = "SELECT * FROM Trabajadores WHERE pkidtrabajador = ?";
    private static final String SQL_SELECTL = "SELECT * FROM Trabajadores WHERE Usernametbd = ?";
    
    public List<Trabajadores> select() {
        String SQL_SELECT = "SELECT * FROM Trabajadores WHERE pkidtrabajador LIKE '%" + codigoTrabajador + "%' OR Nomtbd LIKE '%" + nombreTrabajador + "%'";
        Trabajadores puestosT = null;
        List<Trabajadores> listadoTrabajadores = new ArrayList<Trabajadores>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("pkidtrabajador");
                String idPT = rs.getString("fkidpuestotrabajo");
                String nombre = rs.getString("Nomtbd");
                String apellido = rs.getString("Apelltbd");
                String usuario = rs.getString("Usernametbd");
                String password = rs.getString("Passwordtbd");
                String email = rs.getString("Emailtbd");
                String ultimac = rs.getString("Ultimactbd");
                String estado = rs.getString("Esttbd");
                puestosT = new Trabajadores();
                puestosT.setIdTrabaajdor(id);
                puestosT.setIdPuestoT(idPT);
                puestosT.setNombre(nombre);
                puestosT.setApellido(apellido);
                puestosT.setUsuario(usuario);
                puestosT.setPassword(password);
                puestosT.setEmail(email);
                puestosT.setUltimac(ultimac);
                puestosT.setEstado(estado);
                listadoTrabajadores.add(puestosT);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return listadoTrabajadores;
    }
    
    public int insert(Trabajadores trabajador) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, trabajador.getIdPuestoT());
            stmt.setString(2, trabajador.getNombre());
            stmt.setString(3, trabajador.getApellido());
            stmt.setString(4, trabajador.getUsuario());
            stmt.setString(5, trabajador.getPassword());
            stmt.setString(6, trabajador.getEmail());
            stmt.setString(7, trabajador.getEstado());
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

    public int delete(Trabajadores trabajadores) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, trabajadores.getIdTrabaajdor());
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
    
    public int update(Trabajadores trabajador) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, trabajador.getIdPuestoT());
            stmt.setString(2, trabajador.getNombre());
            stmt.setString(3, trabajador.getApellido());
            stmt.setString(4, trabajador.getUsuario());
            stmt.setString(5, trabajador.getPassword());
            stmt.setString(6, trabajador.getEmail());
            stmt.setString(7, trabajador.getEstado());
            stmt.setString(8, trabajador.getIdTrabaajdor());
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
    
    public Trabajadores selectL(Trabajadores trabajador) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECTL);
            stmt.setString(1, trabajador.getUsuario());
            //System.out.println(stmt);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("pkidtrabajador");
                String idPT = rs.getString("fkidpuestotrabajo");
                String nombre = rs.getString("Nomtbd");
                String apellido = rs.getString("Apelltbd");
                String usuario = rs.getString("Usernametbd");
                String password = rs.getString("Passwordtbd");
                String email = rs.getString("Emailtbd");
                String ultimac = rs.getString("Ultimactbd");
                String estado = rs.getString("Esttbd");
                trabajador.setIdTrabaajdor(id);
                trabajador.setIdPuestoT(idPT);
                trabajador.setNombre(nombre);
                trabajador.setApellido(apellido);
                trabajador.setUsuario(usuario);
                trabajador.setPassword(password);
                trabajador.setEmail(email);
                trabajador.setUltimac(ultimac);
                trabajador.setEstado(estado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return trabajador;
    }
    
    public Trabajadores selectTA(Trabajadores trabajador) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECTTA);
            stmt.setString(1, trabajador.getIdTrabaajdor());
            //System.out.println(stmt);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("pkidtrabajador");
                String idPT = rs.getString("fkidpuestotrabajo");
                String nombre = rs.getString("Nomtbd");
                String apellido = rs.getString("Apelltbd");
                String usuario = rs.getString("Usernametbd");
                String password = rs.getString("Passwordtbd");
                String email = rs.getString("Emailtbd");
                String ultimac = rs.getString("Ultimactbd");
                String estado = rs.getString("Esttbd");
                trabajador.setIdTrabaajdor(id);
                trabajador.setIdPuestoT(idPT);
                trabajador.setNombre(nombre);
                trabajador.setApellido(apellido);
                trabajador.setUsuario(usuario);
                trabajador.setPassword(password);
                trabajador.setEmail(email);
                trabajador.setUltimac(ultimac);
                trabajador.setEstado(estado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return trabajador;
    }
}
