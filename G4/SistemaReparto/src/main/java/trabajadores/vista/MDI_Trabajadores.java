package trabajadores.vista;


import administracion.controlador.ProcesosRepetidos;
import administracion.controlador.Trabajadores;
import administracion.modelo.TrabajadoresDAO;
import administracion.vista.*;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import trabajadores.controlador.GenerarPermisos;

public class MDI_Trabajadores extends javax.swing.JFrame {

    ProcesosRepetidos procesoRepetido = new ProcesosRepetidos();
    GenerarPermisos gpermisos = new GenerarPermisos();
    String idBusqueda = LOGIN_Trabajadores.idUsuario;

    public static JLabel Jl_logo = new JLabel();
    
    private Vst_Bitacora vst_bitacora;
    private Asgn_RutaRemitente asgn_RutaRemitente;

    public MDI_Trabajadores() {
        initComponents();
        InicioSesion();
        Diseño();
    }

    public void Diseño() {
        Jdp_contenedor.setBackground(new Color(83, 107, 120));
        procesoRepetido.cursorMano(Mnb_menu);
        setTitle("[ USUARIO: " + LOGIN_Trabajadores.nomUsuario.toUpperCase() + "  " + procesoRepetido.getFechaActual("gt") + " ]  ");
        logo();
        Jdp_contenedor.add(Jl_logo);
    }

    private void InicioSesion() {
        TrabajadoresDAO ldao = new TrabajadoresDAO();
        Trabajadores login = new Trabajadores();
        gpermisos.cargarAplicaciones(idBusqueda);
        login.setIdTrabaajdor(idBusqueda);
        login.setUltimac(procesoRepetido.getFechaActual("us") + " " + procesoRepetido.getHoraActual());
        ldao.updateL(login);
    }
    
    public void logo() {
        ImageIcon icon = new ImageIcon("src/main/java/assets/logoT.png");
        Jl_logo.setSize(512, 512);
        if (icon != null) {
            Jl_logo.setIcon(icon);
        } else {
            System.out.println("error al cargar el logo");
        }
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = Jl_logo.getSize();
        Jl_logo.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
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
        Sbm_procesos = new javax.swing.JMenu();
        Mnu_procesos = new javax.swing.JMenu();
        MnI_RutasRemitente = new javax.swing.JMenuItem();
        Sbm_herramientas = new javax.swing.JMenu();
        MnI_bitacora = new javax.swing.JMenuItem();
        Sbm_ayuda = new javax.swing.JMenu();
        Btn_cerrarSesion = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        Jdp_contenedor.setBackground(new java.awt.Color(83, 107, 120));

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
        Sbm_catalogo.add(Mnu_mantenimientos);

        Mnb_menu.add(Sbm_catalogo);

        Sbm_procesos.setText("Procesos");
        Sbm_procesos.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N

        Mnu_procesos.setText("Procesos");

        MnI_RutasRemitente.setText("Creación de Rutas de Remitente");
        MnI_RutasRemitente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_RutasRemitenteActionPerformed(evt);
            }
        });
        Mnu_procesos.add(MnI_RutasRemitente);

        Sbm_procesos.add(Mnu_procesos);

        Mnb_menu.add(Sbm_procesos);

        Sbm_herramientas.setText("Herramientas");
        Sbm_herramientas.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N

        MnI_bitacora.setText("Bitacora");
        MnI_bitacora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_bitacoraActionPerformed(evt);
            }
        });
        Sbm_herramientas.add(MnI_bitacora);

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
        logo();
    }//GEN-LAST:event_formComponentResized

    private void Sbm_actualizarPermisosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Sbm_actualizarPermisosMouseClicked

    }//GEN-LAST:event_Sbm_actualizarPermisosMouseClicked

    private void MnI_bitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_bitacoraActionPerformed
        vst_bitacora = new Vst_Bitacora();

        Jdp_contenedor.add(vst_bitacora);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = vst_bitacora.getSize();
        vst_bitacora.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        vst_bitacora.setVisible(true);
        vst_bitacora.toFront();
    }//GEN-LAST:event_MnI_bitacoraActionPerformed

    private void MnI_RutasRemitenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_RutasRemitenteActionPerformed
        asgn_RutaRemitente = new Asgn_RutaRemitente();

        Jdp_contenedor.add(asgn_RutaRemitente);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = asgn_RutaRemitente.getSize();
        asgn_RutaRemitente.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        asgn_RutaRemitente.setVisible(true);
        asgn_RutaRemitente.toFront();
    }//GEN-LAST:event_MnI_RutasRemitenteActionPerformed

    public static void main(String args[]) {
        //FLATLAF
        FlatLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDI_Trabajadores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenu Btn_cerrarSesion;
    private javax.swing.JDesktopPane Jdp_contenedor;
    public static javax.swing.JMenuItem MnI_RutasRemitente;
    private javax.swing.JMenuItem MnI_bitacora;
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
