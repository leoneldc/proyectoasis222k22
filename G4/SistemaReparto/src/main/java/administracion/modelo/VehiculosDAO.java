package administracion.modelo;

import administracion.controlador.Vehiculos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author leeluis500
 */
public class VehiculosDAO {

    public static String codigoVehiculos, nombreVehiculos;
    private static final String SQL_INSERT = "INSERT into Vehiculos(Placavhc,Marcavhc,Modelovhc,Añovhc,Colorvhc,CapaMaxvhc,Estvhc) values(?,?,?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE from Vehiculos where pkidvehiculo = ?";
    private static final String SQL_UPDATE = "UPDATE Vehiculos SET Placavhc=?, Marcavhc=?, Modelovhc=?, Añovhc=?, Colorvhc=?, CapaMaxvhc=?, Estvhc=? WHERE pkidvehiculo=?";
    private static final String SQL_SELECT = "SELECT * FROM Vehiculos WHERE pkidvehiculo = ?";
    private static final String SQL_UPDATEL = "UPDATE Vehiculos SET Ultimacuser=? WHERE pkidvehiculo=?";
    private static final String SQL_UPDATEPV = "UPDATE Vehiculos SET Estvhc=? WHERE pkidvehiculo=?";
    

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public List<Vehiculos> select() {
        String SQL_SELECT = "SELECT * FROM Vehiculos WHERE pkidvehiculo LIKE '%" + codigoVehiculos + "%' OR Marcavhc LIKE '%" + nombreVehiculos + "%'";
        Vehiculos vehiculos = null;
        List<Vehiculos> listaVehiculos = new ArrayList<Vehiculos>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("pkidvehiculo");
                String placa = rs.getString("Placavhc");
                String marca = rs.getString("Marcavhc");
                String modelo = rs.getString("Modelovhc");
                String ano = rs.getString("Añovhc");
                String color = rs.getString("Colorvhc");
                String capacidad = rs.getString("CapaMaxvhc");
                String estado = rs.getString("Estvhc");
                vehiculos = new Vehiculos();
                vehiculos.setId(id);
                vehiculos.setPlaca(placa);
                vehiculos.setMarca(marca);
                vehiculos.setModelo(modelo);
                vehiculos.setAno(ano);
                vehiculos.setColor(color);
                vehiculos.setMax(capacidad);
                vehiculos.setEstado(estado);
                listaVehiculos.add(vehiculos);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return listaVehiculos;
    }

    public int insert(Vehiculos vehiculos) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, vehiculos.getPlaca());
            stmt.setString(2, vehiculos.getMarca());
            stmt.setString(3, vehiculos.getModelo());
            stmt.setString(4, vehiculos.getAno());
            stmt.setString(5, vehiculos.getColor());
            stmt.setString(6, vehiculos.getMax());
            stmt.setString(7, vehiculos.getEstado());
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

    public int delete(Vehiculos vehiculos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, vehiculos.getId());
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

    public int update(Vehiculos vehiculos) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, vehiculos.getPlaca());
            stmt.setString(2, vehiculos.getMarca());
            stmt.setString(3, vehiculos.getModelo());
            stmt.setString(4, vehiculos.getAno());
            stmt.setString(5, vehiculos.getColor());
            stmt.setString(6, vehiculos.getMax());
            stmt.setString(7, vehiculos.getEstado());
            stmt.setString(8, vehiculos.getId());
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
    
    public Vehiculos selectUA(Vehiculos vehiculos) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setString(1, vehiculos.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("pkidvehiculo");
                String placa = rs.getString("Placavhc");
                String marca = rs.getString("Marcavhc");
                String modelo = rs.getString("Modelovhc");
                String ano = rs.getString("Añovhc");
                String color = rs.getString("Colorvhc");
                String capacidad = rs.getString("CapaMaxvhc");
                String estado = rs.getString("Estvhc");
                vehiculos = new Vehiculos();
                vehiculos.setId(id);
                vehiculos.setPlaca(placa);
                vehiculos.setMarca(marca);
                vehiculos.setModelo(modelo);
                vehiculos.setAno(ano);
                vehiculos.setColor(color);
                vehiculos.setMax(capacidad);
                vehiculos.setEstado(estado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return vehiculos;
    }

    public int updateL(Vehiculos vehiculos) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATEL);
            stmt.setString(1, vehiculos.getId());
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
    
    
    //-------- UPDATE PARA ASIGNACION PILOTO A VEHICULO 
    public int updatePV(Vehiculos vehiculos) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATEPV);
            stmt.setString(1, vehiculos.getEstado());
            stmt.setString(2, vehiculos.getId());
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
