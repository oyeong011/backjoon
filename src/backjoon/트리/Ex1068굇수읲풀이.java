package backjoon.트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex1068굇수읲풀이 {
    static int N, REMOVE, ROOT;
    static List<Integer>[] CHILD;
    static int[] LEAF_NUMS;

    static void in() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        CHILD = new ArrayList[N];
        LEAF_NUMS = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < N; i++) {
            CHILD[i] = new ArrayList<>();
        }
        for(int i = 0; i < N; i++) {
            int parent = Integer.parseInt(tokenizer.nextToken());
            if(parent == -1) {
                ROOT = i;
            } else {
                CHILD[parent].add(i);
            }
        }
        REMOVE = Integer.parseInt(reader.readLine());
    }

    static void dfs(int x) {
        if(CHILD[x].isEmpty()) {
            LEAF_NUMS[x]++;
        } else {
            for(int y : CHILD[x]) {
                dfs(y);
                LEAF_NUMS[x] += LEAF_NUMS[y];
            }
        }
    }

    static void solve() {
        for(int i = 0; i < N; i++) {
            if(CHILD[i].contains(REMOVE)) {
                CHILD[i].remove(CHILD[i].indexOf(REMOVE));
            }
        }

        if(REMOVE != ROOT) {
            dfs(ROOT);
        }
        System.out.println(LEAF_NUMS[ROOT]);
    }

    public static void main(String[] args) throws Exception {
        in();
        solve();
    }
}
