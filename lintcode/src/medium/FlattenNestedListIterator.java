package medium;

import dataStructure.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2016/4/24 13:27.
 * <p>
 * Given a nested list of integers, implement an iterator to flatten it.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Have you met this question in a real interview? Yes
 * Example
 * Given the list [[1,1],2,[1,1]], By calling next repeatedly until hasNext returns false,
 * the order of elements returned by next should be: [1,1,2,1,1].
 * <p>
 * Given the list [1,[4,[6]]], By calling next repeatedly until hasNext returns false,
 * the order of elements returned by next should be: [1,4,6].
 *
 */
public class FlattenNestedListIterator implements Iterator<Integer> {

    private List<Integer> list;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        buildList(linkedList, nestedList);
        this.list = new ArrayList<>(linkedList);
    }

    private static void buildList(List<Integer> list, List<NestedInteger> nestedIntegers) {
        for (NestedInteger nestedInteger : nestedIntegers) {
            if (nestedInteger.isInteger()) list.add(nestedInteger.getInteger());
            else buildList(list, nestedInteger.getList());
        }
    }
    int index;
    @Override
    public boolean hasNext() {
        return index < this.list.size();
    }

    @Override
    public Integer next() {
        return this.list.get(index);
    }

    @Override
    public void remove() {

    }
}
