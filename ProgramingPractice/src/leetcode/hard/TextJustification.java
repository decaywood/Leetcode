package leetcode.hard;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TextJustification {

    /**
     * Given an array of words and a length L, format the text such that each
     * line has exactly L characters and is fully (left and right) justified.
     * 
     * You should pack your words in a greedy approach; that is, pack as many
     * words as you can in each line. Pad extra spaces ' ' when necessary so
     * that each line has exactly L characters.
     * 
     * Extra spaces between words should be distributed as evenly as possible.
     * If the number of spaces on a line do not divide evenly between words, the
     * empty slots on the left will be assigned more spaces than the slots on
     * the right.
     * 
     * For the last line of text, it should be left justified and no extra space
     * is inserted between words.
     * 
     * For example, words: ["This", "is", "an", "example", "of", "text",
     * "justification."]
     * 
     * L: 16.
     * 
     * Return the formatted lines as: 
     * [ "This    is    an", 
     *   "example  of text",
     *   "justification.  " ]
     */
    
    private String generateSpace(int num){
       StringBuilder sb = new StringBuilder();
       while(num > 0){
           sb.append(" ");
           num--;
       }
       return sb.toString();
    }
    /**
     * 将空格平均地插在单词间隙之间，并返回
     * 
     */
    public String justifySubString(int L, int length, int wordNum, Queue<String> queue, boolean lastRow){
        StringBuilder sb = new StringBuilder();
        if(!lastRow){
            if(wordNum == 1){
                int spacePerWord = (L - length); 
                sb.append(queue.poll());
                sb.append(generateSpace(spacePerWord));
            }
            else{
                int spacePerWord = (L - length) / (wordNum - 1);//单词间隙
                int extraSpace = (L - length) % (wordNum - 1);
                while (wordNum - 1 > 0) {
                    sb.append(queue.poll());
                    int offset = extraSpace-- > 0 ? 1 : 0;
                    sb.append(generateSpace(spacePerWord+offset));
                    wordNum--;
                }
                sb.append(queue.poll());
            }
        }
        else {
            int spaceNum = L;
            while (!queue.isEmpty()) {
                String word = queue.poll();
                spaceNum -= (word.length());
                sb.append(word);
                if(spaceNum > 0){
                    sb.append(" ");
                    spaceNum--;
                }
                else {
                    spaceNum = 0;
                }
            }
            sb.append(generateSpace(spaceNum));
        }
      
        return sb.toString();
    }
    
    public List<String> fullJustify(String[] words, int L) {
        List<String> list = new ArrayList<String>();
        
        Deque<String> queue = new LinkedList<String>();
        
        int length = 0;
        int remain = 0;
        int wordNum = 0;
        
        for(String word : words){
            
            String currentString = word;
            queue.offer(word);    //此操作用来保证词组顺序，例如有可能因为有单词大小刚好为L，直接continue了
            word = queue.peek();
            
            if(word.length() >= L){  //这里可能引起后到的词先放进list 所以 有上面两步保证顺序
                list.add(queue.poll());
                continue;
            }
            
            wordNum++;
            length += currentString.length();
            remain = L-length;
            
            if(wordNum - 1 > remain){
                length -= currentString.length(); //减去的是当前长度而不应该是队头单词的长度
                wordNum--;
                String childString = justifySubString(L, length, wordNum, queue, false);
                list.add(childString);
                length = queue.peek().length();
                wordNum = 1;
            } 
        }
        
        if(!queue.isEmpty()){
           String string = justifySubString(L, 0, 0, queue, true);
           list.add(string);
        }
        return list;
    }
    
    public static void main(String[] args) {
//        new TextJustification().fullJustify(new String[]{"a","b","c","d","e"}, 1);
        new TextJustification().fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 14);
//        new TextJustification().fullJustify(new String[]{"What","must","be","shall","be."}, 12);
        new TextJustification().fullJustify(new String[]{"Listen","to","many,","speak","to","a","few."}, 6);
    }
    
    
    
}
