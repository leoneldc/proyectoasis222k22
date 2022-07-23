package administracion.modelo;


import administracion.controlador.TrabajadorAplicacion;
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
public class TrabajadorAplicacionDAO {

    private static final String SQL_SELECTV = "SELECT * FROM Asignacion_Trabajador_Apliacion WHERE  fpkidtrabajador=? AND fpkidaplicacion=?";
    private static final String SQL_SELECT = "SELECT * FROM Asignacion_Trabajador_Apliacion WHERE  fpkidtrabajador=?";
    private static final String SQL_INSERT = "INSERT INTO Asignacion_Trabajador_Apliacion VALUES (?,?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE from Asignacion_Trabajador_Apliacion where fpkidtrabajador=? AND fpkidaplicacion=?";
    private static final String SQL_UPDATE = "UPDATE Asignacion_Trabajador_Apliacion SET Ingresarca=?, Consultarca=?, Modificarca=?, Eliminarca=? WHERE fpkidtrabajador=? AND fpkidaplicacion=?";

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public TrabajadorAplicacion selectV(TrabajadorAplicacion trabajador) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECTV);
            stmt.setString(1, trabajador.getIdTrabajador());
            stmt.setString(2, trabajador.getIdAplicacion());
            //System.out.println(stmt);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idUsuario = rs.getString("fpkidtrabajador");
                String idApp = rs.getString("fpkidaplicacion");
                String Guardar = rs.getString("Ingresarca");
                String Buscar = rs.getString("Consultarca");
                String Modificar = rs.getString("Modificarca");
                String Eliminar = rs.getString("Eliminarca");
                trabajador.setIdTrabajador(idUsuario);
                trabajador.setIdAplicacion(idUsuario);
                trabajador.setGuardar(Guardar);
                trabajador.setEliminar(Eliminar);
                trabajador.setModificar(Modificar);
                trabajador.setBuscar(Buscar);
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

    public List<TrabajadorAplicacion> selectTA(TrabajadorAplicacion trabajadores) {
        List<TrabajadorAplicacion> listaAsignacion = new ArrayList<TrabajadorAplicacion>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setString(1, trabajadores.getIdTrabajador());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idUsuario = rs.getString("fpkidtrabajador");
                String idApp = rs.getString("fpkidaplicacion");
                String Guardar = rs.getString("Ingresarca");
                String Buscar = rs.getString("Consultarca");
                String Modificar = rs.getString("Modificarca");
                String Eliminar = rs.getString("Eliminarca");
                trabajadores = new TrabajadorAplicacion();
                trabajadores.setIdTrabajador(idUsuario);
                trabajadores.setIdAplicacion(idApp);
                trabajadores.setGuardar(Guardar);
                trabajadores.setBuscar(Buscar);
                trabajadores.setModificar(Modificar);
                trabajadores.setEliminar(Eliminar);
                listaAsignacion.add(trabajadores);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return listaAsignacion;
    }

    public int insert(TrabajadorAplicacion asignacion) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, asignacion.getIdTrabajador());
            stmt.setString(2, asignacion.getIdAplicacion());
            stmt.setString(3, asignacion.getGuardar());
            stmt.setString(4, asignacion.getBuscar());
            stmt.setString(5, asignacion.getModificar());
            stmt.setString(6, asignacion.getEliminar());
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

    public int delete(TrabajadorAplicacion asignacion) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, asignacion.getIdTrabajador());
            stmt.setString(2, asignacion.getIdAplicacion());
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

    public int update(TrabajadorAplicacion asignacion) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, asignacion.getGuardar());
            stmt.setString(2, asignacion.getBuscar());
            stmt.setString(3, asignacion.getModificar());
            stmt.setString(4, asignacion.getEliminar());
            stmt.setString(5, asignacion.getIdTrabajador());
            stmt.setString(6, asignacion.getIdAplicacion());
            //System.out.println(stmt + " "+rows);
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
