/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/wood-cut
@Language: Java
@Datetime: 17-01-20 21:38
*/

public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0) {
            return 0;
        }
        Arrays.sort(L);
        int start = 0; int end = L[L.length - 1];
        int max = 0;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (countPieces(L,mid) >= k){
                start = mid;
            }else {
                end = mid;
            }
        }
        if (countPieces(L,end) >= k){
                return end;
        }
        return start;
        // write your code here
    }
    
    private int countPieces(int[] L, int pieceLength){
        int sum = 0;
        for (int i = 0; i < L.length; i++) {
            sum += L[i] / pieceLength; 
        }
        return sum;
    }
}