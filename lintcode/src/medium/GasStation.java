package medium;

/**
 * @author: decaywood
 * @date: 2015/9/1 9:54
 *
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 *
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 *
 * Example
 * Given 4 gas stations with gas[i]=[1,1,3,1], and the cost[i]=[2,2,1,1]. The starting gas station's index is 2.
 *
 * Note
 * The solution is guaranteed to be unique.
 *
 * Challenge
 * O(n) time and O(1) extra space
 *
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            gas[i] = gas[i] - cost[i];
            sum += gas[i];
        }
        if(sum < 0) return -1;
        int diffSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i];
            diffSum += diff;
            if (diffSum < diff) {
                diffSum = diff;
                index = i;
            }
        }
        return index;
    }

}
