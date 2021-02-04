package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class ForgotPassword extends JFrame implements ActionListener{
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4,t5;
    JPanel p1,p2;
    
    ForgotPassword() {
        
        setBounds(330,250,750,280);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        p1 = new JPanel();
        p1.setBackground(new Color(204,206,206));
        p1.setBounds(0,0,500,280);
        p1.setLayout(null);
        add(p1);

//        p2 = new JPanel();
//        p2.setBackground(Color.WHITE);
//        p2.setBounds(400,0,350,280);
//        add(p2);
        
        l1 = new JLabel("Username");
        l1.setBounds(20,20,100,20);
        l1.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(l1);
        
        t1 = new JTextField();
        t1.setBounds(190,20,180,20);
        t1.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t1);
        
        l2 = new JLabel("Name");
        l2.setBounds(20,50,100,20);
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(l2);
        
        t2 = new JTextField();
        t2.setBounds(190,50,180,20);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t2);
        
        
        l4 = new JLabel("Security Question");
        l4.setBounds(20,80,140,20);
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(l4);
        
        t4 = new JTextField();
        t4.setBounds(190,80,180,20);
        t4.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t4);
        
        l5 = new JLabel("Answer");
        l5.setBounds(20,110,100,20);
        l5.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(l5);
        
        t5 = new JTextField();
        t5.setBounds(190,110,180,20);
        t5.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t5);
        
        l3 = new JLabel("Password");
        l3.setBounds(20,140,140,20);
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(l3);
        
        t3 = new JTextField();
        t3.setBounds(190,140,180,20);
        t3.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t3);
        
        ImageIcon img = new ImageIcon(ClassLoader.
                getSystemResource("travel/management/system/icons/forgotpassword.jpg"));
        Image img2 = img.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        
        l6 = new JLabel(img3);
        l6.setBounds(515,20,200,200);
        add(l6);
        
        b1 = new JButton("Search");
        b1.setBounds(390,20,100,20);
        b1.setForeground(new Color(133,193,233));
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        b1.setBorder(new LineBorder(new Color(133,193,233)));
        p1.add(b1); 
        
        b2 = new JButton("Retrieve");
        b2.setBounds(390,110,100,20);
        b2.setForeground(new Color(133,193,233));
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        b2.setBorder(new LineBorder(new Color(133,193,233)));
        p1.add(b2); 
        
        b3 = new JButton("Back");
        b3.setBounds(170,190,120,30);
        b3.setForeground(new Color(133,193,233));
        b3.setBackground(Color.BLACK);
        b3.addActionListener(this);
        b3.setBorder(new LineBorder(new Color(133,193,233)));
        p1.add(b3); 
        
    }
    
    public void actionPerformed(ActionEvent e){
        Conn c = new Conn();
        if(e.getSource() == b1){
            
            if(e.getSource() == b1){
                try{
                    String query1 = "SELECT * FROM ACCOUNT WHERE username = '"+t1.getText()+"' ";
                    ResultSet rs = c.statement.executeQuery(query1);
                    
                    while(rs.next()){
                        t2.setText(rs.getString("name"));
                        t4.setText(rs.getString("security"));
                    }
                }catch(SQLException se){
                   
                }
            }
        }else if (e.getSource() == b2){
            try{

                String query2 = "SELECT * FROM ACCOUNT WHERE answer = '"+t5.getText()+"' AND username = '"+t1.getText()+"' ";
                ResultSet rs = c.statement.executeQuery(query2);
                while(rs.next()){
                    t3.setText(rs.getString("password"));
                }
            }catch(SQLException se){
            
            }

        }else if(e.getSource() == b3){
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new ForgotPassword().setVisible(true);
    }
}
