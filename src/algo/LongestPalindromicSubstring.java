package algo;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int N = s.length();
        int maxLen = 1;
        String substring = s.substring(0, 1);

        for (int i = 0; i < N; i++) {
            int l1 = expandAroundCenter(s, i, i);
            int l2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(l1, l2);

            if (len > maxLen) {
                maxLen = len;

                int start = i - (len - 1) / 2;
                int end = i + len / 2;
                substring = s.substring(start, end+1);
            }
        }

        return substring;
    }

    private int expandAroundCenter(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();

        String str = "cbbd";
        String sub = lps.longestPalindrome(str);

        System.out.println(sub);
    }
}
