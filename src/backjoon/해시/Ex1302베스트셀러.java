package backjoon.해시;

import java.io.*;
import java.util.*;

public class Ex1302베스트셀러 {
    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;

        while((c = System.in.read()) > 32){
            n = ( n << 3 ) + ( n << 1 ) + ( c & 15 );
        }
        if (c == 13) System.in.read();
        return isNegative ? ~n + 1 : n;
    }
    public static String readStr() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while((c = System.in.read()) > 32){
            sb.append((char)c);
        }
        if(c == 13) System.in.read();

        return sb.toString();
    }

    public static void main(String[] args) {
        int N = read();
        Map<String, Integer> Book = new HashMap<>();
    }

}
