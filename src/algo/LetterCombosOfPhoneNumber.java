package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombosOfPhoneNumber {

    private Map<Character, List<Character>> digitToChars = Map.of(
            '2', List.of('a', 'b', 'c'),
            '3', List.of('d', 'e', 'f'),
            '4', List.of('g', 'h', 'i'),
            '5', List.of('j', 'k', 'l'),
            '6', List.of('m', 'n', 'o'),
            '7', List.of('p', 'q', 'r', 's'),
            '8', List.of('t', 'u', 'v'),
            '9', List.of('w', 'x', 'y', 'z')
    );


    public List<String> letterCombinations(String digits) {
        List<String> combos = new ArrayList<>();

        if (digits.length() == 0) {
            return combos;
        }

        dfs(combos, 0, digits, "");
        return combos;
    }

    private void dfs(List<String> combos, int i, String digits, String s) {
        if (i == digits.length()) {
            combos.add(s);
            return;
        }

        List<Character> chars = digitToChars.get(digits.charAt(i));
        for (char c : chars) {
            String s1 = s + c;
            dfs(combos, i+1, digits, s1);
        }
    }

    public List<String> letterCombinations1(String digits) {
        List<String> combos = new ArrayList<>();
        dfs1("", 0, combos, digits);
        return combos;
    }

    private void dfs1(String combo, int idx, List<String> combos, String digits) {
        if (idx == digits.length()) {
            combos.add(combo);
            return;
        }

        char digit = digits.charAt(idx);
        List<Character> chars = digitToChars.get(digit);
        for (Character c : chars) {
            String next = combo + c;
            dfs1(next, idx+1, combos, digits);
        }
    }

    public static void main(String[] args) {
        LetterCombosOfPhoneNumber lcpn = new LetterCombosOfPhoneNumber();
        List<String> words = lcpn.letterCombinations1("7346279");
        System.out.println(words);
    }
}
