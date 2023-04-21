package MemoizationAndDP;

import java.util.ArrayList;

public class FibonacciSeries {
    static ArrayList<Integer> fiboArray = new ArrayList<>();
    public static int getFiboNum(int n) {
        if (n < 0) {
            throw new RuntimeException("Fibo starts at 0");
        }
        if (n< fiboArray.size()) {
            return fiboArray.get(n);
        }else {
            int val = getFiboNum(n-1) + getFiboNum(n-2);
            fiboArray.add(val);
            return val;
        }
    }

    public static void main(String[] args) {
        fiboArray.add(0);
        fiboArray.add(1);
        int x = 10;
        System.out.println(getFiboNum(3));
    }
}
