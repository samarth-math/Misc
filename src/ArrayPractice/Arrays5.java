package ArrayPractice;

import java.util.Arrays;

public class Arrays5 {
    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
//        int[] arr = {2,0,1};
//        int[] arr = {1,0};
        Arrays5 arrays5Instance  = new Arrays5();
        Arrays.stream(arrays5Instance.sortColors(arr)).forEach(System.out::print);
    }

    public void Arrays5() {}
//dryr:
// rc: 0, bc: 4, i:0, swapped:true nums: [0,0,2,1,1,2]


        public int[] sortColors(int[] nums) {
            int redCount = 0;
            int blueCount = nums.length-1;
            int i=0;

            while(i<=blueCount) {
                if(nums[i]==0) {
                    int temp = nums[i];
                    nums[i] = nums[redCount];
                    nums[redCount] = temp;
                    redCount++;
                    if(redCount>i) {
                        i++;
                    }
                } else if(nums[i]==2) {
                    int temp = nums[i];
                    nums[i] = nums[blueCount];
                    nums[blueCount] = temp;
                    blueCount--;
                } else {
                    i++;
                }

        }
            return nums;
    }
}
