package IntermediateProblems.carrayForwardAndSubbarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given array[n].Find length of smallest array which contains both max & min of the array
 */
public class MinAndMax {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 4, 5, 2, 1, 4, 2, 3, 5, 4, 4, 1));
        int answer = findSubArray(list);
        System.out.println("Length of smalles sub array which contains both max and min elements: " + answer);

    }

    public static int findSubArray(List<Integer> arr) {
        int min = arr.get(0);
        int max = arr.get(0);
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            if (arr.get(i) < min) min = arr.get(i);
            else if (arr.get(i) > max) max = arr.get(i);
        }

        int last_min_index = -1;
        int last_max_index = -1;
        int answer = n;

        for (int i = 0; i < n; i++) {
            if (arr.get(i) == min) {
                last_min_index = i;
                if (last_max_index != -1) {
                    answer = Math.min(answer, i - last_max_index + 1);
                }
            }

            if (arr.get(i) == max) {
                last_max_index = i;
                if (last_min_index != -1) {
                    answer = Math.min(answer, i - last_min_index + 1);
                }
            }
        }

        return answer;

    }
}
