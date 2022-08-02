

package administracion.modelo;

import administracion.controlador.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 /**
 * @author leeluis500
 */

public class ClientesDAO {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    public static String codigoCliente, nombreCliente;
    private static final String SQL_INSERT = "INSERT into Clientes(Nomcte,Usercte,Passwordcte,Emailcte,Telcte,Estcte) values(?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE from Clientes where pkidcliente = ?";
    private static final String SQL_UPDATE = "UPDATE Clientes SET Nomcte=?, Usercte=?, Passwordcte=?, Emailcte=?, Telcte=?, Estcte=? WHERE pkidcliente=?";
    private static final String SQL_SELECTTA = "SELECT * FROM Clientes WHERE pkidcliente = ?";
    private static final String SQL_SELECTL = "SELECT * FROM Clientes WHERE Usercte = ?";
    
    public List<Clientes> select() { 
        String SQL_SELECT = "SELECT * FROM Clientes WHERE pkidcliente LIKE '%" + codigoCliente + "%' OR Nomcte LIKE '%" + nombreCliente + "%'";
        Clientes clientes = null;
        List<Clientes> listadoClientes = new ArrayList<Clientes>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("pkidcliente");
                String nombre = rs.getString("Nomcte");
                String user = rs.getString("Usercte");
                String password = rs.getString("Passwordcte");
                String email = rs.getString("Emailcte");
                String telefono = rs.getString("Telcte");
                String estado = rs.getString("Estcte");
                clientes = new Clientes();
                clientes.setId(id);
                clientes.setNombre(nombre);
                clientes.setUsuario(user);
                clientes.setPassword(password);
                clientes.setEmail(email);
                clientes.setTelefono(telefono);
                clientes.setEstado(estado);
                listadoClientes.add(clientes);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return listadoClientes;
    }
    
    public int insert(Clientes clientes) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, clientes.getNombre());
            stmt.setString(2, clientes.getUsuario());
            stmt.setString(3, clientes.getPassword());
            stmt.setString(4, clientes.getEmail());
            stmt.setString(5, clientes.getTelefono());
            stmt.setString(6, clientes.getEstado());
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

    public int delete(Clientes clientes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, clientes.getId());
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
    
    public int update(Clientes clientes) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, clientes.getNombre());
            stmt.setString(2, clientes.getPassword());
            stmt.setString(3, clientes.getEmail());
            stmt.setString(4, clientes.getTelefono());
            stmt.setString(5, clientes.getEstado());
            stmt.setString(6, clientes.getId());
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
    
    public Clientes selectL(Clientes clientes) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECTL);
            stmt.setString(1, clientes.getUsuario());
            //System.out.println(stmt);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("pkidcliente");
                String user = rs.getString("Usercte");
                String nombre = rs.getString("Nomcte");
                String password = rs.getString("Passwordcte");
                String email = rs.getString("Emailcte");
                String telefono = rs.getString("Telcte");
                String estado = rs.getString("Estcte");
                clientes = new Clientes();
                clientes.setId(id);
                clientes.setNombre(nombre);
                clientes.setUsuario(user);
                clientes.setPassword(password);
                clientes.setEmail(email);
                clientes.setTelefono(telefono);
                clientes.setEstado(estado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return clientes;
    }
    
    public Clientes selectTA(Clientes clientes) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECTTA);
            stmt.setString(1, clientes.getId());
            //System.out.println(stmt);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("pkidcliente");
                String nombre = rs.getString("Nomtbd");
                String user = rs.getString("Usercte");
                String password = rs.getString("Passwordcte");
                String email = rs.getString("Emailcte");
                String telefono = rs.getString("Telcte");
                String estado = rs.getString("Estcte");
                clientes = new Clientes();
                clientes.setId(id);
                clientes.setNombre(nombre);
                clientes.setUsuario(user);
                clientes.setPassword(password);
                clientes.setEmail(email);
                clientes.setTelefono(telefono);
                clientes.setEstado(estado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return clientes;
    }
}
