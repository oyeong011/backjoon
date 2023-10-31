package backjoon.구현;

import java.io.*;
import java.util.*;

/**
 * Ex23309
 */
public class Ex23309 {

    private static class Station {
        int[] nextNode;
        int[] prevNode;

        Station() {
            this.nextNode = new int[10000001];
            this.prevNode = new int[10000001];
        }

        public void add(int target, int uniqueNumber) {
            if (target == -1) {
                nextNode[uniqueNumber] = prevNode[uniqueNumber] = uniqueNumber;
                return;
            }
            // 신규 노드와 신규노드 오른쪽 노드와 연결
            prevNode[nextNode[target]] = uniqueNumber;
            nextNode[uniqueNumber] = nextNode[target];
            // 신규 노드와 왼쪽노드와 연결
            nextNode[target] = uniqueNumber;
            prevNode[uniqueNumber] = target;
        }

        public void delete(int target) {
            if (nextNode[target] == target) {
                return;
            }
            // 오른쪽 노드랑 왼쪽노드 연결시키기
            prevNode[nextNode[target]] = prevNode[target];
            nextNode[prevNode[target]] = nextNode[target];

            // 지울 노드 양쪽 연결요소 삭제
            nextNode[target] = prevNode[target] = 0;

        }

        public String toString(int target) {
            StringBuilder sb = new StringBuilder();
            int searchNumber = target;
            do {
                sb.append(searchNumber + " -> ");
                searchNumber = nextNode[searchNumber];
            } while (searchNumber != target);
            sb.setLength(sb.length() - 4);

            return sb.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int stationCount = Integer.parseInt(st.nextToken());
        int construction = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int uniqueNumber = Integer.parseInt(st.nextToken());

        Station stationList = new Station();
        int target = -1;
        stationList.add(target, uniqueNumber);
        target = uniqueNumber;

        for (int i = 0; i < stationCount - 1; i++) {
            uniqueNumber = Integer.parseInt(st.nextToken());
            stationList.add(target, uniqueNumber);
            target = uniqueNumber;
        }

        System.out.println(stationList.toString(2));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < construction; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "BN":
                    target = Integer.parseInt(st.nextToken());
                    uniqueNumber = Integer.parseInt(st.nextToken());

                    sb.append(stationList.nextNode[target] + "\n");
                    stationList.add(target, uniqueNumber);

                    break;
                case "BP":
                    target = Integer.parseInt(st.nextToken());
                    uniqueNumber = Integer.parseInt(st.nextToken());

                    sb.append(stationList.prevNode[target] + "\n");
                    stationList.add(stationList.prevNode[target], uniqueNumber);

                    break;
                case "CN":
                    target = Integer.parseInt(st.nextToken());

                    sb.append(stationList.nextNode[target] + "\n");
                    stationList.delete(stationList.nextNode[target]);

                    break;
                case "CP":
                    target = Integer.parseInt(st.nextToken());

                    sb.append(stationList.prevNode[target] + "\n");
                    stationList.delete(stationList.prevNode[target]);

                    break;

                default:
                    break;
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb.toString());

    }

}