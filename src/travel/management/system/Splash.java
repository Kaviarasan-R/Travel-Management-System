
package travel.management.system;

import java.awt.*;
import javax.swing.*;

public class Splash {
    public static void main(String[] args) {
        SplashFrame frame =  new SplashFrame();
        frame.setVisible(true);
        
//        int x = 1;
//        for (int i=1;i<=700;i+=6,x+=7){
//            frame.setLocation(0 ,40);
//            frame.setSize(x+i,i);
//            try{
//                Thread.sleep(10);
//            }catch(Exception e) {}
//        }
//      
//        frame.setVisible(true);
    }
}

// Note : SplashFrame extends JFrame so no need to mension JFrame for adding img.
// and no need to add SplashFrame.frame.setVisible() if you extend JFrame

class SplashFrame extends JFrame implements Runnable{
    Thread t1;
    JFrame frame = new JFrame();
    SplashFrame() {
        ImageIcon img1 = new ImageIcon(ClassLoader.
                getSystemResource("travel/management/system/icons/splash.jpg"));
        
        Image img2 = img1.getImage().getScaledInstance(600,270,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        
        JLabel label = new JLabel(img3);
        add(label);
        
        setBounds(350,250,600,270);

        setUndecorated(true);
        // after 7 seconds close
        t1 = new Thread(this);
        t1.start();
        
    }
    public void run() {
        
        try{
            Thread.sleep(7000);
            this.setVisible(false);
            
            new Login().setVisible(true);
            
        }catch(Exception e){}
        
    }
    
}
