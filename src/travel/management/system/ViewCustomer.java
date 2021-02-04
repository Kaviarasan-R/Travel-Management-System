package travel.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class ViewCustomer extends JFrame implements ActionListener{
    
    JLabel l1,l11,l2,l22,l3,l33,l4,l44,l5,l55,l6,l66,l7,l77,l8,l88,l9,l99;
    JButton b1;
    String username;
    
    ViewCustomer(String username){
        setBounds(400,200,700,500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel label = new JLabel("Customer Details");
        label.setBounds(260,0,350,25);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        add(label);
        
        l1 = new JLabel("Username");
        l1.setBounds(20,40,100,25);
        l1.setFont(new Font("Tahoma",Font.BOLD,14));
        add(l1);
        
        l11 = new JLabel();
        l11.setBounds(160,40,100,25);
        add(l11);
        
        l2 = new JLabel("ID");
        l2.setBounds(20,80,100,25);
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
        add(l2);
        
        l22 = new JLabel();
        l22.setBounds(160,80,100,25);
        add(l22);
        
        
        l3 = new JLabel("Number");
        l3.setBounds(20,120,100,25);
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        add(l3);
        
        l33 = new JLabel();
        l33.setBounds(160,120,100,25);
        add(l33);
        
        l4 = new JLabel("Name");
        l4.setBounds(20,160,100,25);
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
        add(l4);
        
        l44 = new JLabel();
        l44.setBounds(160,160,100,25);
        add(l44);
        
        l5 = new JLabel("Gender");
        l5.setBounds(20,200,100,25);
        l5.setFont(new Font("Tahoma",Font.BOLD,14));
        add(l5);
        
        l55 = new JLabel();
        l55.setBounds(160,200,100,25);
        add(l55);
        
        l6 = new JLabel("Country");
        l6.setBounds(330,40,100,25);
        l6.setFont(new Font("Tahoma",Font.BOLD,14));
        add(l6);
        
        l66 = new JLabel();
        l66.setBounds(440,40,100,25);
        add(l66);
        
        l7 = new JLabel("Address");
        l7.setBounds(330,80,100,25);
        l7.setFont(new Font("Tahoma",Font.BOLD,14));
        add(l7);
        
        l77 = new JLabel();
        l77.setBounds(440,80,180,25);
        add(l77);
        
        l8 = new JLabel("Phone");
        l8.setBounds(330,120,100,25);
        l8.setFont(new Font("Tahoma",Font.BOLD,14));
        add(l8);
        
        l88 = new JLabel();
        l88.setBounds(440,120,180,25);
        add(l88);
        
        l9 = new JLabel("Email");
        l9.setBounds(330,160,100,25);
        l9.setFont(new Font("Tahoma",Font.BOLD,14));
        add(l9);
        
        l99 = new JLabel();
        l99.setBounds(440,160,200,25);
        add(l99);
        
        ImageIcon img1 = new ImageIcon(ClassLoader.
                getSystemResource("travel/management/system/icons/viewall.jpg"));
        Image img2 = img1.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        
        JLabel label1 = new JLabel(img3);
        label1.setBounds(80,300,540,150);
        add(label1);
        
        
        b1 = new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(280,250,100,25);
        b1.addActionListener(this);
        add(b1);
          
        try {
            Conn c = new Conn();
            String query = "SELECT * FROM CUSTOMER WHERE username = '"+username+"'";
            ResultSet rs = c.statement.executeQuery(query);
            while(rs.next()){
                l11.setText(rs.getString("username"));
                l22.setText(rs.getString("id"));
                l33.setText(rs.getString("number"));
                l44.setText(rs.getString("name"));
                l55.setText(rs.getString("gender"));
                l66.setText(rs.getString("country"));
                l77.setText(rs.getString("address"));
                l88.setText(rs.getString("phone"));
                l99.setText(rs.getString("email"));
            }
        }catch(Exception e){
        }
        
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
              this.setVisible(false);
        }
    }
        
    
    public static void main(String[] args) {
        new ViewCustomer("").setVisible(true);
    }
}
