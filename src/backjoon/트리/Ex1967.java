package backjoon.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Ex1967
 */
public class Ex1967 {
    static ArrayList<Node> nodeList[];
    static boolean[] isVisit;
    static int Max_distance;
    static int Max_index;
    static class Node{
        int index;
        int weight;
        Node(int index, int weight){
            this.index = index;
            this.weight = weight;
        }
    }

    public static void dfs(int index, int weight){
        if(Max_distance < weight){
            Max_distance = weight;
            Max_index = index;
        }

        for(Node child : nodeList[index]){
            if(!isVisit[child.index]){
                isVisit[child.index] = true;
                dfs(child.index, weight + child.weight);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        nodeList = new ArrayList[N + 1];

        for(int i = 0; i <= N; i++){
            nodeList[i] = new ArrayList<>();
        }
        for(int i = 0; i < N - 1; i++){
            String[] t = br.readLine().split(" ");
            int parent = Integer.parseInt(t[0]);
            int child = Integer.parseInt(t[1]);
            int weight = Integer.parseInt(t[2]);
            nodeList[parent].add(new Node(child, weight));
            nodeList[child].add(new Node(parent, weight));
        }
        isVisit = new boolean[N + 1];
        isVisit[1] = true;
        dfs(1, 0);
        
        isVisit = new boolean[N + 1];
        isVisit[Max_index] = true;
        dfs(Max_index, 0);
        System.out.println(Max_distance);
    }
}