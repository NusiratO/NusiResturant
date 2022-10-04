import java.util.ArrayList;

public class ListOfTable {
    //Properties
    private int numOfTables;
    private ArrayList<String> tableList = new ArrayList<String>(numOfTables);
 
    public ListOfTable() {
        numOfTables = 11;
    }

    /**
     * Purpose: Creates a list of new tables that are available to the user
     * @param None
     * @return None
     */
    public void newTable(){
        for(int i = 0; i <= numOfTables; i++){
            tableList.add(i, "Available");
        }

        tableList.remove(0);
    }

    /**
     * Purpose: Loops through the list of tables to find the matching table,
     *          sets that table from avaliable to unavailable. If table is not unavailable,
     *          it sends the user a message.
     * @param tableNum
     * @return None
     */
    public void reservedTable(int tableNum){
        for(int i = 1; i < tableList.size(); i++){
            if(i == tableNum){
                if(tableList.get(i).equals("Available")){
                    tableList.set(i, "Unavailable");
                    //create a new customize table for each table
                }
                else{
                    System.out.println("My apologizes, the table seems to be unavailable right now");
                }
            }
        }
    }

    
    public ArrayList<String> getTableList(){
        return tableList;
    }

}
