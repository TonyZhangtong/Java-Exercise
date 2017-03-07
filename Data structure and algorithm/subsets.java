/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/subsets
@Language: Java
@Datetime: 17-02-08 19:46
*/

class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if(num == null || num.length == 0) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);
        helper(result, list, 0, num);
        
        return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list,
                        int start, int[] num) {
        result.add(new ArrayList<Integer>(list));
        for (int i = start ; i < num.length; i++) {
            list.add(num[i]);
            helper(result, list, i+1, num);
            list.remove(list.size() - 1);
        }
    }
}







/*

class Solution {
    
    public ArrayList<ArrayList<Integer>> subsets(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);
        
        subsetsHelper(result, list, num, 0);
        return result;
    }
    
    private void subsetsHelper(ArrayList<ArrayList<Integer>> result, 
        ArrayList<Integer> list, int[] num, int pos) {
        result.add(new ArrayList<Integer>(list));
        for (int i = pos; i < num.length; i++) {
            list.add(num[i]);
            subsetsHelper(result, list, num, i + 1);
            list.remove(list.size() - 1);
        }
    }
    // write your code here
   
}
*/