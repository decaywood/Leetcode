package medium;

/**
 * @author: decaywood
 * @date: 2016/04/23 22:53
 * <p>
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.
 * <p>
 * _9_
 * /   \
 * 3     2
 * / \   / \
 * 4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
 * <p>
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.
 * <p>
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 * <p>
 * You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
 * <p>
 * Example 1:
 * "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Return true
 * <p>
 * Example 2:
 * "1,#"
 * Return false
 * <p>
 * Example 3:
 * "9,#,#,1"
 * Return false
 *
 */
public class VerifyPreorderSerializationOfABinaryTree {

    public boolean isValidSerialization(String preorder) { //出度
        String[] strs = preorder.split(",");
        int degree = -1;         // root has no indegree, for compensate init with -1
        for (String str: strs) {
            degree++;             // all nodes have 1 indegree (root compensated)
            if (degree > 0) {     // total degree should never exceeds 0
                return false;
            }
            if (!str.equals("#")) {// only non-leaf node has 2 outdegree
                degree -= 2;
            }
        }
        return degree == 0;
    }

//    public static boolean isValidSerialization(String preorder) {
//        Deque<String> stack = new LinkedList<>();
//        String none = "#";
//        int count = 0;
//        for (String c : preorder.split(",")) {
//            if (none.equals(c)) count++;
//            else count = 0;
//            if (count == 4) return false;
//            if (none.equals(c) && none.equals(stack.peek())) {
//                if (stack.size() < 2) return false;
//                stack.pop();
//                if (none.equals(stack.peek())) return false;
//                stack.pop();
//                stack.push(none);
//            } else stack.push(c);
//            checkStack(stack);
//        }
//        checkStack(stack);
//        return stack.size() == 1 && stack.peek().equals(none);
//    }
//
//    private static void checkStack(Deque<String> stack) {
//        String none = "#";
//        if (stack.size() > 2) {
//            String c1 = stack.pop();
//            String c2 = stack.pop();
//            if (c1.equals(c2) && c1.equals(none)) {
//                stack.pop();
//                stack.push(none);
//                checkStack(stack);
//            } else {
//                stack.push(c2);
//                stack.push(c1);
//            }
//        }
//    }


}
