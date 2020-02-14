package utils;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author xichen created on 06/02/2020
 */

public class MyScheduler {
    private Timer timer;
    public MyScheduler() {
        timer = new Timer();
    }
    public void schedule(TimerTask task, long interval) {
        timer.schedule(task, 0, interval);
    }
}
