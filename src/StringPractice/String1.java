package StringPractice;

import java.util.*;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/
public class String1 {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        String1 s1 = new String1();
        s1.startingPositions(s, p);
    }

    public void Arrays1() {}
    public List<Integer> startingPositions(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        int[] char_count = new int[26];
        int count = p.length();
        for (char c: p.toCharArray()) {
            char_count[c - 'a']++;
        }
        int left = 0;
        int right = 0;
        while(right < s.length()) {
            if(char_count[s.charAt(right++) - 'a']-- >=1) count--;
            if (count ==0) list.add(left);
            if(right - left==p.length() && char_count[s.charAt(left++) - 'a']++ >= 0) count ++;
        }
        return list;
    }
}
