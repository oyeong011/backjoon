package backjoon.해시;

import java.io.*;
import java.util.*;

public class Ex5568 {
    static Set<Integer> set = new HashSet<>();
    
    public static void main(String[] args) throws IOException{
        int N = read();
        int K = read();

        List<String> arr = new ArrayList<String>();
        for(int i = 0; i < N; i++){
            String input = String.valueOf(read());
            arr.add(input);
        }
        duplicateInspection(arr, K, "");
        
        System.out.println(set.size());
    }

    public static void duplicateInspection(List<String> arr, int K, String str){
        if(K == 0){
            set.add(Integer.parseInt(str));
            return;
        }

        for(int i = 0; i < arr.size(); i++){
            String temp = arr.get(i);
            arr.remove(i);
            duplicateInspection(arr, K - 1, str + temp);
            arr.add(i, temp);
        }
    }



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
