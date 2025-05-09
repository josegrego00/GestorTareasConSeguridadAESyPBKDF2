/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemaimtel.gestortareaseguridad;

import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/**
 *
 * @author josepino
 */
public class ejemploAES {
    // 🔐 Genera una clave AES de 256 bits
    public static SecretKey generateAESKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // 128, 192 o 256
        return keyGen.generateKey();
    }

    // 🔁 Genera un IV aleatorio de 16 bytes
    public static IvParameterSpec generateIV() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    // 🔒 Cifra el texto
    public static String encrypt(String plainText, SecretKey key, IvParameterSpec iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // Modo seguro
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] encrypted = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    // 🔓 Descifra el texto
    public static String decrypt(String cipherText, SecretKey key, IvParameterSpec iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(cipherText));
        return new String(decrypted);
    }

    // 🧪 Ejemplo de uso
    public static void main(String[] args) throws Exception {
        SecretKey key = generateAESKey();
        IvParameterSpec iv = generateIV();

        String textoOriginal = "Esta es una nota secreta";
        String textoCifrado = encrypt(textoOriginal, key, iv);
        String textoDescifrado = decrypt(textoCifrado, key, iv);

        System.out.println("Texto original: " + textoOriginal);
        System.out.println("Texto cifrado (Base64): " + textoCifrado);
        System.out.println("Texto descifrado: " + textoDescifrado);
    } 
}
