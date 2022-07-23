

package administracion.controlador;

 /**
 * @author H. Leonel Dominguez C.
 * @github https://github.com/leoneldc
 */

public class Trabajadores {
    private String idTrabaajdor, idPuestoT, nombre, apellido, usuario, password, ultimac, email, estado;

    public String getIdTrabaajdor() {
        return idTrabaajdor;
    }

    public void setIdTrabaajdor(String idTrabaajdor) {
        this.idTrabaajdor = idTrabaajdor;
    }

    public String getIdPuestoT() {
        return idPuestoT;
    }

    public void setIdPuestoT(String idPuestoT) {
        this.idPuestoT = idPuestoT;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUltimac() {
        return ultimac;
    }

    public void setUltimac(String ultimac) {
        this.ultimac = ultimac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
