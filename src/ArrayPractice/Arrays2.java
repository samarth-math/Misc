package ArrayPractice;

public class Arrays2 {
    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        Arrays2 arrays2Instance = new Arrays2();
        System.out.println(arrays2Instance.searchRange(nums, target));
    }
    public int[] searchRange(int[] nums, int target) {
        int current = binarySearch(nums, target);
        if (current == -1) {
            return new int[]{-1, -1};
        }
        int start = current;
        int end = current;
        while(start>=0 && nums[start]==nums[current]) {
            start = start-1;
        }
        while(end<nums.length && nums[end]==nums[current]) {
            end = end+1;
        }
        return new int[]{start, end};
    }

    public int binarySearch(int[] nums, int target){
        int l = 0;
        int r = nums.length-1;
        while (l<=r) {
            int mid = l + (r-l)/2;
            if (nums[mid]==target) {
                return mid;
            }
            else if(target < nums[mid] ) {
                r = mid -1;
            }
            else if(target > nums[mid]) {
                l = mid + 1;
            }
        }
        return -1;
    }

}
