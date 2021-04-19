package algo;

import java.util.*;

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


    public boolean wordBreak1(String s, List<String> wordDict) {
        int N = s.length();
        boolean[] breaks = new boolean[N+1];
        breaks[0] = true;

        Set<String> words = new HashSet<>(wordDict);

        for (int j = 0; j < N; j++) {
            for (int i = 0; i <= j; i++) {
                String word = s.substring(i, j);

            }
        }
        return breaks[N];
    }


    public List<String> wordBreak2(String s, List<String> wordDict) {
        List<String> sentences = new ArrayList<>();
        List<String> sentence = new ArrayList<>();
        Map<String, List<String>> cache = new HashMap<>();
        search(sentences, sentence, s, wordDict);
        return sentences;
    }

    private void search(List<String> sentences, List<String> sentence, String s, List<String> wordDict) {
        if (s.isBlank()) {
            String sentenceStr = String.join(" ", sentence);
            sentences.add(sentenceStr);
            return;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                sentence.add(word);
                search(sentences, sentence, s.substring(word.length()), wordDict);
                sentence.remove(sentence.size()-1);
            }
        }
    }


    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        List<String> words = List.of("aaaa", "aaa");
        List<String> sents = wb.wordBreak2("aaaaaaa", words);
        System.out.println(sents);
    }
}
