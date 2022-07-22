package administracion.controlador;


import administracion.modelo.UsuarioAplicacionDAO;
import administracion.vista.MDI_Administracion;
import java.util.List;

/**
 * @author H. Leonel Dominguez C.
 * @github https://github.com/leoneldc
 */
public class GenerarPermisos {

    UsuarioAplicacion permisos = new UsuarioAplicacion();
    UsuarioAplicacionDAO permisosDAO = new UsuarioAplicacionDAO();

    public void cargarAplicaciones(String id) {
        
        MDI_Administracion.MnI_modulos.setVisible(false);
        MDI_Administracion.MnI_aplicaciones.setVisible(false);
        MDI_Administracion.MnI_usuarios.setVisible(false);
        MDI_Administracion.MnI_trabajadores.setVisible(false);
        MDI_Administracion.MnI_puestosT.setVisible(false);
        MDI_Administracion.MnI_vahiculos.setVisible(false);
        MDI_Administracion.MnI_bodegas.setVisible(false);
        MDI_Administracion.MnI_clientes.setVisible(false);
        MDI_Administracion.MnI_UsuarioAplicacion.setVisible(false);

        permisos.setIdUsuario(id);
        List<UsuarioAplicacion> listadoPermisos = permisosDAO.selectUA(permisos);
        for (UsuarioAplicacion permiso : listadoPermisos) {
            switch (Integer.parseInt(permiso.getIdAplicacion())) {
                case 4:MDI_Administracion.MnI_modulos.setVisible(true);break;
                case 5:MDI_Administracion.MnI_aplicaciones.setVisible(true);break;
                case 6:MDI_Administracion.MnI_usuarios.setVisible(true);break;
                case 7:MDI_Administracion.MnI_trabajadores.setVisible(true);break;
                case 8:MDI_Administracion.MnI_puestosT.setVisible(true);break;
                case 9:MDI_Administracion.MnI_vahiculos.setVisible(true);break;
                case 10:MDI_Administracion.MnI_bodegas.setVisible(true);break;
                case 11:MDI_Administracion.MnI_clientes.setVisible(true);break;
                case 30:MDI_Administracion.MnI_UsuarioAplicacion.setVisible(true);break;
            }
        }

    }
    
    
}
