package com.riveryoung.leetcode.binarytree;

import java.util.List;

public class BinaryTreeTest {
    public static void printBinaryTreeResult(int[] result){
        System.out.println("");
        System.out.print("[ ");
        for (int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
        System.out.println("]");
    }

    public static void printBinaryTreeResult(Double[] result){
        System.out.println("");
        System.out.print("[ ");
        for (int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
        System.out.println("]");
    }

    public static void printBinaryTreeResult(List<Integer> list){
        //转化List 为 int[]
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        printBinaryTreeResult(res);
    }

    public static void printBinaryTreeResultD(List<Double> list){
        //转化List 为 int[]
        Double[] res = new Double[list.size()];
        for (int i = 0; i < list.size(); i++){
            res[i] = list.get(i).doubleValue();
        }
        printBinaryTreeResult(res);
    }

    public static void printBinaryTreeResultE(List<List<Integer>> list) {
        System.out.print("[");
        int len = list.size();
        for (int i = 0; i < len; i++){
            printBinaryTreeResult(list.get(i));
        }
        System.out.println("]");
    }
}
