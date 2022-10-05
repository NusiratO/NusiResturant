import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {
    private static Restaurant userTable = new Restaurant();
    private int count;
    private int cusOrderNum;
    private ArrayList<Integer> cusOrder = new ArrayList<Integer>(cusOrderNum);
    private static Table cusTable;
    private static Menu CusMenu = new Menu();


    public int getNewInt(int intInput, int min, int max){
        try (Scanner newScan = new Scanner(System.in)) {
            int newInput = intInput;
            while(!(newInput > min && newInput <= max)){
                System.out.println("Error!");
                System.out.println("Select between " + min + " and " + max);
                newInput = newScan.nextInt();
            }
            return newInput;
        }
    }

    public void menuList() throws FileNotFoundException {
        File menuFile = new File("menu.txt");
        try (Scanner menuItem = new Scanner(menuFile)) {
            while(menuItem.hasNextLine()) {
                System.out.println(menuItem.nextLine());
            }
        }
    }
    


    public void payingTableBill(String tableNum){
        double tableBill;
        for(int x = 1; x < ListOfTable.getTableList().size(); x++) {
            if(ListOfTable.getTableList().get(x).equals(tableNum)) {
                tableBill = cusTable.getBill() * 1.08;
                System.out.println("Table " + tableNum + " bill - $" + tableBill);

                try (Scanner scan6 = new Scanner(System.in)) {
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
                }
                ListOfTable.getTableList().set(x, "Avaliable");
                System.out.println("Table Number " + x + " - " + ListOfTable.getTableList().get(x));
            }
        }

    }


    public static void main(String[] args) throws FileNotFoundException {
        ListOfTable.newTable();
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
                for(int i = 1; i < ListOfTable.getTableList().size(); i++){
                    System.out.println("Table Number " + i + " - " + ListOfTable.getTableList().get(i));
                }

                Scanner scan = new Scanner(System.in);
                System.out.println("Select a table (Ex: 1 - 10): ");
                customerTableNum = userTable.getNewInt(scan.nextInt(), 1, 10);

                ListOfTable.reservedTable(customerTableNum);

                for(int i = 1; i < ListOfTable.getTableList().size(); i++){
                    System.out.println("Table Number " + i + " - " + ListOfTable.getTableList().get(i));
                }
            } //Table

            else if(request ==  2){
                Scanner newScan = new Scanner(System.in);
                System.out.println("Table number? ");
                int var10 = newScan.nextInt();
                for(int i = 1; i < ListOfTable.getTableList().size(); i++){
                    if(var10 == i && cusTable.isReserved().equals("Unavailable")){
                        if(CustomerTable.getCusList().size() == 0){
                            Scanner scan2 = new Scanner(System.in);
                            System.out.println("How many customers are joining the table? ");
                            numOfCus = scan2.nextInt();
                            userTable.getNewInt(numOfCus, 0, 10);
                            CustomerTable.newCustomer(numOfCus);

                            for(int x = 0; x < CustomerTable.getNumOfCustomer(); x++){
                                System.out.println("Customer " + CustomerTable.getCusList().get(x).getSeatNumber() + " - $" + CustomerTable.getCusList().get(x).getTotalCost());
                            }
                        }
                    }
                }
            } //Customer

            else if(request == 3){
                userTable.menuList();
                for(int i = 0; i < CustomerTable.getCusList().size(); i++) {
                    Scanner scan4 = new Scanner(System.in);
                    System.out.println("How many food choices is customer " + CustomerTable.getCusList().get(i).getSeatNumber() + " ordering? ");
                    int cusItemNum = scan4.nextInt();
                    CustomerTable.OrderCount(cusItemNum);
                    for (int x = 0; x < cusItemNum; x++) {
                        Scanner cusItem = new Scanner(System.in);
                        System.out.println("Select the food item number (Ex: 1 - 48): ");
                        int foodItemNum = cusItem.nextInt();
                        userTable.getNewInt(foodItemNum, 0, 48);
                        CustomerTable.getCusOrderList().set(i, foodItemNum);
                        CustomerTable.settingCusMenu(foodItemNum);
                        CustomerTable.addingTotalCost(i);
                    }
                    System.out.println("Customer " + CustomerTable.getCusList().get(i).getSeatNumber() + " bill is $" + CustomerTable.getCusList().get(i).getTotalCost());
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


