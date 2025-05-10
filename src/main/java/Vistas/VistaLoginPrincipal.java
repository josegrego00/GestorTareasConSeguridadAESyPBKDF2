/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Logica.ControladoraLogica;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;

/**
 *
 * @author josepino
 */
public class VistaLoginPrincipal extends javax.swing.JFrame {

    private ControladoraLogica controladoraLogica;

    public VistaLoginPrincipal() {
        initComponents();
        controladoraLogica = new ControladoraLogica();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        // Configuración básica de la ventana
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SecureTask Manager - Login");
        setResizable(false);

        // Panel principal con fondo degradado
        jPanel1 = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                Color color1 = new Color(56, 67, 236);
                Color color2 = new Color(90, 135, 255);
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
                g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
                g2.dispose();
            }
        };
        jPanel2.setBackground(new Color(255, 255, 255, 230));
        jPanel2.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15),
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(new Color(200, 200, 200, 100), 1, true),
                        "INICIAR SESIÓN",
                        javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.TOP,
                        new Font("Segoe UI", Font.BOLD, 12),
                        new Color(70, 70, 70)
                ))
        );

        // Componentes del formulario
        jLabel3 = new javax.swing.JLabel("Usuario:");
        jLabel3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        jLabel3.setForeground(new Color(70, 70, 70));

        txtUsuario = new javax.swing.JTextField();
        txtUsuario.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        txtUsuario.setBackground(new Color(250, 250, 250));
        txtUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        jLabel2 = new javax.swing.JLabel("Contraseña:");
        jLabel2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        jLabel2.setForeground(new Color(70, 70, 70));

        txtContrasenna = new javax.swing.JPasswordField();
        txtContrasenna.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        txtContrasenna.setBackground(new Color(250, 250, 250));
        txtContrasenna.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        btnIngresar = new javax.swing.JButton("INGRESAR");
        btnIngresar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnIngresar.setBackground(new Color(56, 67, 236));
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        btnIngresar.setFocusPainted(false);
        btnIngresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // Añade este ActionListener
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIngresar.setBackground(new Color(40, 57, 216));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIngresar.setBackground(new Color(56, 67, 236));
            }
        });

        btnNuevoUsuario = new javax.swing.JButton("¿No tienes cuenta? Regístrate");
        btnNuevoUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        btnNuevoUsuario.setContentAreaFilled(false);
        btnNuevoUsuario.setForeground(new Color(56, 67, 236));
        btnNuevoUsuario.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        btnNuevoUsuario.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnNuevoUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNuevoUsuario.setForeground(new Color(40, 57, 216));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNuevoUsuario.setForeground(new Color(56, 67, 236));
            }
        });

        btnNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoUsuarioActionPerformed(evt);
            }
        });

        // Layout del panel del formulario
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtUsuario)
                                        .addComponent(txtContrasenna)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnIngresar, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(btnNuevoUsuario, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtContrasenna, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addComponent(btnIngresar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNuevoUsuario)
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        // Título de la aplicación
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 28));
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html><div style='text-align: center;'>SecureTask<br>Manager</div></html>");

        // Layout del panel principal
        jPanel1.add(jLabel1, java.awt.BorderLayout.NORTH);
        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        // Configuración final de la ventana
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null); // Centrar la ventana
    }

    private void btnNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {
        if (controladoraLogica.nuevoUsuario()) {
            this.dispose();
        }

    }

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {
        if (controladoraLogica.validarUsuario(txtUsuario, txtContrasenna)) {
            this.dispose();
        }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnNuevoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField txtContrasenna;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration                   
}
