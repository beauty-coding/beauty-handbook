package com.beauty.concurrent.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description
 *
 * @author yufengwen
 * @date 2021/9/17 3:55 下午
 */
public class LockTest {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
    }
}
