package EncriptadoFichero;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Main {

    public static void main(String[] args) {

        try {

            Security.addProvider(new BouncyCastleProvider());

            String usuario = "david";
            String contraseña = "123456";
            String semilla = usuario + contraseña;

            //Generar la clave secreta
            SecretKey claveSecreta = generarClaveSecreta(semilla);

            //Encriptar el texto
            String texto = "Prueba de encriptado de texto";

            byte[] textoEncriptado = encriptarTexto(texto, claveSecreta);

            //Generar el fichero con el texto encriptado
            String fichero = "fichero.cifrado";
            escribirFichero(fichero, textoEncriptado);
            System.out.println("Texto encriptado almacenado en " + fichero + ".");

            //Desencriptar texto
            byte[] bytesFichero = leerFichero(fichero);
            String textoDesencriptado = desencriptarTexto(bytesFichero, claveSecreta);
            System.out.println("El texto desencriptado es: \n" + textoDesencriptado);

        } catch (NoSuchAlgorithmException | NoSuchProviderException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static SecretKey generarClaveSecreta(String semilla) {

        SecureRandom random = new SecureRandom(semilla.getBytes());
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
        return new SecretKeySpec(bytes, "Rijndael");
    }

    public static byte[] encriptarTexto(String texto, SecretKey clave) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, 
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        Cipher cipher = Cipher.getInstance("Rijndael/ECB/PKCS5Padding", "BC");
        cipher.init(Cipher.ENCRYPT_MODE, clave);
        return cipher.doFinal(texto.getBytes());
    }

    public static void escribirFichero(String fichero, byte[] bytes) throws FileNotFoundException, IOException {

        try (FileOutputStream fos = new FileOutputStream(fichero)) {
            fos.write(bytes);
        }
    }

    public static byte[] leerFichero(String fichero) throws FileNotFoundException, IOException {

        try (FileInputStream fis = new FileInputStream(fichero)) {
            return fis.readAllBytes();
        }
    }

    public static String desencriptarTexto(byte[] bytes, SecretKey clave) throws NoSuchAlgorithmException, NoSuchProviderException, 
            NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        Cipher cipher = Cipher.getInstance("Rijndael/ECB/PKCS5Padding", "BC");
        cipher.init(Cipher.DECRYPT_MODE, clave);
        return new String(cipher.doFinal(bytes));

    }
}
