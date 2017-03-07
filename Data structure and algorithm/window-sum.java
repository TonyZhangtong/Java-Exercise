/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/window-sum
@Language: Java
@Datetime: 17-03-02 18:39
*/

public class Solution {
    /**
     * @param nums a list of integers.
     * @return the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
       int[] window = new int [nums.length - k + 1];
        if (nums == null) {
            return null;
        }
        if (nums.length == 0) {
            return new int[0];
        }
        
        for (int i = 0 ; i < nums.length - k + 1; i ++) {
            for (int j = 0; j < k; j++) {
                window[i] += nums[i + j];
            }
        }
        return window;
    }
}

