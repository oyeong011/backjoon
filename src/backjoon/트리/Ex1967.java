package backjoon.트리;

import java.util.*;
import java.io.*;
public class Ex1967 {
    public final int MAX_DISTANCE = 0;
    static class Node{
        int data;
        Node parent;
        List<Node> childNodeList;
        int weight;
        public Node(int data){
            this.data = data;
            this.childNodeList = new ArrayList<>();
        }
        public void addChild(Node childNode, int weight){
            childNode.weight = weight;
            childNode.parent = this;
            childNodeList.add(childNode);
        }
        

    }
    static class Result{
        Node farthestNode;
        int maxDistance;
    }
    public static int read() throws IOException{
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if(isNegative){
            n = System.in.read() & 15;
        }

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        if(c == 13) System.in.read();

        return isNegative ? ~n + 1 : n;
    }

    public static void in() throws IOException{
        int N = read();
        Node[] tree = new Node[N];
        for(int i = 0 ; i < N; i++){
            tree[i] = new Node(i+1);
        }
        for(int i = 0; i < N - 1; i++){
            int parentIdxNum = read(); 
            int childIdxNum = read(); 
            int weight = read(); 
            tree[parentIdxNum-1].addChild(tree[childIdxNum-1], weight);
        }
        solve(tree);
    }
    public static void solve(Node[] tree){
        Node root = tree[0]; 
        Result result1 = dfs(root, root.parent, 0);
        Result result2 = dfs(result1.farthestNode, result1.farthestNode.parent, 0);
        System.out.println(result2.maxDistance);
    }
    public static Result dfs(Node node, Node parent, int distance){
        Result result = new Result();
        result.farthestNode = node;
        result.maxDistance = distance;

        for(Node child : node.childNodeList){
            if(child != parent){
                Result childResult = dfs(child, node, distance + child.weight);
                if(childResult.maxDistance > result.maxDistance){
                    result = childResult;
                }
            }
        }
        if(node.parent != null && node.parent != parent)
        return result;
    }
    public static void main(String[] args) throws IOException{
        in();
    }
}
