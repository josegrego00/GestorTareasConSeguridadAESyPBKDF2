/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Tarea;
import Logica.Usuario;
import java.util.List;

public class ControladoraPersistencia {
    UsuarioJpaController usuarioJpaController;
    TareaJpaController tareaJpaController;
    
    public ControladoraPersistencia() {
        usuarioJpaController= new UsuarioJpaController();
        tareaJpaController= new TareaJpaController();
    }

    public List<Usuario> listarUsuarios() {
       return usuarioJpaController.findUsuarioEntities();
    }

    public void crearUsuario(Usuario nuevoUsuario) {
       usuarioJpaController.create(nuevoUsuario);
    }

    public List<Tarea> obtenerTareas() {
       return tareaJpaController.findTareaEntities();
    }

    public Tarea obtenerTareaPorId(int idTarea) {
       return tareaJpaController.findTarea(idTarea);
    }

   
    
}
