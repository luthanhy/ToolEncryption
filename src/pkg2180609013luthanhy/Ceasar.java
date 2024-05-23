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
    private char EncrytionChar(char value, int index){
        if(!Character.isLetter(value)) return value;
        
        return (char) ((((Character.toUpperCase(value) - 'A') + index) %26 +26)%26+'A');
    }
    public String EncryotionCeasar(String input, int index){
        String result = "";
        int lenghtInput = input.length();
        
        for(int i = 0 ; i < lenghtInput ; i++){
            result += EncrytionChar(input.charAt(i), index);
        }
        return  result;
    }
}
