/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/sort-integers
@Language: Java
@Datetime: 17-02-18 17:55
*/

public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers(int[] A) {
        // Write your code here
       if (A == null || A.length == 0) {
           return;
       }
       quickSort(A, 0, A.length - 1);
    }
       
    private void quickSort(int[]A, int start, int end) {
        if (start >= end) {
              return;
        }
           
        int left = start, right = end;
        int pivot = A[(start + end) / 2];
           
        while (left <= right) {
            while(left <= right && A[left] < pivot) {
                left++;
                
            }
            while(left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp =A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }  
        quickSort(A, start, right);
        quickSort(A, left, end);
       
    }
}