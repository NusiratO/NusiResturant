public class Menu {

    //Properties:
    private String foodItem;
    private double Cost;

    public Menu(){
        Cost = 0.0;
    }

    public void Appetizer(int foodNum){
        if(foodNum == 1){
            foodItem = "Wings";
            Cost = 10.00;
        }
        else if(foodNum == 2){
            foodItem = "Crab Cakes";
            Cost = 15.89;
        }
        else if(foodNum == 3){
            foodItem = "Chip & Dip";
            Cost = 9.89;
        }
        else if(foodNum == 4){
            foodItem = "Mozzarella Sticks";
            Cost = 8.99;
        }
        else if(foodNum == 5){
            foodItem = "Onion Rings";
            Cost = 8.99;
        }
        else if(foodNum == 6){
            foodItem = "Meatballs";
            Cost = 9.99;
        }
        else if(foodNum == 7){
            foodItem = "Boneless Wings";
            Cost = 11.99;
        }
        else if(foodNum == 8){
            foodItem = "Wonton Tacos";
            Cost = 13.99;
        }
        else if(foodNum == 9){
            foodItem = "Chicken Tenders";
            Cost = 9.99;
        }
    }

    public void MainCourse(int foodNum){
        if(foodNum == 11){
            foodItem = "Classic Burger";
            Cost = 14.99;
        }
        else if(foodNum == 12){
            foodItem = "Bourbon Street Steak";
            Cost = 20.89;
        }
        else if(foodNum == 13){
            foodItem = "Baby Back Ribs";
            Cost = 28.89;
        }
        else if(foodNum == 14){
            foodItem = "Chicken Parmesan";
            Cost = 22.99;
        }
        else if(foodNum == 15){
            foodItem = "Grilled Chicken";
            Cost = 21.89;
        }
        else if(foodNum == 16){
            foodItem = "Shrimp & Fries";
            Cost = 25.89;
        }
        else if(foodNum == 17){
            foodItem = "Chicken Alfredo";
            Cost = 22.99;
        }
        else if(foodNum == 18){
            foodItem = "Shrimp Alfredo";
            Cost = 25.99;
        }
        else if(foodNum == 19){
            foodItem = "Chicken Caesar Salad";
            Cost = 26.89;
        }
        else if(foodNum == 20){
            foodItem = "Regular Salad";
            Cost = 22.89;
        }
    }

    public void Dessert(int foodNum){
        if(foodNum == 21){
            foodItem = "Fudge Brownies";
            Cost = 10.99;
        }
        else if(foodNum == 22){
            foodItem = "Chocolate Meltdown";
            Cost = 13.89;
        }
        else if(foodNum == 23){
            foodItem = "Chocolate Cup Cookie Sundae";
            Cost = 14.99;
        }
        else if(foodNum == 24){
            foodItem = "Lava Cake";
            Cost = 11.99;
        }
        else if(foodNum == 25){
            foodItem = "Red Velvet Cake";
            Cost = 12.99;
        }
        else if(foodNum == 26){
            foodItem = "Vanilla Cake";
            Cost = 10.89;
        }
        else if(foodNum == 27){
            foodItem = "Blue Velvet Cake";
            Cost = 13.89;
        }
        else if(foodNum == 28){
            foodItem = "Confetti Cake";
            Cost = 14.89;
        }
        else if(foodNum == 29){
            foodItem = "Cheesecake";
            Cost = 14.99;
        }
        else if(foodNum == 30){
            foodItem = "BJ's Pizzoke";
            Cost = 14.89;
        }
        else if(foodNum == 31){
            foodItem = "Cinnamon Sugar Pretzel Bites";
            Cost = 13.89;
        }
        else if(foodNum == 32){
            foodItem = "Skillet Blood Brownie";
            Cost = 11.89;
        }
    }

    public void Drinks(int foodNum){
        if(foodNum == 33){
            foodItem = "Mango Ice Tea";
            Cost = 9.99;
        }
        else if(foodNum == 34){
            foodItem = "Peach Ice Tea";
            Cost = 9.99;
        }
        else if(foodNum == 35){
            foodItem = "Sweetened Ice Tea";
            Cost = 8.99;
        }
        else if(foodNum == 36){
            foodItem = "Unsweetened Ice Tea";
            Cost = 6.99;
        }
        else if(foodNum == 37){
            foodItem = "Swirled Strawberry Lemonade";
            Cost = 11.89;
        }
        else if(foodNum == 38){
            foodItem = "Swirled Wildberry Lemonade";
            Cost = 13.89;
        }
        else if(foodNum == 39){
            foodItem = "Sprite";
            Cost = 5.89;
        }
        else if(foodNum == 40){
            foodItem = "Coca Cola";
            Cost = 5.89;
        }
        else if(foodNum == 41){
            foodItem = "Diet Coke";
            Cost = 5.89;
        }
        else if(foodNum == 42){
            foodItem = "Mist";
            Cost = 5.89;
        }
        else if(foodNum == 43){
            foodItem = "Orange Soda";
            Cost = 5.89;
        }
        else if(foodNum == 44){
            foodItem = "Tropical Sprite";
            Cost = 5.89;
        }
        else if(foodNum == 45){
            foodItem = "Pepsi";
            Cost = 5.89;
        }
        else if(foodNum == 46){
            foodItem = "Water";
            Cost = 0.00;
        }
        else if(foodNum == 47){
            foodItem = "Oreo Shake";
            Cost = 9.89;
        }
        else if(foodNum == 48){
            foodItem = "Surprise Shake";
            Cost = 10.99;
        }
    }


    public String getFoodItem() {
        return foodItem;
    }

    public double getCost() {
        return Cost;
    }
}
