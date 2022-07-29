package administracion.vista;

import administracion.controlador.ProcesosRepetidos;
import administracion.controlador.Trabajadores;
import administracion.modelo.TrabajadoresDAO;
import java.util.List;

/**
 * @author H. Leonel Dominguez C.
 * @github https://github.com/leoneldc
 */
public class Vst_Trabajadores extends javax.swing.JFrame {

    /**
     * Creates new form Vst_Trabajadores
     */
    public Vst_Trabajadores() {
        initComponents();
        setTitle("Vista de trabajadores activos");
        cargarDatos();
    }

    private void cargarDatos() {
        ProcesosRepetidos procesosr = new ProcesosRepetidos();
        TrabajadoresDAO.codigoTrabajador = "";
        TrabajadoresDAO.nombreTrabajador = "";
        String encabezado[] = {"ID TRABAJADOR", "ID PUESTO T", "NOMBRE", "APELLDIO", "USER", "PASSWORD", "EMAIL", "ULTIMA CONEX", "ESTADO"};
        int cantidadcolumnas = encabezado.length;
        procesosr.llenarColumnas(encabezado, cantidadcolumnas, Tbl_Datos);
        String datos[] = new String[cantidadcolumnas];
        int tamaño[] = {75, 75, 100, 100, 125, 75, 125, 150, 75};
        TrabajadoresDAO trabajadoresDAO = new TrabajadoresDAO();
        List<Trabajadores> listadoTrabajadores = trabajadoresDAO.select();
        for (Trabajadores trabajador : listadoTrabajadores) {
            datos[0] = trabajador.getIdTrabaajdor();
            datos[1] = trabajador.getIdPuestoT();
            datos[2] = trabajador.getNombre();
            datos[3] = trabajador.getApellido();
            datos[4] = trabajador.getUsuario();
            datos[5] = trabajador.getPassword();
            datos[6] = trabajador.getEmail();
            if (trabajador.getUltimac() == null) {
                datos[7] = "N/C";
            } else {
                datos[7] = trabajador.getUltimac();
            }
            if (trabajador.getEstado().equals("1")) {
                datos[8] = "activo";
            } else {
                datos[8] = "inactivo";
            }
            procesosr.llenarFilas(datos, tamaño, Tbl_Datos);
        }
    }

    /**
     * Esto es codigo generado automaticamente por el IDE debido al Design *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_Datos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(88, 129, 87));

        Tbl_Datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Tbl_Datos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1154, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vst_Trabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vst_Trabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vst_Trabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vst_Trabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vst_Trabajadores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tbl_Datos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
