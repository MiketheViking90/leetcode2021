package algo;

public class DecodeWays {
    public int numDecodings(String s) {
        int N = s.length();
        int[] mem = new int[N];
        if ((s.charAt(0) - '0') > 0) {
            mem[0] = 1;
        }
        for (int i = 1; i < N; i++) {
            int num0 = s.charAt(i-1) - '0';
            int num1 = s.charAt(i) - '0';
            int count = mem[i-1];
            if (num0 == 1 && num1 != 0 || num0 == 2 && num1 >= 1 && num1 <= 6) {
                count += 1;
            }
            mem[i] = count;
        }
        return mem[N-1];
    }

    public static void main(String[] args) {
        DecodeWays dw = new DecodeWays();
        int n = dw.numDecodings("123123123");
        System.out.println(n);
    }
}
