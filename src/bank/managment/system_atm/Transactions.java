package bank.managment.system_atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton exit, balanceenquery, pinchange, ministatment, fastcash, withdrawl, deposit, balanceEnquery ;
    String pinnumber;
    Transactions(String pinnumber){
        setLayout(null);
        this.pinnumber=pinnumber;
        
        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image2=image1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(image2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
           
        JLabel text=new JLabel("Please select your Transaction");
        text.setBounds(215, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        deposit= new JButton("Deposite");
        deposit.addActionListener(this);
        deposit.setBounds(170, 415, 150, 30);
        image.add(deposit);
        
        withdrawl= new JButton("cash Withdrawl");
        withdrawl.addActionListener(this);
        withdrawl.setBounds(355, 415, 150, 30);
        image.add(withdrawl);
        
        fastcash= new JButton("Fast cash");
        fastcash.addActionListener(this);
        fastcash.setBounds(170, 450, 150, 30);
        image.add(fastcash);
        
        ministatment= new JButton("Mini Statement");
        ministatment.addActionListener(this);
        ministatment.setBounds(355, 450, 150, 30);
        image.add(ministatment);
        
        pinchange= new JButton("Pin Change");
        pinchange.addActionListener(this);
        pinchange.setBounds(170, 485, 150, 30);
        image.add(pinchange);
        
        balanceEnquery= new JButton("Balance Enquiry");
        balanceEnquery.addActionListener(this);
        balanceEnquery.setBounds(355, 485, 150, 30);
        image.add(balanceEnquery);
        
        exit= new JButton("Exit");
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
            System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrowl(pinnumber).setVisible(true);
        }else if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource() == pinchange){
            setVisible(false);
            new PinChang(pinnumber).setVisible(true);
        }else if(ae.getSource() == ministatment){
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }else if(ae.getSource() == balanceEnquery){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Transactions("");
    }
}
