import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList {
    public static class MyLinkedList<E> implements Iterable<E>{
        private Node<E> head;
        private Node<E> tail;
        private int size = 0;

        private static class Node<E>{
            private E item;
            private Node<E> next;
            Node(E item, Node<E> next){
                this.item = item;
                this.next = next;
            }
        }

        private void add(E val){
            Node<E> last = tail;
            Node<E> newNode = new Node<>(val, null);
            tail = newNode;

            size++;
            if(last == null){
                head = newNode;
            }else{
                last.next = newNode;
            }
        }
        private int get(int index){
            if(index < 0 || index >= size){
                throw new IndexOutOfBoundsException();
            }
            Node<E> n = head;
            for(int i=0; i< index; i++){
                n = n.next;
            }
            return (int) n.item;
        }
        private int delete(int index){
            if(index < 0 || index >= size){
                throw new IndexOutOfBoundsException();
            }
            Node<E> n = head;
            for(int i = 0; i < index; i++){
                n = n.next;
            }
            int val = (int) n.item;
            n.item = null;
            Node<E> next = n.next;
            n.next = null;
            n = next;
            size--;
            if(n == null){
                tail = null;
            }
            return (int) val;
        }

        @Override
        public Iterator<E> iterator() {
            return new MyLinkedListIterator();
        }

        private class MyLinkedListIterator implements Iterator<E> {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E data = current.item;
                current = current.next;
                return data;
            }
        }
    }
    public static class MyQueue<E> implements Iterable<E>{
        private MyLinkedList<E> queue = new MyLinkedList<>();

        public void enqueue(E item){
            queue.add(item);
        }
        public int dequeue(){
            return queue.delete(0);
        }
        public int peek(){
            return queue.get(0);
        }
        public int size(){
            return queue.size;
        }
        public boolean isEmpty(){
            return queue.size == 0;
        }
        @Override
        public Iterator<E> iterator() {
            return queue.iterator();
        }
    }
    public static class MyStack<E> implements Iterable<E>{
        private MyLinkedList<E> stack = new MyLinkedList<>();

        public void push(E item){
            stack.add(item);
        }
        public int pop(){
            return stack.delete(stack.size-1);
        }
        public int peek(){
            return stack.get(stack.size-1);
        }
        public int size(){
            return stack.size;
        }
        public boolean isEmpty(){
            return stack.size == 0;
        }
        @Override
        public Iterator<E> iterator() {
            return stack.iterator();
        }
    }

    public static void main(String[] args) {

        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        for (int i : queue) {
            System.out.println(i);
        }

        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        for (int i : stack) {
            System.out.println(i);
        }
    }
}
