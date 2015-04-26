package Termin2.Solution1;

/**
 * Created by alan on 21/04/15.
 */
public class Kitchen {
    Queue<Order> queue = new Queue<>();

    public void pushOrder(Order order) {
        while(queue.isFull()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        queue.push(order);
        notifyAll();
    }

    public Order popOrder(){
        while(queue.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        notifyAll();
        return queue.pop();

    }
}
