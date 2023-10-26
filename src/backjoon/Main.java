package backjoon;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i=1; i<=N; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder("<");
        while (!queue.isEmpty()) {
            for (int i=1; i<K; i++) {
                queue.add(queue.remove());
            }
            sb.append(queue.remove());

            if (queue.size() != 0) {
                sb.append(", ");
            }
        }
        sb.append(">");

        System.out.println(sb);
    }
}
