package ArrayPractice;

import java.util.HashMap;
import java.util.Map;

public class Arrays3 {
    public static void main(String[] args) {
        int[] arr = {-3,-2,-1};
        Arrays3 arrays3Instance = new Arrays3();
        System.out.println(arrays3Instance.majorityElement(arr));
    }

    public void Arrays3() {}
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums) {
            map.put(i,map.getOrDefault(i,0)+1);
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
