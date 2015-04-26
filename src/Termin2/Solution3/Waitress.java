package Termin2.Solution3;

/**
 * Created by alan on 25/04/15.
 */
public class Waitress implements Runnable, Comparable<Waitress>{
    private final int MAX_FINISH_TIME = 20000;
    private final int MIN_FINISH_TIME = 10000;
    private final int MAX_PROCESS_TIME = 10000;
    private final int MIN_PROCESS_TIME = 5000;

    private Restaurant restaurant;
    private Kitchen kitchen;
    private Delivery delivery;

    private int countCustomer = 0;
    private int id;
    private Customer currentCustomer;
    private int priorityScore = 0;

    public Waitress(Restaurant restaurant, int id, Kitchen kitchen, Delivery delivery) {
        this.restaurant = restaurant;
        this.id = id;
        this.kitchen = kitchen;
        this.delivery = delivery;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()){
            this.currentCustomer = restaurant.topCustomer(this);
            countCustomer++;
            takeOrder(this.currentCustomer);
            delivery.popBurger(this);
            finishOrder();
            this.currentCustomer = null;
            restaurant.popCustomer(this);
        }
    }

    private void takeOrder(Customer customer) {
        int processTime = (int)(Math.random()*(MAX_PROCESS_TIME-MIN_PROCESS_TIME)+MIN_PROCESS_TIME);
        try {
            Thread.sleep(processTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        kitchen.pushOrder(customer.getBurgerCount());
    }

    private void finishOrder(){
        int processTime = (int)(Math.random()*(MAX_FINISH_TIME-MIN_FINISH_TIME)+MIN_FINISH_TIME);
        try {
            Thread.sleep(processTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public int getCountCustomer() {
        return countCustomer;
    }

    public int getPriorityScore() {
        return priorityScore;
    }

    public void setPriorityScore(int priorityScore) {
        this.priorityScore = priorityScore;
    }

    @Override
    public int compareTo(Waitress o) {
        if(this.getPriorityScore() > o.getPriorityScore()){
            return 1;
        }else if (this.getPriorityScore() < o.getPriorityScore()){
            return -1;
        }else{
            return 0;
        }
    }
}
