package easy;

import java.util.ArrayList;

/**
 * @author: decaywood
 * @date: 2015/10/15 10:39
 *
 * Given number n. Print number from 1 to n. But:
 *
 * when number is divided by 3, print "fizz".
 * when number is divided by 5, print "buzz".
 * when number is divided by both 3 and 5, print "fizz buzz".
 *
 * Example
 * If n = 15, you should return:
 *
 * ["1", "2", "fizz", "4", "buzz", "fizz", "7", "8", "fizz", "buzz", "11", "fizz", "13", "14", "fizz buzz"]
 *
 */
public class FizzBuzz {

    public ArrayList<String> fizzBuzz(int n) {
        ArrayList<String> results = new ArrayList<String>();
        for (int i = 1; i < n; i++){
            boolean fizz = i % 3 == 0;
            boolean buzz = i % 5 == 0;
            results.add(fizz && buzz ? "fizz buzz" : fizz ? "fizz" : buzz ? "buzz" : String.valueOf(i));
        }

        return results;
    }
}
