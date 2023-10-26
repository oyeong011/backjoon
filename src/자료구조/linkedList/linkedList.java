package 자료구조.linkedList;

public class linkedList {
    public static void main(String[] args) {
        MysinglyLinkedList<Number> l = new MysinglyLinkedList<>();

        l.add(3);
        l.add(4);
        l.add(5);
        l.add(8);
        l.add(31);
        l.add(32);
        l.add(35);
        l.add(39);
        System.out.println(l);
    }
}
