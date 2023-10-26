package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class Ex2840 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int spinChangenumber, wheel = 0, K = 0;  // 초기값을 설정해주었습니다.
        String alpabet;
        String[] inputs = null;

        LinkedList<String> list = new LinkedList<>();

        try {
            inputs = reader.readLine().split(" ");
            wheel = Integer.parseInt(inputs[0]);
            K = Integer.parseInt(inputs[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        list = makeList(list, wheel);
        listTest(list, K, reader);

        
    }
    public static LinkedList<String> listTest(LinkedList<String> list, int K, BufferedReader reader){
        int arrow = 0;
        int listSize = list.size();
        Boolean luckyOrBomb = true;
        for(int i=0; i < K; i++){
            try {
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
            System.out.println(list.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        
        return list;
    }
    public static LinkedList<String> makeList(LinkedList<String> list, int wheel){
        for(int i=0;i<wheel;i++){
            list.addFirst(null);
        }
        System.out.println("리스트 만들었습니다." + list.toString());
        return list;
    }
    public static boolean isLuckyRoulette(LinkedList<String> list, String alpabet, int arrow){
        if(list.indexOf(alpabet) == -1){
            return true;
        } else if(list.indexOf(alpabet) == arrow){
            return true;
        }
        return false;
    }
}
