package 자료구조.linkedList;

import java.util.Arrays;
import java.util.Objects;

/**
 * MysinglyLinkedList
 */
public class MysinglyLinkedList<E> {
    
    private static class Node<E> {
        private E item; // Node에 담을 데이터
        private Node<E> next; // 다음 Node 객체를 가르키는 래퍼런스

        // 생성자
        Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
    private Node<E> head; // 노드의 첫 부분을 가리키는 포인트
    private Node<E> tail; // 노드의 마지막 부분을 가리키는 포인트
    private int size; // 요소 갯수

    public MysinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    private Node<E> search(int index){
        Node<E> n = head;
        for(int i=0; i< index; i++){
            n = n.next;
        }
        return n;
    }

    public void addFirst(E value){
        Node<E> first = head;

        Node<E> newNode = new Node<>(value, first);

        size++;

        head = newNode;

        if(first == null){
            tail = newNode;
        }
    }
    public void addlast(E value){
        Node<E> last = tail;

        Node<E> newNode = new Node<>(value, null);

        size++;

        tail = newNode;

        if(last == null){
            head = newNode;
        } else{
            last.next = newNode;
        }
    }
    
    public boolean add(E value){
        addlast(value);
        return true;
    }
    public void add(int index, E value){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            // Node<E> first = head;
            // Node<E> newNode = new Node<>(value, first);

            // size++;
            // head = newNode;

            // if(first == null){
            //     tail = newNode;
            // } 
            addFirst(value);
        }
        if(index == size-1){
            addlast(value);
        }

        Node<E> prev_node = search(index - 1);

        Node<E> next_node = prev_node.next;

        Node<E> newNode = new Node<>(value, next_node);
        size++;

        prev_node.next = newNode;
    }
    public E removeFirst(){
        if(head==null){
            throw new IndexOutOfBoundsException();
        }

        E returnValue = head.item;

        Node<E> first = head.next;

        head.next = null;
        head.item = null;

        head = first;

        size--;
        if(head==null){
            tail = null;
        }
        return returnValue;
    }
    public E remove(){
        return removeFirst();
    }

    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            // if(head==null){
            //     throw new IndexOutOfBoundsException();
            // }
            // E returnValue = head.item;

            // Node<E> first = head.next;

            // head.next = null;
            // head.item =null;

            // head = first;

            // size--;
            // if(head==null){
            //     tail = null;
            // }
            // return returnValue
            removeFirst();
        }
        Node<E> prev_node = search(index-1);

        Node<E> del_node = prev_node.next;

        Node<E> next_node = del_node.next;

        E returnValue = del_node.item;

        del_node.next = null;
        del_node.item =null;

        size--;

        prev_node.next = next_node;
        
        return returnValue;
    }

    public boolean remove(Object value){
        if(head==null){
            throw new RuntimeException();
        }
        Node<E> prev_node = null;
        Node<E> del_node = null;
        Node<E> next_node = null;

        Node<E> i = head;

        while (i != null) {
            if(Objects.equals(i.item, value)){
                del_node = i;
                break;
            }
            prev_node = i;
            i = i.next;
        }

        if(del_node==null){
            return false;
        }
        if(del_node == head){
            removeFirst();
            return true;
        }

        next_node = del_node.next;

        del_node.next = null;
        del_node.item = null;

        size--;

        prev_node.next = next_node;

        return true;

    }

    public E removeLast(){
        return remove(size-1);
    }

    public E get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        return search(index).item;
    }

    public void set(int index, E value){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException();
        }
        Node<E> replace_node = search(index);

        replace_node.item = null;
        replace_node.item = value;
    }
    @Override
    public String toString(){
        if(head==null){
            return "[]";
        }

        Object[] array = new Object[size];

        int index = 0;
        Node<E> n = head;
        while (n != null) {
            array[index] = (E) n.item;
            index++;
            n = n.next;
        }

        return Arrays.toString(array);
    }
}