package backjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex11727타일링2 {

    static int[] block = new int[1001];
    static boolean[] isVisited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        block[1] = 1;
        block[2] = 3;

        for(int i = 3; i <= n; i++){
            block[i] = (block[i-1] + 2 * block[i-2]) % 10007;
        }

        System.out.println(block[n]);
    }

}
