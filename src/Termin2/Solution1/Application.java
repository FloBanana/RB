package Termin2.Solution1;

/**
 * Created by alan on 22/04/15.
 */
public class Application {
    public static void main(String[] args){
        Restaurant restaurant = new Restaurant(10);
        Kitchen kitchen = new Kitchen();

        Thread customerGen = new Thread(new CustomerGen(3000, restaurant));
        Thread waitress1 = new Thread(new Waitress(0, restaurant, kitchen));
        Thread waitress2 = new Thread(new Waitress(1, restaurant, kitchen));

        customerGen.start();
        waitress1.start();
        waitress2.start();
    }
}
