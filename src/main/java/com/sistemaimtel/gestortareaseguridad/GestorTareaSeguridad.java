/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.sistemaimtel.gestortareaseguridad;
import Vistas.VistaCrearUsuarioNuevo;
import Vistas.VistaLoginPrincipal;
import Vistas.VistaLoginPrincipal;
import Vistas.VistaTareas;
import com.eatthepath.otp.TimeBasedOneTimePasswordGenerator;
import org.apache.commons.codec.binary.Base32;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author josepino
 */
public class GestorTareaSeguridad {

    public static void main(String[] args) throws Exception {
        VistaCrearUsuarioNuevo crearUsuarioNuevo= new VistaCrearUsuarioNuevo();
        crearUsuarioNuevo.setVisible(true);
        VistaLoginPrincipal loginPrincipal= new VistaLoginPrincipal();
        loginPrincipal.setVisible(true);
        VistaTareas vistaTareas= new VistaTareas();
        vistaTareas.setVisible(true);
    }
}
