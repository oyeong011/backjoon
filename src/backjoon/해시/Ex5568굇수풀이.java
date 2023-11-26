package backjoon.해시;
import java.io.*;
import java.util.*;

public class Ex5568굇수풀이 {

	static int N, K;
	static int[] arr;
	static boolean[] isVisited;
	static Set<Integer> set;
	
	static void dfs(int num, int cnt) {
		if (cnt == K) {
			set.add(num);
			return;
		}
		
		for (int i=0; i<N; i++) {
			if (isVisited[i]){
                continue;
            }
			
            isVisited[i] = true;
			
            if (arr[i] >= 10){
                dfs(num * 100 + arr[i], cnt + 1);
            } else {
                dfs(num * 10 + arr[i], cnt + 1);
            }
			isVisited[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		arr = new int[N];
		isVisited = new boolean[N];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		set = new HashSet<>();
		dfs(0, 0);
		System.out.println(set.size());
		br.close();
	}

}