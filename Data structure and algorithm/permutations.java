/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/permutations
@Language: Java
@Datetime: 17-02-19 21:21
*/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        ArrayList<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nums == null) {
            return rst;
        }
        
        if (nums.length == 0) {
            rst.add(new ArrayList<Integer>());
            return rst;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        helper(nums, rst, list);
        return rst;
    }
    
    private void helper(int[] nums, ArrayList<List<Integer>> rst, List<Integer> list) {
        if (list.size() == nums.length) {
            rst.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = 0; i< nums.length; i++) {
            if (list.contains(nums[i]))  {
                continue;
            }
            
            list.add(nums[i]);
            helper(nums, rst, list);
            list.remove(list.size() - 1); 
        }
    }
}


