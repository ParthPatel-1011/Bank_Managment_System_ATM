package bank.managment.system_atm;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField nametext,fnametext,emailtext,citytext,statetext,pincodetext,addresstext;
    JButton next;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser datech;
    
    SignupOne(){
                
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        Random ran=new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000);
        
        JLabel formno=new JLabel("APPLICATION FORM NO. "+random);
        formno.setFont(new Font("Raleway", Font.BOLD,38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel personalDetail=new JLabel("Page 1: Personal Detaails");
        personalDetail.setFont(new Font("Raleway", Font.BOLD,22));
        personalDetail.setBounds(300, 80, 400, 20);
        add(personalDetail);
        
        JLabel name=new JLabel("Name :");
        name.setFont(new Font("Raleway", Font.BOLD,20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        nametext=new JTextField();
        nametext.setBounds(300, 140, 400, 30);
        nametext.setFont(new Font("Aril",Font.BOLD,16));
        add(nametext);
        
        JLabel fname=new JLabel("Father's Name :");
        fname.setFont(new Font("Raleway", Font.BOLD,20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        fnametext=new JTextField();
        fnametext.setFont(new Font("Aril",Font.BOLD,16));
        fnametext.setBounds(300, 190, 400, 30);
        add(fnametext);
        
        JLabel dob=new JLabel("Date Of Birth :");
        dob.setFont(new Font("Raleway", Font.BOLD,20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        datech=new JDateChooser();
        datech.setBounds(300, 240, 400, 30);
        datech.setForeground(Color.BLACK);
        add(datech);
        
        JLabel gender=new JLabel("Gender :");
        gender.setFont(new Font("Raleway", Font.BOLD,20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 100, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female= new JRadioButton("Female");
        female.setBounds(450, 290, 100, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        
        JLabel email=new JLabel("Email Address :");
        email.setFont(new Font("Raleway", Font.BOLD,20));
        email.setBounds(100, 340, 200, 30);
        add(email);
        
        emailtext=new JTextField();
        emailtext.setFont(new Font("Aril",Font.BOLD,16));
        emailtext.setBounds(300, 340, 400, 30);
        add(emailtext);
        
        JLabel marital=new JLabel("Marital Status :");
        marital.setFont(new Font("Raleway", Font.BOLD,20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBounds(600, 390, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
        
        JLabel address=new JLabel("Address :");
        address.setFont(new Font("Raleway", Font.BOLD,20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        addresstext=new JTextField();
        addresstext.setFont(new Font("Aril",Font.BOLD,16));
        addresstext.setBounds(300, 440, 400, 30);
        add(addresstext);
        
        JLabel city=new JLabel("City :");
        city.setFont(new Font("Raleway", Font.BOLD,20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        citytext=new JTextField();
        citytext.setFont(new Font("Aril",Font.BOLD,16));
        citytext.setBounds(300, 490, 400, 30);
        add(citytext);
        
        JLabel state=new JLabel("State :");
        state.setFont(new Font("Raleway", Font.BOLD,20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        statetext=new JTextField();
        statetext.setFont(new Font("Aril",Font.BOLD,16));
        statetext.setBounds(300, 540, 400, 30);
        add(statetext);
        
        JLabel pincode=new JLabel("Pin Code :");
        pincode.setFont(new Font("Raleway", Font.BOLD,20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        pincodetext=new JTextField();
        pincodetext.setFont(new Font("Aril",Font.BOLD,16));
        pincodetext.setBounds(300, 590, 400, 30);
        add(pincodetext);
        
        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno=""+random;
        String name=nametext.getText();
        String fname=fnametext.getText();
        String dob=((JTextField) datech.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }else if (female.isSelected()){
            gender="Female";
        }
        String email=emailtext.getText();
        String marital=null;
        if(married.isSelected()){
            marital="Married";
        }else if(unmarried.isSelected()){
            marital="Unmarried";
        }else if(other.isSelected()){
            marital="Other";
        }
        String address=addresstext.getText();
        String city=citytext.getText();
        String state=statetext.getText();
        String pin=pincodetext.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }else{
                Conn c=new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public static void main(String[] args) {
        new SignupOne();
    }
}
