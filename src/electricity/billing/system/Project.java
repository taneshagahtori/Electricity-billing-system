
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class Project extends JFrame {
    
    Project(){
        setExtendedState(JFrame.MAXIMIZED_BOTH); //makes frame of entire height and width
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
        Image i2=i1.getImage().getScaledInstance(1550,850,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        
        
        setVisible(true);
    }
    public static void main(String[] args){
        new Project();
    }
}
