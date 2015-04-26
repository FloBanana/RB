package Termin2.Solution1;

/**
 * Created by alan on 21/04/15.
 */
public class Waitress implements Runnable {
    private int PROCESS_TIME_RANGE = 5000;
    private int PROCESS_TIME_MIN = 5000;


    private Kitchen kitchen;
    private int number = -1;
    private Restaurant restaurant;

    public Waitress(int number, Restaurant restaurant, Kitchen kitchen) {
        this.number = number;
        this.restaurant = restaurant;
        this.kitchen = kitchen;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public void run() {
        Customer customer = restaurant.popCustomer(this);
        processOrder();
        kitchen.pushOrder(new Order(customer));
    }

    public void processOrder(){
        try {
            Thread.sleep((int)(Math.random()*PROCESS_TIME_RANGE+PROCESS_TIME_MIN));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
