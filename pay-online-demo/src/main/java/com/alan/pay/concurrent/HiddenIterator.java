package com.alan.pay.concurrent;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author Alan Wang
 * @Date 2018/11/6.
 */
public class HiddenIterator {

    public static void main(String[] args) {
        HiddenIterator obj = new HiddenIterator();
        obj.addTenThings();
    }

    private final Set<Integer> set = new HashSet<>();

    public synchronized void add(Integer i) {
        set.add(i);
    }

    public synchronized void remove(Integer i) {
        set.remove(i);
    }

    public void addTenThings() {
        Random r = new Random();
        for(int i=0; i<10; i++) {
            add(r.nextInt());
        }

        System.out.println("DEBUG: added ten element to " + set);
    }

}
