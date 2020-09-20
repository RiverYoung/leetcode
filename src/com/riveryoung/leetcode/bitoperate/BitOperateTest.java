package com.riveryoung.leetcode.bitoperate;

public class BitOperateTest {
    public static void main(String[] args){
        BitOperate bitOperate = new BitOperate();

        //剑指 Offer 15. 二进制中 1 的个数
        int iHammingWeight = bitOperate.hammingWeight(1021);
        System.out.println("iHammingWeight = " + iHammingWeight);
    }
}
