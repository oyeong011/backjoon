package 자료구조.linkedList;

public class CircularDoublyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    
    private int size;

    public CircularDoublyLinkedList(){
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
            this.prev = prev;
            this.next = next;
        }
    }

    public void addFirst(E value){
        Node<E> first = head;
        Node<E> last = tail;

        Node<E> new_node = new Node<>(null, value, first);

        size++;

        head = new_node;
        if(first == null){
            tail = new_node;

            new_node.next = new_node;
            new_node.prev = new_node;
        } else{
            first.prev = new_node;
            last.next = new_node;
            new_node.prev = last;
        }        
    }
    public void addLast(E value){
        Node<E> first = head;
        Node<E> last = tail;

        Node<E> new_node = new Node<>(last, value, null);

        size++;

        tail = new_node;

        if(last ==null){
            head = new_node;

            new_node.next = new_node;
            new_node.prev = new_node;
        } else{
            last.next = new_node;
            new_node.next = first;
            first.prev = new_node;
        }
    }
    public E removeFirst(){
        if(head == null){
            throw new RuntimeException();
        }
        E returnValue = head.item;

        Node<E> first = head.next;

        head.next = null;
        head.item = null;

        head = first;

        size--;

        if(head == null){
            tail = null;
        }
        return returnValue;
    }
}
