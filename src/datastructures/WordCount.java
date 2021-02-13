package datastructures;


public class WordCount implements Comparable<WordCount> {
    String word;
    int count;

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    @Override
    public int compareTo(WordCount o) {
        if (this.count == o.count) {
            return this.word.compareTo(o.word);
        }

        return Integer.compare(o.count, this.count);
    }

    public static void main(String[] args) {
        WordCount wc1 = new WordCount("xyz", 11);
        WordCount wc2 = new WordCount("def", 5);

        System.out.println(wc1.compareTo(wc2));
    }
}