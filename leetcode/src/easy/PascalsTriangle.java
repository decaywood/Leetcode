package easy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 2014年11月15日
 * @author decaywood
 *
 *  Given numRows, generate the first numRows of Pascal's triangle.
 *
 *   For example, given numRows = 5,
 *   Return
 *   
 *   [
 *        [1],
 *       [1,1],
 *      [1,2,1],
 *     [1,3,3,1],
 *    [1,4,6,4,1]
 *   ]
 */
public class PascalsTriangle {

    List<List<Integer>> target = new ArrayList<List<Integer>>();
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0)
            return target;
        List<Integer> childList = new ArrayList<Integer>();
        childList.add(1);
        target.add(childList);
        if(numRows == 1)
            return target;
        constructList(--numRows, childList);
        return target;
    }
    
    private void constructList(int numRows, List<Integer> list){
        
        if(numRows == 0)
            return;
        
        int value = 1;
        List<Integer> currentList = new ArrayList<Integer>();
        currentList.add(1);
        for(int i = 1; i < list.size(); i++){
            value += list.get(i);
            currentList.add(value);
            value = list.get(i);
        }
        currentList.add(1);
        target.add(currentList);
        constructList(--numRows, currentList);
    }
    
    public static void main(String[] args) {
        new PascalsTriangle().generate(6);
    }
}
