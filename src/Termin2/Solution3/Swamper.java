package Termin2.Solution3;

/**
 * Created by alan on 25/04/15.
 */
public class Swamper implements Runnable {
    private final int MIN_PROCESS_TIME = 10000;
    private final int MAX_PROCESS_TIME = 20000;
    private Kitchen kitchen;
    private Delivery delivery;

    public Swamper(Kitchen kitchen, Delivery delivery) {
        this.kitchen = kitchen;
        this.delivery = delivery;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()) {
            this.kitchen.popOrder();
            flipBurger();
            delivery.pushBurger(new Burger());
        }
    }

    public void flipBurger(){
        int processTime = (int)(Math.random()*(MAX_PROCESS_TIME-MIN_PROCESS_TIME)+MIN_PROCESS_TIME);
        try {
            Thread.sleep(processTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
