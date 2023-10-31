package backjoon.스택덱큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Ex10773
 */
public class Ex10773 {
    
    
    static class Stack {
        private Node top;
        private int size;
        
        private static class Node{
            Node next;
            int money;

            Node(int money, Node next){
                this.money = money;
                this.next = next;
            }
        }

        Stack(){
            this.top = null;
            this.size = 0;
        }

        public void push(int money){
            Node newNode = new Node(money, top);
            top = newNode;
            size++;
        }

        public int pop(){
            if(isEmpty()){
                throw new RuntimeException();
            }
            int moneyElement = top.money;
            top = top.next;
            size--;

            
            return moneyElement;
        }

        public boolean isEmpty(){
            return top == null;
        }
    }
    
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        

        
        Stack stack = new Stack();

        for(int i = 0; i < K; i++){

            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                stack.pop();
            } else {
                stack.push(num);
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}