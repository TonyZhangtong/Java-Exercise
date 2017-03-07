/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/strstr
@Language: Java
@Datetime: 17-01-15 18:48
*/

class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        if(source == null || target == null){
            return -1;
        }
        
        for(int i = 0; i < source.length() - target.length() + 1; i++){
            int j;
            for(j = 0; j < target.length(); j++){
                if(source.charAt(i + j) != target.charAt(j)){
                    break;
                }
            }
            if(j == target.length()){
                return i;
            }
        }
        return -1;
    }
}