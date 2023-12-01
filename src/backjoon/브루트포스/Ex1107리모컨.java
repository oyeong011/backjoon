package backjoon.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex1107리모컨 {
    static int start = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] Channel = br.readLine().toCharArray();
        int[] ChannelInt = new int[Channel.length];
        for(int i = 0; i < Channel.length; i++){
            ChannelInt[i] = Channel[i] - '0';
        }

        int M = Integer.parseInt(br.readLine());
        if(M == 0){
            getMinNumber(makeChannel(ChannelInt), makeChannel(ChannelInt));
            return;
        }
        boolean[] isBroken = new boolean[10];
        String[] broken = br.readLine().split(" ");
        for(String b : broken){
            isBroken[Integer.parseInt(b)] = true;
        }

        List<Integer> unBrokenButton = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            if(!isBroken[i]){
                unBrokenButton.add(i);
            }
        }


        int[] nearChannel = setNearlyChannel(unBrokenButton, ChannelInt);
        int nearNum = makeChannel(nearChannel);
        int targetNum = makeChannel(ChannelInt);

        getMinNumber(nearNum, targetNum);

    }
    public static int makeChannel(int[] Channel){
        int Num = 0;
        for(int i : Channel){
            Num = Num * 10 + i;
        }
        return Num;
    }
    public static void getMinNumber(int nearNum, int targetNum){
        int startChannel = 100;
        int nearChannel = Math.abs(targetNum - startChannel);
        int nearChannel2 = Math.abs(nearNum - targetNum) + String.valueOf(nearNum).length();
        int nearChannel3 = Math.abs(startChannel - targetNum) + String.valueOf(startChannel).length();

        int minChannel = Math.min(nearChannel, nearChannel2);
        minChannel = Math.min(minChannel, nearChannel3);

        System.out.println(minChannel);


    }
    public static int[] setNearlyChannel(List<Integer> unBrokenButton, int[] ChannelInt){
        int[] nearChannel = new int[ChannelInt.length];

        for(int i = 0; i < ChannelInt.length; i++){
            if(!unBrokenButton.contains(ChannelInt[i])){
                nearChannel[i] = checkMinNumber(ChannelInt[i], unBrokenButton);
            } else {
                nearChannel[i] = ChannelInt[i];
            }
        }

        return nearChannel;
    }
    public static int checkMinNumber(int channelNum, List<Integer> unBrokenButton){
        int nearVal = 100;;
        int returnVal = 0;
        for (Integer integer : unBrokenButton) {
            int Val = Math.abs(channelNum - integer);
            if (Val < nearVal) {
                nearVal = Val;
                returnVal = integer;
            }
        }

        return returnVal;

    }
}
