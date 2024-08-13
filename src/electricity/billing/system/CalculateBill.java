
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class CalculateBill extends JFrame implements ActionListener {
    
    JTextField tfunits; 
    JLabel lblname, lbladdresss;
    JButton submit, cancel;
    Choice meterno;
    CalculateBill(){
        setSize(700, 500);
        setLocation(400, 200);
        
        JPanel p=new JPanel(); //creates panel inside the frame
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);
        
        JLabel heading= new JLabel("Calculate Electricity Bill");
        heading.setBounds(100, 10, 400, 25);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(heading);
        
        JLabel lblmeterno= new JLabel("Meter No");
        lblmeterno.setBounds(100, 80, 100, 20);
        p.add(lblmeterno);
        
        meterno=new Choice();
        
        try{
            Conn c= new Conn();
            ResultSet rs= c.s.executeQuery("select * from customer");
            while(rs.next()){
                meterno.add(rs.getString("meter_no"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        meterno.setBounds(240, 80, 200, 20);
        p.add(meterno);
        
        JLabel lbname= new JLabel("Name");
        lbname.setBounds(100, 120, 100, 20);
        p.add(lbname);
        
        lblname= new JLabel("");
        lblname.setBounds(240, 120, 100, 20);
        p.add(lblname);
        
        JLabel lbladdress= new JLabel("Address");
        lbladdress.setBounds(100, 160, 100, 20);
        p.add(lbladdress);
        
        lbladdresss=new JLabel();
        lbladdresss.setBounds(240, 160, 200, 20);
        p.add(lbladdresss);
        
        try{
            Conn c= new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer where meter_no ='"+meterno.getSelectedItem()+"'");
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lbladdresss.setText(rs.getString("address"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        meterno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c= new Conn();
                    ResultSet rs=c.s.executeQuery("select * from customer where meter_no ='"+meterno.getSelectedItem()+"'");
                    while(rs.next()){
                       lblname.setText(rs.getString("name"));
                       lbladdresss.setText(rs.getString("address"));
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
       
        JLabel lblunit= new JLabel("Units Consumed");
        lblunit.setBounds(100, 200, 100, 20);
        p.add(lblunit);
                
        tfunits=new JTextField();
        tfunits.setBounds(240, 200, 200, 20);
        p.add(tfunits);
    
        
        JLabel lblmonth= new JLabel("Month");
        lblmonth.setBounds(100, 240, 100, 20);
        p.add(lblmonth);
      
        submit=new JButton("Next");
        submit.setBounds(120, 390, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        p.add(submit);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(250, 390, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);
        
        setLayout(new BorderLayout());
        add(p, "Center");
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2= i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        add(image, "West");
        
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String name= tfname.getText();
            String meter=lblmeter.getText();
            String address=tfaddress.getText();
            String city=tfcity.getText();
            String state=tfstate.getText();
            String email=tfstate.getText();
            String phone= tfphone.getText();
            
            String query1="insert into customer values('"+name+"', '"+meter+"', '"+address+"', '"+city+"', '"+state+"', '"+email+"', '"+phone+"')";
            String query2="insert into login values('"+meter+"','', '"+name+"', '', '')";
            
            try{
                Conn c=new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);
                
                //new frame
                new MeterInfo(meter);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new CalculateBill();
    }
}
