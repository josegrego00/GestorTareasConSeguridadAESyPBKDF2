package Vistas;

import Logica.ControladoraLogica;
import Logica.Tarea;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;

public class VistaNuevaTarea extends javax.swing.JDialog {

    private ControladoraLogica controladoraLogica;
    private Tarea tareaEditar;
    private boolean esEdicion;
    private JDateChooser dateChooserFechaLimite;

    public VistaNuevaTarea(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        controladoraLogica = new ControladoraLogica();
        initComponents();
        setLocationRelativeTo(parent);
        this.esEdicion = false;
        configurarVista();
    }

    public VistaNuevaTarea(java.awt.Frame parent, boolean modal, Tarea tarea) {
        super(parent, modal);
        controladoraLogica = new ControladoraLogica();
        initComponents();
        setLocationRelativeTo(parent);
        this.tareaEditar = tarea;
        this.esEdicion = true;
        configurarVista();
        cargarDatosTarea();
    }

    private void configurarVista() {
        if (esEdicion) {
            setTitle("Editar Tarea");
            btnGuardar.setText("Guardar Cambios");
        } else {
            setTitle("Nueva Tarea");
        }
    }

    private void cargarDatosTarea() {
        txtNombre.setText(tareaEditar.getNombreTarea());
        txtDescripcion.setText(tareaEditar.getDescriptionTarea());
        dateChooserFechaLimite.setDate(tareaEditar.getFechaLimite());
        chkCompletada.setSelected(tareaEditar.getCompletado());
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        // Componentes
        dateChooserFechaLimite = new JDateChooser();
        dateChooserFechaLimite.setLocale(new Locale("es", "ES"));
        dateChooserFechaLimite.setDateFormatString("dd/MM/yyyy");
        
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        chkCompletada = new javax.swing.JCheckBox();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nombre de la tarea:");

        jLabel2.setText("Descripción:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jLabel3.setText("Fecha límite:");

        chkCompletada.setText("Marcar como completada");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(evt -> dispose());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(dateChooserFechaLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(chkCompletada))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateChooserFechaLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkCompletada))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        // Validaciones
        String nombre = txtNombre.getText().trim();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre de la tarea es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String descripcion = txtDescripcion.getText().trim();
        Date fechaLimite = dateChooserFechaLimite.getDate();
        boolean completada = chkCompletada.isSelected();

        if (esEdicion) {
            // Lógica para editar
            tareaEditar.setNombreTarea(nombre);
            tareaEditar.setDescriptionTarea(descripcion);
            tareaEditar.setFechaLimite(fechaLimite);
            tareaEditar.setCompletado(completada);

            if (controladoraLogica.editarTarea(tareaEditar)) {
                JOptionPane.showMessageDialog(this, "Tarea actualizada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar la tarea", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Lógica para crear nueva
            Tarea nuevaTarea = new Tarea();
            nuevaTarea.setNombreTarea(nombre);
            nuevaTarea.setDescriptionTarea(descripcion);
            nuevaTarea.setFechaCreacion(new Date());
            nuevaTarea.setFechaLimite(fechaLimite);
            nuevaTarea.setCompletado(completada);

            if (controladoraLogica.crearTarea(nuevaTarea)) {
                JOptionPane.showMessageDialog(this, "Tarea creada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al crear la tarea", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox chkCompletada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration                   
}