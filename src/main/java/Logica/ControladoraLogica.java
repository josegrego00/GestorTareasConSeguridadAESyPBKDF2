package Logica;

import Persistencia.ControladoraPersistencia;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ControladoraLogica {
    // Constantes para el bloqueo por intentos fallidos
    private static final int INTENTOS_MAXIMOS = 3;
    private static final long TIEMPO_BLOQUEO_MS = 100000; // 5 minutos
    
    // Estructuras para control de intentos
    private final Map<String, Integer> intentosFallidos = new HashMap<>();
    private final Map<String, Long> usuariosBloqueados = new HashMap<>();
    
    private final ControladoraPersistencia controladoraPersistencia;

    public ControladoraLogica() {
        controladoraPersistencia = new ControladoraPersistencia();
    }

    public void crearUsuario(String nombreUsuario, String contrasenna, String contrasennaRepetida) {
        if (nombreUsuario.isEmpty() || contrasenna.isEmpty() || contrasennaRepetida.isEmpty()) {
            mostrarError("Todos los campos son obligatorios");
            return;
        }
        
        if (!contrasenna.equals(contrasennaRepetida)) {
            mostrarError("Las contraseñas no coinciden");
            return;
        }

        try {
            byte[] salt = generarSalt();
            String[] hashSeguro = generarHashSeguro(contrasenna, salt);
            
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setNombreUsuario(nombreUsuario);
            nuevoUsuario.setContrasennaUsuario(hashSeguro[0]);
            nuevoUsuario.setSalt(hashSeguro[1]);
            nuevoUsuario.setIntera(250000);
            nuevoUsuario.setAlgorithm("PBKDF2WithHmacSHA256");

            controladoraPersistencia.crearUsuario(nuevoUsuario);
            mostrarExito("Usuario creado exitosamente");

        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            mostrarError("Error al crear el usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void validarUsuario(JTextField txtUsuario, JPasswordField txtContrasenna) {
        String nombreUsuario = txtUsuario.getText();
        
        // Verificar bloqueo antes de buscar en la base de datos
        if (estaUsuarioBloqueado(nombreUsuario)) {
            mostrarMensajeBloqueo(nombreUsuario);
            return;
        }
        
        Usuario usuario = buscarUsuario(nombreUsuario);
        if (usuario == null) {
            registrarIntentoFallido(nombreUsuario);
            mostrarError("Credenciales incorrectas");
            return;
        }
        
        try {
            boolean credencialesValidas = verificarCredenciales(usuario, txtContrasenna.getPassword());
            
            if (credencialesValidas) {
                reiniciarIntentos(nombreUsuario);
                mostrarExito("Login exitoso");
                // Aquí iría la lógica para abrir la siguiente ventana
            } else {
                registrarIntentoFallido(nombreUsuario);
                mostrarError("Contraseña incorrecta");
            }
        } catch (Exception e) {
            mostrarError("Error al validar usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Métodos auxiliares para seguridad
    private byte[] generarSalt() {
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        return salt;
    }
    
    private String[] generarHashSeguro(String contrasenna, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec spec = new PBEKeySpec(contrasenna.toCharArray(), salt, 250000, 256);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] hash = factory.generateSecret(spec).getEncoded();
        
        return new String[] {
            Base64.getEncoder().encodeToString(hash),
            Base64.getEncoder().encodeToString(salt)
        };
    }
    
    private boolean verificarCredenciales(Usuario usuario, char[] contrasennaIngresada) throws Exception {
        byte[] salt = Base64.getDecoder().decode(usuario.getSalt());
        PBEKeySpec spec = new PBEKeySpec(contrasennaIngresada, salt, usuario.getIntera(), 256);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(usuario.getAlgorithm());
        byte[] hashGenerado = factory.generateSecret(spec).getEncoded();
        
        return Base64.getEncoder().encodeToString(hashGenerado).equals(usuario.getContrasennaUsuario());
    }

    // Métodos para manejo de usuarios
    private Usuario buscarUsuario(String nombreUsuario) {
        List<Usuario> listaUsuario = controladoraPersistencia.listarUsuarios();
        return listaUsuario.stream()
                .filter(user -> user.getNombreUsuario().equals(nombreUsuario))
                .findFirst()
                .orElse(null);
    }

    // Métodos para bloqueo por intentos fallidos
    private boolean estaUsuarioBloqueado(String nombreUsuario) {
        if (!usuariosBloqueados.containsKey(nombreUsuario)) return false;
        
        long tiempoDesbloqueo = usuariosBloqueados.get(nombreUsuario);
        if (System.currentTimeMillis() < tiempoDesbloqueo) {
            return true;
        } else {
            usuariosBloqueados.remove(nombreUsuario);
            intentosFallidos.remove(nombreUsuario);
            return false;
        }
    }
    
    private void registrarIntentoFallido(String nombreUsuario) {
        int intentos = intentosFallidos.getOrDefault(nombreUsuario, 0) + 1;
        intentosFallidos.put(nombreUsuario, intentos);
        
        if (intentos >= INTENTOS_MAXIMOS) {
            usuariosBloqueados.put(nombreUsuario, System.currentTimeMillis() + TIEMPO_BLOQUEO_MS);
        }
    }
    
    private void reiniciarIntentos(String nombreUsuario) {
        intentosFallidos.remove(nombreUsuario);
        usuariosBloqueados.remove(nombreUsuario);
    }
    
    private void mostrarMensajeBloqueo(String nombreUsuario) {
        long tiempoRestante = (usuariosBloqueados.get(nombreUsuario) - System.currentTimeMillis()) / 1000;
        long minutos = tiempoRestante / 60;
        long segundos = tiempoRestante % 60;
        
        JOptionPane.showMessageDialog(null, 
            "Cuenta bloqueada. Intente nuevamente en " + minutos + " minutos y " + segundos + " segundos.", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
    
    // Métodos auxiliares para mensajes
    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private void mostrarExito(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    public List<Tarea> obtenerTareas() {
        return controladoraPersistencia.obtenerTareas();
    }

    public Tarea obtenerTareaPorId(int idTarea) {
        return controladoraPersistencia.obtenerTareaPorId(idTarea);
    }

    
}