package medium;

import dataStructure.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2016/4/23 16:01.
 *
 * Given a nested list of integers, implement an iterator to flatten it.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Example 1:
 * Given the list [[1,1],2,[1,1]],
 * <p>
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
 * <p>
 * Example 2:
 * Given the list [1,[4,[6]]],
 * <p>
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 */
public class FlattenNestedListIterator implements Iterator<Integer> {

    private List<Integer> nestedList = new ArrayList<>();
    private int index;

    private static void buildList(List<Integer> list, List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) list.add(nestedInteger.getInteger());
            else buildList(list, nestedInteger.getList());
        }
    }

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        buildList(this.nestedList, nestedList);
    }

    @Override
    public Integer next() {
        return nestedList.get(index++);
    }

    @Override
    public boolean hasNext() {
        return nestedList.size() != index;
    }

}
