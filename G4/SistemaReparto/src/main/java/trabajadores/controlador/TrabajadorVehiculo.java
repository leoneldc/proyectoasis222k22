

package trabajadores.controlador;

 /**
 * @author H. Leonel Dominguez C.
 * @github https://github.com/leoneldc
 */

public class TrabajadorVehiculo {
    private String idPiloto, idRepartidor, idVehiculo, idAsignacion, estado;

    @Override
    public String toString() {
        return "PilotoVehiculo{" + "idPiloto=" + idPiloto + ", idVehiculo=" + idVehiculo + '}';
    }
    
    public String getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(String idPiloto) {
        this.idPiloto = idPiloto;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(String idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public String getIdRepartidor() {
        return idRepartidor;
    }

    public void setIdRepartidor(String idRepartidor) {
        this.idRepartidor = idRepartidor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    

}
