package bank.managment.system_atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancle;
    String formno;
    
    SignupThree(String formno){
        
        this.formno=formno;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD,22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);
        
        JLabel l2=new JLabel("Account Type");
        l2.setFont(new Font("Raleway", Font.BOLD,20));
        l2.setBounds(100, 140, 200, 40);
        add(l2);
        
        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(130, 180, 250, 40);
        add(r1);
        
        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(380, 180, 250, 40);
        add(r2);
        
        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(130, 215, 250, 40);
        add(r3);
        
        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(380, 215, 250, 40);
        add(r4);
        
        ButtonGroup acctype=new ButtonGroup();
        acctype.add(r1);
        acctype.add(r2);
        acctype.add(r3);
        acctype.add(r4);
        
        
        JLabel card=new JLabel("Card Number :");
        card.setFont(new Font("Raleway", Font.BOLD,18));
        card.setBounds(100, 270, 200, 40);
        add(card);
        
        JLabel carddetail=new JLabel("XXXX-XXXX-XXXX-4w18");
        carddetail.setFont(new Font("Raleway", Font.BOLD,18));
        carddetail.setBounds(300, 270, 400, 40);
        add(carddetail);
        
        JLabel cd=new JLabel("Your 16 Digit Card Number");
        cd.setFont(new Font("Raleway", Font.BOLD,12));
        cd.setBounds(300, 290, 200, 40);
        add(cd);
        
        JLabel pin=new JLabel("PIN :");
        pin.setFont(new Font("Raleway", Font.BOLD,18));
        pin.setBounds(100, 330, 200, 40);
        add(pin);
        
        JLabel pindetail=new JLabel("XXXX");
        pindetail.setFont(new Font("Raleway", Font.BOLD,18));
        pindetail.setBounds(300, 330, 100, 40);
        add(pindetail);
        
        JLabel pd=new JLabel("Your 4 Digit PIN");
        pd.setFont(new Font("Raleway", Font.BOLD,12));
        pd.setBounds(300, 350, 200, 30);
        add(pd);
        
        JLabel services=new JLabel("Services Required");
        services.setFont(new Font("Raleway", Font.BOLD,20));
        services.setBounds(100, 390, 400, 40);
        add(services);
        
        c1=new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(130, 440, 200, 20);
        add(c1);
        
        c2=new JCheckBox("Mobile Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(130, 480, 200, 20);
        add(c2);
        
        c3=new JCheckBox("Cheque Book");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(130, 520, 200, 20);
        add(c3);
        
        c4=new JCheckBox("Internet Banking");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(330, 440, 200, 20);
        add(c4);
        
        c5=new JCheckBox("E-mail & SMS Alert");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(330, 480, 200, 20);
        add(c5);
        
        c6=new JCheckBox("E-Statment");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(330, 520, 200, 20);
        add(c6);
        
        c7=new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowlage");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 14));
        c7.setBounds(100, 590, 800, 20);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Raleway", Font.BOLD,18));
        submit.setBounds(270, 630, 100, 30);
        add(submit);
        
        cancle = new JButton("Cancle");
        cancle.setBackground(Color.BLACK);
        cancle.setForeground(Color.WHITE);
        cancle.addActionListener(this);
        cancle.setFont(new Font("Raleway", Font.BOLD,18));
        cancle.setBounds(440, 630, 100, 30);
        add(cancle);
        
        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            String accounttype=null;
            if(r1.isSelected()){
                accounttype="Saving Account";
            }else if(r2.isSelected()){
                accounttype="Fixed Deposit Account";
            }else if(r3.isSelected()){
                accounttype="Current Account";
            }else if(r4.isSelected()){
                accounttype="Recurring Deposit Account";
            }
            
            Random random=new Random();
            String cardnumber = "8090564" + String.format("%09d", Math.abs(random.nextLong() % 1000000000L));
            String pinnumber = String.format("%04d", Math.abs(random.nextInt(10000)));
            
            String facility = "";
            if(c1.isSelected()){
                facility = facility + " ATM Card";
            }else if(c2.isSelected()){
                facility = facility + " Mobile Banking";
            }else if(c3.isSelected()){
                facility = facility + " Cheque Book";
            }else if(c4.isSelected()){
                facility = facility + " Internet Banking";
            }else if(c5.isSelected()){
                facility = facility + " E-mail & SMS Alert";
            }else if(c6.isSelected()){
                facility = facility + " E-Statment";
            }
            
            try{
                if(accounttype.equals("")){
                    JOptionPane.showMessageDialog(null, "AccountType is Requeired");
                }else {
                    Conn con=new Conn();
                    String query1="insert into signupThree values('" + formno + "', '" + accounttype + "', '" + cardnumber + "', '" + pinnumber + "', '" + facility + "')";
                    String query2="insert into login values('" + formno + "', '" + cardnumber + "', '" + pinnumber + "')";
                    con.s.executeUpdate(query1);
                    con.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\nPIN: " + pinnumber);
                    
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
        }else if(ae.getSource() == cancle){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new SignupThree("");
    }
}
