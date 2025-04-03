package IntermediateProblems.PrefixSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Specialndex {
    //After removing ith element in array sum of odd index element in array = sum even index element in array
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(4, 3, 2, 7, 6, -2));
        int n = arr.size();

        if (n == 0) {
            System.out.println("No of special indices in array is: 0");
            return;
        }

        List<Integer> pfSumEvenIndex = new ArrayList<>();
        List<Integer> pfSumOddIndex = new ArrayList<>();

        pfSumEvenIndex.add(arr.get(0)); // First element is even index (0)
        pfSumOddIndex.add(0); // No odd-indexed elements before index 0

        // Compute prefix sum arrays
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                pfSumEvenIndex.add(pfSumEvenIndex.get(i - 1) + arr.get(i));
                pfSumOddIndex.add(pfSumOddIndex.get(i - 1));
            } else {
                pfSumEvenIndex.add(pfSumEvenIndex.get(i - 1));
                pfSumOddIndex.add(pfSumOddIndex.get(i - 1) + arr.get(i));
            }
        }

        int count_special_index = 0;

        for (int i = 0; i < n; i++) {
            int sumOdd, sumEven;

            if (i == 0) {
                // Case when removing first element
                sumOdd = pfSumEvenIndex.get(n - 1) - arr.get(0);
                sumEven = pfSumOddIndex.get(n - 1);
            } else {
                sumOdd = pfSumOddIndex.get(i - 1) + (pfSumEvenIndex.get(n - 1) - pfSumEvenIndex.get(i));
                sumEven = pfSumEvenIndex.get(i - 1) + (pfSumOddIndex.get(n - 1) - pfSumOddIndex.get(i));
            }

            if (sumOdd == sumEven) {
                count_special_index++;
            }
        }

        System.out.println("No. of special indices in array is: " + count_special_index);
    }
}
