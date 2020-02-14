import utils.MyScheduler;

import javax.swing.*;
import java.util.TimerTask;

/**
 * @author xichen created on 05/02/2020
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MyPanel myPanel = new MyPanel();
                initializeFrame("CoronaVirus", myPanel);
                scheduleAreaRepainting(myPanel);
            }
        });
    }

    private static void initializeFrame(String title, MyPanel myPanel) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.add(myPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private static void scheduleAreaRepainting(MyPanel myPanel) {
        TimerTask repaintingTask = new TimerTask() {
            @Override
            public void run() {
                myPanel.repaint();
            }
        };

        MyScheduler scheduler = new MyScheduler();
        scheduler.schedule(repaintingTask, 100);
    }
}
