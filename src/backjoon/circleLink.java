package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Objects;


public class circleLink {
    public static void main(String[] args) {
        circleLinkedList<String> list = new circleLinkedList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs;
        int spinChangenumber, N =0 ,K = 0;
        String alpabet;
        
        try{
            inputs = reader.readLine().split(" ");
            N = Integer.parseInt(inputs[0]);
            K = Integer.parseInt(inputs[1]); 
        } catch (IOException e){
            e.printStackTrace();
        }

        list = setList(list, N);
        
        for(int i=0; i < K;i++){
            try {
                inputs = reader.readLine().split(" ");
                spinChangenumber = Integer.parseInt(inputs[0]);
                alpabet = inputs[1];
                list.add(spinChangenumber, alpabet);              
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(list.toString());
        }
        
        
    }
    public static circleLinkedList<String> setList(circleLinkedList<String> list, int count){
        for(int i=0;i<count;i++){
            list.addFirst(null);
        }
        return list;
    }
    // public static void test(circleLinkedList<Number> list, int spinChangenumber, char alpabet){
        
    // }
    public static class circleLinkedList<E>{
        private Node<E> head;
        private Node<E> tail;
        private int size;
        
        public circleLinkedList(){
            this.head = null;
            this.tail = null;
            this.size = 0;
        }
        private static class Node<E>{
            private E item;
            private Node<E> next;
            private Node<E> prev;

            Node(Node<E> prev, E item, Node<E> next){
                this.item = item;
                this.next = next;
                this.prev = prev;
            }
        }
        public Node<E> search(int index){
            Node<E> n = head;
            if((size / 2) > index){
                for(int i = 0; i< index; i++){
                    n = n.next;
                }
            } else {
                n = tail;
                for(int i = size; i>index; i--){
                    n = n.prev;
                }
            }
            return n;
        }
        public void addFirst(E val){
            Node<E> first = head;
            Node<E> last = tail;

            Node<E> new_node = new Node(null, val, first);
            size++;
            head = new_node;

            if(first == null){
                tail = new_node;
                new_node.next = new_node;
                new_node.prev = new_node;
            } else {
                first.prev = new_node;
                last.next = new_node;
                new_node.prev = last;
            }
        }
        public void addLast(E val){
            Node<E> first = head;
            Node<E> last = tail;

            Node<E> new_node = new Node<>(last, val, null);
            size++;
            tail = new_node;

            if(tail==null){
                head = new_node;

                new_node.next = new_node;
                new_node.prev = new_node;
            } else {
                last.next = new_node;
                new_node.next = first;
                first.prev = new_node;
            }

        }
        public void add(int index, E val){
            if(index < 0 || index >= size){
                throw new IndexOutOfBoundsException();
            }
            if(index == 0){
                addFirst(val);
                return;
            }
            if(index == size){
                addLast(val);
                return;
            }

            Node<E> next_node = search(index);
            Node<E> prev_node = next_node.prev;
            Node<E> new_node = new Node<>(prev_node, val, next_node);

            size++;

            prev_node.next = new_node;
            next_node.prev = new_node;
        }
        public void replace(int index, E val){
            
        }
        public E removeFirst(){
            if(head == null){
                throw new NoSuchElementException();
            }

            E val = head.item;

            Node<E> first = head.next;
            Node<E> last = tail;

            head.next = null;
            head.item = null;
            head.prev = null;

            size--;

            head = first;

            if(first == null){
                tail=null;
            } else {
                first.prev = last;
                last.next = first;
            }


            return val;
        }
        public E removeLast(){
            if(tail == null){
                throw new NoSuchElementException();
            }

            E val = tail.item;

            Node<E> last = tail.prev;
            Node<E> first = head;

            tail.item = null;
            tail.prev = null;
            tail.next = null;

            size--;

            if(last==null){
                head = null;
            } else {
                first.prev = last;
                last.next = first;
            }
            return val;
        }
    
        public E remove(int index){
            if(index < 0 || index >= size){
                throw new IndexOutOfBoundsException();
            }
            if(index == 0){
                return removeFirst();
            }
            if(index == size - 1){
                return removeLast();
            }

            Node<E> del_node = search(index);
            Node<E> prev_node = del_node.prev;
            Node<E> next_node = del_node.next;

            E val = del_node.item;

            del_node.item = null;
            del_node.prev = null;
            del_node.next = null;

            size--;

            prev_node.next = next_node;
            next_node.prev = prev_node;

            return val;
        }
        public int indexOf(Object val){
            Node<E> n = head;
            int i=0;
            while (i<size) {
                if(Objects.equals(val, n.item)){
                    return i;
                }
                i++;
                n = n.next;
            }
            return -1;
        }
        public int lastIndexOf(Object val){
            Node<E> n = tail;
            int i= size-1;
            while (i>0) {
                if(Objects.equals(val, n)){
                    return i;
                }
                i--;
                n = n.prev;
            }
            return -1;
        }
        @Override
        public String toString(){
            if(head == null){
                return "[]";
            }
            Node<E> n = head;
            int i = 0;
            String result = "[";
            while (i<size-1) {
                result += n.item + ", ";
                n = n.next;
                i++;
            }
            result += n.item + "]";

            return result;
        }
    }

}
