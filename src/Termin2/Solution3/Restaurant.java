package Termin2.Solution3;


import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by alan on 25/04/15.
 */
public class Restaurant {
    private final int MAX_CAPACITY = 20;
    private final int COUNT_QUEUES = 2;

    private ArrayList<Customer> rejectedCustomer = new ArrayList<>();
    private ArrayList<Integer> waitingTimes = new ArrayList<>();

    private LinkedBlockingQueue<Customer> firstQueue;
    private LinkedBlockingQueue<Customer> secondQueue;

    public Restaurant() {
        firstQueue = new LinkedBlockingQueue<>(MAX_CAPACITY/COUNT_QUEUES);
        secondQueue = new LinkedBlockingQueue<>(MAX_CAPACITY/COUNT_QUEUES+(MAX_CAPACITY%COUNT_QUEUES));
    }

    public synchronized void pushCustomer(Customer tempCustomer) {
        LinkedBlockingQueue<Customer> queue = null;
        int tempId = -1;

        if(firstQueue.remainingCapacity() == 0 && secondQueue.remainingCapacity() == 0){
            Logger.log("No remaining Capacity. Customer rejected");
            rejectedCustomer.add(tempCustomer);
            return;
        }

        if(firstQueue.size() > secondQueue.size()){
            queue = secondQueue;
            tempId = 2;
        }else {
            queue = firstQueue;
            tempId = 1;
        }

        queue.add(tempCustomer);
        Logger.log("PUSHED new " + tempCustomer.toString() + " into Queue " + tempId);
        logCurrentStatus();
        notifyAll();
    }

    public synchronized Customer topCustomer(Waitress waitress) {
        LinkedBlockingQueue<Customer> queue = null;
        int tempId = -1;

        if(waitress.getId() == 1){
            queue = firstQueue;
            tempId = 1;
        } else {
            queue = secondQueue;
            tempId = 2;
        }

        while (queue.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Customer tempCustomer = queue.peek();
        tempCustomer.setStartTime();
        Logger.log("TOPPED " + tempCustomer.toString() + " out of Queue " + tempId);
        return tempCustomer;
    }

    public synchronized Customer popCustomer(Waitress waitress) {
        LinkedBlockingQueue<Customer> queue = null;
        int tempId = -1;

        if(waitress.getId() == 1){
            queue = firstQueue;
            tempId = 1;
        } else {
            queue = secondQueue;
            tempId = 2;
        }

        while (queue.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Customer tempCustomer = queue.poll();
        waitingTimes.add(new Integer((int)tempCustomer.getWaitTime()));
        Collections.sort(waitingTimes);
        System.out.println("POPPED " + tempCustomer.toString() + " out of Queue " + tempId);
        System.out.println("Max: " + waitingTimes.get(waitingTimes.size()-1) + " Min: " + waitingTimes.get(0) + " Avg: " + avgWaitingTime());
        logCurrentStatus();
        notifyAll();
        return tempCustomer;
    }

    public void logCurrentStatus(){
        Logger.log("RESTAURANT STATUS");
        Logger.log("Queue 1 : " + firstQueue.size());
        Logger.log("Queue 2 : " + secondQueue.size());
        Logger.log(rejectedCustomer.toString());
    }

    public int avgWaitingTime(){
        int avgTime = waitingTimes.get(0);
        for(int i = 1; i < waitingTimes.size(); i++){
            avgTime = (avgTime + waitingTimes.get(i))/2;
        }
        return avgTime;
    }
}
