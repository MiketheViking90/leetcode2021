package algo;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> combos = new ArrayList<>();
        dfs(combos, "(", n-1, n);
        return combos;
    }

    private void dfs(List<String> combos, String s, int l, int r) {
        if (l == 0 && r == 0) {
            combos.add(s);
            return;
        }

        if (l > 0) {
            dfs(combos, s + "(", l - 1, r);
        }
        if (l < r) {
            dfs(combos, s + ")", l, r - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        List<String> combos = gp.generateParenthesis(3);
        System.out.println(combos);
    }
}
