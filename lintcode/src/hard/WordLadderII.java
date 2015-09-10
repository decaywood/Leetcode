package hard;

import java.util.*;

/**
 * @author: decaywood
 * @date: 2015/9/8 18:36
 */
public class WordLadderII {

    private static class Entry {
        String str;
        List<String> path;
        public Entry(String str, List<String> path) {
            this.str = str;
            this.path = new ArrayList<>(path);
            this.path.add(str);
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordDict) {
        Deque<Entry> deque = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> res = new ArrayList<List<String>>();
        StringBuilder builder = new StringBuilder();
        deque.offer(new Entry(beginWord, new ArrayList<String>()));
        while (!deque.isEmpty()) {
            Entry entry = deque.poll();
            builder.append(entry.str);
            if(!res.isEmpty() && entry.path.size() == res.get(res.size() - 1).size()) break;
            if (map.containsKey(entry.str) && map.get(entry.str) != entry.path.size()) continue;
            map.put(entry.str, entry.path.size());
            for (int index = 0; index < entry.str.length(); index++) {
                builder.replace(0, builder.length(), entry.str);
                for (char charIndex = 'a'; charIndex <= 'z'; charIndex++) {
                    builder.setCharAt(index, charIndex);
                    String currentStr = builder.toString();
                    if (currentStr.equals(endWord)) {
                        entry.path.add(currentStr);
                        res.add(entry.path);
                        continue;
                    }
                    if (!wordDict.contains(currentStr)) continue;
                    deque.offer(new Entry(currentStr, entry.path));
                }
            }
            builder.delete(0, builder.length());
        }
        return res;
    }
    public static void main(String[] args) {
        String[] strings = new String[]{"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        Set<String> set = new HashSet<>();
        Collections.addAll(set, strings);
        System.out.println(new WordLadderII().findLadders("qa", "sq", set));
    }

}
