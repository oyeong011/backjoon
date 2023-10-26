package 자료구조.linkedList;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.w3c.dom.Node;

public class MyDoublyLinkedList<E> {

    private static class Node<E> {
        private E item;
        private Node<E> next;
        private Node<E> prev;

        Node(Node<E> prev, E item, Node<E> next){
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
    private Node<E> search(int index){
        Node<E> n;

        if((size / 2) > index){
            n = head;
            for(int i = 0; i< index; i++){
                n = n.next;
            }
        } else {
            n = tail;
            for(int i= size-1; i > index ; i--){
                n = n.prev;
            }
        }

        return n;
    }
    private Node<E> head;
    private Node<E> tail;

    private int size;

    public MyDoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(E value){
        Node<E> first = head;

        Node<E> new_node = new Node<>(null, value, first);

        size++;

        head = new_node;

        if(first == null){
            tail = new_node;
        } else{
            first.prev = new_node;
        }
    }

    public void addLast(E value){
        Node<E> last = tail;

        Node<E> new_node = new Node<>(last, value, null);

        size++;

        tail = new_node;

        if(last == null){
            head = new_node;
        } else{
            last.next = new_node;
        }
    }
    public boolean add(E value){
        addLast(value);
        return true;
    }
    public void add(int index, E value){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            addFirst(value);
            return;
        }
        if(index == size){
            addLast(value);
            return;
        }

        Node<E> next_node = search(index);

        Node<E> prev_node = next_node.prev;

        Node<E> new_node = new Node<>(prev_node, value, next_node);

        size++;

        prev_node.next = new_node;

        next_node.prev = new_node;
    }

    public E removeFirst() {

    // 1. 만약 삭제할 요소가 아무것도 없으면 에러
    if (head == null) {
        throw new NoSuchElementException();
    }

    // 2. 삭제될 첫번째 요소의 데이터를 백업
    E value = head.item;

    // 3. 두번째 노드를 임시 저장
    Node<E> first = head.next;

    // 4. 첫번째 노드의 내부 요소를 모두 삭제
    head.next = null;
    head.item = null;

    // 5. 요소가 삭제 되었으니 크기 감소
    size--;
    
    // 6. head가 다음 노드를 가리키도록 업데이트
    head = first;

    if (first == null) {
        // 7. 만일 리스트의 유일한 값을 삭제해서 빈 리스트가 될 경우, tail도 null 처리
        tail = null;
    } else {
        // 8. 만일 빈 리스트가 아닐경우, 삭제되기 이전 두번째 이었던 first가 첫번째 노드가 되니 prev를 null 처리
        first.prev = null;
    }

    // 9. 마지막으로 삭제된 요소를 반환
    return value;
}

    public E remove() {
        return removeFirst();
    }

    public E removeLast() {

        // 1. 만약 삭제할 요소가 아무것도 없으면 에러
        if (tail == null) {
            throw new NoSuchElementException();
        }
    
        // 2. 삭제될 마지막 요소의 데이터를 백업
        E value = tail.item;
    
        // 3. 마지막 노드의 이전 노드를 임시 저장
        Node<E> last = tail.prev;
    
        // 4. 마지막 노드의 내부 요소를 모두 삭제
        tail.item = null;
        tail.prev = null;
    
        // 5. 요소가 삭제 되었으니 크기 감소
        size--;
    
        // 6. tail이 이전 노드를 가리키도록 업데이트
        tail = last;
    
        if(last == null) {
            // 7. 만일 리스트의 유일한 값을 삭제해서 빈 리스트가 될 경우, head도 null 처리
            head = null;
        } else {
            // 8. 만일 빈 리스트가 아닐경우, 삭제되기 이전 마지막의 이전 노드 이었던 last가 마지막 노드가 되니 next를 null 처리
            last.next = null;
        }
    
        // 9. 마지막으로 삭제된 요소를 반환
        return value;
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
        
        E value = del_node.item;

        del_node.item = null;
        del_node.prev = null;
        del_node.next = null;

        size--;

        prev_node.next = next_node;

        prev_node.prev = prev_node;

        return value;
    }
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    
        return search(index).item;
    }
    public void set(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    
        // 1. search 메소드를 이용해 교체할 노드를 얻는다.
        Node<E> replace_node = search(index);
    
        // 2. 교체할 노드의 요소를 변경한다.
        replace_node.item = null;
        replace_node.item = value;
    }

    public int indexOf(Object value){
        Node<E> n = head;
        int i = 0;
        while (n != null) {
            if(Objects.equals(value, n.item)){
                return i;
            }

            i++;
            n = n.next;
        }
        return -1;
    }
    public int lastIndexOf(Object value){
        Node<E> n = tail;
        int i = size - 1;
        while (n != null) {
            if(Objects.equals(value, n.item)){
                return i;
            }
            i--;
            n = n.prev;
        }
        return -1;
    }
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){
        for(Node<E> i = head; i.next != null;){
            Node<E> next_node = i.next;

            i.item = null;
            i.prev = null;
            i.next = null;

            i = next_node;
        }

        head = null;
        tail = null;
        size = 0;
    }

    public boolean contains(Object value){
        return indexOf(value) != -1;
    }
    @Override
    public String toString(){
        if(head == null){
            return "[]";
        }

        Object[] array = new Object[size];

        int index = 0;

        Node<E> n = head;

        while (n != null) {
            array[index] = n.item;
            n = n.next;
            index++;
        }

        return Arrays.toString(array);
    }
}
