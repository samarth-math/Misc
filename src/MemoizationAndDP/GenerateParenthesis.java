package MemoizationAndDP;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        int count = 3;
        char str[] = new char[count*2];
        List<String> result = new ArrayList<String>();
        GenerateParenthesis gp = new GenerateParenthesis();
        gp.addParen(count, count, str, 0, result);
        System.out.println(result);
    }

    private void addParen(int leftRemaining, int rightRemaining, char[] str, int count, List<String> result) {
        if(leftRemaining < 0 || rightRemaining < leftRemaining) return; //invalid state
        if(leftRemaining == 0 && rightRemaining == 0) {
            String st = String.copyValueOf(str);
            result.add(st);
            return;
        }
        else {
            if(leftRemaining>0) {
                str[count] = '(';
                addParen(leftRemaining-1, rightRemaining, str, count+1, result);
            }
            if(rightRemaining>leftRemaining) {
                str[count] = ')';
                addParen(leftRemaining, rightRemaining-1, str, count+1, result);
            }
        }
    }
}
