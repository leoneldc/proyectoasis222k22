package administracion.vista;

import administracion.controlador.Bitacora;
import administracion.controlador.ProcesosRepetidos;
import administracion.modelo.BitacoraDAO;
import java.util.List;

/**
 * @author H. Leonel Dominguez C.
 * @github https://github.com/leoneldc
 */
public class Vst_Bitacora extends javax.swing.JInternalFrame {

    ProcesosRepetidos procesosr = new ProcesosRepetidos();

    /**
     * Creates new form Vst_Bitacora
     */
    public Vst_Bitacora() {
        initComponents();
        diseño();
        cargarBitacora("");
    }

    public void diseño() {
        setTitle("BITACORA DE EVENTOS");
        procesosr.cursorMano(Tbl_Datos, Btn_ayuda, Btn_reporte);
    }

    private void cargarBitacora(String query) {
        ProcesosRepetidos procesosr = new ProcesosRepetidos();
        BitacoraDAO bitacoraDAO = new BitacoraDAO();
        BitacoraDAO.codigoAplicacion = query;
        BitacoraDAO.codigoUsuario = query;
        BitacoraDAO.fechaBusqueda = query;
        String encabezado[] = {"ID BITACORA", "ID USUARIO", "FECHA", "HORA", "HOST", "IP", "ACCIÓN", "ID APLICACIÓN"};
        int cantidadcolumnas = encabezado.length;
        procesosr.llenarColumnas(encabezado, cantidadcolumnas, Tbl_Datos);
        String datos[] = new String[cantidadcolumnas];
        int tamaño[] = {125, 125, 125, 125, 150, 150, 150, 125};
        List<Bitacora> listaBitacora = bitacoraDAO.select();
        for (Bitacora evento : listaBitacora) {
            datos[0] = evento.getIdBitacora();
            datos[1] = evento.getIdUsuario();
            datos[2] = evento.getFecha();
            datos[3] = evento.getHora();
            datos[4] = evento.getHost();
            datos[5] = evento.getIp();
            datos[6] = evento.getAccion();
            datos[7] = evento.getIdModuloApp();
            procesosr.llenarFilas(datos, tamaño, Tbl_Datos);
        }
    }

    /**
     * Esto es codigo generado automaticamente por el IDE debido al Design *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_datos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tbl_Datos = new javax.swing.JTable();
        Lbl_id = new javax.swing.JLabel();
        Txt_query = new javax.swing.JTextField();
        Btn_fondoReporte = new javax.swing.JPanel();
        Btn_reporte = new javax.swing.JLabel();
        Btn_fondoAyuda = new javax.swing.JPanel();
        Btn_ayuda = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        Pnl_datos.setBackground(new java.awt.Color(163, 177, 138));
        Pnl_datos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(52, 78, 65), 1, true));

        Tbl_Datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(Tbl_Datos);

        Lbl_id.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_id.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_id.setText("BUSCAR POR ID USUARIO O ID APLICACION O FECHA:");

        Txt_query.setBackground(new java.awt.Color(163, 177, 138));
        Txt_query.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Txt_query.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(88, 129, 87)));
        Txt_query.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Txt_queryKeyReleased(evt);
            }
        });

        Btn_fondoReporte.setBackground(new java.awt.Color(97, 212, 195));
        Btn_fondoReporte.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_fondoReporte.setMinimumSize(new java.awt.Dimension(104, 40));

        Btn_reporte.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_reporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_reporte.setText("Reporte");
        Btn_reporte.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_reporte.setMinimumSize(new java.awt.Dimension(104, 40));
        Btn_reporte.setPreferredSize(new java.awt.Dimension(104, 40));
        Btn_reporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_reporteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_reporteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_reporteMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondoReporteLayout = new javax.swing.GroupLayout(Btn_fondoReporte);
        Btn_fondoReporte.setLayout(Btn_fondoReporteLayout);
        Btn_fondoReporteLayout.setHorizontalGroup(
            Btn_fondoReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_reporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Btn_fondoReporteLayout.setVerticalGroup(
            Btn_fondoReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_reporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Btn_fondoAyuda.setBackground(new java.awt.Color(253, 255, 182));
        Btn_fondoAyuda.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_fondoAyuda.setMinimumSize(new java.awt.Dimension(104, 40));

        Btn_ayuda.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_ayuda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_ayuda.setText("Ayuda");
        Btn_ayuda.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_ayuda.setMinimumSize(new java.awt.Dimension(104, 40));
        Btn_ayuda.setPreferredSize(new java.awt.Dimension(104, 40));
        Btn_ayuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_ayudaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_ayudaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_ayudaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondoAyudaLayout = new javax.swing.GroupLayout(Btn_fondoAyuda);
        Btn_fondoAyuda.setLayout(Btn_fondoAyudaLayout);
        Btn_fondoAyudaLayout.setHorizontalGroup(
            Btn_fondoAyudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Btn_fondoAyudaLayout.setVerticalGroup(
            Btn_fondoAyudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Pnl_datosLayout = new javax.swing.GroupLayout(Pnl_datos);
        Pnl_datos.setLayout(Pnl_datosLayout);
        Pnl_datosLayout.setHorizontalGroup(
            Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Pnl_datosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(Pnl_datosLayout.createSequentialGroup()
                        .addComponent(Lbl_id)
                        .addGap(18, 18, 18)
                        .addComponent(Txt_query, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btn_fondoReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_fondoAyuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Pnl_datosLayout.setVerticalGroup(
            Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_datosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(Pnl_datosLayout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(Txt_query))
                        .addComponent(Btn_fondoReporte, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Btn_fondoAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Lbl_id, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1145, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Pnl_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Pnl_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Txt_queryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_queryKeyReleased
        String query = Txt_query.getText();
        cargarBitacora(query);
    }//GEN-LAST:event_Txt_queryKeyReleased

    private void Btn_reporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporteMouseClicked
        System.out.println("reporte");
    }//GEN-LAST:event_Btn_reporteMouseClicked

    private void Btn_reporteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporteMouseEntered
        procesosr.pintarComponente("sVerde", Btn_fondoReporte);
    }//GEN-LAST:event_Btn_reporteMouseEntered

    private void Btn_reporteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporteMouseExited
        procesosr.pintarComponente("dsVerde", Btn_fondoReporte);
    }//GEN-LAST:event_Btn_reporteMouseExited

    private void Btn_ayudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseClicked
        System.out.println("ayuda");
    }//GEN-LAST:event_Btn_ayudaMouseClicked

    private void Btn_ayudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseEntered
        procesosr.pintarComponente("sAmarillo", Btn_fondoAyuda);
    }//GEN-LAST:event_Btn_ayudaMouseEntered

    private void Btn_ayudaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseExited
        procesosr.pintarComponente("dsAmarillo", Btn_fondoAyuda);
    }//GEN-LAST:event_Btn_ayudaMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Btn_ayuda;
    private javax.swing.JPanel Btn_fondoAyuda;
    private javax.swing.JPanel Btn_fondoReporte;
    private javax.swing.JLabel Btn_reporte;
    private javax.swing.JLabel Lbl_id;
    private javax.swing.JPanel Pnl_datos;
    private javax.swing.JTable Tbl_Datos;
    private javax.swing.JTextField Txt_query;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

}
