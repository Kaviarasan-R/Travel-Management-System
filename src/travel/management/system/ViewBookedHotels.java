package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class ViewBookedHotels extends JFrame implements ActionListener{
//    JLabel l1,l11,l2,l22,l3,l33,l4,l44,l5,l55,l6,l66,l7,l77,l8,l88,l9,l99;
    JLabel l1,l11,l2,l22,l3,l33,l4,l44,l5,l55,l6,l66,l7,l77,l8,l88,l9,l99,label10,label11,label12,label100,label111,label122;    
    JButton b1;    
    String username;
    
    ViewBookedHotels(String username){
        
        setBounds(400,200,800,520);
        setLayout(null);
        
        JLabel label = new JLabel("View Booked Hotels");
        label.setBounds(70,10,350,25);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.BLACK);
        add(label);
        
        l1 = new JLabel("Username");
        l1.setBounds(20,40,100,25);
        l1.setFont(new Font("Tahoma",Font.BOLD,14));
        l1.setForeground(Color.BLACK);
        add(l1);
        
        l11 = new JLabel();
        l11.setBounds(160,40,140,25);
        add(l11);
        
        l2 = new JLabel("Selected Hotel");
        l2.setBounds(20,80,120,25);
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
        l2.setForeground(Color.BLACK);
        add(l2);
        
        l22 = new JLabel();
        l22.setBounds(160,80,140,25);
        add(l22);
        
        l3 = new JLabel("Total Persons");
        l3.setBounds(20,120,140,25);
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        l3.setForeground(Color.BLACK);
        add(l3);

        l33 = new JLabel();
        l33.setBounds(160,120,140,20);
        add(l33);
        
        label10 = new JLabel("No of Days");
        label10.setBounds(20,160,140,25);
        label10.setFont(new Font("Tahoma",Font.BOLD,14));
        label10.setForeground(Color.BLACK);
        add(label10);

        label100 = new JLabel();
        label100.setBounds(160,160,140,25);
        add(label100);
        
        label11 = new JLabel("AC / no AC");
        label11.setBounds(20,200,120,25);
        label11.setFont(new Font("Tahoma",Font.BOLD,14));
        label11.setForeground(Color.BLACK);
        add(label11);
                
        label111 = new JLabel();
        label111.setBounds(160,200,120,25);
        add(label111);
        
        label12 = new JLabel("Food Included");
        label12.setBounds(20,240,120,25);
        label12.setFont(new Font("Tahoma",Font.BOLD,14));
        label12.setForeground(Color.BLACK);
        add(label12);
                
        
        label122 = new JLabel();
        label122.setBounds(160,240,120,25);
        add(label122);
        
        l4 = new JLabel("ID");
        l4.setBounds(20,280,100,25);
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
        l4.setForeground(Color.BLACK);
        add(l4);
        
        l44 = new JLabel();
        l44.setBounds(160,280,140,25);
        add(l44);
        
        l5 = new JLabel("Number");
        l5.setBounds(20,320,100,25);
        l5.setFont(new Font("Tahoma",Font.BOLD,14));
        l5.setForeground(Color.BLACK);
        add(l5);
        
        l55 = new JLabel();
        l55.setBounds(160,320,140,25);
        add(l55);
        
        l6 = new JLabel("Phone");
        l6.setBounds(20,360,100,25);
        l6.setFont(new Font("Tahoma",Font.BOLD,14));
        l6.setForeground(Color.BLACK);
        add(l6);
        
        l66 = new JLabel();
        l66.setBounds(160,360,180,25);
        add(l66);
        
        l7 = new JLabel("Total Price");
        l7.setBounds(20,400,100,25);
        l7.setFont(new Font("Tahoma",Font.BOLD,14));
        l7.setForeground(Color.BLACK);
        add(l7);
       
        l77 = new JLabel();
        l77.setBounds(160,400,100,25);
        add(l77);
        
        ImageIcon img1 = new ImageIcon(ClassLoader.
                getSystemResource("travel/management/system/icons/bookedDetails.jpg"));
        Image img2 = img1.getImage().getScaledInstance(500,520,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        
        JLabel label1 = new JLabel(img3);
        label1.setBounds(340,0,500,520);
        add(label1);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM BOOKHOTEL WHERE username = '"+username+"' ");
            while(rs.next()){
                l11.setText(rs.getString("username"));
                l22.setText(rs.getString("hotel"));
                l33.setText(rs.getString("totalpersons"));
                label100.setText(rs.getString("days"));
                label111.setText(rs.getString("ac"));
                label122.setText(rs.getString("food"));
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
        b1.setBounds(120,450,120,25);
        b1.addActionListener(this);
        add(b1);
          
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new ViewBookedHotels("").setVisible(true);
    }
}
