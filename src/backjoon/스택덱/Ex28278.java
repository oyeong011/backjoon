package backjoon.스택덱;

import java.io.*;
import java.util.*;

/**
 
Ex28278*/
public class Ex28278 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int cmd = Integer.parseInt(st.nextToken());
            switch (cmd) {
                case 1:
                    int element = Integer.parseInt(st.nextToken());
                    stack.push(element);
                    break;
                case 2:
                    if(stack.isEmpty()){
                        sb.append(-1+"\n");
                        break;
                    }
                    sb.append(stack.pop()+"\n");
                    break;
                case 3:
                    sb.append(stack.size()+"\n");
                    break;
                case 4:
                    int oneOrZero = 0;
                    if(stack.isEmpty()){
                        oneOrZero = 1;
                    }
                    sb.append(oneOrZero + "\n");
                    break;
                case 5:
                    if(stack.isEmpty()){
                        sb.append(-1+"\n");
                        break;
                    }
                    sb.append(stack.peek()+"\n");
                    break;
            }
        }

        System.out.println(sb.toString());
    }
}