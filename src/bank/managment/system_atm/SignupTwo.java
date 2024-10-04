package bank.managment.system_atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    JTextField pan,adhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox income,education,occupation,Religion,category;
    String formno;
    
    SignupTwo(String formno){
                
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        this.formno=formno;
        
        JLabel aadditionalDetails=new JLabel("Page 2: Additional Detaails");
        aadditionalDetails.setFont(new Font("Raleway", Font.BOLD,22));
        aadditionalDetails.setBounds(300, 80, 400, 20);
        add(aadditionalDetails);
        
        JLabel name=new JLabel("Religion :");
        name.setFont(new Font("Raleway", Font.BOLD,20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        String valRegion[] = {"Hindu","Muslim","Sikh","Chiristian","Jain","Other"};
        Religion = new JComboBox(valRegion);
        Religion.setFont(new Font("Aril",Font.BOLD,14));
        Religion.setBackground(Color.WHITE);
        Religion.setBounds(300, 140, 400, 30);
        add(Religion);
        
        JLabel fname=new JLabel("Category :");
        fname.setFont(new Font("Raleway", Font.BOLD,20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        String valCategory[]={"General","General-EWS","OBC","ST","SC","Other"};
        category=new JComboBox(valCategory);
        category.setFont(new Font("Aril",Font.BOLD,16));
        category.setBackground(Color.WHITE);
        category.setBounds(300, 190, 400, 30);
        add(category);        
        
        JLabel dob=new JLabel("Income :");
        dob.setFont(new Font("Raleway", Font.BOLD,20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        String valincome[]={"Null","< 1,50,000","< 2,50,000","< 5,00,000","UpTo 10,00,000"};
        income=new JComboBox(valincome);
        income.setFont(new Font("Aril",Font.BOLD,16));
        income.setBackground(Color.WHITE);
        income.setBounds(300, 240, 400, 30);
        add(income); 
        
        JLabel gender=new JLabel("Educational /");
        gender.setFont(new Font("Raleway", Font.BOLD,20));
        gender.setBounds(100, 310, 200, 30);
        add(gender);
        
        JLabel email=new JLabel("Qulification :");
        email.setFont(new Font("Raleway", Font.BOLD,20));
        email.setBounds(100, 340, 200, 30);
        add(email);
        
        String educationvalue[]={"Non-Graduation","Graduat","Post-Graduation","Doctrat","Other"};
        education=new JComboBox(educationvalue);
        education.setFont(new Font("Aril",Font.BOLD,16));
        education.setBackground(Color.WHITE);
        education.setBounds(300, 340, 400, 30);
        add(education);
        
        JLabel marital=new JLabel("Occupation :");
        marital.setFont(new Font("Raleway", Font.BOLD,20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        
        String occupationvalue[]={"Salaried","Self-Employed","Bussness","Student","Retired","Other"};
        occupation=new JComboBox(occupationvalue);
        occupation.setFont(new Font("Aril",Font.BOLD,16));
        occupation.setBackground(Color.WHITE);
        occupation.setBounds(300, 390, 400, 30);
        add(occupation);       
        
        JLabel address=new JLabel("Pan Number :");
        address.setFont(new Font("Raleway", Font.BOLD,20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        pan=new JTextField();
        pan.setFont(new Font("Aril",Font.BOLD,16));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
        
        JLabel city=new JLabel("Adhar Number :");
        city.setFont(new Font("Raleway", Font.BOLD,20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        adhar=new JTextField();
        adhar.setFont(new Font("Aril",Font.BOLD,16));
        adhar.setBounds(300, 490, 400, 30);
        add(adhar);
        
        JLabel state=new JLabel("Senior Citizen :");
        state.setFont(new Font("Raleway", Font.BOLD,20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        syes=new JRadioButton("Yes");
        syes.setFont(new Font("Aril", Font.BOLD,16));
        syes.setBackground(Color.WHITE);
        syes.setBounds(300, 540, 200, 30);
        add(syes);
        
        sno=new JRadioButton("No");
        sno.setFont(new Font("Aril", Font.BOLD,16));
        sno.setBackground(Color.WHITE);
        sno.setBounds(500, 540, 200, 30);        
        add(sno);
        
        ButtonGroup sitizan = new ButtonGroup();
        sitizan.add(syes);
        sitizan.add(sno);
        
        JLabel pincode=new JLabel("Exisiting Account :");
        pincode.setFont(new Font("Raleway", Font.BOLD,20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        eyes=new JRadioButton("Yes");
        eyes.setFont(new Font("Aril", Font.BOLD,16));
        eyes.setBackground(Color.WHITE);
        eyes.setBounds(300, 590, 200, 30);
        add(eyes);
        
        eno=new JRadioButton("No");
        eno.setFont(new Font("Aril", Font.BOLD,16));
        eno.setBackground(Color.WHITE);
        eno.setBounds(500, 590, 200, 30);        
        add(eno);
        
        ButtonGroup acc = new ButtonGroup();
        acc.add(eyes);
        acc.add(eno);
        
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
        String sreligion=(String)Religion.getSelectedItem();
        String scategory=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String span=pan.getText();
        String saadhar=adhar.getText();
        
        String scitizen=null;
        if(syes.isSelected()){
            scitizen="YES";
        }else if(sno.isSelected()){
            scitizen="NO";
        }
        String eaccount=null;
        if(eyes.isSelected()){
            eaccount="YES";
        }else if(eno.isSelected()){
            eaccount="NO";
        }
        
        try{
            if(pan.equals("") || adhar.equals("")){
                JOptionPane.showMessageDialog(null, "Value is Missing");
            }else{
                Conn c=new Conn();
                String query = "INSERT INTO signuptwo VALUES ('" + formno + "', '" + sreligion + "', '" + scategory + "', '" + sincome + "', '" + seducation + "', '" + soccupation + "', '" + span + "', '" + saadhar + "', '" + scitizen + "', '" + eaccount + "')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public static void main(String[] args) {
        new SignupTwo("");
    }
}
