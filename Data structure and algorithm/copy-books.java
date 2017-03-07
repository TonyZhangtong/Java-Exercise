/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/copy-books
@Language: Java
@Datetime: 17-01-21 22:35
*/

public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        if (pages == null || pages.length == 0) {
            return 0;
        }
        int max = pages[0];
        int total = 0;
        for (int i = 0; i < pages.length; i++) {
            total += pages[i];
            if (pages[i] > max) {
                max = pages[i];
            }
        }
        
        int start = max;
        int end = total;
        
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (countCopiers(pages, mid) > k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (countCopiers(pages, start) <= k) {
            return start;
        }else {
            return end;
        }
        
        // write your code here
    }
    
    private int countCopiers(int[] pages, int limit) {
        if (pages.length == 0) {
            return 0;
        }
        int copiers = 1;
        int sum = pages[0];
        for (int i = 1; i < pages.length; i++) {
            if (sum + pages[i] > limit) {
                copiers++;
                sum = 0;
            }
                sum += pages[i];
        }
        return copiers;
    }
}