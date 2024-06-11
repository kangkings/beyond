package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchMain {
    public static void main(String[] args) {
        List<Integer> list0 = Arrays.asList(1, 3, 4);
        List<Integer> list1 = Arrays.asList(0, 2);
        List<Integer> list2 = Arrays.asList(1, 3);
        List<Integer> list3 = Arrays.asList(0, 2, 4);
        List<Integer> list4 = Arrays.asList(0, 3);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        lists.add(list0);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);

        Dfs dfs = new Dfs(lists);
        dfs.search(lists, 0);

        Bfs bfs = new Bfs(lists);
        bfs.search(lists, 0);

    }
}
