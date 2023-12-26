package backjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1912연속합 {
    static int[] arr;
    static int[] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        dp = new int[n+1];

        String[] input = br.readLine().split(" ");
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(input[i-1]);
        }

        dp[1] = arr[1];
        int max = dp[1];

        for(int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);



    }
}
