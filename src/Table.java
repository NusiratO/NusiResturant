
import java.util.ArrayList;

/**
 * Purpose:
 * @author Nusi
 * @date 7/25/2020
 */

public class Table {
    //properties
    private double Bill;
    private int tableNumber;
    private String Reserved;

    public Table(int tableNumberIn, String ReservedIn){
        tableNumber = tableNumberIn;
        Reserved = ReservedIn;
        Bill = 0.0;
    }


    public void calculateBill(double tableCost){
        Bill = Bill + tableCost;
    }

    public double getBill() {
        return Bill;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public String isReserved() {
        return Reserved;
    }

}
