package backjoon.트리;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ex1068 {
    public static class Node{
        int data;
        List<Node> childNode;
        int parentData = -1;
        public Node(int data){
            this.data = data;
            this.childNode = new ArrayList<>();
        }

        public void addChild(Node child){
            this.childNode.add(child);
        }
        public void removeChild(Node childNode){
            this.childNode.remove(childNode);
        }
    }
    public static void main(String[] args) throws IOException {
        int count = read();
        Node[] nodeList = new Node[count];
        boolean[] isLeaf = new boolean[count];
        Node root = null;
        for(int i=0;i<count;i++){
            nodeList[i] = new Node(i);
        }
        for (int i = 0; i < count; i++) {
            int nodeNumber = read();
            if (nodeNumber == -1) {
                isLeaf[i] = nodeList[i].childNode.isEmpty();
                root = nodeList[i];
                continue;
            } else {
                isLeaf[i] = true;
                nodeList[i].parentData = nodeNumber;
                nodeList[nodeNumber].addChild(nodeList[i]);
            }
            if (isLeaf[nodeNumber]) isLeaf[nodeNumber] = false;
        }

        int removeNode = read();
        isLeaf = preOrder(isLeaf, nodeList, removeNode);
        isLeaf = isParentNodeLeaf(isLeaf, nodeList, removeNode); 
        printCountLeaf(isLeaf);
    }
    public static boolean[] isParentNodeLeaf(boolean[] isLeaf, Node[] nodeList, int removeNode){
        int parentNodeIdx = nodeList[removeNode].parentData;
        if(parentNodeIdx >= 0){
            nodeList[parentNodeIdx].childNode.remove(nodeList[removeNode]);
            if(nodeList[parentNodeIdx].childNode.isEmpty()){
                isLeaf[parentNodeIdx] = true;
            }
        }
        return isLeaf;
    }
    public static boolean[] preOrder(boolean[] isLeaf, Node[] nodeList, int removeNode) {
        if(!nodeList[removeNode].childNode.isEmpty()){
            for(Node child : nodeList[removeNode].childNode){
                preOrder(isLeaf, nodeList, child.data);
            }
        }
        isLeaf[removeNode] = false;
        return isLeaf;
    }

    public static void printCountLeaf(boolean[] isLeaf) {
        int count = 0;
        for (var trueOrFalse : isLeaf) {
            if (trueOrFalse) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;

        if (isNegative) {
            n = System.in.read() & 15;
        }
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        if (c == 13)
            System.in.read();

        return isNegative ? ~n + 1 : n;
    }
}
