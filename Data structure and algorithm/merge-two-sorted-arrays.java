/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/merge-two-sorted-arrays
@Language: Java
@Datetime: 17-02-08 19:33
*/

class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
    
        // Write your code here
        int []merge = new int [A.length + B.length];
        int i = 0, j = 0, index = 0;
        while(i < A.length && j < B.length) {
            if(A[i] >= B[j]) {
                merge[index++] = B[j++];
            }else {
                merge[index++] = A[i++];
            }
            
        }
        
        while(i < A.length) {
           merge[index++] = A[i++];
        }
        
        while(j < B.length) {
            merge[index++] = B[j++];
        }
        
        return merge;
    }                                       
}