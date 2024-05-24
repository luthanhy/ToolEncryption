/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2180609013luthanhy;

/**
 *
 * @author Administrator
 */
public class Ceasar {
    private String key;
    public Ceasar(String key){
        this.key = key;
    }
    private char EncrytionChar(char value, int index){
        if(!Character.isLetter(value)) return value;
        int keyValue = key.charAt(index % key.length());
        return (char) ((((Character.toUpperCase(value) - 'A') + (keyValue-'A')) %26 +26)%26+'A');
    }
    public String EncryotionCeasar(String input, int index){
        String result = "";
        int lenghtInput = input.length();
        
        for(int i = 0 ; i < lenghtInput ; i++){
            result += EncrytionChar(input.charAt(i), index);
        }
        return  result;
    }
    
    public String DecryptionCeasar(String input, int index) {
        String result = "";
        int lengthInput = input.length();
        
        for (int i = 0; i < lengthInput; i++) {
            char encryptedChar = input.charAt(i);
            if (Character.isLetter(encryptedChar)) {
                int keyValue = key.charAt(index % key.length());
                int decryptedValue = (((Character.toUpperCase(encryptedChar) - 'A') - (keyValue - 'A')) % 26 + 26) % 26 + 'A';
                result += (char) decryptedValue;
            } else {
                result += encryptedChar;
            }
        }
        
        return result;
    }
}
