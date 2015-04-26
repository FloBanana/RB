package Termin2.Solution3;

/**
 * Created by alan on 25/04/15.
 */
public class Kitchen {
    private final int QUEUE_SIZE = 10;
    private int burgerCounter = 0;


    public synchronized void pushOrder(int addBurger){
        this.burgerCounter += addBurger;
        logStatus();
        Logger.log("PUSHED Order to kitchen");
        notifyAll();
    }

    public synchronized void popOrder(){
        while(burgerCounter <= -4){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.burgerCounter--;
        logStatus();
        Logger.log("POPED Order from kitchen");
    }

    public void logStatus(){
        Logger.log("KITCHEN STATUS");
        Logger.log("Orders in Queue : " + burgerCounter);
    }
}
