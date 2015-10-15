package medium;

import dataStructure.DirectedGraphNode;

import java.util.*;

/**
 * @author: decaywood
 * @date: 2015/10/15 15:08
 *
 * Find the number Weak Connected Component in the directed graph.
 * Each node in the graph contains a label and a list of its neighbors.
 * (a connected set of a directed graph is a subgraph in which any two vertices
 * are connected by direct edge path.)
 *
 * Example
 * Given graph:
 *
 * A----->B  C
 * \     |  |
 *  \    |  |
 *   \   |  |
 *    \  v  v
 *     ->D  E <- F
 * Return {A,B,D}, {C,E,F}. Since there are two connected component which are {A,B,D} and {C,E,F}
 *
 */
public class FindTheWeakConnectedComponentInTheDirectedGraph {


    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        Set<Set<Integer>> sets = new HashSet<>();
        for (DirectedGraphNode node : nodes) {
            Set<Set<Integer>> toMerge = new HashSet<>();
            Set<Integer> set = addToList(sets, toMerge, new HashSet<>(), node);
            for (Set<Integer> mergeSet : toMerge) {
                sets.remove(mergeSet);
                set.addAll(mergeSet);
            }
            sets.add(set);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (Set<Integer> set : sets) {
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }

    private Set<Integer> addToList(
            Set<Set<Integer>> sets,
            Set<Set<Integer>> toMerge,
            Set<Integer> tempList,
            DirectedGraphNode node) {
        if(tempList.contains(node.label)) return tempList;
        tempList.add(node.label);
        for (DirectedGraphNode neighbor : node.neighbors) addToList(sets, toMerge, tempList, neighbor);
        for (Set<Integer> set : sets) {
            if (set.contains(node.label)) {
                toMerge.add(set);
            }
        }
        return tempList;
    }

}
