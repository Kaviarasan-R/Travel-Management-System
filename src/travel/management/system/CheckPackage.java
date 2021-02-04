
package travel.management.system;

import java.awt.*;
import javax.swing.*;

public class CheckPackage extends JFrame{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
   
    CheckPackage() {
        setBounds(400,200,600,400);
        
        String[] package1 = new String[] {"GOLD PACKAGE","-> 6 Days & 7 Nights","-> Airport Assistance","-> Half Day City Tour","-> Daily Buffet","-> Full Day 3 Island Criuse","-> Traveller Guide","BOOK NOW","SUMMER SPECIAL","Rs.12000/-","package1.jpg"};
        String[] package2 = new String[] {"SILVER PACKAGE","-> 6 Days & 5 Nights","-> Toll Free and Entrance Free","-> Meet and Greet at Airport","-> Daily Buffet","-> Full Day 3 Island Criuse","-> BBQ Dinner","BOOK NOW","SUMMER SPECIAL","Rs.10000/-","package2.jpg"};
        String[] package3 = new String[] {"BRONZE PACKAGE","-> 4 Days & 3 Nights","-> Return Airfare","-> Free Clubbing","-> Night Safari","-> Full Day 3 Island Criuse","-> 5 Star Hotel","Cruise With Dinner","SUMMER SPECIAL","Rs.8000/-","package3.jpg"};
        
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel p1 = createPackage(package1);
        tabbedPane.addTab("Package 1", null, p1);
      
        JPanel p2 = createPackage(package2);
        tabbedPane.addTab("Package 2", null, p2);
      
        JPanel p3 = createPackage(package3);
        tabbedPane.addTab("Package 3", null, p3);
        
        add(tabbedPane,BorderLayout.CENTER);
    }
    
    public JPanel createPackage(String[] pack) {
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        
        l1 = new JLabel(pack[0]);
        l1.setBounds(30,10,300,25);
        l1.setFont(new Font("Tahoma",Font.PLAIN,25));
        l1.setForeground(Color.BLACK);
        p1.add(l1);

        l2 = new JLabel(pack[1]);
        l2.setBounds(30,50,300,20);
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(l2);

        l3 = new JLabel(pack[2]);
        l3.setBounds(30,80,300,20);
        l3.setForeground(Color.RED);
        l3.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(l3);

        l4 = new JLabel(pack[3]);
        l4.setBounds(30,110,300,20);
        l4.setForeground(Color.RED);
        l4.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(l4);

        l5 = new JLabel(pack[4]);
        l5.setBounds(30,140,300,20);
        l5.setForeground(Color.RED);
        l5.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(l5);
        
        l6 = new JLabel(pack[5]);
        l6.setBounds(30,170,300,20);
        l6.setForeground(Color.RED);
        l6.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(l6);

        l7 = new JLabel(pack[6]);
        l7.setBounds(30,200,300,20);
        l7.setForeground(Color.RED);
        l7.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(l7);
        
        l8 = new JLabel(pack[7]);
        l8.setBounds(60,240,300,25);
        l8.setForeground(Color.BLUE);
        l8.setFont(new Font("Tahoma",Font.PLAIN,30));
        p1.add(l8);
        
        l9 = new JLabel(pack[8]);
        l9.setBounds(60,280,300,25);
        l9.setForeground(Color.orange);
        l9.setFont(new Font("Tahoma",Font.PLAIN,30));
        p1.add(l9);
       
        l8 = new JLabel(pack[9]);
        l8.setBounds(380,60,300,25);
        l8.setForeground(Color.darkGray);
        l8.setFont(new Font("Tahoma",Font.PLAIN,30));
        p1.add(l8);
        
        ImageIcon img1 = new ImageIcon(ClassLoader.
                getSystemResource("travel/management/system/icons/"+pack[10]));
        Image img2 = img1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        
        JLabel label1 = new JLabel(img3);
        label1.setBounds(0,0,600,400);
        p1.add(label1);
        
        return p1;
    }
    public static void main(String[] args) {
        new CheckPackage().setVisible(true);
    }
}
