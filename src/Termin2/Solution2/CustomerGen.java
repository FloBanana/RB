package Termin2.Solution2;

/**
 * Created by alan on 25/04/15.
 */
public class CustomerGen implements Runnable {
    private int LIFETIME = 15000;
    private float PROBABILITY_OF_CREATION = 1f;
    private int MAX_CUSTOMER = 5;
    private Restaurant restaurant = null;

    public CustomerGen(Restaurant restaurant) {
        this.restaurant = restaurant;
        Logger.log("Restaurant created");
    }

    public void createCustomer(){
        if(Math.random() < PROBABILITY_OF_CREATION){
            restaurant.pushCustomer(new Customer());
            Logger.log("New Customer created and pushed");
        }
    }

    @Override
    public void run() {
        for(int i = 0; i < MAX_CUSTOMER; i++){
            createCustomer();
            try {
                Thread.sleep(LIFETIME/MAX_CUSTOMER);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
