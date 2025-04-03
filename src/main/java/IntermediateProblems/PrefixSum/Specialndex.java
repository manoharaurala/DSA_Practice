package IntermediateProblems.PrefixSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Specialndex {
    //After removing ith element in array sum of odd index element in array = sum even index element in array
    public static void main(String[] args) {

        List<Integer> arr = new ArrayList<>(Arrays.asList(4, 3, 2, 7, 6, -2));
        int n = arr.size();

        List<Integer> pfSumEvenIndex = new ArrayList<>();
        pfSumEvenIndex.add(arr.getFirst());

        List<Integer> pfSumOddIndex = new ArrayList<>();
        pfSumOddIndex.add(0);


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

        //for i=0

        if ((pfSumOddIndex.get(n - 1) - pfSumOddIndex.get(0)) == (pfSumEvenIndex.get(n - 1) - pfSumEvenIndex.get(0))) {
            count_special_index++;
        }


        for (int i = 1; i < n; i++) {
            int sumOdd = (pfSumOddIndex.get(i - 1)) +
                    (pfSumEvenIndex.get(n - 1) - pfSumOddIndex.get(i - 1));
            int evenOdd = (pfSumEvenIndex.get(i - 1)) +
                    (pfSumOddIndex.get(n - 1) - pfSumOddIndex.get(i - 1));

            if (sumOdd == evenOdd) count_special_index++;

        }

        System.out.println("No of special index in array is: " + count_special_index);


    }
}
