package backjoon;

import java.io.*;
import java.util.*;

/**
 * Ex23309
 */
public class Ex23309 {
    private static class Station{
        int absoluteNum;
        Station next;
        Station prev;

        Station(Station prev,int absoluteNum, Station next){
            
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int stationCount = Integer.parseInt(st.nextToken());
        int construction = Integer.parseInt(st.nextToken());


    }
    
}