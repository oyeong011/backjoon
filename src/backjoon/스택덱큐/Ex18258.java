package backjoon.스택덱큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.StringTokenizer;

public class Ex18258 {
    /**
 * queue
     */
    static class Queue {
        private Node head;
        private Node tail;
        private int size;
        
        Queue(){
        }
        private static class Node {
            Node next;
            Node prev;
            int val;

            Node(Node prev, int val, Node next){
                this.next = next;
                this.prev = prev;
                this.val = val;
            }
        }

        public void push(int val){
            Node last = tail;
            Node newNode = new Node(last, val, null);

            size++;

            tail = newNode;

            if(last==null){
                head = newNode;
            } else {
                last.next = newNode;
            }
        }

        public int pop(){
            if(head==null){
                return -1;
            }
            int value = head.val;
            Node newNode = head.next;
            
            head = newNode;

            size--;
            if(newNode == null){
                tail = newNode;
            } else {
                newNode.prev = null;
            }
            return value;
        }
        public int isEmpty(){
            return head == null ? 1 : 0;
        }
        public int getSize(){
            return size;
        }
        public int peek(){
            if(head==null){
                return -1;
            }
            return head.val;
        }
        public int backPeek(){
            if(tail == null){
                return -1;
            }
            return tail.val;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        
        Queue queue = new Queue();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "push":
                    int value = Integer.parseInt(st.nextToken());
                    queue.push(value);
                    break;
                case "pop":
                    sb.append(queue.pop() + "\n");
                    break;
                case "size":
                    sb.append(queue.getSize() + "\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty() + "\n");
                    break;
                case "front":
                    sb.append(queue.peek() + "\n");
                    break;
                case "back":
                    sb.append(queue.backPeek() + "\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
