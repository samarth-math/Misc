package Arrays;

public class Arrays1 {
    public static void main(String[] args) {
        int[] arr = {-3,-2,-1};
        Arrays1 arrays1Instance = new Arrays1();
        System.out.println(arrays1Instance.maxSubArray(arr));
    }

    public void Arrays1() {}
    public int maxSubArray(int[] a) {

        int sum = Integer.MIN_VALUE, maxSum = Integer.MIN_VALUE, l = a.length, index=0;
        if(l == 1)
            return a[0];

        for (int i = 0; i < l; i++) {
            maxSum = Math.max(maxSum, a[i]);
            index = i;
            if(a[i] > 0) {
                sum = a[i];
                break;
            }
        }

        for (int i = index+1; i < l; i++) {
            if(sum + a[i] > 0) {
                sum += a[i];
            } else {
                sum = 0;
            }
            maxSum = Math.max(sum, maxSum);
        }


        return maxSum;
    }
}
