package bank.managment.system_atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton signin,signup,clear;
    JTextField cardtext;
    JPasswordField pintext;
    
    Login (){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(70, 30, 100, 100);
        add(l1);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text=new JLabel("Wellcom to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200, 60, 400, 40);
        add(text);
        
        JLabel cardno=new JLabel("Card No :");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(150, 180, 200, 35);
        add(cardno);
        
        cardtext=new JTextField();
        cardtext.setBounds(300,180,250,35);
        cardtext.setFont(new Font("Arial",Font.BOLD,18));
        add(cardtext);
        
        JLabel pin=new JLabel("PIN :");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(150, 250, 300, 35);
        add(pin);
        
        pintext=new JPasswordField();
        pintext.setBounds(300,250,250,35);
        pintext.setFont(new Font("Arial",Font.BOLD,18));
        add(pintext);
        
        signin = new JButton("SIGN IN");
        signin.setBounds(300,320,120,30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        add(signin);
        
        clear = new JButton("CLEAR");
        clear.setBounds(440,320,110,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300,370,250,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        setSize(800,500);
        setVisible(true);
        setLocation(350, 200);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardtext.setText("");
            pintext.setText("");
        }else if (ae.getSource() == signin){
            Conn con=new Conn();
            String cardnumber=cardtext.getText();
            String pinnumber=pintext.getText();
            String query="select * from login where Cardnumber = '"+cardnumber+"' and PIN = '"+pinnumber+"' ";
            try{
                ResultSet rs = con.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect CardNumber or PIN");
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }else if (ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
