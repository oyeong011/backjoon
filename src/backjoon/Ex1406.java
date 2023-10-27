package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Ex1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        LinkedList<Character> editor = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            editor.addLast(ch);
        }


        input = br.readLine();
        int N = Integer.parseInt(input);
        int idx = 0;

        for (int i = 0; i < N; i++) {
            String[] inputs= br.readLine().split(" ");
            print_Editor(editor, N, inputs);
            
        }

    }
    public static void print_Editor(LinkedList<Character> Editor, int idx, String[] inputs){

            switch (inputs[0]) {
                case "L":
                    if(idx == 0){
                        break;
                    }
                    idx--;
                    break;
                case "D":
                    if(idx == Editor.size()){
                        break;
                    }
                    idx++;
                    break;
                case "B":
                    if(idx == 0){
                        break;
                    }
                    break;
            
                case "P":

                    
                    break;
            
                default:
                    break;
            
        }
        
    }
}
