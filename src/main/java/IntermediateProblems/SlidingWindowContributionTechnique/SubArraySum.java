package IntermediateProblems.SlidingWindowContributionTechnique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArraySum {
    //find  sum of all sub array
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        int ans = sum_subArray(list);
        System.out.println("Sum of all sub array using carry forward: " + ans);
        System.out.println("Sum of all sub array using contribution technique: " + sum_subArray_contribution(list));

    }

    private static int sum_subArray(List<Integer> list) {
        int n = list.size();
        int total_sum = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + list.get(j);
                total_sum =total_sum+ sum;
            }
        }
        return total_sum;
    }

    private static int sum_subArray_contribution(List<Integer> list){
        int sum=0;
        int n=list.size();
        for(int i=0;i<n;i++){
            sum=sum+list.get(i)*(i+1)*(n-i);
        }

        return sum;
    }

}
