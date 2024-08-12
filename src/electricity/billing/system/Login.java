
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login, cancel, signup;
    JTextField username, password;
    Choice logginin;
    Login(){
        super("Login Page"); //heading of page
        getContentPane().setBackground(Color.WHITE);  //for bg color
        setLayout(null); 
        
        JLabel lblusername= new JLabel("Username"); //lbl=label
        lblusername.setBounds(300,20,100,20);
        add(lblusername);
        
        username= new JTextField(); //textfield
        username.setBounds(400,20,150,20);
        add(username);
        
        JLabel lblpassword= new JLabel("Password");
        lblpassword.setBounds(300,60,100,20);
        add(lblpassword);
        
        password= new JTextField(); //textfield
        password.setBounds(400,60,150,20);
        add(password);
        
        JLabel loggininas= new JLabel("Loggin in as");
        loggininas.setBounds(300,100,100,20);
        add(loggininas);
        
        logginin=new Choice(); //select dropdown option
        logginin.add("Admin"); //dropdown fiels
        logginin.add("Customer");
        logginin.setBounds(400, 100, 150, 20);
        add(logginin);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2=i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        login= new JButton("Login", new ImageIcon(i2)); //login button
        login.setBounds(330, 160, 100, 20);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i3= new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i4=i3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        cancel= new JButton("Cancel", new ImageIcon(i4)); //cancel button
        cancel.setBounds(450, 160, 100, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i5= new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i6=i5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        signup= new JButton("Signup", new ImageIcon(i6)); //signup button
        signup.setBounds(390, 200, 100, 20);
        signup.addActionListener(this);
        add(signup);
        
        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));  //signup page image
        Image i8=i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i9= new ImageIcon(i8);
        JLabel image= new JLabel(i9);
        image.setBounds(0,0,250, 250);
        add(image);
        
        
        setSize(640, 300);
        setLocation(400, 200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== login){
            String susername=username.getText();
            String spassword=password.getText();
            String user=logginin.getSelectedItem();
            
            try{
                Conn c=new Conn();
                String query="select * from login where username = '"+susername+"' and password = '"+spassword+"' and user = '"+user+"'";  //DDL query
                
                ResultSet re= c.s.executeQuery(query); //importing sql package, all the data after executing query will be stored in this resultset
                
                if(re.next()){ //if the entry matches 
                    setVisible(false);
                    new Project();
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Login"); //when the query doesnt execute or the entry doesnt matches
                    username.setText("");
                    password.setText("");
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == cancel){
            setVisible(false);
        }else if(ae.getSource() == signup){
            setVisible(false); // will close login windo
            new Signup(); //it will open signup window
            
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
}
