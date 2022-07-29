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
        MDI_Trabajadores.MnI_RutasRemitente.setVisible(false);

        permisos.setIdTrabajador(id);
        List<TrabajadorAplicacion> listadoPermisos = permisosDAO.selectTA(permisos);
        for (TrabajadorAplicacion permiso : listadoPermisos) {
            switch (Integer.parseInt(permiso.getIdAplicacion())) {
                case 1001:
                    MDI_Trabajadores.MnI_RutasRemitente.setVisible(true);
                    break;
            }
        }

    }

}
