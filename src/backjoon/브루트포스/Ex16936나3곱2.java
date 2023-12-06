package backjoon.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Ex16936나3곱2 {

    static int N;
    static long[] arr ,result;
    static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isVisited = new boolean[N];
        result = new long[N];
        arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            arr[i] = (Long.parseLong(st.nextToken()));
        }

        dfs(0);

        System.out.println(sb.toString());
    }

    public static void dfs(int depth){


        if(depth == N){
            for(int i = 0; i < N; i++){
                sb.append(result[i]).append(" ");
            }
        } else {
            for(int i = 0; i < N; i++){
                if(!isVisited[i]){
                    isVisited[i] = true;
                    result[depth] = arr[i];

                    if(numberTest(depth)){
                        dfs(depth + 1);
                    }
                    isVisited[i] = false;
                }
            }
        }
    }

    public static boolean numberTest(int depth){
        if(depth > 0){
            return 0 != divideOrMulti(result[depth - 1], result[depth]);
        }
        return true;
    }
    public static long divideOrMulti(long num1, long num2){

        if(num1 % 3 == 0){
            if(num1 / 3 == num2){
                return num2;
            }
        }
        if(num1 * 2 == num2){
            return num2;
        }

        return 0;
    }
}
