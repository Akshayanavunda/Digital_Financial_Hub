/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package atm.simulator.syatem;

import javax.swing.*;
import java.awt.*;

public class Transactions extends JFrame {
    Transactions(){
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        Jlabel image=new Jlabel(i3);
        
        add(image);
        setSize(900,900);
        setLocation(300,0);
        setVisible(True);
    }
    public Transactions(String pin) {
        setTitle("Transactions");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // You can add buttons, labels, etc. here later
    }
}