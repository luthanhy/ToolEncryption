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
public class PLAYFAIL {
    private char pf[][];
    public PLAYFAIL()
    {
         pf =new char[][] {
            {'M','O','N','A','R'},
            {'C','H','Y','B','D'},
            {'E','F','G','I','K'},
            {'L','P','Q','S','T'},
            {'U','V','W','X','Z'}
        } ;
    }
    public String EncryptionPLAYFAIL(String input){
        input = input.toUpperCase();
        input = input.replace('J', 'I');
        int n = input.length();
        int i= 0;
        String result = "";
        char a,b;
        while(i<n){
               if(i==n-1){
                   a = input.charAt(i);
                   b = 'X';
                   i++;
               }else
               {
                   a = input.charAt(i);
                   b = input.charAt(i+1);
                   if(a==b){
                       b = 'X';
                       i++;
                   }else{
                       i+=2;
                   }
               }
               result+=Replace(a,b);
        }
        return result;
    }
    private String Replace(char a, char b){
        String LocationA = FindLocation(a);
        String LocationB = FindLocation(b);
        char x,y;
        if(LocationA.charAt(0) ==  LocationB.charAt(0)){
            x = pf[LocationA.charAt(0) - '0'][((LocationA.charAt(1) - '0')+1)%5];
            y = pf[LocationB.charAt(0) - '0'][((LocationB.charAt(1) - '0')+1)%5];
            return x+""+y;

        }if(LocationA.charAt(1) ==  LocationB.charAt(1)){
            x = pf[((LocationA.charAt(0) - '0')+1)%5][LocationA.charAt(1) - '0'];
            y = pf[((LocationB.charAt(0) - '0')+1)%5][LocationB.charAt(1) - '0'];
            return x+""+y;
        }
          x = pf[LocationA.charAt(0) - '0'][LocationB.charAt(1) - '0'];
          y = pf[LocationB.charAt(0) - '0'][LocationA.charAt(1) - '0'];
        return x+""+y;
    }
    private String FindLocation(char a){
        for(int i = 0; i < 5 ; i++){
            for(int j = 0 ; j < 5 ; j++){
                if(pf[i][j] == a){
                    return i+""+j;
                }
            }
        }
        return "";
    }
    public String DecryptionPLAYFAIL(String input){
        String key = DecryptionPlayfail(input);
        int n = key.length();
        String result = "";
        for(int i = 0 ;i < n-2 ; i+=2){
            if(key.charAt(i) == key.charAt(i+2)){
                result+=key.charAt(i);
            }else{
                result+=key.charAt(i)+""+key.charAt(i+1);
            }
        }
        if(key.charAt(n-1) == 'X'){
            result+=key.charAt(n-2);
        }else{
            result+=key.charAt(n-2);
            result+=key.charAt(n-1);
        }
        return result;
    }
    private String DecryptionPlayfail(String input){
        int n = input.length();
        String result = "";
        char a,b;
        for(int i = 0 ; i < n; i+=2){
            a = input.charAt(i);
            b = input.charAt(i+1);
            result+=ReplaceNoth(a,b);
        }
        return result;
    }
    private String ReplaceNoth(char a,char b){
        String LocationA = FindLocation(a);
        String LocationB = FindLocation(b);
        char x,y;
        if(LocationA.charAt(0) ==  LocationB.charAt(0)){
            x = pf[LocationA.charAt(0) - '0'][((LocationA.charAt(1) - '0')-1+5)%5];
            y = pf[LocationB.charAt(0) - '0'][((LocationB.charAt(1) - '0')-1+5)%5];
            return x+""+y;

        }if(LocationA.charAt(1) ==  LocationB.charAt(1)){
            x = pf[((LocationA.charAt(0) - '0')-1+5)%5][LocationA.charAt(1) - '0'];
            y = pf[((LocationB.charAt(0) - '0')-1+5)%5][LocationB.charAt(1) - '0'];
            return x+""+y;
        }
          x = pf[LocationA.charAt(0) - '0'][LocationB.charAt(1) - '0'];
          y = pf[LocationB.charAt(0) - '0'][LocationA.charAt(1) - '0'];
        return x+""+y;
    }
}
