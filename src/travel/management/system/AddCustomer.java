package travel.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener{
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    Choice c1;
    JButton b1,b2;
    JRadioButton r1,r2;
    String username;
    
    AddCustomer(String username){
        setBounds(400,200,600,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel label = new JLabel("Add Customer Details");
        label.setBounds(160,0,350,25);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        add(label);
        
        l1 = new JLabel("Username");
        l1.setBounds(20,30,100,25);
        l1.setFont(new Font("Tahoma",Font.BOLD,14));
        add(l1);
        
        t1 = new JTextField();
        t1.setBounds(150,30,150,20);
        add(t1);
        
        l2 = new JLabel("ID");
        l2.setBounds(20,60,100,25);
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
        add(l2);
        
        c1 = new Choice();
        c1.add("Passport");
        c1.add("Voter ID");
        c1.add("Bank Statement");
        c1.setBounds(150,60,150,20);
        add(c1);
        
        l3 = new JLabel("Number");
        l3.setBounds(20,90,100,25);
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        add(l3);
        
        t2 = new JTextField();
        t2.setBounds(150,90,150,20);
        add(t2);
        
        l4 = new JLabel("Name");
        l4.setBounds(20,120,100,25);
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
        add(l4);
        
        t3 = new JTextField();
        t3.setBounds(150,120,150,20);
        add(t3);
        
        l5 = new JLabel("Gender");
        l5.setBounds(20,150,100,25);
        l5.setFont(new Font("Tahoma",Font.BOLD,14));
        add(l5);
        
        r1 = new JRadioButton("Male");
        r1.setBackground(Color.WHITE);
        r1.setBounds(150,150,60,25);
        add(r1);
        
        r2 = new JRadioButton("Female");
        r2.setBackground(Color.WHITE);
        r2.setBounds(210,150,100,25);
        add(r2);
        
        l6 = new JLabel("Country");
        l6.setBounds(20,180,100,25);
        l6.setFont(new Font("Tahoma",Font.BOLD,14));
        add(l6);
        
        t4 = new JTextField();
        t4.setBounds(150,180,150,20);
        add(t4);
        
        l7 = new JLabel("Address");
        l7.setBounds(20,210,100,25);
        l7.setFont(new Font("Tahoma",Font.BOLD,14));
        add(l7);
        
        t5 = new JTextField();
        t5.setBounds(150,210,150,20);
        add(t5);
        
        l8 = new JLabel("Phone");
        l8.setBounds(20,240,100,25);
        l8.setFont(new Font("Tahoma",Font.BOLD,14));
        add(l8);
        
        t6 = new JTextField();
        t6.setBounds(150,240,150,20);
        add(t6);
        
        l9 = new JLabel("Email");
        l9.setBounds(20,270,100,25);
        l9.setFont(new Font("Tahoma",Font.BOLD,14));
        add(l9);
        
        t7 = new JTextField();
        t7.setBounds(150,270,150,20);
        add(t7);
        
        
        ImageIcon img1 = new ImageIcon(ClassLoader.
                getSystemResource("travel/management/system/icons/newcustomer.jpg"));
        Image img2 = img1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        
        JLabel label1 = new JLabel(img3);
        label1.setBounds(250,0,400,380);
        add(label1);
        
        b1 = new JButton("Add");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(40,320,80,25);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(170,320,80,25);
        b2.addActionListener(this);
        add(b2);
        
        System.out.println(username);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM ACCOUNT WHERE username = '"+username+"'");
            while(rs.next()){
                t1.setText(rs.getString("username"));
                t3.setText(rs.getString("name"));
            }
        }catch(Exception e){
        }
        
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
            String username = t1.getText();
            String id = c1.getSelectedItem();
            String number = t2.getText();
            String name = t3.getText();
            String gender = null;
            if(r1.isSelected()){
                gender = "Male";
            }else {
                gender = "Female";
            }
            String country = t4.getText();
            String address = t5.getText();
            String phone = t6.getText();
            String email = t7.getText();
    
            String q = "INSERT INTO CUSTOMER VALUES('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+email+"')";
    
            try{
                 Conn c = new Conn();
                 c.statement.executeUpdate(q);
                 
                 JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
                 this.setVisible(false);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        
        }else if(ae.getSource() == b2){
            this.setVisible(false);
        }
    }
        
    
    public static void main(String[] args) {
        new AddCustomer("").setVisible(true);
    }
}
