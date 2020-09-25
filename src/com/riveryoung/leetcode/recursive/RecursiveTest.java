package com.riveryoung.leetcode.recursive;

public class RecursiveTest {
    public static void main(String[] args) {
        Recursive recursive = new Recursive();

        //剑指 Offer 64. 求1+2+…+n
        int sum = recursive.sumNums(9);
        System.out.println("sum = " + sum);
    }
}

class Recursive{
    /**
     * 剑指 Offer 64. 求1+2+…+n
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     *
     * 示例 1：
     * 输入: n = 3
     * 输出: 6
     *
     * 示例 2：
     * 输入: n = 9
     * 输出: 45
     *
     * 限制：
     * 1 <= n <= 10000
     * */
    public int sumNums(int num){
        if (num == 0){
            return 0;
        }else {
            return num + sumNums(num - 1);
        }
    }
}
