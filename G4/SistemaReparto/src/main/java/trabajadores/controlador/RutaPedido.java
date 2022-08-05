

package trabajadores.controlador;

 /**
 * @author H. Leonel Dominguez C.
 * @github https://github.com/leoneldc
 */

public class RutaPedido {
    private String idAsignacion, idRuta, idPedido;

    public String getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(String idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public String getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(String idRuta) {
        this.idRuta = idRuta;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    @Override
    public String toString() {
        return "RutaPedido{" + "idAsignacion=" + idAsignacion + ", idRuta=" + idRuta + ", idPedido=" + idPedido + '}';
    }

}
