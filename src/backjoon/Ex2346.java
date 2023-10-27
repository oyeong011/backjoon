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

    }

    static class Balloon {
        int number;
        int moveIndex;

        Balloon(int number, int moveIndex) {
            this.number = number;
            this.moveIndex = moveIndex;
        }

    }

    public static LinkedList<Balloon> moveAndBoomBalloon(LinkedList<Balloon> balloonList, int N) {
        for (int i = 0; i < N; i++) {

        }
        return balloonList;
    }

    public static LinkedList<Balloon> makeList(LinkedList<Balloon> balloonList, int N, String[] inputs) {
        for (int i = 0; i < N; i++) {
            int balloonInMoveCount = Integer.parseInt(inputs[i]);
            balloonList.addLast(new Balloon(i + 1, balloonInMoveCount));
        }
        return balloonList;
    }
}
