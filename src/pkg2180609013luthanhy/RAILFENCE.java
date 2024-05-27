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
public class RAILFENCE {
    public String EncryptionRAILFENCE(String input,int key){
        int n = input.length();
        int sd,sc;
        sd = key;
        sc = n/sd+1;
        char hr[][] = new char[sd][sc];
        int c,d;
        c = 0 ;
        d = 0;
        int sodu = n%sd;
        for(int i = 0 ; i <n ; i++){
            hr[d][c] = input.charAt(i);
            d++;
            if(d==key){
                c++;
                d=0;
            }
        }
        String result = "";
        int sokytu = sc;
        for(int i = 0 ; i <sd ; i++){
            if(i>=sodu) sokytu = sc-1;
            for(int j = 0 ; j < sokytu ; j++){
                result= result + hr[i][j];
            }
        }
        return result;
    }
    public String DecryptionRAILFENCE(String input,int key){
        int n = input.length();
        int sd,sc;
        sd = key;
        sc = n/sd+1;
        int sokytu = sc;
        int sodu = n%sd;
        int t = 0;
        char hr[][] = new char[sd][sc];
        for(int i = 0 ; i <sd ; i++){
            if(i>=sodu) sokytu = sc - 1;
            for(int j = 0 ; j < sokytu ; j++){
                hr[i][j] = input.charAt(t);
                t++;
            }
        }
        int c,d;
        c = 0;
        d = 0;
        String result = "";
        for(int  i = 0 ; i < n ; i++){
            result += hr[d][c];
            d++;
            if(d==key){
                c++;
                d = 0;
            }
        }
        return result;
    }
}
