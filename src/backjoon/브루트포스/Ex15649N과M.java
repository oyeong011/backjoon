package backjoon.브루트포스;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ex15649N과M {
    static boolean[] isUsed;
    static int[] list;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        N = read();
        M = read();
        list = new int[M];
        isUsed = new boolean[N];
        permutation(0);
        System.out.println(sb.toString());
    }
    public static void permutation(int depth){
        if(M == depth){
            for(int i = 0; i < M; i++){
                sb.append(list[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < N; i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                list[depth] = i + 1;
                permutation(depth + 1);
                isUsed[i] = false;
            }
        }
    }
    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if(isNegative) n = System.in.read() & 15;

        while((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if(c == 13) System.in.read();

        return isNegative ? ~n + 1 : n;
    }
}
