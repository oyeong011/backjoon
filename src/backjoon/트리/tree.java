package backjoon.트리;

import backjoon.트리.tree.Tree.Node;

public class tree {
    public static class Tree {
        int count;

        public Tree() {
            count = 0;
        }

        public class Node {
            Object data;
            Node left;
            Node right;

            public Node(Object data) {
                this.data = data;
                left = null;
                right = null;
            }

            public void addLeft(Node node) {
                left = node;
                count++;
            }

            public void addRight(Node node) {
                right = node;
                count++;
            }

            public void deleteLeft() {
                left = null;
                count--;
            }

            public void deleteRight() {
                right = null;
                count--;
            }
        }

        public Node addNode(Object data) {
            Node n = new Node(data);
            return n;
        }

        public void inOrder(Node node) {
            if (node == null) {
                return;
            }

            inOrder(node.left);
            System.out.println(node.data + " ");
            inOrder(node.right);
        }

        public void preOrder(Node node) {
            if (node == null) {
                return;
            }

            System.out.println(node.data + " ");
            inOrder(node.left);
            inOrder(node.right);
        }

        public void postOrder(Node node) {
            if (node == null) {
                return;
            }

            inOrder(node.left);
            inOrder(node.right);
            System.out.println(node.data + " ");
        }

    }

    public static void main(String[] args) {
        Tree tree = new Tree();

        Node node1 = tree.addNode(1);
        Node node2 = tree.addNode(2);
        Node node3 = tree.addNode(3);
        Node node4 = tree.addNode(4);
        Node node5 = tree.addNode(5);
        Node node6 = tree.addNode(6);
        Node node7 = tree.addNode(7);

        node1.addLeft(node2);
        node1.addRight(node3);

        node2.addLeft(node4);
        node2.addRight(node5);

        node3.addLeft(node6);
        node3.addRight(node7);

        // 순회
        tree.preOrder(node1);
        System.out.println();
        tree.inOrder(node1);
        System.out.println();
        tree.postOrder(node1);
        System.out.println();

        node2.deleteLeft();
        node3.deleteRight();

        /*
         * 삭제 이후 트리 모양
         * 1
         * 2 3
         * 5 6
         */

        System.out.println();
        tree.preOrder(node1);
        System.out.println();
        tree.inOrder(node1);
        System.out.println();
        tree.postOrder(node1);
        System.out.println();
    }
}
