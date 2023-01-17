public class OrderList{
    private int orderCost;
    private Order or;
    public OrderList(Order o){
        this.or = o;
        this.orderCost = o.getCost();
    }
    Order[] orderorder = new Order[1];
    int length = orderorder.length;
    public Order getOrder(){
        for(int i = 0 ;i < length;i++){
           for(int x = 0; x < 1 ;x++){
               return or;
           }
        }
        return null;
    }
    public void addNothingToMenuItem(){
        Order.menuItem += "";
    }






}