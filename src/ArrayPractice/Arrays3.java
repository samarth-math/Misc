package ArrayPractice;

import java.util.HashMap;
import java.util.Map;

public class Arrays3 {
    public static void main(String[] args) {
        int[] arr = {-3,-2,-1};
        Arrays1 arrays1Instance = new Arrays1();
        System.out.println(arrays1Instance.maxSubArray(arr));
    }

    public void Arrays3() {}
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums) {
            Integer count = map.get(i);
            if (count!=null) {
                count++;
            } else {
                count = 1;
            }
            map.put(i, count);
        }
        int max = 0;
        int maxi =0;
        for (int i: map.keySet()) {
            if (map.get(i)>max) {
                maxi = i;
                max = map.get(i);
            }
        }
        return maxi;
    }
}
