
package travel.management.system;

import java.awt.*;
import javax.swing.*;

public class Loading extends JFrame implements Runnable{
    JProgressBar p;
    Thread t;
    String username;
    
    public void run() {
        try{
            for(int i=0;i<=101;i++){
                int m = p.getMaximum();
                int n = p.getValue();
                if(n < m){
                    p.setValue(p.getValue() + 1);
                }else {
                    i = 101;
                    setVisible(false);
                    new Dashboard(username).setVisible(true);
                }
                Thread.sleep(50);
            }
        }catch(Exception e){
        }
    }
    
    
    Loading(String user) {
        username = user;
        t = new Thread(this);
        
        setBounds(350,250,600,270);
//        getContentPane().setBackground(new Color(204,206,206));
        setLayout(null);
        
        JLabel l1 = new JLabel("Travel and Tourism Management");
        l1.setBounds(55,10,500,40);
        l1.setFont(new Font("Raleway",Font.BOLD,30));
        l1.setForeground(Color.WHITE);
        add(l1);
        
        p = new JProgressBar();
        p.setStringPainted(true);
        p.setBounds(150,100,280,20);
        p.setBackground(Color.DARK_GRAY);
        add(p);
        
//        JLabel l2 = new JLabel("Please Wait..");
//        l2.setBounds(230,130,130,25);
//        l2.setFont(new Font("Tahoma",Font.BOLD,14));
//        l2.setForeground(Color.red);
//        add(l2);
        
        JLabel l3 = new JLabel("Welcome "+ username );
        l3.setBounds(30,200,170,25);
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        l3.setForeground(Color.white);
        add(l3);
        
        ImageIcon img1 = new ImageIcon(ClassLoader.
            getSystemResource("travel/management/system/icons/splash.jpg"));
        
        Image img2 = img1.getImage().getScaledInstance(600,270,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        
        JLabel label = new JLabel(img3);
        label.setBounds(0,0,600,270);
        add(label);

        
        t.start();
        setUndecorated(true);
        
    }
    public static void main(String[] args) {
        new Loading("").setVisible(true);
    }
}
