package Termin2.Solution3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by alan on 25/04/15.
 */
public class Delivery {
    private final int CAPACITY = 12;
    private final int MIN_REMAINING_BURGER = 2;
    private final int MAX_WAIT_TIME = 60000;
    private ArrayList<Waitress> waitressesScoreBoard;

    private LinkedBlockingQueue<Burger> deliveryQueue;

    public Delivery() {
        this.deliveryQueue = new LinkedBlockingQueue<>(CAPACITY);
        waitressesScoreBoard = new ArrayList<>();
    }

    public synchronized void pushBurger(Burger burger){
        while(deliveryQueue.remainingCapacity() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        deliveryQueue.add(burger);
        updatePriority();
        Collections.sort(waitressesScoreBoard);
        notifyAll();
        Logger.log("PUSHED burger on the delivery ribbon");
        logStatus();
    }

    public synchronized Burger[] popBurger(Waitress waitress){
        addScoreBoard(waitress);
        Collections.sort(waitressesScoreBoard);

        while(deliveryQueue.size() <= MIN_REMAINING_BURGER+waitress.getCurrentCustomer().getBurgerCount() || !waitressesScoreBoard.get(0).equals(waitress)){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        Burger burgers[] = new Burger[waitress.getCurrentCustomer().getBurgerCount()];
        for(int i = 0; i < burgers.length; i++){
            burgers[i] = deliveryQueue.poll();
        }

        waitressesScoreBoard.remove(waitress);

        Logger.log("POPPED " + waitress.getCurrentCustomer().getBurgerCount() + " burger from delivery ribbon");
        logStatus();
        return burgers;
    }

    public void addScoreBoard(Waitress waitress){
        int score = 0;

        score += waitress.getCurrentCustomer().getMAX_BURGER() - waitress.getCurrentCustomer().getBurgerCount();

        if(waitress.getCurrentCustomer().getWaitTime() > MAX_WAIT_TIME){
            score += 8;
        }

        if(!waitressesScoreBoard.isEmpty()){
            if((waitressesScoreBoard.get(0).getCountCustomer() - waitress.getCountCustomer()) > 3){
                score += 8;
            }
        }

        waitress.setPriorityScore(score);
        waitressesScoreBoard.add(waitress);
    }

    public void updatePriority(){
        for(int i = 0; i < waitressesScoreBoard.size(); i++){
            Waitress waitress = waitressesScoreBoard.get(i);
            int score = 0;

            score += waitress.getCurrentCustomer().getMAX_BURGER() - waitress.getCurrentCustomer().getBurgerCount();

            if(waitress.getCurrentCustomer().getWaitTime() > MAX_WAIT_TIME){
                score += 8;
            }

            if(!waitressesScoreBoard.isEmpty()){
                if((waitressesScoreBoard.get(0).getCountCustomer() - waitress.getCountCustomer()) > 3){
                    score += 8;
                }
            }

            waitress.setPriorityScore(score);
        }
    }

    public void logStatus(){
        Logger.log("Burger on the ribbon : " + deliveryQueue.size());
    }
}
