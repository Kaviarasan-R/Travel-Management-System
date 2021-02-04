
package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15;
    String username;
    
    Dashboard(String username) {
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0,0,1950,40);
        p1.setBackground(new Color(0,0,102));
        add(p1);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(0,0,300,1000);
        p2.setBackground(new Color(0,0,102));
        add(p2);
        
        l1 = new JLabel("Dashboard");
        l1.setFont(new Font("Tahoma",Font.BOLD,30));
        l1.setForeground(Color.WHITE);
        l1.setBounds(10,5,300,30);
        p1.add(l1);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/home.jpg"));
        Image img2 = img.getImage().getScaledInstance(1950,1000,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        l2 = new JLabel(img3);
        l2.setBounds(0,0,1650,1000);
        add(l2);
        
        b1 = new JButton("Add Personal Details");
        b1.setBackground(new Color(0,0,102));
        b1.setFont(new Font("Tahoma",Font.PLAIN,20));
        b1.setForeground(Color.WHITE);
        b1.setBounds(0,40,300,50);
        b1.setMargin(new Insets(0,0,0,60));
        b1.addActionListener(this); 
        p2.add(b1);
        
        b2 = new JButton("Update Personal Details");
        b2.setBackground(new Color(0,0,102));
        b2.setFont(new Font("Tahoma",Font.PLAIN,20));
        b2.setForeground(Color.WHITE);
        b2.setBounds(0,80,300,50);
        b2.setMargin(new Insets(0,0,0,30));
        b2.addActionListener(this); 
        p2.add(b2);
        
        b3 = new JButton("View Details");
        b3.setBackground(new Color(0,0,102));
        b3.setFont(new Font("Tahoma",Font.PLAIN,20));
        b3.setForeground(Color.WHITE);
        b3.setBounds(0,120,300,50);
        b3.setMargin(new Insets(0,0,0,130));
        b3.addActionListener(this); 
        p2.add(b3);
        
        b4 = new JButton("Delete Personal Details");
        b4.setBackground(new Color(0,0,102));
        b4.setFont(new Font("Tahoma",Font.PLAIN,20));
        b4.setForeground(Color.WHITE);
        b4.setBounds(0,160,300,50);
        b4.setMargin(new Insets(0,0,0,33));
        b4.addActionListener(this);
        p2.add(b4);
        
        b5 = new JButton("Check Package");
        b5.setBackground(new Color(0,0,102));
        b5.setFont(new Font("Tahoma",Font.PLAIN,20));
        b5.setForeground(Color.WHITE);
        b5.setBounds(0,200,300,50);
        b5.setMargin(new Insets(0,0,0,110));
        b5.addActionListener(this);
        p2.add(b5);
        
        b6 = new JButton("Book Package");
        b6.setBackground(new Color(0,0,102));
        b6.setFont(new Font("Tahoma",Font.PLAIN,20));
        b6.setForeground(Color.WHITE);
        b6.setBounds(0,240,300,50);
        b6.setMargin(new Insets(0,0,0,120));
        b6.addActionListener(this);
        p2.add(b6);
        
        b7 = new JButton("View Package");
        b7.setBackground(new Color(0,0,102));
        b7.setFont(new Font("Tahoma",Font.PLAIN,20));
        b7.setForeground(Color.WHITE);
        b7.setBounds(0,280,300,50);
        b7.setMargin(new Insets(0,0,0,120));
        b7.addActionListener(this);
        p2.add(b7);
        
        b8 = new JButton("View Hotels");
        b8.setBackground(new Color(0,0,102));
        b8.setFont(new Font("Tahoma",Font.PLAIN,20));
        b8.setForeground(Color.WHITE);
        b8.setBounds(0,320,300,50);
        b8.setMargin(new Insets(0,0,0,130));
        b8.addActionListener(this);
        p2.add(b8);
        
        b9 = new JButton("Book Hotels");
        b9.setBackground(new Color(0,0,102));
        b9.setFont(new Font("Tahoma",Font.PLAIN,20));
        b9.setForeground(Color.WHITE);
        b9.setBounds(0,360,300,50);
        b9.setMargin(new Insets(0,0,0,130));
        b9.addActionListener(this);
        p2.add(b9);
        
        b10 = new JButton("View Booked Hotel");
        b10.setBackground(new Color(0,0,102));
        b10.setFont(new Font("Tahoma",Font.PLAIN,20));
        b10.setForeground(Color.WHITE);
        b10.setBounds(0,400,300,50);
        b10.setMargin(new Insets(0,0,0,70));
        b10.addActionListener(this);
        p2.add(b10);
        
        b13 = new JButton("Calculator");
        b13.setBackground(new Color(0,0,102));
        b13.setFont(new Font("Tahoma",Font.PLAIN,20));
        b13.setForeground(Color.WHITE);
        b13.setBounds(0,440,300,50);
        b13.setMargin(new Insets(0,0,0,145));
        b13.addActionListener(this);
        p2.add(b13); 
        
        b14 = new JButton("Notepad");
        b14.setBackground(new Color(0,0,102));
        b14.setFont(new Font("Tahoma",Font.PLAIN,20));
        b14.setForeground(Color.WHITE);
        b14.setBounds(0,480,300,50);
        b14.setMargin(new Insets(0,0,0,155));
        b14.addActionListener(this);
        p2.add(b14);
        
        b15 = new JButton("About");
        b15.setBackground(new Color(0,0,102));
        b15.setFont(new Font("Tahoma",Font.PLAIN,20));
        b15.setForeground(Color.WHITE);
        b15.setBounds(0,520,300,50);
        b15.setMargin(new Insets(0,0,0,170));
        b15.addActionListener(this);
        p2.add(b15);
        
        l3 = new JLabel("Travel and Tourism Management System");
        l3.setFont(new Font("Tahoma",Font.BOLD,30));
        l3.setForeground(Color.WHITE);
        l3.setBounds(540,80,1000,50);
        l2.add(l3);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == b1){
            
            new AddCustomer(username).setVisible(true);
            
        }else if(ae.getSource() == b2){
            
            new UpdateCustomer(username).setVisible(true);
                
        }else if(ae.getSource() == b3) {
            
            new ViewCustomer(username).setVisible(true);
            
        }else if(ae.getSource() == b4){
        
            new DeleteCustomer(username).setVisible(true);
            
        }else if(ae.getSource() == b5){
            
            new CheckPackage().setVisible(true);
            
        }else if(ae.getSource() == b6){
            
            new BookPackage(username).setVisible(true);
            
        }else if(ae.getSource() == b7){
            
            new ViewPackage(username).setVisible(true);
            
        }else if(ae.getSource() == b8){
        
            new ViewHotels().setVisible(true);
            
        }else if(ae.getSource() == b9){
            
            new BookHotel(username).setVisible(true);
            
        }else if(ae.getSource() == b10){
        
            new ViewBookedHotels(username).setVisible(true);
            
        }else if(ae.getSource() == b13){
            
            try{
                Runtime.getRuntime().exec("Calc.exe");
            }catch(Exception e){}
            
        }else if(ae.getSource() == b14){
            
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){}
            
        }else if(ae.getSource() == b15){
        
            new About().setVisible(true);
        
        }
    }
    
    public static void main(String[] args) {
        new Dashboard("").setVisible(true);
    }
}
