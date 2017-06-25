package net.chromaryu.chisaki.thread;

import net.chromaryu.chisaki.chisaki;

import java.util.TimerTask;

/**
 * Created by IfritSystem on 2017/06/24.
 */
public class clockNotifier extends TimerTask {
    boolean exit;
    @Override
    public void run() {
            synchronized (chisaki.ms) {
                chisaki.ms.notify();
            }
    }
}
