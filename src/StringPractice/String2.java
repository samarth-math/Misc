package StringPractice;

import java.util.HashMap;
import java.util.Map;

public class String2 {
    public static void main(String[] args) {
        String s = "ab";
        String p = "ba";
        String2 s1 = new String2();
        System.out.println(s1.isAnagram(s, p));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (charCount.containsKey(s.charAt(i))) {
                Integer count = charCount.get(s.charAt(i));
                charCount.put(s.charAt(i), ++count);
            } else {
                charCount.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (charCount.containsKey(t.charAt(i))) {
                if (charCount.get(t.charAt(i)) == 0){
                    return false;
                }
                Integer count = charCount.get(t.charAt(i));
                charCount.put(t.charAt(i), --count);
            } else {
                return false;
            }
        }
        return true;
    }
}
