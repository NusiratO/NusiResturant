import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {
    private static Restaurant userTable = new Restaurant();
    private int numOfTables;
    private ArrayList<String> tableList = new ArrayList<String>(numOfTables);
    private int numOfCustomer;
    private ArrayList<Customer> CusList = new ArrayList<Customer>(numOfCustomer + 1);
    private int count;
    private ArrayList<Integer> cusOrderList = new ArrayList<Integer>(count);
    private int cusOrderNum;
    private ArrayList<Integer> cusOrder = new ArrayList<Integer>(cusOrderNum);
    private static Table cusTable;
    private static Menu CusMenu = new Menu();



    public Restaurant() {
        //Properties should not touch other methods
        numOfTables = 11;
        numOfCustomer = 0;
        count = 0;
        cusOrderNum = 0;
    }

    public void newTable(){
        for(int i = 0; i <= numOfTables; i++){
            tableList.add(i, "Free");
        }

        tableList.remove(0);
    }

    public ArrayList<String> getTableList() {
        return tableList;
    }

    public void reservedTable(int tableNum){
        for(int i = 1; i < userTable.getTableList().size(); i++){
            if(i == tableNum){
                if(userTable.getTableList().get(i).equals("Free")){
                    userTable.getTableList().set(i, "Reserved");
                    cusTable = new Table(tableNum, "Reserved");
                }
                else{
                    System.out.println("Sorry, it seems that the table has been reserved.");
                }
            }
        }
    }

    public void newCustomer(int num){
        numOfCustomer = num;
        for(int i = 0; i <= numOfCustomer; i++){
            Customer seatNum = new Customer(i);
            CusList.add(seatNum);
        }
        CusList.remove(0);
    }

    public int getNumOfCustomer() {
        return numOfCustomer;
    }

    public ArrayList<Customer> getCusList() {
        return CusList;
    }

    public void OrderCount(int cusOrderCount){
        count = cusOrderCount;
        for(int i = 0; i <= count; i++){
            cusOrderList.add(i);
        }
    }

    public int getCount() {
        return count;
    }

    public ArrayList<Integer> getCusOrderList() {
        return cusOrderList;
    }


    public int getNewInt(int intInput, int min, int max){
        Scanner newScan = new Scanner(System.in);
        int newInput = intInput;
        while(!(newInput > min && newInput <= max)){
            System.out.println("Error!");
            System.out.println("Select between " + min + " and " + max);
            newInput = newScan.nextInt();
        }
        return newInput;
    }

    public void menuList() throws FileNotFoundException {
        File menuFile = new File("menu.txt");
        Scanner menuItem = new Scanner(menuFile);

        while(menuItem.hasNextLine()) {
            System.out.println(menuItem.nextLine());
        }
    }

    

    public double addingTotalCost(int cusList){
        double cusTotal = 0.0;
            for (int x = 1; x < userTable.getCusOrderList().size(); x++) {
                if (userTable.getCusOrderList().get(x) > 0 && userTable.getCusOrderList().get(x) <= 9) {
                    CusMenu.Appetizer(userTable.getCusOrderList().get(x));
                    double var3 = CusMenu.getCost();
                    cusTotal = cusTotal + var3;
                    userTable.getCusList().get(cusList).addTotalCost(var3);
                }
                else if (userTable.getCusOrderList().get(x) > 9 && userTable.getCusOrderList().get(x) <= 20) {
                    CusMenu.MainCourse(userTable.getCusOrderList().get(x));
                    double var3 = CusMenu.getCost();
                    cusTotal = cusTotal + var3;
                    userTable.getCusList().get(cusList).addTotalCost(var3);
                }
                else if (userTable.getCusOrderList().get(x) > 20 && userTable.getCusOrderList().get(x) <= 32) {
                    CusMenu.Dessert(userTable.getCusOrderList().get(x));
                    double var3 = CusMenu.getCost();
                    cusTotal = cusTotal + var3;
                    userTable.getCusList().get(cusList).addTotalCost(var3);
                }
                else if (userTable.getCusOrderList().get(x) > 32 && userTable.getCusOrderList().get(x) <= 48) {
                    CusMenu.Drinks(userTable.getCusOrderList().get(x));
                    double var3 = CusMenu.getCost();
                    cusTotal = cusTotal + var3;
                    userTable.getCusList().get(cusList).addTotalCost(var3);
                }

            }
        return cusTotal;
    }


    public void payingTableBill(String tableNum){
        double tableBill;
        for(int x = 1; x < userTable.getTableList().size(); x++) {
            if(userTable.getTableList().get(x).equals(tableNum)) {
                tableBill = cusTable.getBill() * 1.08;
                System.out.println("Table " + tableNum + " bill - $" + tableBill);

                Scanner scan6 = new Scanner(System.in);
                System.out.println("Table payment amount: ");
                double tablePayment = scan6.nextDouble();
                while (tablePayment < 0.00) {
                    System.out.println("Error!");
                    System.out.println("Table payment amount: ");
                    tablePayment = scan6.nextDouble();
                }
                double billPaid = tableBill - tablePayment;
                System.out.println("Your table balance now is $" + billPaid);
                while (!(billPaid <= 0.00)) {
                    System.out.println("Remaining balance!");
                    System.out.println("Table payment amount: ");
                    tablePayment = scan6.nextDouble();
                    billPaid = billPaid - tablePayment;
                }
                System.out.println("Table balance now is $" + billPaid);

                userTable.getTableList().set(x, "Free");
                System.out.println("Table Number " + x + " - " + userTable.getTableList().get(x));
            }
        }

    }


    public static void main(String[] args) throws FileNotFoundException {
        userTable.newTable();
        int request = 0;
        int customerTableNum;
        int numOfCus = 0; //Write the TestSweep


        while(request > -1 && request <= 4){
            Scanner requestScan = new Scanner(System.in);
            System.out.println("\nServer's Restaurant Screen");
            System.out.println("  1. Table");
            System.out.println("  2. Add Customer");
            System.out.println("  3. Take Order");
            System.out.println("  4. Bill");
            System.out.println("\nSelect a option or enter 0 to end: ");
            request = userTable.getNewInt(requestScan.nextInt(), -1, 4);


            if(request == 1){
                for(int i = 1; i < userTable.getTableList().size(); i++){
                    System.out.println("Table Number " + i + " - " + userTable.getTableList().get(i));
                }

                Scanner scan = new Scanner(System.in);
                System.out.println("Select a table (Ex: 1 - 10): ");
                customerTableNum = userTable.getNewInt(scan.nextInt(), 1, 10);

                userTable.reservedTable(customerTableNum);

                for(int i = 1; i < userTable.getTableList().size(); i++){
                    System.out.println("Table Number " + i + " - " + userTable.getTableList().get(i));
                }
            } //Table

            else if(request ==  2){
                Scanner newScan = new Scanner(System.in);
                System.out.println("Table number? ");
                int var10 = newScan.nextInt();
                for(int i = 1; i < userTable.getTableList().size(); i++){
                    if(var10 == i && cusTable.isReserved().equals("Reserved")){
                        if(userTable.getCusList().size() == 0){
                            Scanner scan2 = new Scanner(System.in);
                            System.out.println("How many customers are joining the table? ");
                            numOfCus = scan2.nextInt();
                            userTable.getNewInt(numOfCus, 0, 10);
                            userTable.newCustomer(numOfCus);

                            for(int x = 0; x < userTable.getNumOfCustomer(); x++){
                                System.out.println("Customer " + userTable.getCusList().get(x).getSeatNumber() + " - $" + userTable.getCusList().get(x).getTotalCost());
                            }
                        }
                    }
                }
            } //Customer

            else if(request == 3){
                userTable.menuList();
                for(int i = 0; i < userTable.getCusList().size(); i++) {
                    Scanner scan4 = new Scanner(System.in);
                    System.out.println("How many food choices is customer " + userTable.getCusList().get(i).getSeatNumber() + " ordering? ");
                    int cusItemNum = scan4.nextInt();
                    userTable.OrderCount(cusItemNum);
                    for (int x = 0; x < cusItemNum; x++) {
                        Scanner cusItem = new Scanner(System.in);
                        System.out.println("Select the food item number (Ex: 1 - 48): ");
                        int foodItemNum = cusItem.nextInt();
                        userTable.getNewInt(foodItemNum, 0, 48);
                        userTable.getCusOrderList().set(i, foodItemNum);
                        userTable.settingCusMenu(foodItemNum);
                        userTable.addingTotalCost(i);
                    }
                    System.out.println("Customer " + userTable.getCusList().get(i).getSeatNumber() + " bill is $" + userTable.getCusList().get(i).getTotalCost());
                }
                } //Menu

            else if(request == 4){
                Scanner newScan = new Scanner(System.in);
                System.out.println("Table number? ");
                int var10 = userTable.getNewInt(newScan.nextInt(), 1, 10);
                String var11 = Integer.toString(var10);
                userTable.payingTableBill(var11);
            }//Bill
        }
        Scanner requestScan = new Scanner(System.in);
        System.out.println("\nServer's Restaurant Screen");
        System.out.println("  1. Table");
        System.out.println("  2. Add Customer");
        System.out.println("  3. Take Order");
        System.out.println("  4. Bill");
        System.out.println("\nSelect a option or enter 0 to end: ");
        request = requestScan.nextInt();

        while(request > 4){
            System.out.println("Error!");
            System.out.println("Select a option or enter 0 to end: ");
            request = requestScan.nextInt();
        }

    }

    public int getCusOrderNum() {
        return cusOrderNum;
    }

    public ArrayList<Integer> getCusOrder() {
        return cusOrder;
    }
}


