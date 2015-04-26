package Termin2.Solution2;


/**
 * Created by alan on 21/04/15.
 */
public class Waitress implements Runnable {
    private int PROCESS_TIME_RANGE = 1000;
    private int PROCESS_TIME_MIN = 1000;

    private Restaurant restaurant = null;

    private int waitressCount = 0;
    private int id = -1;

    public Waitress(Restaurant restaurant, int id) {
        this.restaurant = restaurant;
        this.id = id;
        Logger.log("Waitress created. Nr. " + this.getId());
    }

    @Override
    public void run() {
        while(!Thread.interrupted()) {
            Customer customer = restaurant.topCustomer(this);
            waitressCount++;
            processOrder();
        }
    }

    public void processOrder(){
        try {
            Thread.sleep((int)(Math.random()*PROCESS_TIME_RANGE+PROCESS_TIME_MIN));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getWaitressCount() {
        return waitressCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
