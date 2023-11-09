package backjoon.트리;

import java.io.*;
import java.util.*;

public class Ex1167 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] treeList = new int[N][N]; 
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            inputNumber(st, treeList);
        }
    }
    public static int[][] inputNumber(StringTokenizer st, int[][] treeList){
        int targetIdx = Integer.parseInt(st.nextToken());
        int i = 0;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if(num == -1) return treeList;
            treeList[targetIdx][num] = Integer.parseInt(st.nextToken());
        }
        return treeList;
    }
}
