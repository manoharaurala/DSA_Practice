package Array1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateKtimes {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
        int k = 3;
        rotateKTimes(input, k);
        System.out.println("Array after rotating: "+k+" times");
        System.out.println(input);
    }

    public static void rotateKTimes(List<Integer> input, int k) {
        reverse(input, 0, input.size() - 1);
        reverse(input, 0, k - 1);
        reverse(input, k, input.size() - 1);
    }

    public static void reverse(List<Integer> input, int x, int y) {

        while (x < y) {
            int temp = input.get(x);
            input.set(x, input.get(y));
            input.set(y, temp);
            x++;
            y--;
        }

    }

}
