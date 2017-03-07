/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/subsets-ii
@Language: Java
@Datetime: 17-01-17 05:35
*/

class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.length ==0) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        subsetsHelper(result, list, nums, 0);
        return result;
        // write your code here
    }
    
    private void subsetsHelper(ArrayList<ArrayList<Integer>> result, 
        ArrayList<Integer> list, int[] nums, int pos) {
            result.add(new ArrayList<Integer>(list));
            for(int i = pos; i < nums.length; i++) {
                if (i != 0 && nums[i] == nums[i - 1] && i > pos) {
                    //防止数组越界 [1],[1,1]   nums[i] 与 nums[i-1]相等 并且nums[i-1] 不在list里面
                    continue;
                }
                list.add(nums[i]);
                subsetsHelper(result, list, nums, i + 1);
                list.remove(list.size() - 1);
            }
        }
}
