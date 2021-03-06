/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/word-break
@Language: Java
@Datetime: 17-03-05 22:11
*/

public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
     
    public int getMaxLength(Set<String> dict) {
       int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength; 
    } 
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here   
        if (s == null || s.length() == 0) {
            return true;
        } 
        
        int maxLength = getMaxLength(dict);
        boolean[] canSegment = new boolean[s.length() + 1];
        canSegment[0] = true;
        for (int i= 1; i<= s.length(); i++) {
            canSegment[i] = false;
            for (int lastWordLength = 1; lastWordLength <= maxLength && lastWordLength <= i; lastWordLength++) {
                if (!canSegment[i - lastWordLength]) {
                    continue;
                }
                String word = s.substring(i - lastWordLength, i);
                if (dict.contains(word)) {
                    canSegment[i] = true;
                    break;
                }
            }
        }
        
        return canSegment[s.length()];
    }
    
    
}