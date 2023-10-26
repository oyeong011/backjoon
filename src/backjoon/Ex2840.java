package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class Ex2840 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<String> list = new LinkedList<>(); // 링크드 리스트 생성


        // 입력받기
        String[] inputs = reader.readLine().split(" ");
        int wheel = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);
        //링크드 리스트 만들기
        list = makeList(list, wheel);

        //행운의 바퀴면 바퀴 출력 아니면 ! 출력
        list =  getLuckyRoulette(list, K, reader);
        String st = String.join("", list);
        System.out.println(st);
        
    }
    public static LinkedList<String> getLuckyRoulette(LinkedList<String> list, int K, BufferedReader reader) throws IOException{
        //행운의바퀴 담을 리스트
        LinkedList<String> finalList = new LinkedList<>();
        //화살표
        int arrow = 0;
        //리스트의 크기
        int listSize = list.size();
        //행운의 바퀴인지 아닌지 여부
        boolean isLuckyRoulette = true;

        for(int i=0; i < K; i++){
            //회전수와 넣을 알파벳 입력 받기
            String[] inputs = reader.readLine().split(" ");
            int spin = Integer.parseInt(inputs[0]);
            String alpabet = inputs[1];

            //화살표가 몇번 움직이는지 설정
            arrow += spin;
            arrow %= listSize;

            if(isLuckyRoulette(list, alpabet, arrow)){
                list.set(arrow, alpabet);
            } else {
                isLuckyRoulette = false;
            }
        }
        
        if(isLuckyRoulette){ // 행운의 바퀴인 판단하는 함수
            int i = 1;
            while (listSize>i+arrow) {
                finalList.addFirst(list.get(arrow+i));
                i++;
            }
            i = 0;
            while (arrow >= i) {
                finalList.addFirst(list.get(i));
                i++;
            }
            return finalList;
        } else {
            finalList.addFirst("!");
            return finalList;
        }
    }
    public static LinkedList<String> makeList(LinkedList<String> list, int wheel){
        for(int i=0;i<wheel;i++){
            list.addFirst("?");
        }
        return list;
    }
    public static boolean isLuckyRoulette(LinkedList<String> list, String alpabet, int arrow){ // 행운의 바퀴인지 판별
        int index = list.indexOf(alpabet);
        // 처음 넣었을때의 경우
        if(index == -1){
            if(list.get(arrow).equals("?") || list.get(arrow).equals(alpabet)){ // 
                return true;
            } else{
                return false;
            }
        // 기존에 있는 배열일때
        } else if(index == arrow){
            return true;
        }
        return false;
    }
}
