package Termin2.Solution3;

/**
 * Created by alan on 25/04/15.
 */
public class CustomerGen implements Runnable {
    private final int MAX_CUSTOMER = 5;
    private final int MIN_CUSTOMER = 1;
    private final int ROUNDTIME;

    Restaurant restaurant = null;

    public CustomerGen(Restaurant restaurant, int roundtime) {
        this.restaurant = restaurant;
        this.ROUNDTIME = roundtime;
    }

    public void run(){
        while(!Thread.interrupted()){
            createCustomer();
            try {
                Thread.sleep(ROUNDTIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void createCustomer() {
        int customerCount = (int)(Math.random()*MAX_CUSTOMER+MIN_CUSTOMER);
        for (int i = 0; i < customerCount; i++){
            Customer tempCustomer = new Customer();
            restaurant.pushCustomer(tempCustomer);
        }
    }
}
