package backjoon.DFSBFS;

import java.io.IOException;

public class Ex1260 {
    public static void main(String[] args) throws IOException{
        int numberOfPoint = read();
        int highWay = read();
        int searchOfPoint = read();
    
        
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
        return isNegative ? ~n + 1 : n;
    }
}
