public class Customer {
    //Properties:
    private int seatNumber;
    private double totalCost;

    public Customer(int seatNumberIn){
        seatNumber = seatNumberIn;
        totalCost = 0.0;
    }

    public void addTotalCost(double mealPrice){
        totalCost += mealPrice;

    }


    public int getSeatNumber(){
        return seatNumber;
    }

    public double getTotalCost(){
        return totalCost;
    }


}
