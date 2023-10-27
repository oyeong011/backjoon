package backjoon;

import java.io.*;
import java.util.*;

/**
 * Ex23309
 */
public class Ex23309 {

    private static class Station {
        int absoluteNum;
        Station next;
        Station prev;

        Station(Station prev, int absoluteNum, Station next) {
            this.absoluteNum = absoluteNum;
            this.next = next;
            this.prev = prev;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Station cur = this;
            do {
                sb.append(cur.absoluteNum).append(" -> ");
                cur = cur.next;
            } while (cur != this);
            if (sb.length() > 4) {
                sb.setLength(sb.length() - 4);
            }
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

        Station head = new Station(null, uniqueNumber, null);
        Station station = head;
        for (int i = 0; i < stationCount - 1; i++) {
            uniqueNumber = Integer.parseInt(st.nextToken());
            Station newStation = new Station(station, uniqueNumber, null);
            station.next = newStation;
            station = newStation;
        }
        head.prev = station;
        station.next = head;

        int idx, newAbsoluteNum;
        StringBuilder sb = new StringBuilder();
        Station newStation, removeStation, leftStation, rightStation;
        for (int i = 0; i < construction; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "BN":
                    idx = Integer.parseInt(st.nextToken());
                    newAbsoluteNum = Integer.parseInt(st.nextToken());
                    while (station.absoluteNum != idx) {
                        station = station.next;
                    }
                    rightStation = station.next;
                    leftStation = station.prev;

                    sb.append(rightStation.absoluteNum).append("\n");

                    newStation = new Station(station, newAbsoluteNum, rightStation);
                    rightStation.prev = newStation;
                    station.next = newStation;

                    break;
                case "BP":
                    idx = Integer.parseInt(st.nextToken());
                    newAbsoluteNum = Integer.parseInt(st.nextToken());

                    while (station.absoluteNum != idx) {
                        station = station.next;
                    }
                    rightStation = station.next;
                    leftStation = station.prev;

                    sb.append(leftStation.absoluteNum).append("\n");

                    newStation = new Station(leftStation, newAbsoluteNum, station);
                    leftStation.next = newStation;
                    station.prev = newStation;

                    break;
                case "CN":
                    idx = Integer.parseInt(st.nextToken());
                    while (station.absoluteNum != idx) {
                        station = station.next;
                    }

                    removeStation = station.next;
                    sb.append(removeStation.absoluteNum).append("\n");

                    rightStation = removeStation.next;
                    leftStation = removeStation.prev;

                    if (rightStation.equals(station)) {
                        station.next = station;
                        station.prev = station;
                    } else {
                        rightStation.prev = leftStation;
                        leftStation.next = rightStation;
                    }

                    break;
                case "CP":
                    idx = Integer.parseInt(st.nextToken());
                    while (station.absoluteNum != idx) {
                        station = station.next;
                    }
                    removeStation = station.prev;

                    sb.append(removeStation.absoluteNum).append("\n");

                    rightStation = removeStation.next;
                    leftStation = removeStation.prev;

                    if (leftStation.equals(station)) {
                        station.next = station;
                        station.prev = station;
                    } else {
                        rightStation.prev = leftStation;
                        leftStation.next = rightStation;
                    }
                    break;

                default:
                    break;
            }
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb.toString());

    }

}