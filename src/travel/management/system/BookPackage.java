package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BookPackage extends JFrame implements ActionListener{
    JLabel l1,l11,l2,l22,l3,l33,l4,l44,l5,l55,l6,l66,l7,l77,l8,l88,l9,l99;
    JButton b1,b2,b3;
    Choice c1;
    JTextField t1;
    
    String username;
    
    BookPackage(String username){
        
        setBounds(400,200,800,400);
        setLayout(null);
        
        JLabel label = new JLabel("Book Package");
        label.setBounds(180,10,350,25);
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
        
        l2 = new JLabel("Select Package");
        l2.setBounds(20,90,120,25);
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
        l2.setForeground(Color.BLACK);
        add(l2);
        
        c1 = new Choice();
        c1.add("Gold Package");
        c1.add("Silver Package");
        c1.add("Bronze Package");
        c1.setBounds(160,90,140,25);
        add(c1);
        
        l3 = new JLabel("Total Persons");
        l3.setBounds(20,130,140,25);
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        l3.setForeground(Color.BLACK);
        add(l3);

        t1  = new JTextField();
        t1.setBounds(160,130,140,20);
        add(t1);
        
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
                getSystemResource("travel/management/system/icons/bookpackage.jpg"));
        Image img2 = img1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        
        JLabel label1 = new JLabel(img3);
        label1.setBounds(340,60,500,200);
        add(label1);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM CUSTOMER WHERE username = '"+username+"' ");
            while(rs.next()){
                l11.setText(rs.getString("username"));
                l44.setText(rs.getString("id"));
                l55.setText(rs.getString("number"));
                l66.setText(rs.getString("phone"));
            }
            
        }catch(Exception e){
        }
        
        
        b1 = new JButton("Check Price");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(340,300,120,25);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Book Package");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(490,300,120,25);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(640,300,120,25);
        b3.addActionListener(this);
        add(b3);
          
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String p = c1.getSelectedItem();
            
            int cost = 0;
            
            if(p.equals("Gold Package")){
                cost+=12000;
            }else if(p.equals("Silver Package")){
                cost+=10000;
            }else if(p.equals("Bronze Package")){
                cost+=8000;
            }
            
            int persons = Integer.parseInt(t1.getText());
            cost *= persons;
            l77.setText("Rs."+ cost + " /-");
            
            
        }else if(ae.getSource() == b2){
            try{
                
                Conn c = new Conn();
                c.statement.executeUpdate("INSERT INTO BOOKPACKAGE VALUES('"+l11.getText()+"','"+c1.getSelectedItem()+"','"+t1.getText()+"','"+l44.getText()+"','"+l55.getText()+"','"+l66.getText()+"','"+l77.getText()+"')");
                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                this.setVisible(false);
                
            }catch(Exception e){}
            
            
        }else if(ae.getSource() == b3){
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new BookPackage("").setVisible(true);
    }
}
