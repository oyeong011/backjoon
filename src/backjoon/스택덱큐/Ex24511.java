package backjoon.스택덱큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex24511 {


    public static int[] makeList(StringTokenizer st, int[] List){
        int i=0;
        while (st.hasMoreTokens()) {
            List[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        return List;
    }
    public static int[] inputDataArray(int input,int[] dataList, int[] dataStructure, StringBuilder sb, int N){
        int arrow, tmp;
        arrow = input;
        for(int i = 0;i < N; i++){
            if(dataStructure[i]==0){
                tmp = dataList[i];
                dataList[i] = arrow;
                arrow = tmp;
            } else {
                continue;
            }
        }
        sb.append(arrow + " ");
        return dataList;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());

        int[] dataStructure = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        dataStructure = makeList(st, dataStructure);
        
        int[] dataList = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        dataList = makeList(st, dataList);
        
        st = new StringTokenizer(br.readLine(), " ");
        int inputDataCount = Integer.parseInt(st.nextToken());
        
        int[] inputData = new int[inputDataCount];
        st = new StringTokenizer(br.readLine(), " ");
        
        inputData = makeList(st, inputData);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < inputDataCount; i++){
            dataList = inputDataArray(inputData[i], dataList, dataStructure, sb, N);
        }
        
        System.out.println(sb.toString());
    }
}
