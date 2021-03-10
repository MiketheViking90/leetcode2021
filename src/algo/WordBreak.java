package algo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int N = s.length();
        boolean[] mem = new boolean[N+1];
        mem[0] = true;

        Set<String> words = new HashSet<>(wordDict);

        int i = 0;
        int j = 1;
        while (j < N+1) {
            String substring = s.substring(i, j);
            if (mem[0] && words.contains(substring)) {
                mem[j] = true;
                i = j;
            } else {
                j++;
            }
        }
        return mem[N];
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        List<String> words = List.of("aaaa", "aaa");
        boolean b = wb.wordBreak("aaaaaaa", words);
        System.out.println(b);
    }
}
