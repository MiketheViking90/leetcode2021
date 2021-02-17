package algo;

public class ReverseString {
    public void reverseString(char[] s) {
        int N = s.length;

        for (int i = 0; i < N/2; i++) {
            char c = s[i];

            s[i] = s[N-i-1];
            s[N-i-1] = c;
        }
    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        char[] str = "abcdefghijkl".toCharArray();
        rs.reverseString(str);
        System.out.println(new String(str));
    }
}
