/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/permutations-ii
@Language: Java
@Datetime: 17-02-19 22:01
*/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Write your code here
        ArrayList<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nums == null) {
            return rst;
        }
        
        if (nums.length == 0) {
            rst.add(new ArrayList<Integer>());
            return rst;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] visited = new int[nums.length]; 
        for (int i = 0; i < nums.length; i++) {
            visited[i] = 0;
        }
        Arrays.sort(nums);
        helper(nums, rst, list, visited);
        return rst;
    } 
    
    private void helper(int[] nums, ArrayList<List<Integer>> rst, ArrayList<Integer> list, int[] visited) {
        
        if (list.size() == nums.length) {
            rst.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1 || (i != 0 && nums[i] == nums[i -1] && visited[i - 1] == 0)) {
                continue;                
            }
            
            list.add(nums[i]);
            visited[i] = 1; 
            helper(nums, rst, list, visited);
            list.remove(list.size() -1);
            visited[i] = 0;
        }
    }
}


