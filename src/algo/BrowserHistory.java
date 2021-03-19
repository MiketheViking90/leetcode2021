package algo;

import java.util.LinkedList;
import java.util.List;

public class BrowserHistory {

    List<String> history;
    int idx;

    public BrowserHistory(String homepage) {
        history = new LinkedList<>();
        history.add(homepage);
        idx = 0;
    }

    public void visit(String url) {
        if (history.size() >= idx + 1) {
            history.subList(idx+1, history.size()).clear();
        }
        history.add(url);
        idx++;
    }

    public String back(int steps) {
        idx = idx - Math.min(steps, idx);
        return history.get(idx);
    }

    public String forward(int steps) {
        int N = history.size();
        idx = idx + Math.min(steps, N-1-idx);
        return history.get(idx);
    }

    public static void main(String[] args) {
        BrowserHistory bh = new BrowserHistory("a");

        bh.visit("b");
        bh.visit("c");
        bh.visit("d");
        bh.visit("f");
        bh.visit("g");

        String url;
        url = bh.back(1);
        System.out.println(url + " == f");
        url = bh.back(2);
        System.out.println(url + " == c");
        url = bh.back(3);
        System.out.println(url + " == a");
        url = bh.back(4);
        System.out.println(url + " == a");
        url = bh.back(5);
        System.out.println(url + " == a");


        url = bh.forward(1);
        System.out.println(url + " == b");
        url = bh.forward(2);
        System.out.println(url + " == d");

        bh.visit("m");
        System.out.println(bh.history);
    }
}
