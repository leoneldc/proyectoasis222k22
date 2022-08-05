package trabajadores.modelo;

import trabajadores.controlador.TrabajadorVehiculo;
import clientes.modelo.Conexion;
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
public class TrabajadorVehiculoDAO {

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    private static final String SQL_INSERT = "INSERT into Asignacion_Trabajador_Vehiculo(fkidpiloto,fkidvehiculo) VALUES (?,?)";
    private static final String SQL_DELETE = "DELETE from Asignacion_Trabajador_Vehiculo WHERE pkasignacion = ?";
    private static final String SQL_SELECT = "SELECT * FROM Asignacion_Trabajador_Vehiculo WHERE fkidpiloto = ? AND fkidvehiculo = ?";
    private static final String SQL_SELECTRP = "SELECT * FROM Asignacion_Trabajador_Vehiculo WHERE fkidpiloto = ?";
    private static final String SQL_SELECTRV = "SELECT * FROM Asignacion_Trabajador_Vehiculo WHERE fkidrepartidor = ?";
    private static final String SQL_SELECTN = "SELECT * FROM Asignacion_Trabajador_Vehiculo";
    private static final String SQL_SELECTA = "SELECT * FROM Asignacion_Trabajador_Vehiculo WHERE pkasignacion = ?";
    private static final String SQL_UPDATE = "UPDATE Asignacion_Trabajador_Vehiculo SET fkidrepartidor=? WHERE pkasignacion=?";
    
    public TrabajadorVehiculo query(TrabajadorVehiculo asignacion) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setString(1, asignacion.getIdPiloto());
            stmt.setString(2, asignacion.getIdVehiculo());
            //System.out.println(stmt);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idAsignacion = rs.getString("pkasignacion");
                String idPiloto = rs.getString("fkidpiloto");
                String idRepartidor = rs.getString("fkidrepartidor");
                String idVehiculo = rs.getString("fkidvehiculo");
                String estado = rs.getString("Estasignacion");
                asignacion = new TrabajadorVehiculo();
                asignacion.setIdAsignacion(idAsignacion);
                asignacion.setIdPiloto(idPiloto);
                asignacion.setIdRepartidor(idRepartidor);
                asignacion.setIdVehiculo(idVehiculo);
                asignacion.setEstado(estado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return asignacion;
    }
    
    public TrabajadorVehiculo queryA(TrabajadorVehiculo asignacion) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECTA);
            stmt.setString(1, asignacion.getIdAsignacion());
            //System.out.println(stmt);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idAsignacion = rs.getString("pkasignacion");
                String idPiloto = rs.getString("fkidpiloto");
                String idRepartidor = rs.getString("fkidrepartidor");
                String idVehiculo = rs.getString("fkidvehiculo");
                String estado = rs.getString("Estasignacion");
                asignacion = new TrabajadorVehiculo();
                asignacion.setIdAsignacion(idAsignacion);
                asignacion.setIdPiloto(idPiloto);
                asignacion.setIdRepartidor(idRepartidor);
                asignacion.setIdVehiculo(idVehiculo);
                asignacion.setEstado(estado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return asignacion;
    }
    
    public List<TrabajadorVehiculo> selectV(TrabajadorVehiculo asignacion) {
        List<TrabajadorVehiculo> listadoClientes = new ArrayList<TrabajadorVehiculo>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECTRP);
            stmt.setString(1, asignacion.getIdPiloto());
            //System.out.println(stmt);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idAsignacion = rs.getString("pkasignacion");
                String idPiloto = rs.getString("fkidpiloto");
                String idRepartidor = rs.getString("fkidrepartidor");
                String idVehiculo = rs.getString("fkidvehiculo");
                String estado = rs.getString("Estasignacion");
                asignacion = new TrabajadorVehiculo();
                asignacion.setIdAsignacion(idAsignacion);
                asignacion.setIdPiloto(idPiloto);
                asignacion.setIdRepartidor(idRepartidor);
                asignacion.setIdVehiculo(idVehiculo);
                asignacion.setEstado(estado);
                listadoClientes.add(asignacion);
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
    
    public List<TrabajadorVehiculo> selectVR(TrabajadorVehiculo asignacion) {
        List<TrabajadorVehiculo> listadoClientes = new ArrayList<TrabajadorVehiculo>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECTRV);
            stmt.setString(1, asignacion.getIdRepartidor());
            //System.out.println(stmt);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idAsignacion = rs.getString("pkasignacion");
                String idPiloto = rs.getString("fkidpiloto");
                String idRepartidor = rs.getString("fkidrepartidor");
                String idVehiculo = rs.getString("fkidvehiculo");
                String estado = rs.getString("Estasignacion");
                asignacion = new TrabajadorVehiculo();
                asignacion.setIdAsignacion(idAsignacion);
                asignacion.setIdPiloto(idPiloto);
                asignacion.setIdRepartidor(idRepartidor);
                asignacion.setIdVehiculo(idVehiculo);
                asignacion.setEstado(estado);
                listadoClientes.add(asignacion);
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
   
    public List<TrabajadorVehiculo> selectN(TrabajadorVehiculo asignacion) {
        List<TrabajadorVehiculo> listadoClientes = new ArrayList<TrabajadorVehiculo>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECTN);
            //System.out.println(stmt);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idAsignacion = rs.getString("pkasignacion");
                String idPiloto = rs.getString("fkidpiloto");
                String idRepartidor = rs.getString("fkidrepartidor");
                String idVehiculo = rs.getString("fkidvehiculo");
                String estado = rs.getString("Estasignacion");
                asignacion = new TrabajadorVehiculo();
                asignacion.setIdAsignacion(idAsignacion);
                asignacion.setIdPiloto(idPiloto);
                asignacion.setIdRepartidor(idRepartidor);
                asignacion.setIdVehiculo(idVehiculo);
                asignacion.setEstado(estado);
                listadoClientes.add(asignacion);
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
   
    public int update(TrabajadorVehiculo asignacion) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, asignacion.getIdRepartidor());
            stmt.setString(2, asignacion.getIdAsignacion());
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
    
    public int insert(TrabajadorVehiculo asignacion) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, asignacion.getIdPiloto());
            stmt.setString(2, asignacion.getIdVehiculo());
            //System.out.println("ejecutando query:" + smtm);
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int delete(TrabajadorVehiculo asignacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
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
    
    //--SELECT RUTAS REMITENTE
    public TrabajadorVehiculo selectRM(TrabajadorVehiculo asignacion) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECTA);
            stmt.setString(1, asignacion.getIdAsignacion());
            //System.out.println(stmt);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idAsignacion = rs.getString("pkasignacion");
                String idPiloto = rs.getString("fkidpiloto");
                String idVehiculo = rs.getString("fkidvehiculo");
                asignacion = new TrabajadorVehiculo();
                asignacion.setIdAsignacion(idAsignacion);
                asignacion.setIdPiloto(idPiloto);
                asignacion.setIdVehiculo(idVehiculo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return asignacion;
    }
}
