package backjoon.브루트포스;

public class Ex1107리모컨Goat풀이 {
    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();

        boolean[] broken = new boolean[10];

        for (int i = 0; i < M; i++) {
            broken[read()] = true;
        }

        int result = Math.abs(N - 100);

        for (int i = 0; i < 1000000; i++) {
            String str = String.valueOf(i);
            int len = str.length();

            boolean isBreak = false;

            for (int j = 0; j < len; j++) {
                if (broken[str.charAt(j) - '0']) {
                    isBreak = true;
                    break;
                }
            }

            if (!isBreak) {
                int min = Math.abs(N - i) + len;
                result = Math.min(min, result);
            }
        }

        System.out.print(result);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        if (c == 13) {
            System.in.read();
        }

        return n;
    }
}
