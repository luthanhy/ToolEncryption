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
public class VIGENERE {
   private int vig[][];
   public VIGENERE(){
       vig = new int[26][26];
       for(int i = 0 ; i < 26 ; i++){
           for(int j = 0 ; j < 26 ; j++){
               vig[i][j] = (i+j)%26;
           }
       }
   }
    public String EncryptionVIGENERE(String input, String key){
        int n = input.length();
        String IdInput = "";
        int k = 0;
        for(int i = 0 ; i < n ; i++){
            if(Character.isLetter(input.charAt(i)))
            {
                IdInput+= EncryptionV(input.charAt(i), key.charAt(k));
                k++;
                k = k%key.length();
            }else{
                IdInput+=input.charAt(i);
            }
        }
                    return  IdInput;
    }
    private char EncryptionV(char x,char k){
        int xn = Character.toUpperCase(x) - 'A';
        int kn = Character.toUpperCase(k) - 'A';
        int yn = vig[kn][xn];
        return (char) (yn + 'A');
    }
    public String DecryptionVIGENERE(String input,String key){
        String kt1= "";
        int kn = key.length();
        for(int i = 0 ; i < kn ; i++){
            kt1 += (char)(((26-(Character.toUpperCase(key.charAt(i))-'A'))%26)+'A');
        }
        String result = EncryptionVIGENERE(input,kt1);
        return result;
    }
}
