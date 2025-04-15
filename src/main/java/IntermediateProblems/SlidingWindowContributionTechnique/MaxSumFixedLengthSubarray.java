package IntermediateProblems.SlidingWindowContributionTechnique;

public class MaxSumFixedLengthSubarray {

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        int maxSum = findMaxSumSubarray(arr, k);
        System.out.println("Maximum sum of subarray of length " + k + ": " + maxSum);
    }

    private static int findMaxSumSubarray(int[] arr, int k) {
        int n = arr.length;
        if (n < k) {
            throw new IllegalArgumentException("k cannot be larger than array length");
        }

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int maxSum = sum;

        for (int end = k; end < n; end++) {
            sum += arr[end] - arr[end - k];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
