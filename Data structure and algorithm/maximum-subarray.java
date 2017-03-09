/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/maximum-subarray
@Language: Java
@Datetime: 17-03-02 18:30
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your cod
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
       int max = nums[0], sum = 0, minSum = 0;
       for (int i = 0; i < nums.length; i++) {
           sum += nums[i];
           max = Math.max(max, sum - minSum);
           minSum = Math.min(minSum, sum);
       }
       return max;
    }
}