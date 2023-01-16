public class Order {
    private String menuItem;
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

    public int orderTotalCost(){
        return (getAmountOfBurgers()*5 + getAmountOfSandwiches()*4 + getAmountOfFries()*5 + getAmountOfShakes()*6 + getAmountOfIceCreams()*3);
    }

}
