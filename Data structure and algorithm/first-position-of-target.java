/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/first-position-of-target
@Language: Java
@Datetime: 17-01-20 20:27
*/

class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length -1;
        while(start + 1 < end) {
            int m = start + (end - start) / 2;
            if (nums[m] < target) {
                start = m;
            }else {
                end = m;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
        //write your code here
    }
}