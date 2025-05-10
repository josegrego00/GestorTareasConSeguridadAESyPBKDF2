package Vistas;

import Logica.ControladoraLogica;
import Logica.Tarea;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VistaTareas extends javax.swing.JFrame {

    private ControladoraLogica control = new ControladoraLogica();
    private DefaultTableModel modeloTabla;

    public VistaTareas() {
        initComponents();
        setLocationRelativeTo(null);
        configurarTabla();
        cargarTareas();
    }

    private void configurarTabla() {
        modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer que la tabla no sea editable directamente
            }
        };
        
        tblTareas.setModel(modeloTabla);
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Descripción");
        modeloTabla.addColumn("Fecha Creación");
        modeloTabla.addColumn("Fecha Límite");
        modeloTabla.addColumn("Estado");
    }

    private void cargarTareas() {
        modeloTabla.setRowCount(0); // Limpiar tabla
        List<Tarea> tareas = control.obtenerTareas();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        for (Tarea tarea : tareas) {
            Object[] fila = {
                tarea.getId(),
                tarea.getNombreTarea(),
                tarea.getDescriptionTarea(),
                sdf.format(tarea.getFechaCreacion()),
                tarea.getFechaLimite() != null ? sdf.format(tarea.getFechaLimite()) : "Sin fecha",
                tarea.getCompletado() ? "Completada" : "Pendiente"
            };
            modeloTabla.addRow(fila);
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        // Componentes principales
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTareas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnNueva = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCompletar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Tareas");

        // Configuración de la tabla
        tblTareas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "Nombre", "Descripción", "Fecha Creación", "Fecha Límite", "Estado"}
        ));
        tblTareas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblTareas);

        // Panel de botones
        btnNueva.setText("Nueva Tarea");
        btnNueva.addActionListener(this::btnNuevaActionPerformed);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(this::btnEditarActionPerformed);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        btnCompletar.setText("Marcar como Completada");
        btnCompletar.addActionListener(this::btnCompletarActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNueva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCompletar, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
        ));
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCompletar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        // Filtros
        jLabel1.setText("Filtrar tareas:");
        jLabel2.setText("Buscar por nombre:");
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(this::btnFiltrarActionPerformed);

        // Layout principal
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFiltrar))
                        .addGap(0, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            )));
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFiltrar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)))
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
    }

    private void btnNuevaActionPerformed(java.awt.event.ActionEvent evt) {
        VistaNuevaTarea vistaNueva = new VistaNuevaTarea(this, true);
        vistaNueva.setVisible(true);
        cargarTareas();
    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
        int filaSeleccionada = tblTareas.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una tarea para editar", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int idTarea = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
        Tarea tarea = control.obtenerTareaPorId(idTarea);
        
        VistaNuevaTarea vistaEditar = new VistaNuevaTarea(this, true);
        vistaEditar.setVisible(true);
        cargarTareas();
    }

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {
        int filaSeleccionada = tblTareas.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una tarea para eliminar", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirmacion = JOptionPane.showConfirmDialog(
            this, 
            "¿Está seguro que desea eliminar esta tarea?", 
            "Confirmar eliminación", 
            JOptionPane.YES_NO_OPTION
        );
        
      /*  if (confirmacion == JOptionPane.YES_OPTION) {
            int idTarea = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
            control.eliminarTarea(idTarea);
            cargarTareas();
        }*/
    }

    private void btnCompletarActionPerformed(java.awt.event.ActionEvent evt) {
        int filaSeleccionada = tblTareas.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una tarea para marcar", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int idTarea = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
       // control.marcarTareaComoCompletada(idTarea, true);
        cargarTareas();
    }

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {
        String filtro = txtFiltro.getText().trim();
        if (filtro.isEmpty()) {
            cargarTareas();
            return;
        }
        
        modeloTabla.setRowCount(0);
        /*List<Tarea> tareas = control.filtrarTareasPorNombre(filtro);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Tarea tarea : tareas) {
            Object[] fila = {
                tarea.getId(),
                tarea.getNombreTarea(),
                tarea.getDescriptionTarea(),
                sdf.format(tarea.getFechaCreacion()),
                tarea.getFechaLimite() != null ? sdf.format(tarea.getFechaLimite()) : "Sin fecha",
                tarea.getCompletado() ? "Completada" : "Pendiente"
            };
            modeloTabla.addRow(fila);
        }*/
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCompletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnNueva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTareas;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration                   
}