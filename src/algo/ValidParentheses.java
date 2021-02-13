package algo;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> opens = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (isOpen(c)) {
                opens.push(c);
            } else {
                if (opens.isEmpty()) {
                    return false;
                }
                char top = opens.pop();
                if (!isMatch(top, c)) {
                    return false;
                }
            }
        }
        return opens.isEmpty();
    }

    private boolean isMatch(char open, char close) {
        if (open == '(') {
            return close == ')';
        } else if (open == '{') {
            return close == '}';
        } else {
            return close == ']';
        }
    }

    private boolean isOpen(char c) {
        return c == '(' || c == '{' || c == '[';
    }
}
