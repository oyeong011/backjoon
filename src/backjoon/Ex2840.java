package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class Ex2840 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int wheel = 0, K = 0;  // 초기값을 설정해주었습니다.
        String[] inputs = null; // 입력 받을 문자열 생성
        LinkedList<String> list = new LinkedList<>(); // 링크드 리스트 생성


        
        inputs = reader.readLine().split(" ");
        wheel = Integer.parseInt(inputs[0]);
        K = Integer.parseInt(inputs[1]);
    

        list = makeList(list, wheel);
        list =  listTest(list, K, reader);
        String st = String.join("", list);
        System.out.println(st);
        
    }
    public static LinkedList<String> listTest(LinkedList<String> list, int K, BufferedReader reader) throws IOException{
        LinkedList<String> finalList = new LinkedList<>();
        int arrow = 0;
        int listSize = list.size();
        Boolean luckyOrBomb = true;
        for(int i=0; i < K; i++){
            
            String[] inputs = reader.readLine().split(" ");
            int spin = Integer.parseInt(inputs[0]);
            String alpabet = inputs[1];
            arrow += spin;
            arrow %= listSize;

            if(isLuckyRoulette(list, alpabet, arrow)){
                list.set(arrow, alpabet);
            } else {
                luckyOrBomb = false;
            }
        }
        
        if(luckyOrBomb){ // 행운의 바퀴인 판단하는 함수
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
        if(list.indexOf(alpabet) == -1){// 처음 넣었을때의 경우
            if(list.get(arrow)=="?" || list.get(arrow) == alpabet){ // 
                return true;
            } else{
                return false;
            }
        } else if(list.indexOf(alpabet) == arrow){ // 기존에 있는 배열일때
            return true;
        }
        return false;
    }
}
