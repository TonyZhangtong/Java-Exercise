/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/total-occurrence-of-target
@Language: Java
@Datetime: 17-02-02 02:02
*/

public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        if(A == null || A.length ==0) {
            return 0;
        }
        int start = 0, end = A.length - 1;
        
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid] < target) {
                start = mid;
            }else if (A[mid] > target) {
                end = mid;
            }else {
                start = mid;
            }
            
        }
        
        while (A[start] == target && start != 0) {
            start --;
        }
        
        if(A[start] == target && A[end] == target) {
            return end -start + 1;
        }
        
        if(A[end] == target) {
            return end -start ;
        }
        if(end > 1 && A[end - 1] == target) {
            return end -start - 1;
        }
        
        return 0;
    }
}