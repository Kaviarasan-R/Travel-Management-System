package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BookHotel extends JFrame implements ActionListener{
    JLabel l1,l11,l2,l22,l3,l33,l4,l44,l5,l55,l6,l66,l7,l77,l8,l88,l9,l99,label10,label11,label12;
    JButton b1,b2,b3;
    Choice c1,c2,c3;
    JTextField t1,t2;
    
    String username;
    
    BookHotel(String username){
        
        setBounds(400,200,800,400);
        setLayout(null);
        
        JLabel label = new JLabel("Book Hotel");
        label.setBounds(180,0,350,25);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.BLACK);
        add(label);
        
        l1 = new JLabel("Username");
        l1.setBounds(20,30,100,25);
        l1.setFont(new Font("Tahoma",Font.BOLD,14));
        l1.setForeground(Color.BLACK);
        add(l1);
        
        l11 = new JLabel();
        l11.setBounds(160,30,140,25);
        add(l11);
        
        l2 = new JLabel("Select Hotel");
        l2.setBounds(20,60,120,25);
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
        l2.setForeground(Color.BLACK);
        add(l2);
        
        c1 = new Choice();
        c1.add("JW Marriot Hotel");
        c1.add("The Taj Hotel");
        c1.setBounds(160,60,140,25);
        add(c1);
        
        l3 = new JLabel("Total Persons");
        l3.setBounds(20,90,140,25);
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        l3.setForeground(Color.BLACK);
        add(l3);

        t1  = new JTextField();
        t1.setBounds(160,90,140,20);
        add(t1);

        label10 = new JLabel("No of Days");
        label10.setBounds(20,120,140,25);
        label10.setFont(new Font("Tahoma",Font.BOLD,14));
        label10.setForeground(Color.BLACK);
        add(label10);

        t2  = new JTextField();
        t2.setBounds(160,120,140,20);
        add(t2);

        label11 = new JLabel("AC / no AC");
        label11.setBounds(20,150,120,25);
        label11.setFont(new Font("Tahoma",Font.BOLD,14));
        label11.setForeground(Color.BLACK);
        add(label11);
        
        c2 = new Choice();
        c2.add("Yes");
        c2.add("No");
        c2.setBounds(160,150,140,25);
        add(c2);
        
        label12 = new JLabel("Food Included");
        label12.setBounds(20,180,120,25);
        label12.setFont(new Font("Tahoma",Font.BOLD,14));
        label12.setForeground(Color.BLACK);
        add(label12);
        
        c3 = new Choice();
        c3.add("Yes");
        c3.add("No");
        c3.setBounds(160,180,140,25);
        add(c3);
        
        
        l4 = new JLabel("ID");
        l4.setBounds(20,210,100,25);
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
        l4.setForeground(Color.BLACK);
        add(l4);
        
        l44 = new JLabel();
        l44.setBounds(160,210,140,25);
        add(l44);
        
        l5 = new JLabel("Number");
        l5.setBounds(20,240,100,25);
        l5.setFont(new Font("Tahoma",Font.BOLD,14));
        l5.setForeground(Color.BLACK);
        add(l5);
        
        l55 = new JLabel();
        l55.setBounds(160,240,140,25);
        add(l55);
        
        l6 = new JLabel("Phone");
        l6.setBounds(20,270,100,25);
        l6.setFont(new Font("Tahoma",Font.BOLD,14));
        l6.setForeground(Color.BLACK);
        add(l6);
        
        l66 = new JLabel();
        l66.setBounds(160,270,180,25);
        add(l66);
        
        l7 = new JLabel("Total Price");
        l7.setBounds(20,300,100,25);
        l7.setFont(new Font("Tahoma",Font.BOLD,14));
        l7.setForeground(Color.BLACK);
        add(l7);
       
        l77 = new JLabel();
        l77.setBounds(160,300,100,25);
        add(l77);
        
        ImageIcon img1 = new ImageIcon(ClassLoader.
                getSystemResource("travel/management/system/icons/book.jpg"));
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
        
        b2 = new JButton("Book Hotel");
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
            try{
                if(c1.getSelectedItem().equals("JW Marriot Hotel")){
                    int cost = 2000;
                    int food = 2500;
                    int ac = 3000;
                    
                    int persons = Integer.parseInt(t1.getText());
                    int days = Integer.parseInt(t2.getText());
                    
                    String foodprice = c2.getSelectedItem();
                    String acprice = c3.getSelectedItem();

                    if(persons * days > 0){
                        int total = 0;
                        total += acprice.equals("Yes") ? ac : 0;
                        total += foodprice.equals("Yes") ? food : 0;
                        total += cost;
                        total = total * persons * days;
                        
                        l77.setText("Rs."+ total + " /-");
                        
                    }else{
                        l77.setText("please enter valid number");                    
                    }
                }else if(c1.getSelectedItem().equals("The Taj Hotel")){
                    int cost = 2500;
                    int food = 2200;
                    int ac = 4000;
                    
                    int persons = Integer.parseInt(t1.getText());
                    int days = Integer.parseInt(t2.getText());
                    
                    String foodprice = c2.getSelectedItem();
                    String acprice = c3.getSelectedItem();

                    if(persons * days > 0){
                        int total = 0;
                        total += acprice.equals("Yes") ? ac : 0;
                        total += foodprice.equals("Yes") ? food : 0;
                        total += cost;
                        total = total * persons * days;
                        
                        l77.setText("Rs."+ total + " /-");
                        
                    }else{
                        l77.setText("please enter valid number");                    
                    }

                }
            }catch(Exception e){}
            
        }else if(ae.getSource() == b2){
            try{
                
                Conn c = new Conn();
                c.statement.executeUpdate("INSERT INTO BOOKHOTEL VALUES('"+l11.getText()+"','"+c1.getSelectedItem()+"','"+t1.getText()+"','"+t2.getText()+"','"+c2.getSelectedItem()+"','"+c3.getSelectedItem()+"','"+l44.getText()+"','"+l55.getText()+"','"+l66.getText()+"','"+l77.getText()+"')");
                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                this.setVisible(false);
                
            }catch(Exception e){}
            
            
        }else if(ae.getSource() == b3){
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new BookHotel("rkavi").setVisible(true);
    }
}
