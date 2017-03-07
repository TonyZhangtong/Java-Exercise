/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/sqrtx
@Language: Java
@Datetime: 17-01-20 19:52
*/

class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        if(x == 0) {
            return 0;
        }
        long left = 1; long right = x;
        while (left < right - 1){
            long m = left + (right - left) / 2;
            if (m * m > x) {
                right = m;
            }else {
                left = m;
            } 
        }
        if(right * right <= x ) {
            return (int) right;
        }
        return (int) left;
        // write your code here
    }
}