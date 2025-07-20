package atm.simulator.syatem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class Trans extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2;
    JButton l1,l2,l3, l4;
 
    String pin;

    Trans(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);

             setTitle("Label Position Example");
        setLayout(new FlowLayout());

        l1 = new JButton("Receiver");
        l1.setFont(new Font("System", Font.BOLD, 13));
        l1.setBackground(Color.WHITE);
        l1.setForeground(Color.BLACK);
        add(l1);

        l2 = new JButton("Amount");
        l2.setFont(new Font("System", Font.BOLD, 13));
        l2.setBackground(Color.WHITE);
        l2.setForeground(Color.BLACK);
        add(l2);

        // Set the position of l2 below l1 using FlowLayout
        setLayout(new FlowLayout(FlowLayout.LEFT));
          
 
 
//        l2 = new JButton("RECEIVER ID");
//        l2.setForeground(Color.WHITE);
//        l2.setFont(new Font("System", Font.BOLD, 16));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 16));

        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 16));

        b1 = new JButton("TRANSFER");
        b1.setFont(new Font("System", Font.BOLD, 16));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("BACK");
        b2.setFont(new Font("System", Font.BOLD, 16));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        setLayout(null);

     l1.setBounds(150, 389, 100, 35); // Adjusted x-position to place l1 next to t1

l2.setBounds(150, 454, 100, 35);

t1.setBounds(400, 389, 150, 35);
add(t1);

t2.setBounds(400, 454, 150, 35);
add(t2);

b1.setBounds(150, 633, 150, 35);
add(b1);

b2.setBounds(350, 633, 150, 35);
add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(960, 1080);
        setUndecorated(true);
        setLocation(500, 0);

        setVisible(true);
        //add(l1);
        add(l2);
        revalidate();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String receiverAccount = t1.getText();
            String amount = t2.getText();

            if (receiverAccount.equals("") || amount.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter both Receiver's Account No and Amount");
            } else {
                int confirmation = JOptionPane.showConfirmDialog(null,
                        "Do you really want to transfer Rs " + amount + " to Account No: " + receiverAccount + "?",
                        "Confirmation", JOptionPane.YES_NO_OPTION);

                if (confirmation == JOptionPane.YES_OPTION) {
                    try {
                        Conn c1 = new Conn();
                        ResultSet rs = c1.s.executeQuery("select * from transfer where pin = '" + pin + "'");
                        int balance = 0;
                        while (rs.next()) {
                            balance = Integer.parseInt(rs.getString("balance"));
                        }

                        int transferAmount = Integer.parseInt(amount);
                        if (balance >= transferAmount) {
                            // Deduct amount from sender's account
                            c1.s.executeUpdate("update bank set balance = balance - " + transferAmount + " where pin = '"
                                    + pin + "'");

                            // Update amount to receiver's account
                            c1.s.executeUpdate("update bank set balance = balance + " + transferAmount
                                    + " where accountno = '" + receiverAccount + "'");

                            JOptionPane.showMessageDialog(null, "Rs " + amount + " transferred successfully!");

                            setVisible(false);
                            new Transactions(pin).setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Insufficient balance!");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (ae.getSource() == b2) {
            
            new Transactions(pin).setVisible(true);
              setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Trans("").setVisible(true);
    }
}