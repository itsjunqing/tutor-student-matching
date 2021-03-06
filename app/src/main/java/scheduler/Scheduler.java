package scheduler;

import observer.OSubject;

import java.util.Timer;
import java.util.TimerTask;

/**
 * A Scheduler (Subject) that periodically notifies its Observer(s) to perform certain actions.
 */
public class Scheduler extends OSubject {

    private int frequency;
    private Timer timer;

    /**
     * Constructs a Scheduler
     */
    public Scheduler(int frequency) {
        this.timer = new Timer();
        this.frequency = frequency;
        runTasks();
    }

    /**
     * Run the tasks of notifying the observers for every set of interval
     */
    private void runTasks() {
        TimerTask scheduledRun = new TimerTask() {
            @Override
            public void run() {
                System.out.println("From Scheduler: Running Instance");
                notifyObservers();
            }
        };
        timer.schedule(scheduledRun, 0, frequency * 1000); // delay of 0 seconds + period interval of frequency
    }

    /**
     * End the scheduler tasks
     */
    public void endScheduler(){
        timer.cancel();
        timer.purge();
    }

}