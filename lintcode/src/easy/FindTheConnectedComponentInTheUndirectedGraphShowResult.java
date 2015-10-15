package easy;

import dataStructure.UndirectedGraphNode;

import java.util.*;

/**
 * @author: decaywood
 * @date: 2015/10/15 18:13
 */
public class FindTheConnectedComponentInTheUndirectedGraphShowResult {

    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (UndirectedGraphNode node : nodes) {
            List<Integer> list = addToList(new ArrayList<Integer>(), set, node);
            if(list.isEmpty()) continue;
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }

    private List<Integer> addToList(
            List<Integer> list,
            Set<Integer> set,
            UndirectedGraphNode node) {
        if(set.contains(node.label)) return list;
        set.add(node.label);
        list.add(node.label);
        for (UndirectedGraphNode neighbor : node.neighbors) addToList(list, set, neighbor);
        return list;
    }
}
