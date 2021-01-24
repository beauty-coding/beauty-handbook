package com.beauty.concurrent.thread;

/**
 * todo description
 *
 * @author yufw
 * @version v0.1.0.0
 * @date 2021/1/22 14:52
 * @since v0.1.0.0
 */
public class ThreadState {

    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set(1);
        new Thread();
    }
}
