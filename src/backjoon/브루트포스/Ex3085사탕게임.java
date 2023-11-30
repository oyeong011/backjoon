package backjoon.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex3085사탕게임 {
    static int max = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];

        for(int i=0; i<N; i++) {
        	String input = br.readLine();
        	for(int j=0; j<N; j++) {
        		map[i][j] = input.charAt(j);
        	}
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(j != N - 1){
                    swap(map, i, j, i, j + 1);
                    checkCol(map, j, j + 1, i);
                    swap(map, i, j, i, j + 1);
                }
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(j != N - 1){
                    swap(map, j, i, j + 1, i);
                    checkRow(map, j, j + 1, i);
                    swap(map, j, i, j + 1, i);
                }
            }
        }

        System.out.println(max);


    }

    public static void swap(char[][] map, int x1, int y1, int x2, int y2) {
    	char temp = map[x1][y1];
    	map[x1][y1] = map[x2][y2];
    	map[x2][y2] = temp;
    }
    public static void checkRow(char[][] map, int x, int y, int axis){

        int count;
        int[] checkAxis = {x, y};

        for(int i : checkAxis){
            count = 1;
            for(int j = 0; j < map.length; j++){
                if(j != map.length - 1 && map[i][j] == map[i][j + 1]){
                    count++;
                }
                else{
                    max = Math.max(max, count);
                    count = 1;
                }
            }
        }

        count = 1;
        for(int i = 0; i < map.length; i++){
            if(i != map.length - 1 && map[i][axis] == map[i + 1][axis]){
                count++;
            }
            else{
                max = Math.max(max, count);
                count = 1;
            }
        }

    }
    public static void checkCol(char[][] map, int x, int y, int axis){

        int count;
        int[] checkAxis = {x, y};

        for(int i : checkAxis){
            count = 1;
            for(int j = 0; j < map.length; j++){
                if(j != map.length - 1 && map[j][i] == map[j + 1][i]){
                    count++;
                }
                else{
                    max = Math.max(max, count);
                    count = 1;
                }
            }
        }

        count = 1;
        for(int i = 0; i < map.length; i++){
            if(i != map.length - 1 && map[axis][i] == map[axis][i + 1]){
                count++;
            }
            else{
                max = Math.max(max, count);
                count = 1;
            }
        }

    }

}
