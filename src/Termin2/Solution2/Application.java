package Termin2.Solution2;

/**
 * Created by alan on 25/04/15.
 */
public class Application {
    public static void main(String[] args){
        Restaurant restaurant = new Restaurant();
        CustomerGen customerGen = new CustomerGen(restaurant);
        Thread customerGenThread = new Thread(customerGen);

        customerGenThread.start();
    }
}
