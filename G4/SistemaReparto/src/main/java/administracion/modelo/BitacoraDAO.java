package administracion.modelo;

import administracion.controlador.Bitacora;
import java.net.UnknownHostException;
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
public class BitacoraDAO {

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    public static String codigoUsuario, codigoAplicacion, fechaBusqueda;
    private static final String SQL_INSERT = "INSERT INTO Bitacora VALUES(?,?,?,?,?,?,?,?)";
    
    public List<Bitacora> select() {
        String SQL_SELECT = "SELECT * FROM Bitacora WHERE fkidusuario LIKE '%" + codigoUsuario + "%' OR fkappbtc LIKE '%" + codigoAplicacion + "%' OR Fechabtc LIKE '%" + fechaBusqueda + "%'";
        Bitacora bitacora = null;
        List<Bitacora> listaEventos = new ArrayList<Bitacora>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idBitacora = rs.getString("pkidbitacora");
                String idUsuario = rs.getString("fkidusuario");
                String fecha = rs.getString("Fechabtc");
                String hora = rs.getString("Horabtc");
                String host = rs.getString("Hostbtc");
                String ip = rs.getString("Ipbtc");
                String accion = rs.getString("Accionbtc");
                String idAplicaion = rs.getString("fkappbtc");
                bitacora = new Bitacora();
                bitacora.setIdBitacora(idBitacora);
                bitacora.setIdUsuario(idUsuario);
                bitacora.setFecha(fecha);
                bitacora.setHora(hora);
                bitacora.setHost(host);
                bitacora.setIp(ip);
                bitacora.setAccion(accion);
                bitacora.setIdModuloApp(idAplicaion);
                listaEventos.add(bitacora);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return listaEventos;
    }

    public int insert(Bitacora btc) throws UnknownHostException {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, "0");
            stmt.setString(2, btc.getIdUsuario());
            stmt.setString(3, btc.getFecha());
            stmt.setString(4, btc.getHora());
            stmt.setString(5, btc.getHost());
            stmt.setString(6, btc.getIp());
            stmt.setString(7, btc.getAccion());
            stmt.setString(8, btc.getIdModuloApp());
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
