package travel.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class DeleteCustomer extends JFrame implements ActionListener{
    JLabel t1,t2,t3,t4,t5,t6,t7,t8,t9;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;

    JButton b1,b2;

    String username;
    
    DeleteCustomer(String user){
        this.username = user;
        setBounds(400,200,600,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel label = new JLabel("Delete Customer Details");
        label.setBounds(130,0,350,25);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        add(label);
        
        l1 = new JLabel("Username");
        l1.setBounds(20,30,100,25);
        l1.setFont(new Font("Tahoma",Font.BOLD,14));
        add(l1);
        
        t1 = new JLabel();
        t1.setBounds(150,30,150,20);
        add(t1);
        
        l2 = new JLabel("ID");
        l2.setBounds(20,60,100,25);
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
        add(l2);
        
        t2 = new JLabel();
        t2.setBounds(150,60,150,20);
        add(t2);
        
        l3 = new JLabel("Number");
        l3.setBounds(20,90,100,25);
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        add(l3);
        
        t3 = new JLabel();
        t3.setBounds(150,90,150,20);
        add(t3);
        
        l4 = new JLabel("Name");
        l4.setBounds(20,120,100,25);
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
        add(l4);
        
        t4 = new JLabel();
        t4.setBounds(150,120,150,20);
        add(t4);
        
        l5 = new JLabel("Gender");
        l5.setBounds(20,150,100,25);
        l5.setFont(new Font("Tahoma",Font.BOLD,14));
        add(l5);
        
        t5 = new JLabel();
        t5.setBounds(150,150,100,25);
        add(t5);
                
        l6 = new JLabel("Country");
        l6.setBounds(20,180,100,25);
        l6.setFont(new Font("Tahoma",Font.BOLD,14));
        add(l6);
        
        t6 = new JLabel();
        t6.setBounds(150,180,150,20);
        add(t6);
        
        l7 = new JLabel("Address");
        l7.setBounds(20,210,100,25);
        l7.setFont(new Font("Tahoma",Font.BOLD,14));
        add(l7);
        
        t7 = new JLabel();
        t7.setBounds(150,210,150,20);
        add(t7);
        
        l8 = new JLabel("Phone");
        l8.setBounds(20,240,100,25);
        l8.setFont(new Font("Tahoma",Font.BOLD,14));
        add(l8);
        
        t8 = new JLabel();
        t8.setBounds(150,240,150,20);
        add(t8);
        
        l9 = new JLabel("Email");
        l9.setBounds(20,270,100,25);
        l9.setFont(new Font("Tahoma",Font.BOLD,14));
        add(l9);
        
        t9 = new JLabel();
        t9.setBounds(150,270,150,20);
        add(t9);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM CUSTOMER WHERE username = '"+username+"'");
            while(rs.next()){
                t1.setText(rs.getString("username"));
                t2.setText(rs.getString("id"));
                t3.setText(rs.getString("number"));
                t4.setText(rs.getString("name"));
                t5.setText(rs.getString("gender"));
                t6.setText(rs.getString("country"));
                t7.setText(rs.getString("address"));
                t8.setText(rs.getString("phone"));
                t9.setText(rs.getString("email"));
            }
        }catch(Exception e){
        }

        
        
        ImageIcon img1 = new ImageIcon(ClassLoader.
                getSystemResource("travel/management/system/icons/delete.png"));
        Image img2 = img1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        
        JLabel label1 = new JLabel(img3);
        label1.setBounds(250,0,400,380);
        add(label1);
        
        b1 = new JButton("Delete");
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
        
                
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
            try{
                Conn c = new Conn();
                
                c.statement.executeUpdate("DELETE FROM ACCOUNT WHERE username = '"+username+"'");
                c.statement.executeUpdate("DELETE FROM CUSTOMER WHERE username = '"+username+"'");
                c.statement.executeUpdate("DELETE FROM BOOKPACKAGE WHERE username = '"+username+"'");
                c.statement.executeUpdate("DELETE FROM BOOKHOTEL WHERE username = '"+username+"'");
                
                JOptionPane.showMessageDialog(null, "Deleted Successfully");
                this.setVisible(false);
                
            }catch(Exception e){}
            
        }else if(ae.getSource() == b2){
            this.setVisible(false);
        }
    }
        
    
    public static void main(String[] args) {
        new DeleteCustomer("").setVisible(true);
    }
}
