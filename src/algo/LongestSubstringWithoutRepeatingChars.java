package algo;

public class LongestSubstringWithoutRepeatingChars {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        int i = 0;
        int j = 0;
        int N = s.length();
        int len = 1;
        int maxLen = 1;

        int[] asciiToCount = new int[128];
        asciiToCount[s.charAt(i)] = 1;

        while (j < N) {
            if (isAllUnique(asciiToCount)) {
                j++;

                if (j == N) {
                    return Math.max(maxLen, j - i);
                }

                char c = s.charAt(j);
                asciiToCount[c]++;

                len = j - i;
                maxLen = Math.max(maxLen, len);
            } else {
                char c = s.charAt(i);
                i++;

                asciiToCount[c]--;
            }
        }
        return maxLen;
    }

    private static boolean isAllUnique(int[] asciiToCount) {
        for (int count : asciiToCount) {
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        int len = lengthOfLongestSubstring(str);
        System.out.println(len);
    }
}
