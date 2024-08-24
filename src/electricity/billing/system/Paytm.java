
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Paytm extends JFrame implements ActionListener{
    String meter;
    JButton back;
    Paytm(String meter){
        this.meter=meter;
        
        setSize(800, 600);
        setLocation(400, 150);
        
        JEditorPane j=new JEditorPane(); //gives text area
        j.setEditable(false);
        
        try{
            j.setPage("https://paytm.com/online-payments"); //url of the page you want to display
        }
        catch(Exception e){
            j.setContentType("text/html"); //html code to display if the try condition fails
            j.setText("<htm>COuld not load <html>"); //displays the text 
        }
        
        JScrollPane pane=new JScrollPane(j);
        add(pane);
        
        back=new JButton("Back");
        back.setBounds(640, 20, 80, 30);
        back.addActionListener(this);
        j.add(back);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new PayBill(meter);
    }
    
    public static void main(String[] args){
        new Paytm("");
    }
    
}
