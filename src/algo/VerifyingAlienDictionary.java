package algo;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAlienDictionary {
    Map<Character, Integer> charRanks = new HashMap<>();

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            charRanks.put(c, i);
        }

        for (int i = 0; i < words.length-1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];

            if (!areWordsOrdered(w1, w2)) {
                return false;
            }
        }
        return true;
    } 

    private boolean areWordsOrdered(String w1, String w2) {
        int minLength = Math.min(w1.length(), w2.length());

        for (int i = 0; i < minLength; i++) {
            char c1 = w1.charAt(i);
            char c2 = w2.charAt(i);

            int rank1 = charRanks.get(c1);
            int rank2 = charRanks.get(c2);

            if (rank1 < rank2) {
                return true;
            }
            if (rank1 > rank2) {
                return false;
            }
        }

        return w2.length() >= w1.length();
    }


    public static void main(String[] args) {
        VerifyingAlienDictionary vad = new VerifyingAlienDictionary();
        String[] words = {"word","world","row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        boolean b = vad.isAlienSorted(words, order);
        System.out.println(b);
    }
}