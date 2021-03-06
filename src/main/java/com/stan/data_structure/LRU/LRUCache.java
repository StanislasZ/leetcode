package com.stan.data_structure.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

//leetcode146
//方法1： 继承LinkedHashMap
public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    //调父类构造器
    public LRUCache(int capacity) {
        // accessOrder为true代表根据访问顺序，false代表根据插入顺序
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }


    /**
     * 评论中有人说
     * 他的get调用的LinkedHashMap的getOrDefault方法,
     * LinkedHashMap的getOrDefault方法里面有每次调用移动键的位置的功能
     *
     * 粗略地看了下源码，LinkedHashMap在get或getOrDefault方法中，
     * 只要accessOrder = true， 就会执行afterNodeAccess方法
     *
     * 把get的Entry变成最新的，即移动到最右边，让tail = get的这个Entry
     *
     * @param key
     * @return
     */
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    /**
     * 重写该方法后，当实际键值对个数超过容量时， 在put后会触发删除最老Entry，以实现LRU
     *
     * afterNodeInsertion这个方法在 HashMap就有定义，方法体为空， put操作的最后会调用该方法
     * HashMap的put里的afterNodeInsertion相当于没用，因为是空方法
     *
     *
     * 疑问： 为什么要这样设计？？
     * 猜想： 可能是为了保证put可以直接继承
     *
     * LinkedHashMap添加了具体内容。     *
     * 所以 LinkedHashMap的put操作的最后 才会有afterNodeInsertion的效果
     *
     *
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

