/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2180609013luthanhy;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author luthanhy
 */
public class DES {
     public static byte[] encrypt(byte[] input, byte[] keyBytes) throws Exception {
        Key key = new SecretKeySpec(keyBytes, "DES");
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(input);
    }
     public static byte[] decrypt(byte[] encryptedData, byte[] keyBytes) throws Exception {
    if (encryptedData.length % 8 != 0) {
        throw new IllegalArgumentException("Encrypted data length must be a multiple of 8 bytes");
    }
    if (keyBytes.length != 8) {
        throw new IllegalArgumentException("Key length must be 8 bytes (64 bits)");
    }
    
    Key key = new SecretKeySpec(keyBytes, "DES");
    Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
    cipher.init(Cipher.DECRYPT_MODE, key);
    return cipher.doFinal(encryptedData);
}

}
