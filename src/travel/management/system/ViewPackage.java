package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class ViewPackage extends JFrame implements ActionListener{
    JLabel l1,l11,l2,l22,l3,l33,l4,l44,l5,l55,l6,l66,l7,l77,l8,l88,l9,l99;
    JButton b1;
    
    String username;
    
    ViewPackage(String username){
        
        setBounds(400,200,800,450);
        setLayout(null);
        
        JLabel label = new JLabel("View Package");
        label.setBounds(100,10,350,25);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.BLACK);
        add(label);
        
        l1 = new JLabel("Username");
        l1.setBounds(20,50,100,25);
        l1.setFont(new Font("Tahoma",Font.BOLD,14));
        l1.setForeground(Color.BLACK);
        add(l1);
        
        l11 = new JLabel();
        l11.setBounds(160,50,140,25);
        add(l11);
        
        l2 = new JLabel("Selected Package");
        l2.setBounds(20,90,120,25);
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
        l2.setForeground(Color.BLACK);
        add(l2);
        
        l22 = new JLabel();
        l22.setBounds(160,90,140,25);
        add(l22);
        
        l3 = new JLabel("Total Persons");
        l3.setBounds(20,130,140,25);
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        l3.setForeground(Color.BLACK);
        add(l3);

        l33 = new JLabel();
        l33.setBounds(160,130,140,20);
        add(l33);
        
        l4 = new JLabel("ID");
        l4.setBounds(20,170,100,25);
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
        l4.setForeground(Color.BLACK);
        add(l4);
        
        l44 = new JLabel();
        l44.setBounds(160,170,140,25);
        add(l44);
        
        l5 = new JLabel("Number");
        l5.setBounds(20,210,100,25);
        l5.setFont(new Font("Tahoma",Font.BOLD,14));
        l5.setForeground(Color.BLACK);
        add(l5);
        
        l55 = new JLabel();
        l55.setBounds(160,210,140,25);
        add(l55);
        
        l6 = new JLabel("Phone");
        l6.setBounds(20,250,100,25);
        l6.setFont(new Font("Tahoma",Font.BOLD,14));
        l6.setForeground(Color.BLACK);
        add(l6);
        
        l66 = new JLabel();
        l66.setBounds(160,250,180,25);
        add(l66);
        
        l7 = new JLabel("Total Price");
        l7.setBounds(20,290,100,25);
        l7.setFont(new Font("Tahoma",Font.BOLD,14));
        l7.setForeground(Color.BLACK);
        add(l7);
       
        l77 = new JLabel();
        l77.setBounds(160,290,100,25);
        add(l77);
        
        ImageIcon img1 = new ImageIcon(ClassLoader.
                getSystemResource("travel/management/system/icons/bookedDetails.jpg"));
        Image img2 = img1.getImage().getScaledInstance(500,450,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        
        JLabel label1 = new JLabel(img3);
        label1.setBounds(340,0,500,450);
        add(label1);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM BOOKPACKAGE WHERE username = '"+username+"' ");
            while(rs.next()){
                l11.setText(rs.getString("username"));
                l22.setText(rs.getString("package"));
                l33.setText(rs.getString("totalpersons"));
                l44.setText(rs.getString("id"));
                l55.setText(rs.getString("number"));
                l66.setText(rs.getString("phone"));
                l77.setText(rs.getString("totalprice"));
            }
            
        }catch(Exception e){
        }
        
        
        b1 = new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(120,350,120,25);
        b1.addActionListener(this);
        add(b1);
          
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new ViewPackage("").setVisible(true);
    }
}
