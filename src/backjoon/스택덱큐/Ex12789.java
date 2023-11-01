package backjoon.스택덱큐;


public class Ex12789 {
    static class Stack {
        private Node head;
        private int size;
        
        private static class Node {
            Node next;
            int orderNumber;
            Node(Node next, int orderNumber){
                this.next = next;
                this.orderNumber = orderNumber;
            }
        }

        public void push(int orderNumber){
            Node first = head;
            Node newNode = new Node(first, orderNumber);

            head = newNode;
            size++;
        }
        public void pop(){
            if(head == null){
                throw new RuntimeException();
            }
            Node newNode = head.next;

            head = newNode;
        }
        public int peek(){
            if(head == null){
                return -1;
            }
            return head.orderNumber;
        }
    }

    public static int read() throws Exception{
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if(isNegative){
            n = System.in.read();
        }
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        if(c == '\r'){
            c = System.in.read();
        }
        return isNegative ? ~n + 1 : n;

    }
    public static void main(String[] args) throws Exception{
        int N = read();
        int[] numbers = new int[N];
        Stack stack = new Stack();

        for(int i=0;i<N;i++){
            numbers[i] = read();
        }


        StringBuilder sb = new StringBuilder();
        int giveOrder=1;
        boolean isPossible = true;
        for(int i = 0; i < N; i++){
            while(giveOrder == stack.peek()){
                giveOrder++;
                stack.pop();
            }
            if(giveOrder == numbers[i]){
                giveOrder++;
                continue;
            } 

            if(stack.peek() == -1 || stack.peek() > numbers[i]){
                stack.push(numbers[i]);
            } else {
                isPossible = false;
                break;
            }
        }
        if(isPossible){
            sb.append("Nice");
        } else {
            sb.append("Sad");
        }
        System.out.println(sb);
    }
}
