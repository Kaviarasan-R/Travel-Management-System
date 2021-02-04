
package travel.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Signup extends JFrame implements ActionListener{
    JButton b1,b2;
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4,t5;
    JPanel p1,p2;
//    Choice c1;
    
    Signup() {
        setBounds(330,250,650,280);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        p1 = new JPanel();
        p1.setBackground(new Color(204,206,206));
        p1.setBounds(0,0,400,280);
        p1.setLayout(null);
        add(p1);

        p2 = new JPanel();
        p2.setBackground(new Color(131,193,233));
        p2.setBounds(400,0,250,280);
        add(p2);
        
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
        
        l3 = new JLabel("Password");
        l3.setBounds(20,80,100,20);
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(l3);
        
        t3 = new JTextField();
        t3.setBounds(190,80,180,20);
        t3.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t3);
        
        l4 = new JLabel("Security Question");
        l4.setBounds(20,110,140,20);
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(l4);

        t4 = new JTextField();
        t4.setBounds(190,110,180,20);
        t4.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t4);
        
//        c1 = new Choice();
//        c1.add("What is your Nickname?");
//        c1.add("Who is your Favourite Person?");
//        c1.add("What is your School Name?");
//        c1.add("What is your Childhood Name?");
//        c1.setBounds(190,110,180,20);
//        p1.add(c1);
        
        l5 = new JLabel("Answer");
        l5.setBounds(20,140,100,20);
        l5.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(l5);
        
        t5 = new JTextField();
        t5.setBounds(190,140,180,20);
        t5.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t5);
        
        ImageIcon img = new ImageIcon(ClassLoader.
                getSystemResource("travel/management/system/icons/signup.png"));
        Image img2 = img.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        
        l6 = new JLabel(img3);
        l6.setBounds(50,130,80,80);
        p2.add(l6);
        
        b1 = new JButton("Create");
        b1.setBounds(50,180,100,30);
        b1.setForeground(new Color(133,193,233));
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        b1.setBorder(new LineBorder(new Color(133,193,233)));
        p1.add(b1); 
        
        b2 = new JButton("Back");
        b2.setBounds(230,180,100,30);
        b2.setForeground(new Color(133,193,233));
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        b2.setBorder(new LineBorder(new Color(133,193,233)));
        p1.add(b2);
        
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == b1){
            String username = t1.getText();
            String name = t2.getText();
            String password = t3.getText();
            String  security = t4.getText();
            String answer = t5.getText();
            
            String query = "INSERT INTO ACCOUNT VALUES('"+username+"','"+name+"','"+password+"','"+security+"','"+answer+"')";
            try{
                Conn c = new Conn();
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Account Created Successfully");
                
                this.setVisible(false);
                new Login().setVisible(true);
                
            }catch(SQLException se){
                
                System.out.println("Signup error" + se);
            }
            
        }else if (e.getSource() == b2){
            
            this.setVisible(false);
            new Login().setVisible(true);
            
        }
    }
    
    public static void main(String[] args) {
        
        new Signup().setVisible(true);
    }
}
