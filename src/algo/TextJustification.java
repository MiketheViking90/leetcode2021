package algo;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int N = words.length;
        List<String> lines = new ArrayList<>();

        List<String> curLine = new ArrayList<>();
        int i = 0;
        while (i < N) {
            String curWord = words[i];
            int lineLen = getLength(curLine);
            if (curWord.length() + lineLen + curLine.size() > maxWidth) {
                String line = justify(curLine, maxWidth);
                lines.add(line);
                curLine = new ArrayList<>();
            }
            curLine.add(curWord);
            i++;
        }
        String line = justify(curLine, maxWidth);
        lines.add(line);
        return lines;
    }

    private int getLength(List<String> curLine) {
        int len = 0;
        for (String word : curLine) {
            len += word.length();
        }
        return len;
    }

    private String justify(List<String> curLine, int maxWidth) {
        int spaces = (maxWidth - getLength(curLine)) / curLine.size();

        StringBuilder sb = new StringBuilder();
        for (String word : curLine) {
            sb.append(word);
            sb.append(" ".repeat(spaces));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        int w = 16;

        TextJustification tj = new TextJustification();
        List<String> lines = tj.fullJustify(words, w);
        System.out.println(lines);
    }
}
