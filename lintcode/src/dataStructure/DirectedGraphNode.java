package dataStructure;

/**
 * @author: decaywood
 * @date: 2015/10/15 15:09
 */

import java.util.ArrayList;

public class DirectedGraphNode {
    public int label;
    public ArrayList<DirectedGraphNode> neighbors;

    public DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
}
