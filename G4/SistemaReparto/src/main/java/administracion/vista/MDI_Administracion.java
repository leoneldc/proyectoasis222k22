package administracion.vista;

import administracion.controlador.ProcesosRepetidos;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Dimension;

public class MDI_Administracion extends javax.swing.JFrame {
    
    ProcesosRepetidos procesoRepetido = new ProcesosRepetidos();
    private Mnt_Modulos mnt_modulos;
    private Mnt_Aplicaciones mnt_aplicaciones;
    private Mnt_Usuarios mnt_usuarios;
    private Mnt_PuestoTrabajo mnt_puesto_trabajo;
    private Asn_UsuarioAplicacion asn_usuarioAplicacion;

    public MDI_Administracion() {
        initComponents();
        Diseño();
    }

    public void Diseño(){
        Jdp_contenedor.setBackground(new Color(52, 78, 65));
        procesoRepetido.cursorMano(Mnb_menu);
        setTitle("[ USUARIO: " + LOGIN_Administracion.nomUsuario.toUpperCase() + "  [ "+procesoRepetido.getFechaActual("gt")+" ]  ");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jdp_contenedor = new javax.swing.JDesktopPane();
        Mnb_menu = new javax.swing.JMenuBar();
        Sbm_actualizarPermisos = new javax.swing.JMenu();
        Sbm_archivos = new javax.swing.JMenu();
        Sbm_catalogo = new javax.swing.JMenu();
        Mnu_mantenimientos = new javax.swing.JMenu();
        MnI_modulos = new javax.swing.JMenuItem();
        MnI_aplicaciones = new javax.swing.JMenuItem();
        MnI_usuarios = new javax.swing.JMenuItem();
        MnI_puestosT = new javax.swing.JMenuItem();
        MnI_trabajadores = new javax.swing.JMenuItem();
        MnI_clientes = new javax.swing.JMenuItem();
        MnI_vahiculos = new javax.swing.JMenuItem();
        MnI_bodegas = new javax.swing.JMenuItem();
        Sbm_procesos = new javax.swing.JMenu();
        Mnu_procesos = new javax.swing.JMenu();
        MnI_UsuarioAplicacion = new javax.swing.JMenuItem();
        Sbm_herramientas = new javax.swing.JMenu();
        Sbm_ayuda = new javax.swing.JMenu();
        Btn_cerrarSesion = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        javax.swing.GroupLayout Jdp_contenedorLayout = new javax.swing.GroupLayout(Jdp_contenedor);
        Jdp_contenedor.setLayout(Jdp_contenedorLayout);
        Jdp_contenedorLayout.setHorizontalGroup(
            Jdp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        Jdp_contenedorLayout.setVerticalGroup(
            Jdp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 727, Short.MAX_VALUE)
        );

        Sbm_actualizarPermisos.setText("*");
        Sbm_actualizarPermisos.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Sbm_actualizarPermisos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Sbm_actualizarPermisosMouseClicked(evt);
            }
        });
        Mnb_menu.add(Sbm_actualizarPermisos);

        Sbm_archivos.setText("Archivos");
        Sbm_archivos.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Mnb_menu.add(Sbm_archivos);

        Sbm_catalogo.setText("Catalogo");
        Sbm_catalogo.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N

        Mnu_mantenimientos.setText("Mantenimientos");

        MnI_modulos.setText("Modulos");
        MnI_modulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_modulosActionPerformed(evt);
            }
        });
        Mnu_mantenimientos.add(MnI_modulos);

        MnI_aplicaciones.setText("Aplicaciones");
        MnI_aplicaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_aplicacionesActionPerformed(evt);
            }
        });
        Mnu_mantenimientos.add(MnI_aplicaciones);

        MnI_usuarios.setText("Usuarios");
        MnI_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_usuariosActionPerformed(evt);
            }
        });
        Mnu_mantenimientos.add(MnI_usuarios);

        MnI_puestosT.setText("Puestos de Trabajos");
        MnI_puestosT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_puestosTActionPerformed(evt);
            }
        });
        Mnu_mantenimientos.add(MnI_puestosT);

        MnI_trabajadores.setText("Trabajadores");
        Mnu_mantenimientos.add(MnI_trabajadores);

        MnI_clientes.setText("Clientes");
        Mnu_mantenimientos.add(MnI_clientes);

        MnI_vahiculos.setText("Vehiculos");
        Mnu_mantenimientos.add(MnI_vahiculos);

        MnI_bodegas.setText("Bodegas");
        Mnu_mantenimientos.add(MnI_bodegas);

        Sbm_catalogo.add(Mnu_mantenimientos);

        Mnb_menu.add(Sbm_catalogo);

        Sbm_procesos.setText("Procesos");
        Sbm_procesos.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N

        Mnu_procesos.setText("Procesos");

        MnI_UsuarioAplicacion.setText("Asignacion Usuario Aplicacion");
        MnI_UsuarioAplicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_UsuarioAplicacionActionPerformed(evt);
            }
        });
        Mnu_procesos.add(MnI_UsuarioAplicacion);

        Sbm_procesos.add(Mnu_procesos);

        Mnb_menu.add(Sbm_procesos);

        Sbm_herramientas.setText("Herramientas");
        Sbm_herramientas.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Mnb_menu.add(Sbm_herramientas);

        Sbm_ayuda.setText("Ayuda");
        Sbm_ayuda.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Mnb_menu.add(Sbm_ayuda);

        Btn_cerrarSesion.setText("Cerrar Sesión");
        Btn_cerrarSesion.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Mnb_menu.add(Btn_cerrarSesion);

        setJMenuBar(Mnb_menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jdp_contenedor)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jdp_contenedor)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        
    }//GEN-LAST:event_formComponentResized

    private void Sbm_actualizarPermisosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Sbm_actualizarPermisosMouseClicked
        
    }//GEN-LAST:event_Sbm_actualizarPermisosMouseClicked

    private void MnI_modulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_modulosActionPerformed
        mnt_modulos = new Mnt_Modulos();

        Jdp_contenedor.add(mnt_modulos);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = mnt_modulos.getSize();
        mnt_modulos.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        mnt_modulos.setVisible(true);
        mnt_modulos.toFront();
    }//GEN-LAST:event_MnI_modulosActionPerformed

    private void MnI_aplicacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_aplicacionesActionPerformed
        mnt_aplicaciones = new Mnt_Aplicaciones();

        Jdp_contenedor.add(mnt_aplicaciones);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = mnt_aplicaciones.getSize();
        mnt_aplicaciones.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        mnt_aplicaciones.setVisible(true);
        mnt_aplicaciones.toFront();
    }//GEN-LAST:event_MnI_aplicacionesActionPerformed

    private void MnI_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_usuariosActionPerformed
        mnt_usuarios = new Mnt_Usuarios();

        Jdp_contenedor.add(mnt_usuarios);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = mnt_usuarios.getSize();
        mnt_usuarios.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        mnt_usuarios.setVisible(true);
        mnt_usuarios.toFront();
    }//GEN-LAST:event_MnI_usuariosActionPerformed

    private void MnI_puestosTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_puestosTActionPerformed
        mnt_puesto_trabajo = new Mnt_PuestoTrabajo();

        Jdp_contenedor.add(mnt_puesto_trabajo);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = mnt_puesto_trabajo.getSize();
        mnt_puesto_trabajo.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        mnt_puesto_trabajo.setVisible(true);
        mnt_puesto_trabajo.toFront();
    }//GEN-LAST:event_MnI_puestosTActionPerformed

    private void MnI_UsuarioAplicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_UsuarioAplicacionActionPerformed
        asn_usuarioAplicacion = new Asn_UsuarioAplicacion();

        Jdp_contenedor.add(asn_usuarioAplicacion);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = asn_usuarioAplicacion.getSize();
        asn_usuarioAplicacion.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        asn_usuarioAplicacion.setVisible(true);
        asn_usuarioAplicacion.toFront();
    }//GEN-LAST:event_MnI_UsuarioAplicacionActionPerformed

    public static void main(String args[]) {
        //FLATLAF
        FlatLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDI_Administracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenu Btn_cerrarSesion;
    private javax.swing.JDesktopPane Jdp_contenedor;
    private javax.swing.JMenuItem MnI_UsuarioAplicacion;
    public static javax.swing.JMenuItem MnI_aplicaciones;
    public static javax.swing.JMenuItem MnI_bodegas;
    public static javax.swing.JMenuItem MnI_clientes;
    public static javax.swing.JMenuItem MnI_modulos;
    public static javax.swing.JMenuItem MnI_puestosT;
    public static javax.swing.JMenuItem MnI_trabajadores;
    public static javax.swing.JMenuItem MnI_usuarios;
    public static javax.swing.JMenuItem MnI_vahiculos;
    public static javax.swing.JMenuBar Mnb_menu;
    public static javax.swing.JMenu Mnu_mantenimientos;
    public static javax.swing.JMenu Mnu_procesos;
    public static javax.swing.JMenu Sbm_actualizarPermisos;
    public static javax.swing.JMenu Sbm_archivos;
    public static javax.swing.JMenu Sbm_ayuda;
    public static javax.swing.JMenu Sbm_catalogo;
    public static javax.swing.JMenu Sbm_herramientas;
    public static javax.swing.JMenu Sbm_procesos;
    // End of variables declaration//GEN-END:variables
}