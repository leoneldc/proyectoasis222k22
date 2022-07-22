

package administracion.vista;

import administracion.controlador.Bitacora;
import administracion.controlador.ProcesosRepetidos;
import administracion.modelo.BitacoraDAO;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

 /**
 * @author H. Leonel Dominguez C.
 * @github https://github.com/leoneldc
 */

public class FuncionesBitacora {
    ProcesosRepetidos procesosr = new ProcesosRepetidos();
    
    public void GuardarBitacora(String accion, String modulo){
        try {
            Bitacora btc = new Bitacora();
            BitacoraDAO btcDAO = new BitacoraDAO();
            
            //funcion para obtener el host y ip del equipo
            InetAddress addr = InetAddress.getLocalHost();
            String hostname = addr.getHostName();
            String ipname = addr.getHostAddress();
            
            btc.setIdUsuario(LOGIN_Administracion.idUsuario);
            btc.setFecha(procesosr.getFechaActual("us"));
            btc.setHora(procesosr.getHoraActual());
            btc.setHost(hostname);
            btc.setIp(ipname);
            btc.setAccion(accion);
            btc.setIdModuloApp(modulo);
            btcDAO.insert(btc);
        } catch (UnknownHostException ex) {
            Logger.getLogger(FuncionesBitacora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
