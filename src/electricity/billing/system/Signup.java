
package electricity.billing.system;
import javax.swing.*;
import javax.swing.border.*; //sub package
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener{
    JButton create, back;
    Choice accountType;
    JTextField meter, username, name, password;
    Signup(){
        setBounds(450, 150, 700, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel panel=new JPanel();
        panel.setBounds(30,30,650,300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(172, 216, 230)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(134, 139, 34)); //font color
        add(panel);
        
        JLabel heading=new JLabel("Create Account As");
        heading.setBounds(100, 50, 140, 20);
        heading.setForeground(Color.GRAY); 
        heading.setFont(new Font("Tahoma", Font.BOLD,14));// font family, style, size 
        panel.add(heading);
        
        accountType= new Choice(); //select dropdown menu
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260,50,150,20);
        panel.add(accountType);
        
        JLabel lblmeter=new JLabel("Meter Number");
        lblmeter.setBounds(100, 90, 140, 20);
        lblmeter.setForeground(Color.GRAY); 
        lblmeter.setFont(new Font("Tahoma", Font.BOLD,14));// font family, style, size 
        lblmeter.setVisible(false);
        panel.add(lblmeter);
        
        meter= new JTextField();
        meter.setBounds(260,90,150,20);
        meter.setVisible(false);//meterno field will not show when choice=customer
        panel.add(meter);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(100, 130, 140, 20);
        lblusername.setForeground(Color.GRAY); 
        lblusername.setFont(new Font("Tahoma", Font.BOLD,14));// font family, style, size 
        panel.add(lblusername);
        
        username= new JTextField();
        username.setBounds(260, 130,150,20);
        panel.add(username);
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(100, 170, 140, 20);
        lblname.setForeground(Color.GRAY); 
        lblname.setFont(new Font("Tahoma", Font.BOLD,14));// font family, style, size 
        panel.add(lblname);
        
        name= new JTextField();
        name.setBounds(260,170,150,20);
        panel.add(name);
        
         meter.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent fe){}
            
            @Override
            public void focusLost(FocusEvent fe) {
                try{
                    Conn c=new Conn();
                    ResultSet rs=c.s.executeQuery("select * from login where meter_no='"+meter.getText()+"'");
                    while(rs.next()){
                        name.setText(rs.getString("name"));
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            
        });
        
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(100, 210, 140, 20);
        lblpassword.setForeground(Color.GRAY); 
        lblpassword.setFont(new Font("Tahoma", Font.BOLD,14));// font family, style, size 
        panel.add(lblpassword);
        
        password= new JTextField();
        password.setBounds(260,210,150,20);
        panel.add(password);
        
        accountType.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ae){
                String user=accountType.getSelectedItem();
                if(user.equals("Customer")){
                    lblmeter.setVisible(true);
                    meter.setVisible(true);
                    name.setEditable(false); //disables editing option
                }
                else{
                    lblmeter.setVisible(false);
                    meter.setVisible(false);
                    name.setEditable(true);
                }
            }
        });
        
        create=new JButton("Create");
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.setBounds(140, 260,120,25);
        create.addActionListener(this);
        panel.add(create);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300, 260,120,25);
        back.addActionListener(this);
        panel.add(back);
         
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2= i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(415, 30, 250, 250);
        panel.add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == create){
            String acctype=accountType.getSelectedItem(); //select the account type from the dropdrown menu
            String susername=username.getText(); //it will take text value from the field
            String sname=name.getText();
            String pass=password.getText();
            String smeter=meter.getText();
            
            //making sql query
            try{
                Conn c=new Conn();  //establishing connection with mysql by creating conn class and making its object here
                
                String query=null;
                if(acctype.equals("Admin")){
                    query ="insert into login values('"+smeter+"', '"+susername+"', '"+sname+"', '"+pass+"','"+acctype+"' )"; //defining query (DML)
                }else{
                    query="update login set username= '"+susername+"',password='"+pass+"', user='"+acctype+"' where meter_no ='"+smeter+"'";
                }
                c.s.executeUpdate(query); //updating(adding new values) query
               
                JOptionPane.showMessageDialog(null, "Account Created Successfully"); //popup if the query runs successfully
                
                setVisible(false); //closes signup frame
                new Login(); //opens login frame
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args){
        new Signup();
    }
    
    
}
