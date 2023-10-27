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
        // System.out.println("초기 리스트 : " + Editor.toString());
        int idx = input.length() + 1;
        input = br.readLine();
        int N = Integer.parseInt(input);

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            switch (inputs[0]) {
                case "L":
                    if (idx == 1) {
                        break;
                    }
                    idx--;
                    // System.out.println("idxL : " + idx);
                    break;
                case "D":
                    if (idx == Editor.size() + 1) {
                        break;
                    }
                    idx++;
                    // System.out.println("idxD : " + idx);
                    break;
                case "B":
                    if (idx == 1) {
                        break;
                    } else if (idx == Editor.size() + 1) {
                        Editor.removeLast();
                        idx--;
                    } else {
                        Editor.remove(idx - 2);
                        idx--;
                    }
                    // System.out.println("EditorB : " + Editor.toString());
                    break;
                case "P":
                    if (idx == Editor.size() + 1) {
                        Editor.addLast(inputs[1].charAt(0));
                        idx++;
                    } else if (idx == 1) {
                        Editor.addFirst(inputs[1].charAt(0));
                        idx++;
                    } else {
                        Editor.add(idx - 1, inputs[1].charAt(0));
                        idx++;
                    }
                    // System.out.println("EditorP : " + idx + " " + Editor.toString());
                    break;
                default:
                    break;
            }
        }
        int size = Editor.size();
        for (int i = 0; i < size; i++) {
            System.out.print(Editor.removeFirst());
        }
    }

}
