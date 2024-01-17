package backjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex1931회의실배정 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++) {
        	String[] input = br.readLine().split(" ");
        	arr[i][0] = Integer.parseInt(input[0]);
        	arr[i][1] = Integer.parseInt(input[1]);
        }

        int count = 0;



        System.out.println(count);
    }
}
