import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Arrays;

/**
 * @author Jimmy Zheng
 * @Version: 6.0
 * Creates an interactive Restaurant GUI window
 */
public class Restaurant extends JFrame{

    Order customerOrder = new Order();
    //window2
    static JFrame cartWindow = new JFrame("Cart");
    String[] customerName = new String[1];
    String[] customerCardInfo = new String[1];
    /**
     * Creates frame
     */
    public static void main(String[] args){
        new Restaurant();
    }
    JLabel menu, menumenu, directions, cardOnly, yourOrderIs, total, actualTotal, name, cardInformation, name2, cardInformation2;
    JTextField order;
    JButton addItem, Cart, back;

    /**
     * first frame
     * @version: 6.0
     */
    Restaurant(){
        //text-field
        order = new JTextField();
        order.setBounds(400,170,300,30);
        //labels
        menu = new JLabel("<html><br>Burger - 5<br><br>Sandwich - 4<br><br>Fries - 5<br><br>Shake - 6<br><br>Ice Cream - 3<br><br><br><html>");
        menu.setBounds(100,150,200,300);
        menu.setFont(new Font("Courier New", Font.PLAIN, 20));
        menumenu = new JLabel("<html><u>Menu</u></html>");
        menumenu.setBounds(130,10,200,300);
        menumenu.setFont(new Font("Courier New", Font.PLAIN, 24));
        directions = new JLabel("Enter what item you want:");
        directions.setFont(new Font("Courier New", Font.PLAIN, 20));
        directions.setBounds(402,135,500,50);
        cardOnly = new JLabel("Card Only");
        cardOnly.setFont(new Font("Courier New", Font.BOLD, 20));
        cardOnly.setBounds(350,30,300,30);
        JTextField nameTextField = new JTextField();
        JTextField cardInfoTextField = new JTextField();
        //button
        addItem = new JButton("Add Item");
        addItem.setBounds(500,200,100,30);
        /*
        @Pre-condition: Enter one of the menu items
        @Post-condition: Stores it in a list
         */
        addItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] foods = {"burger","sandwich","fries","shake","ice cream"};
                    if(Arrays.asList(foods).contains(order.getText().toLowerCase())){
                        if(order.getText().toLowerCase().contains("burger")){
                            customerOrder.setAmountOfBurgers();
                        }
                        if(order.getText().toLowerCase().contains("sandwich")){
                            customerOrder.setAmountOfSandwiches();
                        }
                        if(order.getText().toLowerCase().contains("fries")){
                            customerOrder.setAmountOfFries();
                        }
                        if(order.getText().toLowerCase().contains("shake")){
                            customerOrder.setAmountOfShakes();
                        }
                        if(order.getText().toLowerCase().contains("ice cream")){
                            customerOrder.setAmountOfIceCreams();
                        }
                        order.setText("");
                    }
                     else{
                        JOptionPane.showMessageDialog(null, "Please enter a menu item");
                    }

            }
        });

        //window1
        JFrame frame = new JFrame("Restaurant");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(850, 650));
        frame.pack();
        frame.add(order);
        frame.add(menu);
        frame.add(menumenu);
        frame.add(directions);
        frame.add(addItem);
        frame.add(cardOnly);
        frame.setLayout(null);
        Cart = new JButton("Cart");
        Cart.setBounds(355,525,120,50);
        frame.add(Cart);
        frame.setVisible(true);

        name = new JLabel("Name:");
        name.setFont(new Font("Courier New", Font.PLAIN, 20));
        name.setBounds(402,240,300,40);
        cardInformation = new JLabel("Card Number (16 digits):");
        cardInformation.setFont(new Font("Courier New", Font.PLAIN, 20));
        cardInformation.setBounds(402,300,300,40);
        frame.add(name);
        frame.add(cardInformation);
        nameTextField.setBounds(400,275,300,30);
        frame.add(nameTextField);
        cardInfoTextField.setBounds(400,335,300,30);
        frame.add(cardInfoTextField);
        Cart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerName[0] = nameTextField.getText();
                customerCardInfo[0] = cardInfoTextField.getText();
                frame.setVisible(false);
                cartWindow.setVisible(true);
                orderingLabel();
            }
        });

        cartWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cartWindow.setPreferredSize(new Dimension(850, 650));
        cartWindow.pack();
        cartWindow.setLayout(null);
        cartWindow.setVisible(false);

        //back button
        back = new JButton("Back");
        back.setBounds(355,525,120,50);
        cartWindow.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                cartWindow.setVisible(false);
            }
        });
    }

    private static String[] censored(String[] y){
        int j = 0;
        while(j<y.length-4){
            y[j]="X";
            j++;
        }
        return y;
    }

    //Your order is
    public void orderingLabel(){

        name2 = new JLabel("Name: " + customerName[0]);
        name2.setBounds(325,220,500,40);
        name2.setFont(new Font("Courier New", Font.PLAIN, 20));

        String[] cardInfoArray = new String[customerCardInfo[0].length()];
        for(int i = 0; i<cardInfoArray.length;i++){
            cardInfoArray[i]=customerCardInfo[0].substring(i,i+1);
        }
        StringBuilder builder = new StringBuilder();
        for(String s : censored(cardInfoArray)) { //enhanced for loop
            builder.append(s);
        }
        String str = builder.toString();

        cardInformation2 = new JLabel("Card Number: " + str);
        cardInformation2.setBounds(325,320,500,50);
        cardInformation2.setFont(new Font("Courier New", Font.PLAIN, 20));

        cartWindow.add(name2);
        cartWindow.add(cardInformation2);

        yourOrderIs = new JLabel("Your Order is:");
        yourOrderIs.setFont(new Font("Courier New", Font.PLAIN, 20));
        yourOrderIs.setBounds(330,-120,600,300);
        cartWindow.add(yourOrderIs);
        //actual customer order
        String x = customerOrder.wholeOrder();
        JTextArea entireOrder = new JTextArea(x);
        entireOrder.setBounds(35,60,775,120);
        entireOrder.setFont(new Font("Courier New", Font.PLAIN, 20));
        entireOrder.setLineWrap(true);
        entireOrder.setWrapStyleWord(true);
        entireOrder.setEditable(false);
        cartWindow.add(entireOrder);
        total = new JLabel("Total:");
        total.setFont(new Font("Courier New", Font.PLAIN, 20));
        total.setBounds(325,270,100,50);
        cartWindow.add(total);
        actualTotal = new JLabel("$"+ customerOrder.orderTotalCost());
        actualTotal.setFont(new Font("Courier New", Font.PLAIN, 20));
        actualTotal.setBounds(410,270,100,50);
        cartWindow.add(actualTotal);
        JButton placeOrder = new JButton("Place Order");
        placeOrder.setBounds(355,420,120,50);
        cartWindow.add(placeOrder);
        placeOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cartWindow.setVisible(false);
                JOptionPane.showMessageDialog(null, "Thank You For Your Purchase");
                cartWindow.dispatchEvent(new WindowEvent(cartWindow, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}