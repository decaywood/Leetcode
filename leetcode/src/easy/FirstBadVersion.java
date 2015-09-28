package easy;

/**
 * @author: decaywood
 * @date: 2015/9/26 21:54
 *
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version,
 * all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 * which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */
public abstract class FirstBadVersion {

    /*
        The isBadVersion API is defined in the parent class VersionControl.
        boolean isBadVersion(int version);
    */
    abstract boolean isBadVersion(int version);

    public int firstBadVersion(int n) {
        if(isBadVersion(1)) return 1;
        int i = 0, j = n;
        while (i + 1 != j) {
            int mid = i + (j - i) / 2;
            boolean notBad = !isBadVersion(mid);
            i = notBad ? mid : i;
            j = notBad ? j : mid;
        }
        return isBadVersion(i) ? i : i + 1;
    }

}
