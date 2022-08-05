package ArrayPractice;

import java.util.*;

public class Arrays4 {
    public static void main(String[] args) {
        int[] arr = {1,2,7,5,2,6};
        int target = 7;
        Arrays4 arrays4Instance = new Arrays4();
        System.out.println(arrays4Instance.minSubArrayLen(target,arr));
    }

    public void Arrays4() {}
    public int minSubArrayLen(int target, int[] nums) {
        int l=0;
        int r=0;
        int sum=0;
        int minWindow = Integer.MAX_VALUE;

        while(r<nums.length) {
            sum+=nums[r];
            while(sum>=target) {
                int currentWindow = r - l + 1;
                minWindow = Integer.min(minWindow, currentWindow);
                sum-=nums[l];
                l++;
            }
            r++;
        }
        return minWindow == Integer.MAX_VALUE?0:minWindow;
    }
}
