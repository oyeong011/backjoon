package backjoon.트리;

import java.io.IOException;

/**
 * Ex1991
 */
public class Ex1991 {
    public class Tree{
        int count;
        public Tree(){

        }

        public class Node{
            Object data;
            Node left;
            Node right;

            public Node(Object data){
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

        public Node addNode(Object data){
            Node n = new Node(data);
            return n;
        }

        public void inOrder(Node node){
            if(node == null){
                return;
            }

            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.left);
        }

        public void preOrder(Node node){
            if(node == null){
                return;
            }

            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.left);
        }

        public void postOrder(Node node){
            if(node == null){
                return;
            }

            postOrder(node.left);
            postOrder(node.left);
            System.out.println(node.data);
        }
    }

    public static void main(String[] args) {
        
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
        }
    }
}