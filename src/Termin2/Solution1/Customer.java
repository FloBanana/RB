package Termin2.Solution1;

/**
 * Created by alan on 21/04/15.
 */
public class Customer {
    private int burger;

    public Customer() {
        this.burger = (int)(Math.random()*8+1);
    }

    public int getBurger() {
        return burger;
    }
}
