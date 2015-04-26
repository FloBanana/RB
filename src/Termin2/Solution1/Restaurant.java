package Termin2.Solution1;

/**
 * Created by alan on 21/04/15.
 */
public class Restaurant {
    Queue<Customer> firstQueue;
    Queue<Customer> secondQueue;
    boolean firstTurn = true;
    int waitress1Count = 0;
    int waitress2Count = 0;

    public Restaurant(int spaces) {
        firstQueue = new Queue<>( spaces / 2 );
        secondQueue = new Queue<>( ( spaces / 2 ) + ( spaces % 2 ) );
    }

    public synchronized void pushCustomer(Customer customer){
        while(true) {
            if (!firstQueue.isFull()) {
                if (firstTurn) {
                    firstQueue.push(customer);
                    firstTurn = false;
                    notifyAll();
                    Logger.log("Pushed customer in first Termin2.Solution1.Queue");
                    return;
                } else if (!secondQueue.isFull()) {
                    secondQueue.push(customer);
                    firstTurn = true;
                    notifyAll();
                    Logger.log("Pushed customer in second Termin2.Solution1.Queue");
                    return;
            }
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public synchronized Customer popCustomer(Waitress waitress){
        Customer resultCustomer = null;
        while (true) {
            if (waitress.getNumber() == 0) { //TODO: Magic Number
                if (!firstQueue.isEmpty()) {
                    notifyAll();
                    Logger.log("Poped customer from first Termin2.Solution1.Queue");
                    waitress1Count++;
                    return firstQueue.pop();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                if (!secondQueue.isEmpty()){
                    notifyAll();
                    Logger.log("Poped customer from second Termin2.Solution1.Queue");
                    waitress2Count++;
                    return secondQueue.pop();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
