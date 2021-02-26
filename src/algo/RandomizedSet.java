package algo;

import java.util.*;

public class RandomizedSet {

    List<Integer> list;
    Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            int n = list.size();
            list.add(val);
            map.put(val, n);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int N = list.size();

            int lastElt = list.get(N-1);
            int idx = map.get(val);

            map.remove(val, idx);
            map.put(lastElt, idx);

            list.remove(N-1);
            list.remove(idx);
            list.add(idx, lastElt);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int idx = new Random().nextInt(list.size());
        return list.get(idx);
    }

    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        rs.insert(0);
        rs.insert(1);
        rs.remove(0);
        rs.insert(2);
        rs.remove(1);

        System.out.println(rs.getRandom());
        System.out.println(rs.getRandom());
        System.out.println(rs.getRandom());
    }
}
