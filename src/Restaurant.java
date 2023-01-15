import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Restaurant extends JFrame{
    Order customerOrder = new Order();
    //window2
    static JFrame checkoutWindow = new JFrame("Checkout");


    public static void main(String[] args){
        new Restaurant();
    }


    JLabel menu, menumenu, directions, cardOnly, yourOrderIs;
    JTextField order;
    JButton addItem, checkout, back;

    Restaurant(){


        //text-field
        order = new JTextField();
        order.setBounds(400,260,300,30);


        //labels
        menu = new JLabel("<html><br>Burger - 5<br><br>Sandwich - 4<br><br>Fries - 5<br><br>Shake - 6<br><br>Ice Cream - 3<br><br><br><html>");
        menu.setBounds(100,150,200,300);
        menu.setFont(new Font("Courier New", Font.PLAIN, 20));

        menumenu = new JLabel("<html><u>Menu</u></html>");
        menumenu.setBounds(130,10,200,300);
        menumenu.setFont(new Font("Courier New", Font.PLAIN, 24));

        directions = new JLabel("Enter what item you want:");
        directions.setFont(new Font("Courier New", Font.PLAIN, 20));
        directions.setBounds(402,190,500,50);

        cardOnly = new JLabel("Card Only");
        cardOnly.setFont(new Font("Courier New", Font.BOLD, 20));
        cardOnly.setBounds(350,30,300,30);

        //button
        addItem = new JButton("Add Item");
        addItem.setBounds(500,320,100,30);
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
        checkout = new JButton("Checkout");
        checkout.setBounds(355,525,120,50);
        frame.add(checkout);
        frame.setVisible(true);



        checkout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                checkoutWindow.setVisible(true);
                orderingLabel();
            }
        });

        checkoutWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        checkoutWindow.setPreferredSize(new Dimension(850, 650));
        checkoutWindow.pack();
        checkoutWindow.setLayout(null);
        checkoutWindow.setVisible(false);




        //back button
        back = new JButton("Back");
        back.setBounds(355,525,120,50);
        checkoutWindow.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                checkoutWindow.setVisible(false);
            }
        });
    }
    //Your order is
    public void orderingLabel(){
        yourOrderIs = new JLabel("Your Order is:");
        yourOrderIs.setFont(new Font("Courier New", Font.PLAIN, 20));
        yourOrderIs.setBounds(330,-120,600,300);
        checkoutWindow.add(yourOrderIs);
        //actual customer order
        String x = customerOrder.wholeOrder();
        JTextArea entireOrder = new JTextArea(x);
        entireOrder.setBounds(35,60,775,120);
        entireOrder.setFont(new Font("Courier New", Font.PLAIN, 20));
        entireOrder.setLineWrap(true);
        entireOrder.setWrapStyleWord(true);
        entireOrder.setEditable(false);
        checkoutWindow.add(entireOrder);
    }
}