package algo;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveDuplicates {
    public String removeDuplicates(String S) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : S.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else if (stack.peek() == c) {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();
        String str = "abbaca";
        String noDupes = rd.removeDuplicates(str);
        System.out.println(noDupes);
    }
}
