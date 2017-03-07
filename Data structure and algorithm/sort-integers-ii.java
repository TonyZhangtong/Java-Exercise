/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/sort-integers-ii
@Language: Java
@Datetime: 17-02-18 19:10
*/

public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return;
        }
        
        //only once 
        int[] temp = new int[A.length];
        mergeSort(A, 0 ,A.length - 1, temp);
    }
    
    private void mergeSort(int[] A, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }

        mergeSort(A, start, (start + end) / 2, temp);
        mergeSort(A, (start + end) / 2 + 1, end , temp);
        merge(A, start, end, temp);
    }
    
    private void merge(int[] A, int start, int end, int[] temp) {
        int middle = (start + end) / 2;
        int leftIndex = start;
        int rightIndex = middle + 1;
        int index = leftIndex;
        
        while(leftIndex <= middle && rightIndex <= end) {
            if (A[leftIndex] < A[rightIndex]) {
                temp[index++] = A[leftIndex++];
                
            } else {
                temp[index++] = A[rightIndex++];
                
            }
        }
        while (leftIndex <= middle) {
            temp[index++] = A[leftIndex++];
        }
        while (rightIndex <= end) {
            temp[index++] = A[rightIndex++]; 
        }
        
        for (int i = start; i<= end; i++) {
            A[i] = temp[i];
        }
        
    }
}