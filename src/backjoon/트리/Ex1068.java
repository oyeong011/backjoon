package backjoon.트리;

import java.io.IOException;

public class Ex1068 {
    public static void main(String[] args) {
        
    }
    public static int read() throws IOException{
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;

        if(isNegative){
            n = System.in.read() & 15;
        }
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    } 
}
