package Arrays;

public class HelloWorld {
    public static void main(String[] args) {
        int[] arr = {-3,-2,-1};
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] a) {

        int sum = Integer.MIN_VALUE, maxSum = Integer.MIN_VALUE, l = a.length, index=0;
        if(l == 1)
            return a[0];

        for (int i = 0; i < l; i++) {
            maxSum = maxSum > a[i] ? maxSum : a[i];
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

            maxSum = sum > maxSum ? sum : maxSum;

        }


        return maxSum;
    }
}
