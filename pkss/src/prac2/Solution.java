package prac2;

import java.util.stream.Stream;

public class Solution {
    public static int task11(int a, int b, int c) {
        return Stream.of(a, b, c).toList().stream().max(Integer::compare).orElseThrow();
    }

    public static double task14(double A) {
        double x = (4 + Math.sqrt(-4 * -4 - 4 * -1)) / 2;
        double y = (-A + Math.sqrt(A * A - 4 * 2 * -(A * A))) / (2 * 2);
        return (x + y) / (x * y);
    }

    public static double task17(int[] coords) {
        if (coords.length != 16) {
            return -1;
        }
        double side1 = getDistance(coords[0], coords[1], coords[2], coords[3]);
        double side2 = getDistance(coords[2], coords[3], coords[4], coords[5]);
        double side3 = getDistance(coords[4], coords[5], coords[6], coords[7]);
        double side4 = getDistance(coords[6], coords[7], coords[8], coords[9]);
        double side5 = getDistance(coords[8], coords[9], coords[10], coords[11]);
        double side6 = getDistance(coords[10], coords[11], coords[12], coords[13]);
        double side7 = getDistance(coords[12], coords[13], coords[14], coords[15]);
        double side8 = getDistance(coords[14], coords[15], coords[0], coords[1]);
        return side1 + side2 + side3 + side4 + side5 + side6 + side7 + side8;
    }
    public static double[] task20(int[] xes) {
        double[] res = new double[xes.length];
        for(int i=0; i< xes.length; i++){
            res[i] = 3* P(xes[i] + 3) * P(xes[i]);
        }
        return res;
    }
    public static boolean[] task23(int[] nums) {
        boolean[] res = new boolean[nums.length];
        for(int i=0; i< nums.length; i++){
            res[i] = isPrime(nums[i]);
        }
        return res;
    }
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    private static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
    private static double P(double X) {
        return 10 * Math.pow(X, 3) - 14 * Math.pow(X, 2) + 12 * X - 2;
    }
}
