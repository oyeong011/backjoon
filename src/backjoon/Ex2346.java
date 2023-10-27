package backjoon;

import java.io.*;
import java.util.*;

public class Ex2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]);

        inputs = br.readLine().split(" ");

        LinkedList<Balloon> balloonList = new LinkedList<>();

        balloonList = makeList(balloonList, N, inputs);
        int[] solveList = new int[N];
        solveList = moveAndBoomBalloon(balloonList, N);
        for(int i=0 ; i<N-1;i++){
            System.out.print(solveList[i]+" ");
        }
        System.out.println(solveList[N-1]);
    }

    static class Balloon {
        int number;
        int moveIndex;

        Balloon(int number, int moveIndex) {
            this.number = number;
            this.moveIndex = moveIndex;
        }
        @Override
        public String toString() {
        return " " + number + " ";
        }
    }

    public static int[] moveAndBoomBalloon(LinkedList<Balloon> balloonList, int N) {
        int arrow = 0;
        int[] solveList = new int[N];
        Balloon numberAndMoveIndex = new Balloon(0, 0);
        for (int i = 0; i < N; i++) {
            numberAndMoveIndex = balloonList.remove(arrow);
            System.out.println("balloonList.toString() : " + balloonList.toString());
            solveList[i] = numberAndMoveIndex.number;
            // System.out.println("solveList[i] : " + solveList[i]);
            int movingNumber = numberAndMoveIndex.moveIndex;
            arrow = balloonList.size()==1 ? 0 : arrowSet(balloonList, arrow, movingNumber);
        }
        return solveList;
    }

    public static int arrowSet(LinkedList<Balloon> balloonList, int arrow, int movingNumber){
            if(balloonList.size() == 0){
                return 0;
            }
            arrow %= balloonList.size();
            arrow += movingNumber>0 ? movingNumber-1 : -(Math.abs(movingNumber)%balloonList.size());
            arrow = arrow > 0 ? arrow : balloonList.size() + arrow;
            arrow %= balloonList.size();
            arrow = Math.abs(arrow);
        
        return arrow;
    }
    public static LinkedList<Balloon> makeList(LinkedList<Balloon> balloonList, int N, String[] inputs) {
        for (int i = 0; i < N; i++) {
            int balloonInMoveCount = Integer.parseInt(inputs[i]);
            balloonList.addLast(new Balloon(i + 1, balloonInMoveCount));
        }
        return balloonList;
    }
}
