package administracion.controlador;

 /**
 * @author H. Leonel Dominguez C.
 * @github https://github.com/leoneldc
 */

public class Bitacora {
    private String idBitacora, idUsuario, fecha, hora, host, ip, accion, idModuloApp;

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getIdModuloApp() {
        return idModuloApp;
    }

    public void setIdModuloApp(String idModuloApp) {
        this.idModuloApp = idModuloApp;
    }
    public String getIdBitacora() {
        return idBitacora;
    }

    public void setIdBitacora(String idBitacora) {
        this.idBitacora = idBitacora;
    }

    @Override
    public String toString() {
        return "Bitacora{" + "idUsuario=" + idUsuario + ", fecha=" + fecha + ", hora=" + hora + ", host=" + host + ", ip=" + ip + ", accion=" + accion + ", idModuloApp=" + idModuloApp + '}';
    }


}
