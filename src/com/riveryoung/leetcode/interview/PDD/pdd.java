package com.riveryoung.leetcode.interview.PDD;

import java.sql.Time;
import java.util.Date;
/**
 * 设计一个数据结构，实现LFU(Least Frequently Used) Cache缓存机制
 * 实现 LFUCache 类：
 * LFUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * String get(String key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 null 。
 * void put(String key, String value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前找到使用次数最少的键值对，并将新的键值对替换掉，如果出现多个次数最少的键值对，则替换掉使用时间最久的那个。
 * https://leetcode-cn.com/problems/lfu-cache/
 * */


public class pdd {
    public static void main(String[] args){

    }



    public class LFUCache{
        CacheE[] mCacheE = null;
        int mCapacity = 0;
        int mSize = 0;

        public class CacheE{
            String key = null;
            String val = null;
            int cnt = 0;
            Time time;
        }

        public LFUCache(int capacity){
            mCacheE = new CacheE[capacity];
            mCapacity = capacity;
        }

        public String get(String key){

            return key;
        }

        public void put(String key, String value){
            if (mSize == mCapacity){
                //找出使用次数最少的元素


            }else{
                //查找是否存在相同的key
                for (int i = 0 ; i < mSize ; i++){
                    if (key.equals(mCacheE[i])){

                    }
                }
            }

        }
    }
}
