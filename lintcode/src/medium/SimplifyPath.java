package medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: decaywood
 * @date: 2015/10/16 14:56
 *
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * Example
 * "/home/", => "/home"
 *
 * "/a/./b/../../c/", => "/c"
 *
 * Challenge
 * Did you consider the case where path = "/../"?
 *
 * In this case, you should return "/".
 *
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 *
 * In this case, you should ignore redundant slashes and return "/home/foo".
 *
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<>();
        for (String s : path.split("/")) {
            if(s.equals(".") || s.equals("")) continue;
            if(s.equals("..")) {
                if(deque.isEmpty()) return "/";
                deque.pollLast();
            }
            else deque.offerLast(s);
        }
        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()) builder.append('/').append(deque.pollFirst());
        return builder.length() == 0 ? "/" : builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPath("/home//foo/"));
    }
}
