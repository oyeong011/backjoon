package backjoon.구현;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class ex1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        LinkedList<Number> first_List = new LinkedList<>();
        first_List = makeList(first_List, N);
        // System.out.println("first_List : "+ first_List.toString());
        Queue<Number> queue = new LinkedList<>();

        print_Yosepus(queue, first_List, K);

    }

    public static LinkedList<Number> makeList(LinkedList<Number> list, int N) {
        for (int i = 1; i <= N; i++) {
            list.addLast(i);
        }
        return list;
    }

    public static void print_Yosepus(Queue<Number> queue, LinkedList<Number> first_List, int K) {
        int listSize = first_List.size();
        int arrow = K-1;
        for (int i = 0; i < listSize; i++) {
            queue.add(first_List.remove(arrow));
            // System.out.println("queue : "+ queue.toString());
            // System.out.println("first_List : "+ first_List.toString());
            // System.out.println();
            int size = first_List.size();
            arrow = arrowSet(arrow, K, size);

        }
        System.out.print("<");
        for (int i = 0; i < listSize-1; i++) {
            System.out.print(queue.remove()+", ");
        }
        System.out.print(queue.remove());
        System.out.print(">");
    }

    public static int arrowSet(int arrow, int K, int size) { // size로 먼저 나누어서 넘치지 않게 해야한다
        if(size == 0){
            return 0;
        }
        arrow %= size;
        arrow += K - 1;
        arrow = arrow >= size ? arrow %= size : arrow;
        if (size == 1) {
            arrow = size-1;
        }
        if(arrow == 0){
            return 0;
        }

        return arrow ;
    }
}