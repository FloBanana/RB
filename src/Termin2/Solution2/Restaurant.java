package Termin2.Solution2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by alan on 25/04/15.
 */
public class Restaurant{
    private int RESTAURANT_SIZE = 20;
    private int QUEUE_COUNT = 2;

    private Queue<Customer> firstQueue = null;
    private Queue<Customer> secondQueue = null;

    private Waitress firstWaitress = null;
    private Waitress secondWaitress = null;

    public Restaurant() {
        firstQueue = new LinkedList<>();
        secondQueue = new LinkedList<>();

        firstWaitress = new Waitress(this, 1);
        secondWaitress = new Waitress(this, 2);

        Thread firstWaitressThread = new Thread(firstWaitress);
        Thread secondWaitressThread = new Thread(secondWaitress);

        firstWaitressThread.start();
        secondWaitressThread.start();
    }

    public boolean restaurantIsFull(){
        if(RESTAURANT_SIZE == 0){
            return true;
        }
        return false;
    }

    public synchronized void pushCustomer(Customer customer) {
        if(restaurantIsFull()){
            Logger.log("Restaurant is full");
            return;
        }

        if(firstQueue.size() < secondQueue.size()){
            firstQueue.add(customer);
            Logger.log("New Customer pushed to Queue 1");
        } else {
            secondQueue.add(customer);
            Logger.log("New Customer pushed to Queue 2");
        }

        Logger.log("Queue 1: " + firstQueue.size());
        Logger.log("Queue 2: " + secondQueue.size());
        RESTAURANT_SIZE--;

        if(Math.abs(firstWaitress.getWaitressCount()-secondWaitress.getWaitressCount()) > 3){ //TODO: Priorisierung
            if(firstWaitress.getWaitressCount()-secondWaitress.getWaitressCount() > 0){
                secondWaitress.notify();
            } else {
                firstWaitress.notify();
            }
        } else {
            notifyAll();
        }
    }

    public synchronized Customer topCustomer(Waitress waitress){
        Queue<Customer> queue = null;
        if(waitress.getId() == 1){ //firstQueue
            queue = firstQueue;
        }else{
            queue = secondQueue;
        }

        while(queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Customer tempCus = queue.poll();
        RESTAURANT_SIZE++;

        Logger.log("Top Customer " + tempCus.toString() + " out of Queue " + waitress.getId());
        return tempCus;
    }
}
