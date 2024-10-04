package bank.managment.system_atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton deposit,back;
    String pinnumber;
    
    Deposit(String pinnumber){
        setLayout(null);
        this.pinnumber=pinnumber;
        
        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image2=image1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(image2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text=new JLabel("Enter The Amount You Went To Deposit");
        text.setBounds(183, 300, 400, 20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        amount=new JTextField();
        amount.setBounds(183, 345, 305, 25);
        amount.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(amount);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(355, 485, 150, 30);
        deposit.addActionListener(this);
        deposit.setFont(new Font("System", Font.BOLD, 16));
        image.add(deposit);
        
        back=new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        back.setFont(new Font("System", Font.BOLD, 16));
        image.add(back);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else if(ae.getSource() == deposit){
            String number=amount.getText();
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter the amount you went to Deposit");
            }else{
                try{
                    Conn con=new Conn();
                    String query="insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+number+"')";
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+number+" Deposit Sucessfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        new Deposit("");
    }
}
