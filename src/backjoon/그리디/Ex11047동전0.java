package backjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex11047동전0 {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        int[] coins = new int[N];
        int count = 0;

        for(int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for(int i = N - 1; i >= 0; i--) {
            if(K >= coins[i]) {
                count += K / coins[i];
                K %= coins[i];
            }
        }



        System.out.println(count);


    }
}
