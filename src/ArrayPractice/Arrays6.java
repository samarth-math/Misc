package ArrayPractice;

import java.util.*;

public class Arrays6 {

    public static void main(String args[]) {
        int [] input =
                new int[]{34809,98653,82440,24539,36382,43589,20538,96848,6587,30791,62448,47843,46684};
        Arrays6 instance = new Arrays6();
        instance.oddEvenJumps(input);
        instance.oddEvenJumpsSoln(input);
    }

    public int oddEvenJumpsSoln(int[] arr) {
        int res = 1; int n = arr.length;
        boolean[] higher = new boolean[arr.length];
        boolean[] lower = new boolean[arr.length];
        higher[n-1] = lower[n-1] = true;
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
        tm.put(arr[n-1], n-1);
        for(int i= arr.length-2; i>=0;i--){
            Map.Entry<Integer,Integer> hi = tm.ceilingEntry(arr[i]);
            Map.Entry<Integer,Integer> lo = tm.floorEntry(arr[i]);
            if(hi!=null) higher[i]=lower[hi.getValue()];
            if(lo!=null) lower[i]=higher[lo.getValue()];
            if(higher[i]) res++;
            tm.put( arr[i],  i);
        }
        return res;
    }
    public int oddEvenJumps(int[] arr) {
        int counts = 0;
        int[] evenJumps = new int[arr.length];
        Arrays.fill(evenJumps, -1);
        int[] oddJumps = new int[arr.length];
        Arrays.fill(oddJumps, -1);
        for (int i = arr.length-1; i >=0; i--) {
            counts += countJumps(arr, i, evenJumps, oddJumps);
            System.out.println(i + ":" + counts);
        }
        return counts;
    }

    private int countJumps(int[] arr, int start, int[] evenJumps, int[] oddJumps) {
        int i = start;
        int jumpNum = 1;
        while (i < arr.length - 1) {
            if (jumpNum % 2 == 1) {
                // odd jump
                if(oddJumps[i]!=-1){
                    i = oddJumps[i];
                    jumpNum++;
                    continue;
                }
                int x = i+1;
                int minMoreThanCurrent = Integer.MAX_VALUE;
                int mMTCIndex = -1;
                // find least more than current
                while (x < arr.length) {
                    if (arr[i] <= arr[x] && arr[x] < minMoreThanCurrent) {
                        minMoreThanCurrent = arr[x];
                        mMTCIndex = x;
                    }
                    x++;
                }
                if (mMTCIndex == -1) {
                    // not found
                    break;
                } else {
                    oddJumps[i] = mMTCIndex;
                    i = mMTCIndex;
                    jumpNum++;
                }
            }
            else {
                if(evenJumps[i]!=-1){
                    i = evenJumps[i];
                    jumpNum++;
                    continue;
                }
                int x = i+1;
                int maxLessThanCurrent = Integer.MIN_VALUE;
                int mLTC = -1;
                // find least more than current
                while (x < arr.length) {
                    if (arr[i] >= arr[x] && arr[x] > maxLessThanCurrent) {
                        maxLessThanCurrent = arr[x];
                        mLTC = x;
                    }
                    x++;
                }
                if (mLTC == -1) {
                    // not found
                    break;
                } else {
                    evenJumps[i] = mLTC;
                    i = mLTC;
                    jumpNum++;
                }
            }
        }
        if (i == arr.length - 1) {
            return 1;
        } else {
            return 0;
        }
    }

}
