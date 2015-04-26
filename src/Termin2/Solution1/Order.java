package Termin2.Solution1;

/**
 * Created by alan on 21/04/15.
 */
public class Order {
    private Customer customer = null;

    public Order(Customer customer) {
        this.customer = customer;
    }

    public int getBurger(){
        return this.customer.getBurger();
    }
}
