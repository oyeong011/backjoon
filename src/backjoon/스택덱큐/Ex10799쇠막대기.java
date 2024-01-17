package backjoon.스택덱큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10799쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int count = 0;
        int stick = 0;

        for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if(c == '(') {
				stick++;
			} else {
				stick--;
				if(input.charAt(i-1) == '(') {
					count += stick;
				} else {
					count++;
				}
			}
		}
		System.out.println(count);

    }
}
