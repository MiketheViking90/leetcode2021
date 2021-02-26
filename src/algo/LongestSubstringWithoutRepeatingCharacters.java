package algo;

public class LongestSubstringWithoutRepeatingCharacters {
    int[] charCounts = new int[128];

    public int lengthOfLongestSubstring(String s) {
        int N = s.length();
        if (N <= 1) {
            return N;
        }

        int i = 0;
        int j = 0;
        int maxLength = 1;

        while (j < N) {
            char c = s.charAt(j++);
            charCounts[c]++;
            if (isAllUnique(charCounts)) {
                maxLength = Math.max(maxLength, j-i);
            } else {
                c = s.charAt(i++);
                charCounts[c]--;
            }
        }
        return maxLength;
    }

    private boolean isAllUnique(int[] charCounts) {
        for (int count : charCounts) {
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
        String str = "bbbbbb";
        int len = ls.lengthOfLongestSubstring(str);
        System.out.println(len);
    }
}
