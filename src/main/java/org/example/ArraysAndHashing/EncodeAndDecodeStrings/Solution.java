package org.example.ArraysAndHashing.EncodeAndDecodeStrings;


/*
Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.

Please implement encode and decode

Example 1:

Input: ["neet","code","love","you"]

Output:["neet","code","love","you"]

Example 2:

Input: ["we","say",":","yes"]

Output: ["we","say",":","yes"]

Constraints:

    0 <= strs.length < 100
    0 <= strs[i].length < 200
    strs[i] contains only UTF-8 characters.

 */


import java.util.ArrayList;
import java.util.List;

class Solution {


    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs){
            sb.append(s.length()).append(":").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> retlist = new ArrayList<>();
        int i = 0;

        while (i < str.length()){
            int colonPos = str.indexOf(':', i);

            if (colonPos == -1) break;

            int length = Integer.parseInt(str.substring(i, colonPos));
            String slovo = str.substring(colonPos + 1, colonPos + 1 + length);
            retlist.add(slovo);

            i = colonPos + 1 + length;
        }
        return retlist;
    }
}
