/**
 * @Author: Jimmy Zheng
 * @3.0
 * Keeps track of order and customer information
 */
public class Order {
    private int cost;
    public static String menuItem;
    private int amountOfBurgers;
    private int amountOfSandwiches;
    private int amountOfFries;
    private int amountOfShakes;
    private int amountOfIceCreams;
    private boolean isBurger;
    private boolean isSandwich;
    private boolean isFries;
    private boolean isShakes;
    private boolean isIceCreams;
    public Order(){
        menuItem = "";
    }
    public void setAmountOfBurgers(){
        amountOfBurgers++;
        isBurger = true;
    }
    public int getAmountOfBurgers(){
        return amountOfBurgers;
    }
    public void setAmountOfSandwiches(){
        amountOfSandwiches++;
        isSandwich = true;
    }
    public int getAmountOfSandwiches(){
        return amountOfSandwiches;
    }
    public void setAmountOfFries(){
        amountOfFries++;
        isFries = true;
    }
    public int getAmountOfFries(){
        return amountOfFries;
    }
    public void setAmountOfShakes(){
        amountOfShakes++;
        isShakes = true;
    }
    public int getAmountOfShakes(){
        return amountOfShakes;
    }
    public void setAmountOfIceCreams(){
        amountOfIceCreams++;
        isIceCreams = true;
    }
    public int getAmountOfIceCreams(){
        return amountOfIceCreams;
    }

    public String wholeOrder(){
        if(isBurger){
            menuItem += "Burger " + getAmountOfBurgers() + "\n";
        }
        if(isSandwich){
            menuItem += "Sandwich " + getAmountOfSandwiches() + "\n";
        }
        if(isFries){
            menuItem += "Fries " + getAmountOfFries() + "\n";
        }
        if(isShakes){
            menuItem += "Shake " + getAmountOfShakes() + "\n";
        }
        if(isIceCreams){
            menuItem += "Ice Cream " + getAmountOfIceCreams() + "\n";
        }
        return menuItem;
    }
    public String toString(){
        return wholeOrder();
    }
    /**
     * @return cost of order
     */
    public int orderTotalCost(){
        int[] costArray = new int[5];
        costArray[0] = getAmountOfBurgers()*5;
        costArray[1] = getAmountOfSandwiches()*4;
        costArray[2] = getAmountOfFries()*5;
        costArray[3] = getAmountOfShakes()*6;
        costArray[4] = getAmountOfIceCreams()*3;
        int cost = 0;
        for(int i = 0; i<costArray.length; i++){
            cost+= costArray[i];
        }
        return (cost);
    }

    public int getCost(){
        return cost;
    }
}
