package com.riveryoung.leetcode.dynamicprograming;

public class DynamicProgramming {
    /**
    *   递归的方法
    *   时间复杂度 O(n2) 空间复杂度O(n)
    **/
    public int Fibonacci(int n) {
        if (n < 0) {
            return -1;
        }
        if (0 == n){
            return 0;
        }
        if (1 == n){
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    /**
     *  动态规划的方法
     *  时间复杂度 O(n) 空间复杂度O(1)
     * */
    public int Fibonacci_dp(int n){
        if (n < 0) {
            return -1;
        }
        if (0 == n){
            return 0;
        }
        if (1 == n){
            return 1;
        }
        int Fp0 = 0;
        int Fp1 = 1;
        int temp = 0;
        for (int i = 2; i <= n; i++){
            temp = Fp0 + Fp1;
            Fp0 = Fp1;
            Fp1 = temp;
        }
        return temp;
    }

    public int FrogJumpWays(int n){
        if (n <= 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int way1 = 1;
        int way2 = 2;
        int waySum = 0;
        for (int i = 3; i <= n; i++){
            waySum = (way1 + way2) % 1000000007;
            way1 = way2;
            way2 = waySum;
        }
        return waySum;
    }
}
