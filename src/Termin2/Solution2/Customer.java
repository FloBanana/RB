package Termin2.Solution2;

import java.util.Date;

/**
 * Created by alan on 25/04/15.
 */
public class Customer {
    static int SEQUENCE = 0;
    private int MIN_ORDER_VOLUME = -1;
    private int MAX_ORDER_VOLUME = -1;
    private int id = -1;
    private int orderVolume = -1;

    private Date startDate;

    public Customer() {
        this.SEQUENCE++;
        this.id = SEQUENCE;
        this.orderVolume = (int)(Math.random()*MAX_ORDER_VOLUME+MIN_ORDER_VOLUME);
        this.startDate = new Date();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", orderVolume=" + orderVolume +
                '}';
    }

    public float waitTime() {
        Date now = new Date();
        return 1f; //TODO: Set it up bitch
    }
}
