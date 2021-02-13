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

    public static void main(String[] args) {
        LetterCombosOfPhoneNumber lcpn = new LetterCombosOfPhoneNumber();
        List<String> words = lcpn.letterCombinations("7346279");
        System.out.println(words);
    }
}
