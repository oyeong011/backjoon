package backjoon.스택덱큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex24511 {

    static class Queue{
        private Node head;
        private Node tail;
        private int size;
        
        private static class Node {
            Node next;
            Node prev;
            int num;

            Node(Node prev, int num, Node next){
                this.prev = prev;
                this.next = next;
                this.num = num;
            }
        }
        public void push(int val){
            Node last = tail;
            Node newNode = new Node(last, val, null);
            tail = newNode;
            size++;

            if(last == null){
                head = newNode;
            } else {
                last.next = newNode;
            }
        }

        public void pushFirst(int val){
            Node first = head;
            Node newNode = new Node(null, val, head);
            head = newNode;
            size++;

            if(first == null){
                tail = newNode;
            } else {
                first.prev = newNode;
            }
        }
        public int pop(){
            if(head == null){
                throw new RuntimeException();
            }
            int returnVal = head.num;
            Node newNode = head.next;

            head = newNode;
            size--;

            if(newNode == null){
                tail = newNode;
            } else {
                newNode.prev = null;
            }
            return returnVal;
        }
    }
    public static int[] makeList(StringTokenizer st, int[] List){
        int i=0;
        while (st.hasMoreTokens()) {
            List[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        return List;
    }
    public static Queue makeQueueList(StringTokenizer st, int[] dataStructure){
        int i=0;
        Queue queue = new Queue();
        while (st.hasMoreTokens()) {
            if(dataStructure[i] == 0){
                queue.pushFirst(Integer.parseInt(st.nextToken()));
            } else{
                st.nextToken();
            }
            i++;
        }
        return queue;
    }
    static int read() throws Exception{
        int c, n = System.in.read() & 15;

        boolean isNegative = n == 13;
        if(isNegative){
            n = System.in.read() & 15;
        }
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return isNegative ? -n + 1 : n;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());

        int[] dataStructure = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        dataStructure = makeList(st, dataStructure);
        
        
        st = new StringTokenizer(br.readLine(), " ");
        Queue queueList = makeQueueList(st, dataStructure);
        
        
        st = new StringTokenizer(br.readLine(), " ");
        int inputDataCount = Integer.parseInt(st.nextToken());
        int[] inputData = new int[inputDataCount];
        st = new StringTokenizer(br.readLine(), " ");
        
        inputData = makeList(st, inputData);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < inputDataCount; i++){
            queueList.push(inputData[i]);
            sb.append(queueList.pop()+ " ");
        }
        
        System.out.println(sb.toString());
    }
}
