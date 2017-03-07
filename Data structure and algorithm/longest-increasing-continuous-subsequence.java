/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/longest-increasing-continuous-subsequence
@Language: Java
@Datetime: 17-03-02 18:05
*/

public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
       
        if (A == null || A.length == 0) {
            return 0;
        }
        int increasing = 1;
        int sub = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] >= A[i-1]) {
                sub++;
                increasing = Math.max(increasing, sub);
            } else {
                sub = 1;
            }
        }
        sub = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i-1]) {
                sub++;
                increasing = Math.max(increasing, sub);
            } else {
                sub = 1;
            }
        }
        return increasing;
    }
}