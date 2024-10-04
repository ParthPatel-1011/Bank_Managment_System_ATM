
package bank.managment.system_atm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    JButton back;
    String pinnumber;
    
    BalanceEnquiry(String pinnumber){
        setLayout(null);
        this.pinnumber=pinnumber;
        
        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image2=image1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(image2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        back= new JButton("BACK");
        back.addActionListener(this);
        back.setBounds(170, 520, 335, 30);
        image.add(back);
        
        int balance = 0;        
        try{
                Conn c=new Conn();               
                ResultSet rs=c.s.executeQuery("select * from bank where PIN = '"+pinnumber+"'");
                while (rs.next()) {
                    if(rs.getString("Type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("Amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("Amount"));
                    }
                }
        }catch(Exception e){
            System.out.println(e);
        }
        
        JLabel bal = new JLabel("Your Current Amount Balance is Rs " + balance);
        bal.setForeground(Color.WHITE);
        bal.setFont(new Font("System", Font.BOLD, 16));
        bal.setBounds(170, 320, 400, 30);
        image.add(bal);
        
        
        setSize(900,900);
        setLocation(300, 0);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
