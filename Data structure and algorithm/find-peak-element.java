/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/find-peak-element
@Language: Java
@Datetime: 17-01-21 19:58
*/

class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 1, end = A.length - 2;
        while (start + 1 < end) {
            int mid  = start + (end - start) / 2;
            if (A[mid] > A[mid-1]) {
                start = mid;
            }else if (A[mid] > A[mid + 1]) {
                end = mid;
            }else {
                end = mid;
            }
        }
        
        if (A[start] > A[end]) {
            return start;
        }else {
            return end;
        }
        // write your code here
    }
}
