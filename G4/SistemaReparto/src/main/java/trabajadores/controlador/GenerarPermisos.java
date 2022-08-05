package trabajadores.controlador;

import administracion.controlador.*;
import administracion.modelo.TrabajadorAplicacionDAO;
import java.util.List;
import trabajadores.vista.MDI_Trabajadores;

/**
 * @author H. Leonel Dominguez C.
 * @github https://github.com/leoneldc
 */
public class GenerarPermisos {

    TrabajadorAplicacion permisos = new TrabajadorAplicacion();
    TrabajadorAplicacionDAO permisosDAO = new TrabajadorAplicacionDAO();

    public void cargarAplicaciones(String id) {
        MDI_Trabajadores.MnI_PilotoVehiculo.setVisible(false);
        MDI_Trabajadores.MnI_RepartidorVehiculo.setVisible(false);
        MDI_Trabajadores.MnI_RutasRemitente.setVisible(false);
        MDI_Trabajadores.MnI_RutaPedido.setVisible(true);

        permisos.setIdTrabajador(id);
        List<TrabajadorAplicacion> listadoPermisos = permisosDAO.selectTA(permisos);
        for (TrabajadorAplicacion permiso : listadoPermisos) {
            switch (Integer.parseInt(permiso.getIdAplicacion())) {
                case 1001:MDI_Trabajadores.MnI_PilotoVehiculo.setVisible(true);MDI_Trabajadores.MnI_RepartidorVehiculo.setVisible(true);break;
                case 1002:MDI_Trabajadores.MnI_RutasRemitente.setVisible(true);break;
                case 1003:MDI_Trabajadores.MnI_RutaPedido.setVisible(true);break;
            }
        }

    }

}
