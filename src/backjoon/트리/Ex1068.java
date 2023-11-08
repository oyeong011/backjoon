package backjoon.트리;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ex1068 {
    public static void main(String[] args) throws IOException {
        int count = read();
        int[][] nodeList = new int[count][2];
        boolean[] isLeaf = new boolean[count];
        for(int i=0 ; i < count ; i++){
            int nodeNumber = read();
            if(nodeNumber == -1){
                isLeaf[0] = true;
                continue;
            }
            if(isLeaf[nodeNumber]) isLeaf[nodeNumber] = false;
            
            if(nodeList[nodeNumber][0] == 0){
                isLeaf[i] = true;
                nodeList[nodeNumber][0] = i;
            } else {
                isLeaf[i] = true;
                nodeList[nodeNumber][1] = i;
            }
        }

        int removeNode = read();
        isLeaf = preOrder(isLeaf, nodeList, removeNode);
        
        printCountLeaf(isLeaf);
    }
    public static boolean[] preOrder(boolean[] isLeaf, int[][] nodeList, int removeNode){
        if(nodeList[removeNode][0] != 0){
            isLeaf = preOrder(isLeaf, nodeList, nodeList[removeNode][0]);
        }
        if(nodeList[removeNode][1] != 0){
            isLeaf = preOrder(isLeaf, nodeList, nodeList[removeNode][1]);
        }
        isLeaf[removeNode] = false;
        
        
        return isLeaf;
    }
    public static void printCountLeaf(boolean[] isLeaf){
        int count = 0;
        for(var trueOrFalse : isLeaf){
            if(trueOrFalse){
                count++;
            }
        }
        System.out.println(count);
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
        if (c == 13) System.in.read();
        
        return isNegative ? ~n + 1 : n;
    } 
}
