package backjoon.해시;

import java.io.*;
import java.util.*;

public class Ex1302베스트셀러 {

    static Map<String, Integer> Book = new HashMap<>();

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;

        while((c = System.in.read()) > 32){
            n = ( n << 3 ) + ( n << 1 ) + ( c & 15 );
        }
        if (c == 13) System.in.read();
        return isNegative ? ~n + 1 : n;
    }
    public static String readStr() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while((c = System.in.read()) > 32){
            sb.append((char)c);
        }
        if(c == 13) System.in.read();

        return sb.toString();
    }

    public static void solve(int N) throws IOException{
        for(int i = 0; i < N; i++){
            String book = readStr();
            if(Book.containsKey(book)){
                Book.put(book, Book.get(book) + 1);
            }
            else{
                Book.put(book, 1);
            }
        }
    }
    public static void printMaxBook(){
        int max = 0;
        List<String> list = new ArrayList<>();

        for(String key : Book.keySet()){
            int val = Book.get(key);
            if(max < val){
                max = val;
                list.clear();
                list.add(key);
            }else if(max == val){
                list.add(key);
            }
        }
        Collections.sort(list);
        System.out.print(list.get(0));
    }

    public static void main(String[] args) throws IOException{
        int N = read();
        solve(N);
        printMaxBook();
    }
}
