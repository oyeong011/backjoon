package backjoon;

import java.io.*;
import java.util.*;

public class Ex1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        LinkedList<Character> Editor = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            Editor.addLast(ch);
        }
        ListIterator<Character> Arrow = Editor.listIterator();

        while (Arrow.hasNext()) {
            Arrow.next();
        }

        input = br.readLine();
        int N = Integer.parseInt(input);

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            switch (inputs[0]) {
                case "L":
                    if(Arrow.hasPrevious()){
                        Arrow.previous();
                    }
                    break;
                case "D":
                    if(Arrow.hasNext()){
                        Arrow.next();
                    }
                    break;
                case "B":
                    if(Arrow.hasPrevious()){
                        Arrow.previous();
                        Arrow.remove();
                    }
                    // System.out.println("EditorB : " + Editor.toString());
                    break;
                case "P":
                    Arrow.add(inputs[1].charAt(0));
                    break;
                default:
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : Editor) {
            sb.append(ch);
        }
        System.out.println(sb.toString());
    }

}
