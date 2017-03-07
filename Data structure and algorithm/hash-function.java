/*
@Copyright:LintCode
@Author:   tong12
@Problem:  http://www.lintcode.com/problem/hash-function
@Language: Java
@Datetime: 17-02-15 19:33
*/

class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        long hashVal = 0;
        
        for (int i = 0; i < key.length; i++) {
            hashVal = (hashVal * 33 + (int)key[i]) % HASH_SIZE ;
        }
        
        
        if (hashVal < 0) {
            hashVal += HASH_SIZE;
        }
        
        return (int)hashVal;
        // write your code here
    }
};