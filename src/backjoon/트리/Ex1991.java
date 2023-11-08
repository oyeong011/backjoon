package backjoon.트리;

import java.io.IOException;
import java.util.*;
/**
 * Ex1991
 */
public class Ex1991 {
    public static class Tree{
        private Node root;
        private Map<Character, Node> nodeMap;
        int count;
        public Tree(){
            nodeMap = new HashMap<>();
        }

        public class Node{
            char data;
            Node left;
            Node right;

            public Node(char data){
                this.data = data;
                this.left = null;
                this.right = null;
            }

            public void addLeft(Node node){
                left = node;
                count++;
            }

            public void addRight(Node node){
                right = node;
                count++;
            }

            public void deleteLeft(){
                left = null;
                count--;
            }

            public void deleteRight(){
                right = null;
                count--;
            }
        }

        public void addNode(char data, char leftData, char rightData){
            Node parentNode = nodeMap.getOrDefault(data, new Node(data));
            nodeMap.putIfAbsent(data, parentNode);

            if(leftData != '.'){
                Node leftNode = new Node(leftData);
                parentNode.left = leftNode;
                nodeMap.put(leftData, leftNode);
            }

            if(rightData != '.'){
                Node rightNode = new Node(rightData);
                parentNode.right = rightNode;
                nodeMap.put(rightData, rightNode);
            }

            if(root == null){
                root = parentNode;
            }
        }

        public void inOrder(Node node){
            if(node == null){
                return;
            }

            inOrder(node.left);
            System.out.print(node.data);
            inOrder(node.right);
        }

        public void preOrder(Node node){
            if(node == null){
                return;
            }

            System.out.print(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }

        public void postOrder(Node node){
            if(node == null){
                return;
            }

            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data);
        }
    }

    public static void main(String[] args) throws IOException{
        int num = read();
        Tree tree = new Tree();
        for(int i = 0 ; i < num; i++){
            char parentNode = readChar();
            char leftNode = readChar();
            char rightNode = readChar();
            tree.addNode(parentNode, leftNode, rightNode);
        }
        
        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
    }

    public static int read() throws IOException{
        int c, n = System.in.read() & 15;

        boolean isNegative = n == 13;

        if(isNegative){
            n = System.in.read();
        }

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return isNegative ? ~n + 1 : n;
    }
    public static char readChar() throws IOException {
        int c;
        while (true) {
            c = System.in.read();
            // 대문자인지 확인 (ASCII 코드 65-90)
            if (c >= 65 && c <= 90) {
                return (char) c;
            }
            if (c == 46) {
                return (char) c;
            }
        }
    }
}