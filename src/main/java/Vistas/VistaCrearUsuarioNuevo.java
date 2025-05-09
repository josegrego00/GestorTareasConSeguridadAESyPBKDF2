/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import Logica.ControladoraLogica;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

/**
 *
 * @author josepino
 */
public class VistaCrearUsuarioNuevo extends JFrame {

    private ControladoraLogica controladoraLogica;

    public VistaCrearUsuarioNuevo() {
        initComponents();
        controladoraLogica = new ControladoraLogica();

    }

    private void initComponents() {
        // Configuración básica de la ventana
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Nuevo Usuario");
        setResizable(false);

        // Panel principal con fondo degradado
        jPanel1 = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                Color color1 = new Color(70, 130, 180);  // Azul acero
                Color color2 = new Color(176, 224, 230); // Azul claro
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        jPanel1.setLayout(new java.awt.BorderLayout());

        // Panel del formulario
        jPanel2 = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 25, 25);
                g2.dispose();
            }
        };
        jPanel2.setBackground(new Color(255, 255, 255, 200));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Título del formulario
        JLabel tituloLabel = new JLabel("REGISTRO DE USUARIO");
        tituloLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        tituloLabel.setForeground(new Color(70, 70, 70));
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Configuración de etiquetas
        jLabel1 = new javax.swing.JLabel("Nombre de Usuario:");
        jLabel1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        jLabel1.setForeground(new Color(70, 70, 70));

        jLabel2 = new javax.swing.JLabel("Contraseña:");
        jLabel2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        jLabel2.setForeground(new Color(70, 70, 70));

        jLabel3 = new javax.swing.JLabel("Confirmar Contraseña:");
        jLabel3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        jLabel3.setForeground(new Color(70, 70, 70));

        // Configuración de campos de texto
        txtNombreUsuario = new javax.swing.JTextField();
        stylizeTextField(txtNombreUsuario);

        txtContrasenna = new javax.swing.JPasswordField(); // Cambiado a JPasswordField
        stylizeTextField(txtContrasenna);

        txtContrasennaRepetida = new javax.swing.JPasswordField(); // Cambiado a JPasswordField
        stylizeTextField(txtContrasennaRepetida);

        // Botón de crear usuario
        btnCrearUsuario = new javax.swing.JButton("CREAR USUARIO");
        btnCrearUsuario.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCrearUsuario.setBackground(new Color(70, 130, 180));
        btnCrearUsuario.setForeground(Color.WHITE);
        btnCrearUsuario.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        btnCrearUsuario.setFocusPainted(false);
        btnCrearUsuario.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCrearUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrearUsuario.setBackground(new Color(65, 105, 225));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrearUsuario.setBackground(new Color(70, 130, 180));
            }
        });
        btnCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });

        // Layout del panel del formulario
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(tituloLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNombreUsuario)
                                        .addComponent(txtContrasenna)
                                        .addComponent(txtContrasennaRepetida)
                                        .addComponent(btnCrearUsuario, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tituloLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtNombreUsuario, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtContrasenna, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtContrasennaRepetida, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(btnCrearUsuario, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        // Layout del panel principal
        jPanel1.add(jPanel2, BorderLayout.CENTER);

        // Configuración final de la ventana
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(jPanel1, BorderLayout.CENTER);
        setSize(400, 500);
        setLocationRelativeTo(null); // Centrar la ventana
    }

// Método para estilizar los campos de texto
    private void stylizeTextField(javax.swing.JComponent field) {
        field.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        field.setBackground(new Color(250, 250, 250));
    }

    private void txtNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {
        VistaCrearUsuarioNuevo crearUsuarioNuevo = new VistaCrearUsuarioNuevo();
        crearUsuarioNuevo.setVisible(true);
    }

    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {
        // 1. Obtener datos del formulario
        String nombreUsuario = txtNombreUsuario.getText().trim();
        String contrasenna = txtContrasenna.getText();
        String contrasennaRepetida = txtContrasennaRepetida.getText();

        controladoraLogica.crearUsuario(nombreUsuario, contrasenna, contrasennaRepetida);

    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCrearUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtContrasenna;
    private javax.swing.JTextField txtContrasennaRepetida;
    private javax.swing.JTextField txtNombreUsuario;
    // End of variables declaration                   
}

