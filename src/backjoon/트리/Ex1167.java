package backjoon.트리;

import java.io.*;
import java.util.*;

public class Ex1167 {
    static ArrayList<Node> list[];
    static int max_Distance;
    static int max_Index;
    static boolean[] isVisit;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = read();
        
        list = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++){
            inputNumber(br);
        }


        isVisit = new boolean[N + 1];
        isVisit[1] = true;
        dfs(1, 0);
        
        isVisit = new boolean[N + 1];
        isVisit[max_Index] = true;
        dfs(max_Index, 0);
        System.out.println(max_Distance);
    }
    
    public static void inputNumber(BufferedReader br) throws IOException{
        
        int parentIdx = read();
        int childIdx;
        while ((childIdx = read()) != -1) {

            int weight = read();

            list[parentIdx].add(new Node(childIdx, weight));
            list[childIdx].add(new Node(parentIdx, weight));
        }
    }

    public static void dfs(int index, int weight){
        if(max_Distance < weight){
            max_Distance = weight;
            max_Index = index;
        }

        for(Node node : list[index]){
            if(!isVisit[node.index]){
                isVisit[node.index] = true;
                dfs(node.index, weight + node.weight);
            }
        }
    }
    static class Node{
        int index;
        int weight;

        Node(int index, int weight){
            this.index = index;
            this.weight = weight;
        }
    }

    public static int read() throws IOException{
        boolean isMinus = false;
        

        int c, n = System.in.read();
        if(n == 45){
            isMinus = true;
            n = System.in.read();
        }
        
        n &= 15;
        
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        
        if(c == 13) System.in.read();

        return isMinus ? ~n + 1 : n;

    }
    private static int read1() throws IOException {
        boolean isMinus = false;

        int c, n = System.in.read();
        if (n == 45) {
            isMinus = true;
            n = System.in.read();
        }
        n &= 15;

        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);

        if (isMinus)
            return ~n + 1;
        else
            return n;
    }
}
