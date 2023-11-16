package backjoon.DFSBFS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Ex1260 {
    static ArrayList<Node> list[];
    static boolean[] isVisit;
    // public class PriorityQueue {
    //     private int capacity;
    //     private int size;
    //     private int[] heap;

    //     public PriorityQueue(int capacity){
    //         this.capacity = capacity;
    //         this.heap = new int[capacity];
    //         this.size = 0;
    //     }

    //     public void add(int element){
    //         if(size >= capacity){
    //             throw new IllegalStateException("Queue is full");
    //         }

    //         heap[size] = element;
    //         heapifyUp(size);
    //         size++;
    //     }
    //     public int poll(){
    //         if(size == 0){
    //             throw new IllegalStateException("Queue is empty");
    //         }

    //         int element = heap[0];

    //         heap[0] = heap[size - 1];
    //         size--;
    //         heapifyDown(0);

    //         return element;
    //     }

    //     private void heapUp(int index){
    //         int parentIndex = (index - 1) / 2;

    //         if(index > 0 && heap[parentIndex] > heap[index]){
    //             swap(index, parentIndex);
    //             heapUp(parentIndex);
    //         }
    //     }
    //     private void heapDown(int index){
    //         int smallest = index;
    //         int leftChild = 2 * index + 1;
    //         int rightChild = 2 * index + 2;
        
    //         if(leftChild < size && heap[leftChild] < heap[smallest]){
    //             smallest = leftChild;
    //         }

    //         if(rightChild < size && heap[rightChild] < heap[smallest]){
    //             smallest = leftChild;
    //         }
        
    //         if(smallest != index){
    //             swap(index, smallest);
    //             heapDown(smallest);
    //         }
    //     }
    //     private void swap(int i, int j){
    //         int temp = heap[i];
    //         heap[i] = heap[j];
    //         heap[j] = temp;
    //     }
        
    // }
    public static class Node{
        private int index;

        Node(int index){
            this.index = index;
        }
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
    public static void main(String[] args) throws IOException{
        int numberOfPoint = read();
        int highWay = read();
        int searchOfPoint = read();
        
        list = new ArrayList[numberOfPoint + 1];
        for(int i = 0; i <= numberOfPoint; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < highWay; i++){
            int node1 = read();
            int node2 = read();
            list[node1].add(new Node(node2));
            list[node2].add(new Node(node1));
        }
        

        isVisit = new boolean[numberOfPoint + 1];
        dfs(searchOfPoint);

        System.out.println();
        
        isVisit = new boolean[numberOfPoint + 1];
        bfs(searchOfPoint);
    }
    public static void dfs(int index){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        if(isVisit[index] == false){
            System.out.print(index + " ");
            isVisit[index] = true;
        }


        for(Node child : list[index]){
            if(!isVisit[child.index]){
                priorityQueue.add(child.index);
            }
        }
        while (!priorityQueue.isEmpty()) {
            dfs(priorityQueue.poll());
        }
    }
    public static void bfs(int index){
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        queue.add(index);
        isVisit[index] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");
            
            for(Node child : list[current]){
                if(!isVisit[child.index]){
                    isVisit[child.index] = true;
                    priorityQueue.add(child.index);
                }
            }
            while (!priorityQueue.isEmpty()) {
                queue.add(priorityQueue.poll());
            }
        }
    }



}
