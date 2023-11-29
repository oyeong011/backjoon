package backjoon.해시;

import java.io.IOException;
import java.util.*;

public class Ex1253 {
    public static void main(String[] args) throws IOException{
        int N = read();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int GOOD = read();
            arr[i] = GOOD;
        }
        Arrays.sort(arr);
        solve(arr);
    }
    public static void solve(int[] arr){
        int GoodCount = 0;

        for(int i = 0; i < arr.length; i++){
            int target = arr[i];
            int startPointer = 0;
            int endPointer = arr.length - 1;

            while(startPointer < endPointer){
                int sum = arr[startPointer] + arr[endPointer];
                if(sum == target) {
                    if(i == startPointer){
                        startPointer++;
                    }
                    else if(i == endPointer){
                        endPointer--;
                    }
                    else{
                        GoodCount++;
                        break;
                    }
                }
                if(sum > target) endPointer--;
                if(sum < target) startPointer++;
            }
        }
        System.out.println(GoodCount);
    }



    public static int read() throws IOException{
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if(isNegative){
            n = System.in.read() & 15;
        }
        while((c = System.in.read()) > 32){
            n = (n << 3) + (n << 1) + (c & 15);
        }
        if(c == 13){
            System.in.read();
        }
        return isNegative ? ~n + 1 : n;
    }
}
