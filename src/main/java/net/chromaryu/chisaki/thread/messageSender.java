package net.chromaryu.chisaki.thread;

import net.chromaryu.chisaki.chisaki;

/**
 * Created by IfritSystem on 2017/06/25.
 */
public class messageSender extends Thread {
    private int i;
    public boolean flag;
    @Override
    public void run() {
        while (!flag) {
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(++i);
        }
    }
}
