/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/search-in-a-big-sorted-array
@Language: Java
@Datetime: 17-01-20 20:56
*/

/**
 * Definition of ArrayReader:
 * 
 * class ArrayReader {
 *      // get the number at index, return -1 if index is less than zero.
 *      public int get(int index);
 * }
 */
public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        if (reader == null) {
            return -1;
        }
        int start = 0;
        int k = 1;
        while(reader.get(k) < target) {
            k = k * 2;
        }
         int end = k;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (reader.get(mid) == target){
                end = mid;
            }else if (reader.get(mid) < target) {
                start = mid;
                
            }else {
                end =mid;
            }
        }
        if (reader.get(start) == target) {
            return start;
        }
        if (reader.get(end) == target) {
            return end;
        }
        return -1;
        // write your code here
    }
}