package backjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex11399ATM {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        int sum = 0;
        int[] dp = new int[N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j <= i; j++){
                dp[i] += arr[j];
            }
            sum += dp[i];
        }

        System.out.println(sum);
    }

}
