package algo;

import java.util.*;

import static java.util.Comparator.comparing;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordToCount = new HashMap<>();
        for (String word : words) {
            int count = wordToCount.getOrDefault(word, 0);
            wordToCount.put(word, count+1);
        }

        PriorityQueue<WordCount> pq = new PriorityQueue<>();
        for (Map.Entry<String, Integer> entry : wordToCount.entrySet()) {
            WordCount wc = new WordCount(entry.getKey(), entry.getValue());
            if (pq.size() < k) {
                pq.offer(wc);
            } else {
                if (pq.peek().compareTo(wc) < 0) {
                    pq.poll();
                    pq.offer(wc);
                }
            }
        }

        List<String> topWords = new ArrayList<>();
        while(!pq.isEmpty()) {
            String word = pq.poll().word;
            topWords.add(0, word);
        }
        return topWords;
    }

    public class WordCount implements Comparable<WordCount> {
        String word;
        int count;

        public WordCount(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(WordCount o) {
            return comparing((WordCount wc) -> wc.count)
                    .thenComparing(comparing((WordCount wc) -> wc.word).reversed())
                    .compare(this, o);
        }
    }

    public static void main(String[] args) {
        TopKFrequentWords tkfe = new TopKFrequentWords();
//        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is", "red", "joe", "day"};
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int n = 2;
        List<String> topWords = tkfe.topKFrequent(words, n);
        System.out.println(topWords);
    }
}
