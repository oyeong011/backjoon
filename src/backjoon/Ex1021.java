package backjoon;

import java.io.*;
import java.util.*;
public class Ex1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        LinkedList<Integer> list = new LinkedList<>();
        list = makeList(list, N);
        
        inputs = br.readLine().split(" ");
        int[] Num = new int[M];
        
        for(int i = 0;i < M; i++){
            Num[i] = Integer.parseInt(inputs[i]);
        }
        System.out.println(minNumber(list, Num));


    }
    public static int minNumber(LinkedList<Integer> list, int[] Num){
        int minNumber = 0;
        //비교하고 땡기면 카운트 바로앞에잇으면 그냥 꺼내고
        for(int i = 0; i < Num.length; i++){
            if(Num[i] == list.getFirst()){
                list.removeFirst();
            } else {
                minNumber = _plus_rightLeft_MinNumber(list, Num[i], minNumber);
            }
        }
        return minNumber;
    }
    public static int _plus_rightLeft_MinNumber(LinkedList<Integer> list, int Num, int minNumber){
        int elementIndex = list.indexOf(Num);
        if(elementIndex > list.size() - elementIndex){
                    while (elementIndex != 0) {
                        list = right(list);
                        minNumber++;
                        elementIndex = list.indexOf(Num);
                        if(elementIndex == 0){
                            break;
                        }
                    }
                    list.removeFirst();
                } else {
                    while (elementIndex != 0) {
                        list = left(list);
                        minNumber++;
                        elementIndex = list.indexOf(Num);
                        if(elementIndex == 0){
                            break;
                        }
                    }
                    list.removeFirst();
                }
        return minNumber;
    }
    public static LinkedList<Integer> makeList(LinkedList<Integer> list, int N){
        for(int i=1; i<=N;i++){
            list.add(i);
        }
        return list;
    }
    public static LinkedList<Integer> left(LinkedList<Integer> list){
        Integer first_Element = list.removeFirst();
        list.addLast(first_Element);
        return list;
    } 
    public static LinkedList<Integer> right(LinkedList<Integer> list){
        Integer last_Element = list.removeLast();
        list.addFirst(last_Element);
        return list;
    } 
}
