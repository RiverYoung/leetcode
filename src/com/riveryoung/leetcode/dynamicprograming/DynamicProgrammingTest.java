package com.riveryoung.leetcode.dynamicprograming;

public class DynamicProgrammingTest {
    public static void main(String[] args){
        DynamicProgramming dp = new DynamicProgramming();
        int n1 = dp.Fibonacci(2);
        int n2 = dp.Fibonacci(5);
        System.out.println(n1 + " " + n2);

        n1 = dp.Fibonacci_dp(2);
        n2 = dp.Fibonacci_dp(5);
        System.out.println(n1 + " " + n2);

        int way1 = dp.FrogJumpWays(2);
        int way2 = dp.FrogJumpWays(7);
        int way3 = dp.FrogJumpWays(0);
        System.out.println(way1 + " " + way2 + " " + way3);
    }
}
