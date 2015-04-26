package Termin2.Solution3;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by alan on 25/04/15.
 */
public class Customer {
    private static int customerSequence = 0;

    private final int MAX_BURGER = 8;
    private final int MIN_BURGER = 1;

    private final int burgerCount;
    private final int id;
    private Date startTime;

    public Customer() {
        this.customerSequence++;
        this.id = customerSequence;
        this.burgerCount = (int)(Math.random()*MAX_BURGER+MIN_BURGER);
    }

    public void setStartTime(){
        this.startTime = new Date();
    }

    public long getWaitTime(){
        Date now = new Date();
        return TimeUnit.SECONDS.convert((now.getTime() - startTime.getTime()), TimeUnit.MILLISECONDS);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "burgerCount=" + burgerCount +
                ", id=" + id +
                ", startTime=" + startTime +
                '}';
    }

    public int getBurgerCount() {
        return burgerCount;
    }

    public int getMAX_BURGER() {
        return MAX_BURGER;
    }
}
