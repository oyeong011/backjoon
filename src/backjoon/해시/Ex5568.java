package backjoon.해시;

import java.io.*;
import java.util.*;

public class Ex5568 {
    
    public static void main(String[] args) throws IOException{
        int N = read();
        int K = read();

        Set<Integer> set = new HashSet<>();

        String[] arr = new String[N];
        for(int i = 0; i < N; i++){
            arr[i] = String.valueOf(read());
        }
        
    }

    public static void duplicateInspcetion(String[] arr, )


    public static int read() throws IOException{
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;

        if(isNegative) n = System.in.read() & 15;

        while((c = System.in.read()) > 32){
            n = (n << 3) + (n << 1) + (c & 15);
        }

        if(c == 13) System.in.read();

        return isNegative ? ~n + 1 : n;
        
    }
}
