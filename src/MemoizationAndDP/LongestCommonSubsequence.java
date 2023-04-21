package MemoizationAndDP;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String text1 = "some";
        String text2 = "omc";
        LongestCommonSubsequence lcss = new LongestCommonSubsequence();
        System.out.println(lcss.lcs(text1, text2));
    }

    public int lcs(String s1, String s2) {
        if(s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        int case1;
        //choose current character
        if(s2.indexOf(s1.charAt(0))== -1) {
            case1 = Integer.MIN_VALUE;
        } else {
            case1 = 1 +  lcs(s1.substring(1), s2.substring(s2.indexOf(s1.charAt(0))));
        }

        //reject current character
        int case2 = lcs(s1.substring(1), s2);

        return Math.max(case1, case2);
    }
}


