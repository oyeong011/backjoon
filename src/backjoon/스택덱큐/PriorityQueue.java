package backjoon.스택덱큐;

/**
 * PriorityQueue
 */
public class PriorityQueue {
        private int capacity;
        private int size;
        private int[] heap;

        public PriorityQueue(int capacity){
            this.capacity = capacity;
            this.heap = new int[capacity];
            this.size = 0;
        }

        public void add(int element){
            if(size >= capacity){
                throw new IllegalStateException("Queue is full");
            }

            heap[size] = element;
            heapUp(size);
            size++;
        }
        public int poll(){
            if(size == 0){
                throw new IllegalStateException("Queue is empty");
            }

            int element = heap[0];

            heap[0] = heap[size - 1];
            size--;
            heapDown(0);

            return element;
        }

        private void heapUp(int index){
            int parentIndex = (index - 1) / 2;

            if(index > 0 && heap[parentIndex] > heap[index]){
                swap(index, parentIndex);
                heapUp(parentIndex);
            }
        }
        private void heapDown(int index){
            int smallest = index;
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
        
            if(leftChild < size && heap[leftChild] < heap[smallest]){
                smallest = leftChild;
            }

            if(rightChild < size && heap[rightChild] < heap[smallest]){
                smallest = leftChild;
            }
        
            if(smallest != index){
                swap(index, smallest);
                heapDown(smallest);
            }
        }
        private void swap(int i, int j){
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
        public boolean isEmpty() {
            return size == 0;
        }
    }