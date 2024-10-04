package bank.managment.system_atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChang extends JFrame implements ActionListener{
    String pinnumber;
    JPasswordField npin,rnpin;
    JButton chang,back;
    
    PinChang(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text=new JLabel("CHANG YOUR PIN");
        text.setBounds(263, 290, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        JLabel pintext=new JLabel("Enter New PIN");
        pintext.setBounds(165, 330, 180, 25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        image.add(pintext);
        
        npin=new JPasswordField();
        npin.setBounds(330, 330, 180, 25);
        npin.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(npin);
        
        JLabel repintext=new JLabel("Re-Enter New PIN");
        repintext.setBounds(165, 370, 180, 25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        image.add(repintext);
        
        rnpin=new JPasswordField();
        rnpin.setBounds(330, 370, 180, 25);
        rnpin.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(rnpin);
        
        chang=new JButton("Chang");
        chang.setBounds(355, 485, 150, 30);
        chang.addActionListener(this);
        chang.setFont(new Font("System", Font.BOLD, 16));
        image.add(chang);
        
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
        }else if(ae.getSource() == chang){
            String newpin = npin.getText();
            
            if(newpin.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter New PIN");
                return;
            }
            if(rnpin.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please RE-Enter New PIN");
                return;
            }
            if (!npin.getText().equals(rnpin.getText())){
                JOptionPane.showMessageDialog(null, "Enter PIN does not Match");
                return;
            }
            if (newpin.length() != 4) {
                JOptionPane.showMessageDialog(null, "Please Enter Correct 4 Digit PIN");
                return;
            }
            
            try{
                Conn con=new Conn();
                String query1="update bank set PIN = '"+newpin+"' where PIN = '"+pinnumber+"'";
                con.s.executeUpdate(query1);
                String query2="update login set PIN = '"+newpin+"' where PIN = '"+pinnumber+"'";
                con.s.executeUpdate(query2);
                String query3="update signupThree set PIN = '"+newpin+"' where PIN = '"+pinnumber+"'";
                con.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN Chang Sucessfully");
                setVisible(false);
                new Transactions(newpin).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
            
        }
    }
    
    public static void main(String[] args) {
        new PinChang("").setVisible(true);
    }
}
