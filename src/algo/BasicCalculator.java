package algo;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculator {
    public int calculate(String s) {
        Deque<Character> ops = new LinkedList<>();
        Deque<Character> vals = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                vals.push(c);
            } else if (isOperation(c)) {
                ops.push(c);
            } else if (c == ')') {
                evaluateUntilParen(ops, vals);
            }
        }
        return evaluate(ops.pop(), vals.pop(), vals.pop());
    }

    private int evaluate(Character op, Character c1, Character c2) {
        int v1 = Character.getNumericValue(c1);
        int v2 = Character.getNumericValue(c2);

        if (op == '+') {
            return v1 + v2;
        } else {
            return v2 - v1;
        }
    }

    private void evaluateUntilParen(Deque<Character> ops, Deque<Character> vals) {
        while (!ops.isEmpty() && ops.peek() != '(') {
            Character op = ops.pop();
            int val = evaluate(op, vals.pop(), vals.pop());
            char valChar = (char) (val + '0');
            vals.push(valChar);
        }

        if (!ops.isEmpty() && ops.peek() == '(') {
            ops.pop();
        }
    }

    private boolean isOperation(char c) {
        return c == '-' || c == '+' || c == '(';
    }

    public static void main(String[] args) {
        BasicCalculator bc = new BasicCalculator();
        String str = "(1+(4+5+2)-3)+(6+8)";
        int val = bc.calculate(str);
        System.out.println(val);
    }
}
