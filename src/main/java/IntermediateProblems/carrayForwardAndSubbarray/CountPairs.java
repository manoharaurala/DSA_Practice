package IntermediateProblems.carrayForwardAndSubbarray;

public class CountPairs {
    public static void main(String[] args) {
        /*
        Given string lower case count no of pairs such that i<j & s[i]=='a' s[j]=='g
         */
        String input = "bcaggaag";

        int answer = calculatePairs(input);
        System.out.println("No of pairs: " + answer);
    }

    public static int calculatePairs(String input) {
        int count_a = 0;
        int answer = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a') count_a++;
            else if (input.charAt(i) == 'g') answer = answer + count_a;
        }

        return answer;

    }

}
