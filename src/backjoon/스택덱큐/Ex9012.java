package backjoon.스택덱큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex9012 {
    
    static class Stack {
        private Node head;
        private int size;
        
        private static class Node {
            Node next;
            char bracketAt;

            Node(Node next, char bracketAt){
                this.next = next;
                this.bracketAt = bracketAt;
            }
            
        }

        public void push(char bracketAt){
            Node first = head;
            Node newNode = new Node(first, bracketAt);

            head = newNode;

            size++;
        }
        public void pop(){
            if(head == null){
                throw new RuntimeException();
            }
            Node newNode = head.next;

            head = newNode;
            size--;
        }
        public boolean isEmpty(){
            return head == null;
        }
        public char peek(){
            if(isEmpty()){
                return 'X';
            }
            return head.bracketAt;
        }
    }
    
    public static void isBracket(StringBuilder sb, String bracket){
        Stack stack = new Stack();
        for(int i=0;i<bracket.length();i++){
            char bracketEdge = bracket.charAt(i);
            if(bracketEdge == ')'){
                if(stack.peek() =='('){stack.pop();} 
                else {stack.push(bracketEdge);}
            } else {
                stack.push(bracketEdge);
            }
        }
        if(stack.isEmpty()){
            sb.append("YES\n");
        } else {
            sb.append("NO\n");
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i =0;i<N;i++){
            String bracket = br.readLine();
            isBracket(sb, bracket);
        }
        System.out.println(sb.toString());
    }
}
