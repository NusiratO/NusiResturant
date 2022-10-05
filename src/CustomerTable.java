/**
 * Purpose: Creates a new customer, tracks their order, and calculates the cost
 * @author Nusi
 * @date 10/04/2022
 */

import java.util.ArrayList;

public class CustomerTable {
    //Properties
    private static int numOfCustomer;
    private static int count;
    private int cusOrderNum;
    private static ArrayList<Customer> CusList = new ArrayList<Customer>(numOfCustomer + 1);
    private static ArrayList<Integer> cusOrderList = new ArrayList<Integer>(count);
    private ArrayList<Integer> cusOrder = new ArrayList<Integer>(cusOrderNum);
    private static Table cusTable;
    private static Menu CusMenu = new Menu();

    public CustomerTable(){
        numOfCustomer = 0;
        count = 0;
        cusOrderNum = 0;
    }

    /**
     * Purpose: Creates a new customer in the customer list
     * @param num
     */
    public static void newCustomer(int num){
        numOfCustomer = num;
        for(int i = 0; i <= numOfCustomer; i++){
            Customer seatNum = new Customer(i);
            CusList.add(seatNum);
        }
        CusList.remove(0);
    }

    /**
     * Purpose: Creates a list with the number of times the customer will order 
     * @param cusOrderCount
     */
    public static void OrderCount(int cusOrderCount){
        count = cusOrderCount;
        for(int i = 0; i <= count; i++){
            cusOrderList.add(i);
        }
    }

    /**
     * Purpose: finds the food item number and adds the cost to the tables' bill
     * @param numOfFoodItem
     */
    public static void settingCusMenu(int numOfFoodItem){
        //System.out.println(userTable.getVar());
        String foodName;
        double foodCost;
            //System.out.println(userTable.getVar().get(z));
        if (numOfFoodItem > 0 && numOfFoodItem <= 9) {
            CusMenu.Appetizer(numOfFoodItem);
            foodName = CusMenu.getFoodItem();
            foodCost = CusMenu.getCost();
            cusTable.calculateBill(foodCost);
            System.out.println(foodName + " - $" + foodCost);
        }
        else if (numOfFoodItem > 9 && numOfFoodItem <= 20) {
            CusMenu.MainCourse(numOfFoodItem);
            foodCost = CusMenu.getCost();
            foodName = CusMenu.getFoodItem();
            cusTable.calculateBill(foodCost);
            System.out.println(foodName + " - $" + foodCost);
        }
        else if (numOfFoodItem > 20 && numOfFoodItem <= 32) {
            CusMenu.Dessert(numOfFoodItem);
            foodCost = CusMenu.getCost();
            foodName = CusMenu.getFoodItem();
            cusTable.calculateBill(foodCost);
            System.out.println(foodName + " - $" + foodCost);
        }
        else if (numOfFoodItem > 32 && numOfFoodItem <= 48) {
            CusMenu.Drinks(numOfFoodItem);
            foodCost = CusMenu.getCost();
            foodName = CusMenu.getFoodItem();
            cusTable.calculateBill(foodCost);
            System.out.println(foodName + " - $" + foodCost);
        }
    }

    /**
     * Purpose: Calculates the total cost of what the customer ordered
     * @param cusList
     * @return the customer total cost
     */
    public static double addingTotalCost(int cusList){
        double cusTotal = 0.0;
            for (int x = 1; x < cusOrderList.size(); x++) {
                if (cusOrderList.get(x) > 0 && cusOrderList.get(x) <= 9) {
                    CusMenu.Appetizer(cusOrderList.get(x));
                    double var3 = CusMenu.getCost();
                    cusTotal = cusTotal + var3;
                    //userTable.getCusList().get(cusList).addTotalCost(var3);
                }
                else if (cusOrderList.get(x) > 9 && cusOrderList.get(x) <= 20) {
                    CusMenu.MainCourse(cusOrderList.get(x));
                    double var3 = CusMenu.getCost();
                    cusTotal = cusTotal + var3;
                    //userTable.getCusList().get(cusList).addTotalCost(var3);
                }
                else if (cusOrderList.get(x) > 20 && cusOrderList.get(x) <= 32) {
                    CusMenu.Dessert(cusOrderList.get(x));
                    double var3 = CusMenu.getCost();
                    cusTotal = cusTotal + var3;
                    //userTable.getCusList().get(cusList).addTotalCost(var3);
                }
                else if (cusOrderList.get(x) > 32 && cusOrderList.get(x) <= 48) {
                    CusMenu.Drinks(cusOrderList.get(x));
                    double var3 = CusMenu.getCost();
                    cusTotal = cusTotal + var3;
                    //userTable.getCusList().get(cusList).addTotalCost(var3);
                }

            }
        return cusTotal;
    }

    //getters
    public static int getNumOfCustomer(){
        return numOfCustomer;
    }

    public static ArrayList<Customer> getCusList(){
        return CusList;
    }

    public int getCount() {
        return count;
    }

    public static ArrayList<Integer> getCusOrderList() {
        return cusOrderList;
    }
}
