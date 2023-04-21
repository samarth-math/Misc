package StringPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class String3 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String3 s3 = new String3();
        s3.firstUniqChar(s);
        s.toCharArray();
    }

    public static Predicate<String> nameStartingWithPrefix(String prefix) {
        return x -> x.startsWith(prefix);
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> freqMap = new HashMap<Character, Integer>();
        int count;
        for(Character v: s.toCharArray()) {
            if(freqMap.containsKey(v)) {
                count = freqMap.get(v);
            } else {
                count = 0;
            }
            freqMap.put(v, ++count);
        }

        for (int i=0; i<s.length();i++) {
            if (freqMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }


}
