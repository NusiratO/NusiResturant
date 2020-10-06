public class TestFunctions {

    public static void main(String[] args) {
        System.out.println("------Testing the Table Class------");
        for(int i = 1; i <= 20; i++) {
            Table table1 = new Table(i, "Reserved");
            System.out.println("Should print out table " + i + ": " + table1.getTableNumber());
            System.out.println("Should print out Reserved: " + table1.isReserved());
            System.out.println("Should print out 0.0: " + table1.getBill());
            table1.calculateBill(100.0);
            System.out.println("Should print out 100.0: " + table1.getBill());
            System.out.println("-----");
        }

        System.out.println();
        System.out.println("------Testing the Customer Class------");
        for(int i = 1; i <= 5; i++) {
            Customer testCustomer = new Customer(i);
            System.out.println("Should print out seat number " + i + ": " + testCustomer.getSeatNumber());
            System.out.println("Should print out 0.0: " + testCustomer.getTotalCost());
            testCustomer.addTotalCost(5.99);
            System.out.println("Should print out 5.99: " + testCustomer.getTotalCost());
            testCustomer.addTotalCost(6.89 + 2.00);
            System.out.println("Should print out 14.88: " + testCustomer.getTotalCost());
            testCustomer.addTotalCost(0.00);
            System.out.println("Should print out 14.88: " + testCustomer.getTotalCost());
            System.out.println("-----");
        }

        System.out.println();
        System.out.println("------Testing the Menu Class------");
        Menu testMenu = new Menu();
        System.out.println("Should print out 0.0: " + testMenu.getCost());
        for(int i = 1; i <= 9; i++){
            testMenu.Appetizer(i);
            System.out.println("Appetizer " + i + " is - " + testMenu.getFoodItem());
            System.out.println("The cost of this item is " + testMenu.getCost());
            System.out.println("-----");
        }

        for(int i = 11; i <= 20; i++){
            testMenu.MainCourse(i);
            System.out.println("Main Course " + i + " is - " + testMenu.getFoodItem());
            System.out.println("The cost of this item is " + testMenu.getCost());
            System.out.println("-----");
        }

        for(int i = 21; i <= 32; i++){
            testMenu.Dessert(i);
            System.out.println("Dessert " + i + " is - " + testMenu.getFoodItem());
            System.out.println("The cost of this item is " + testMenu.getCost());
            System.out.println("-----");
        }

        for(int i = 33; i <= 48; i++){
            testMenu.Drinks(i);
            System.out.println("Drinks " + i + " is - " + testMenu.getFoodItem());
            System.out.println("The cost of this item is " + testMenu.getCost());
            System.out.println("-----");
        }
    }
}
