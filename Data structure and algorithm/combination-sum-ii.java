/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/combination-sum-ii
@Language: Java
@Datetime: 17-02-18 21:42
*/

public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (num == null || num.length == 0) {
            return results;
        }
        Arrays.sort(num);
        List<Integer> combination = new ArrayList<>();
        helper(num, 0,combination, target, results);
        
        return results;
        
    }
    
    private void helper(int[] num,
                        int startIndex,
                        List<Integer> combination,
                        int target,
                        List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<Integer>(combination));
            return;
        }
        
        for (int i = startIndex; i < num.length; i++) {
            if (target < num[i]) {
                break;
            }
            if (i != startIndex && num[i] == num[i-1] ) {
                continue;
            }
            
            combination.add(num[i]);
            helper(num, i + 1, combination, target - num[i], results);
            combination.remove(combination.size() - 1);
        }
    }
}