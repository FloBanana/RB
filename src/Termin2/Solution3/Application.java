package Termin2.Solution3;

/**
 * Created by alan on 25/04/15.
 */
public class Application {
    public static void main(String[] args){

        Restaurant restaurant = new Restaurant();
        Kitchen kitchen = new Kitchen();
        Delivery delivery = new Delivery();

        Waitress firstWaitress = new Waitress(restaurant, 1, kitchen, delivery);
        Waitress secondWaitress = new Waitress(restaurant, 2, kitchen, delivery);

        Swamper firstSwamper = new Swamper(kitchen, delivery);
        Swamper secondSwamper = new Swamper(kitchen, delivery);
        Swamper thirdSwamper = new Swamper(kitchen, delivery);

        CustomerGen customerGen = new CustomerGen(restaurant, 30000);

        Thread firstWaitressThread = new Thread(firstWaitress);
        Thread secondWaitressThread = new Thread(secondWaitress);
        Thread customerGenThread = new Thread(customerGen);
        Thread firstSwamperThread = new Thread(firstSwamper);
        Thread secondSwamperThread = new Thread(secondSwamper);
        Thread thirdSwamperThread = new Thread(thirdSwamper);

        firstWaitressThread.start();
        secondWaitressThread.start();
        customerGenThread.start();
        firstSwamperThread.start();
        secondSwamperThread.start();
        thirdSwamperThread.start();

    }
}
