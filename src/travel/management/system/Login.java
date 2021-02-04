package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

public class Login extends JFrame implements ActionListener{
    JButton b1,b2,b3;
    JTextField t1;
    JPasswordField t2;
    
    Login() {
        
        setLayout(null); //BorderLayout,FlowLayout,GridLayout,Grid
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,250,600,320);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0,0,300,300);
        add(p1);
        
        ImageIcon l1 = new ImageIcon(ClassLoader.
                getSystemResource("travel/management/system/icons/login.png"));
        Image l2 = l1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon l3 = new ImageIcon(l2);
        
        JLabel label1 = new JLabel(l3);
        label1.setBounds(75,120,130,130);
        p1.add(label1);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(300,0,300,300);
        p2.setBackground(new Color(204,206,206));
        add(p2);
        
        JLabel label2 = new JLabel("Username");
        label2.setBounds(100,20,100,30);
        label2.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        p2.add(label2);
        
        t1 = new JTextField();
        t1.setBounds(20, 60, 250, 25);
        t1.setBorder(BorderFactory.createEmptyBorder());
        p2.add(t1);
        
        JLabel label3 = new JLabel("Password");
        label3.setBounds(100,100,100,30);
        label3.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        p2.add(label3);
        
        t2 = new JPasswordField();
        t2.setBounds(20, 140, 250, 25);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p2.add(t2);
        
        b1 = new JButton("Login");
        b1.setBounds(30,170,100,30);
        b1.setBackground(new Color(133,193,233));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        b1.setBorder(BorderFactory.createEmptyBorder());
        p2.add(b1);
        
        b2 = new JButton("Signup");
        b2.setBounds(160,170,100,30);
        b2.setForeground(new Color(133,193,233));
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        b2.setBorder(new LineBorder(new Color(133,193,233)));
        p2.add(b2);      
        
        b3 = new JButton("Forget Password");
        b3.setBounds(120,220,140,30);
        b3.setForeground(new Color(133,193,233));
        b3.setBackground(Color.BLACK);
        b3.addActionListener(this);
        b3.setBorder(new LineBorder(new Color(133,193,233)));
        p2.add(b3);  
        
        JLabel label4 = new JLabel("Trouble in Login?");
        label4.setForeground(Color.RED);
        label4.setBounds(20,225,100,20);
        p2.add(label4);
        
//        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == b1){
            try{
                String username = t1.getText();
                String password = t2.getText();
                String sql = "SELECT * FROM ACCOUNT WHERE username = '"+username+"' AND password = '"+password+"'";
                
                Conn c = new Conn();
                ResultSet rs = c.statement.executeQuery(sql);
                if(rs.next()){
                    this.setVisible(false);
                    new Loading(username).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                }
                
            }catch(Exception exc){
            
            }
        }else if (e.getSource() == b2){
            
            this.setVisible(false);
            new Signup().setVisible(true);
            
        }else if(e.getSource() == b3){
            this.setVisible(false);
            new ForgotPassword().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
