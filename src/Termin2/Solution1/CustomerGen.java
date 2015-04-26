package Termin2.Solution1;

/**
 * Created by alan on 21/04/15.
 */
public class CustomerGen implements Runnable{

    private int DEFAULT_RUNNING_TIME = 30000;
    private int MIN_CUSTOMER = 1;
    private int MAX_CUSTOMER = 5;
    private float CHANCE_FOR_CREATION = 1f;
    private int runningTime;
    private Restaurant restaurant;


    public CustomerGen(int runningTime, Restaurant restaurant) {
        this.runningTime = runningTime;
        this.restaurant = restaurant;
    }



    @Override
    public void run() {
        for(int i = 0; i < MAX_CUSTOMER; i++){
            if(Math.random() <= CHANCE_FOR_CREATION){
                restaurant.pushCustomer(new Customer());
                Logger.log("New Termin2.Solution1.Customer created");
            }
            waitSomeTime(DEFAULT_RUNNING_TIME/MAX_CUSTOMER);
        }
    }

    public void waitSomeTime(int timeToWait){
        try {
            Thread.sleep(timeToWait);
        } catch (InterruptedException e) {
        }
    }
}
