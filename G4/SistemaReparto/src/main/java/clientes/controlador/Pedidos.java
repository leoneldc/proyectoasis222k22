/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientes.controlador;

/**
 *
 * @author leelu
 */
public class Pedidos {

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDireR() {
        return direR;
    }

    public void setDireR(String direR) {
        this.direR = direR;
    }

    public String getDireD() {
        return direD;
    }

    public void setDireD(String direD) {
        this.direD = direD;
    }

    public String getZonaD() {
        return zonaD;
    }

    public void setZonaD(String zonaD) {
        this.zonaD = zonaD;
    }

    public String getNomD() {
        return nomD;
    }

    public void setNomD(String nomD) {
        this.nomD = nomD;
    }

    public String getTelD() {
        return telD;
    }

    public void setTelD(String telD) {
        this.telD = telD;
    }

    public String getTamP() {
        return tamP;
    }

    public void setTamP(String tamP) {
        this.tamP = tamP;
    }
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    @Override
    public String toString() {
        return "Pedidos{" + "idCliente=" + idCliente + ", fecha=" + fecha + ", direR=" + direR + ", direD=" + direD + ", zonaD=" + zonaD + ", nomD=" + nomD + ", telD=" + telD + ", tamP=" + tamP + ", estado=" + estado + ", idPedido=" + idPedido + '}';
    }
    
    private String idCliente, fecha, direR, direD, zonaD, nomD, telD, tamP, estado, idPedido;

}
