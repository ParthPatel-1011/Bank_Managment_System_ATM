package bank.managment.system_atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton exit, balanceenquery, pinchange, ministatment, fastcash, withdrawl, deposit, balanceEnquery ;
    String pinnumber;
    FastCash(String pinnumber){
        setLayout(null);
        this.pinnumber=pinnumber;
        
        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image2=image1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(image2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
           
        JLabel text=new JLabel("Select Wthdrowal Amount");
        text.setBounds(215, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        deposit= new JButton("Rs 100");
        deposit.addActionListener(this);
        deposit.setBounds(170, 415, 150, 30);
        image.add(deposit);
        
        withdrawl= new JButton("Rs 500");
        withdrawl.addActionListener(this);
        withdrawl.setBounds(355, 415, 150, 30);
        image.add(withdrawl);
        
        fastcash= new JButton("Rs 1000");
        fastcash.addActionListener(this);
        fastcash.setBounds(170, 450, 150, 30);
        image.add(fastcash);
        
        ministatment= new JButton("Rs 2000");
        ministatment.addActionListener(this);
        ministatment.setBounds(355, 450, 150, 30);
        image.add(ministatment);
        
        pinchange= new JButton("Rs 5000");
        pinchange.addActionListener(this);
        pinchange.setBounds(170, 485, 150, 30);
        image.add(pinchange);
        
        balanceEnquery= new JButton("Rs 10000");
        balanceEnquery.addActionListener(this);
        balanceEnquery.setBounds(355, 485, 150, 30);
        image.add(balanceEnquery);
        
        exit= new JButton("BACK");
        exit.addActionListener(this);
        exit.setBounds(170, 520, 335, 30);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            String amount=((JButton)ae.getSource()).getText().substring(3);
            try{
                Conn c=new Conn();               
                ResultSet rs=c.s.executeQuery("select * from bank where PIN = '"+pinnumber+"'");
                int balance = 0;
                while (rs.next()) {
                    if(rs.getString("Type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("Amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("Amount"));
                    }
                }
                if(ae.getSource()!=exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date=new Date();
                String query="insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrow', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amount+" Withdrow Sucessfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String[] args) {
        new FastCash("");
    }
}
