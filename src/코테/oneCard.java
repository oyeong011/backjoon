package 코테;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Stack;

/**
 * oneCard
 */
public class oneCard {
        static final int CARD = 13;
        static int[] card = new int[CARD + 1];
        static int StairCount = 0;
    	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
        System.out.println("Hello Goorm! Your input is " + input);
		
        Stack<Integer> stack = new Stack<>();

		int Card_Count = Integer.parseInt(input);
        boolean[] cardCheckDup = new boolean[CARD + 1];

        input = br.readLine();
        String[] numbers = input.split(" ");
        int[] cardList = new int[Card_Count];

        for(int i = 0 ; i < Card_Count; i++){
            cardList[i] = Integer.parseInt(numbers[i]);
        }
        
        for(int i = 0 ; i < Card_Count; i++){
            if(!stack.isEmpty()){
                stack = stairMake(stack, cardList, cardCheckDup, i);
                continue;
            }
            stack.add(cardList[i]);
        }
        stack = stackMake(stack, cardCheckDup = new boolean[CARD + 1]);
        
        StringBuilder sb = new StringBuilder();
        sb.append(StairCount + "\n");
        for(int i = 1; i < card.length; i++){
            sb.append(card[i] + " ");
        }
        System.out.println(sb.toString());
	}
    public static boolean sizeComparison(int prev, int next){
        if(prev + 1 == next){
            return true;
        }
        if(prev - 1 == next){
            return true;
        }
        return false;
    }
    public static Stack<Integer> stairMake (Stack<Integer> stack, int[] cardList, boolean[] cardCheckDup, int i){
        if(sizeComparison(stack.peek(), cardList[i])){
            stack.add(cardList[i]);
            return stack;
        }
        if(!sizeComparison(stack.peek(), cardList[i]) && stack.size() == 1){
            stack.pop();
            stack.add(cardList[i]);
            return stack;
        }
        stack = stackMake(stack, cardCheckDup = new boolean[CARD + 1]);
        stack.add(cardList[i]);
        return stack;
    }
    public static Stack<Integer> stackMake (Stack<Integer> stack, boolean[] cardCheckDup){
        if(stack.size() == 1){
            return stack;
        }
        while (!stack.isEmpty()) {
            int StackElement = stack.pop();
            if(!cardCheckDup[StackElement]){
                cardCheckDup[StackElement] = true;
                card[StackElement] += 1;
            }
        }
        StairCount += 1;
        return stack;
    }
}