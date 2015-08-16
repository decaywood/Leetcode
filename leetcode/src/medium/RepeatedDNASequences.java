package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/8/16 12:52
 *
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify
 * repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings)
 * that occur more than once in a DNA molecule.
 *
 * For example,
 *
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 *
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 *
 * 找出长度为10的重复DNA序列
 *
 */
public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        Map<Long, Integer> mapper = new HashMap<>();
        List<String> result = new ArrayList<>();
        long mask = 0xfffff;
        int tempKey = 0;
        char[] chars = s.toCharArray();
        for (int index = 0; index < chars.length; index++) {
            char c = chars[index];
            int component = c == 'A' ? 0 : c == 'C' ? 1 : c == 'T' ? 2 : c == 'G' ? 3 : -1;
            tempKey += component;
            if(index + 1 >= 10) {
                long key = tempKey & mask;
                int times = mapper.getOrDefault(key, 0) + 1;
                if(times == 2) result.add(parseString(key));
                mapper.put(key, times);
            }
            tempKey <<= 2;
        }
        return result;
    }

    public String parseString(long key) {
        StringBuilder builder = new StringBuilder();
        int mask = 0xc0000;
        for (int i = 0; i < 10; i++) {
            long index = (mask & key) >> 18;
            builder.append(index == 0 ? 'A' : index == 1 ? 'C' : index == 2 ? 'T' : index == 3 ? 'G' : ' ');
            key <<= 2;
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        List<String> strings = new RepeatedDNASequences().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        for (String s : strings) {
            System.out.println(s);
        }
    }

}
