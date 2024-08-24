
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {
    
    String atype, meter;
    Project(String atype, String meter){
        this.atype=atype;
        this.meter=meter;
        setExtendedState(JFrame.MAXIMIZED_BOTH); //makes frame of entire height and width
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
        Image i2=i1.getImage().getScaledInstance(1550,850,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        
        JMenuBar mb= new JMenuBar(); //adds menu bar ontop of frame
        setJMenuBar(mb);
        
        JMenu master=new JMenu("Master"); //creates menu bar items
        master.setForeground(Color.BLUE);
        
        
        JMenuItem newcustomer=new JMenuItem("New Customer"); //menu items inside the main menu bar items
        newcustomer.setFont(new Font("monospaced", Font.PLAIN, 12));
        newcustomer.setBackground(Color.WHITE);
        ImageIcon icon1=new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image1=icon1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(image1));
        newcustomer.setMnemonic('D'); //for adding keyboard shortcuts
        newcustomer.addActionListener(this);
        newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK)); //adding shortcut key ctrl+D
        master.add(newcustomer); //adding newcustomer menu item inside master field
       
        
        JMenuItem customerdetails=new JMenuItem("Customer Details"); //menu items inside the main menu bar items
        customerdetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        customerdetails.setBackground(Color.WHITE);
        ImageIcon icon2=new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image image2=icon2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        customerdetails.setIcon(new ImageIcon(image2));
        customerdetails.setMnemonic('M'); //for adding keyboard shortcuts
        customerdetails.addActionListener(this);
        customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK)); //adding shortcut key ctrl+M
        master.add(customerdetails);
        
        
        JMenuItem depositdetails=new JMenuItem("Deposit Details"); //menu items inside the main menu bar items
        depositdetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        depositdetails.setBackground(Color.WHITE);
        ImageIcon icon3=new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image image3=icon3.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        depositdetails.setIcon(new ImageIcon(image3));
        depositdetails.setMnemonic('N'); //for adding keyboard shortcuts
        depositdetails.addActionListener(this);
        depositdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK)); //adding shortcut key ctrl+N
        master.add(depositdetails);
        
        
        JMenuItem calculatebills=new JMenuItem("Calculate Bill"); //menu items inside the main menu bar items
        calculatebills.setFont(new Font("monospaced", Font.PLAIN, 12));
        calculatebills.setBackground(Color.WHITE);
        ImageIcon icon4=new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image4=icon4.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculatebills.setIcon(new ImageIcon(image4));
        calculatebills.setMnemonic('B'); //for adding keyboard shortcuts
        calculatebills.addActionListener(this);
        calculatebills.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK)); //adding shortcut key ctrl+B
        master.add(calculatebills);
        
        
        JMenu info=new JMenu("Information"); //creates menu bar items
        info.setForeground(Color.RED);
        
        
        
        JMenuItem updateinfo=new JMenuItem("Update Information"); //menu items inside the main menu bar items
        updateinfo.setFont(new Font("monospaced", Font.PLAIN, 12));
        updateinfo.setBackground(Color.WHITE);
        ImageIcon icon5=new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image5=icon5.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        updateinfo.setIcon(new ImageIcon(image5));
        updateinfo.setMnemonic('P'); //for adding keyboard shortcuts
        updateinfo.addActionListener(this);
        updateinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK)); //adding shortcut key ctrl+P
        info.add(updateinfo); //adding newcustomer menu item inside master field
        
        
        JMenuItem viewinfo=new JMenuItem("View Information"); //menu items inside the main menu bar items
        viewinfo.setFont(new Font("monospaced", Font.PLAIN, 12));
        viewinfo.setBackground(Color.WHITE);
        ImageIcon icon6=new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image6=icon6.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        viewinfo.setIcon(new ImageIcon(image6));
        viewinfo.setMnemonic('V'); //for adding keyboard shortcuts
        viewinfo.addActionListener(this);
        viewinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK)); //adding shortcut key ctrl+V
        info.add(viewinfo);
        
        
        JMenu user=new JMenu("User"); //creates menu bar items
        user.setForeground(Color.BLUE);
        
        
        
        JMenuItem paybill=new JMenuItem("Pay Bill"); //menu items inside the main menu bar items
        paybill.setFont(new Font("monospaced", Font.PLAIN, 12));
        paybill.setBackground(Color.WHITE);
        ImageIcon icon7=new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image7=icon7.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(image7));
        paybill.setMnemonic('R'); //for adding keyboard shortcuts
        paybill.addActionListener(this);
        paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK)); //adding shortcut key ctrl+R
        user.add(paybill); //adding newcustomer menu item inside master field
        
        
        JMenuItem billdetails=new JMenuItem("Bill Details"); //menu items inside the main menu bar items
        billdetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        billdetails.setBackground(Color.WHITE);
        ImageIcon icon8=new ImageIcon(ClassLoader.getSystemResource("icon/icon8.png"));
        Image image8=icon8.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(image8));
        billdetails.setMnemonic('B'); //for adding keyboard shortcuts
        billdetails.addActionListener(this);
        billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK)); //adding shortcut key ctrl+B
        user.add(billdetails);
        
        
        JMenu report=new JMenu("Report"); //creates menu bar items
        report.setForeground(Color.RED);
        
        
        
        JMenuItem generatebill=new JMenuItem("Generate Bill"); //menu items inside the main menu bar items
        generatebill.setFont(new Font("monospaced", Font.PLAIN, 12));
        generatebill.setBackground(Color.WHITE);
        ImageIcon icon9=new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image9=icon9.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        generatebill.setIcon(new ImageIcon(image9));
        generatebill.setMnemonic('G'); //for adding keyboard shortcuts
        generatebill.addActionListener(this);
        generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK)); //adding shortcut key ctrl+G
        report.add(generatebill); //adding newcustomer menu item inside master field
        
        
        JMenu utility=new JMenu("Utility"); //creates menu bar items
        utility.setForeground(Color.BLUE);
        
        
        
        JMenuItem notepad=new JMenuItem("NotePad"); //menu items inside the main menu bar items
        notepad.setFont(new Font("monospaced", Font.PLAIN, 12));
        notepad.setBackground(Color.WHITE);
        ImageIcon icon10=new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image image10=icon10.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(image10));
        notepad.setMnemonic('T'); //for adding keyboard shortcuts
        notepad.addActionListener(this);
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK)); //adding shortcut key ctrl+T
        utility.add(notepad);
        
        
        JMenuItem calculator=new JMenuItem("Calculator"); //menu items inside the main menu bar items
        calculator.setFont(new Font("monospaced", Font.PLAIN, 12));
        calculator.setBackground(Color.WHITE);
        ImageIcon icon11=new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image11=icon11.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(image11));
        calculator.setMnemonic('C'); //for adding keyboard shortcuts
        calculator.addActionListener(this);
        calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK)); //adding shortcut key ctrl+C
        utility.add(calculator);
        
        
        JMenu mexit=new JMenu("Exit"); //creates menu bar items
        mexit.setForeground(Color.RED);
        
        
        
        JMenuItem exit=new JMenuItem("Exit"); //menu items inside the main menu bar items
        exit.setFont(new Font("monospaced", Font.PLAIN, 12));
        exit.setBackground(Color.WHITE);
        ImageIcon icon12=new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image12=icon12.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        exit.setIcon(new ImageIcon(image12));
        exit.setMnemonic('X'); //for adding keyboard shortcuts
        exit.addActionListener(this);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK)); //adding shortcut key ctrl+X
        mexit.add(exit);
        
        if(atype.equals("Admin")){
            mb.add(master);
        }
        else{
            mb.add(info);
            mb.add(user);
            mb.add(report);
        }
        
        
        mb.add(utility);
        mb.add(mexit);
        
        setLayout(new FlowLayout());
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        String msg= ae.getActionCommand(); // tells which text is been called
        if(msg.equals("New Customer")){
            new NewCustomer();
        }
        else if(msg.equals("Customer Details")){
            new CustomerDetails();
        }
        else if(msg.equals("Deposit Details")){
            new DepositDetails();
        }
        else if(msg.equals("Calculate Bill")){
            new CalculateBill();
        }
        else if(msg.equals("View Information")){
            new ViewInformation(meter);
        }
        else if(msg.equals("Update Information")){
            new UpdateInformation(meter);
        }
        else if(msg.equals("Bill Details")){
            new BillDetails(meter);
        }
        else if(msg.equals("NotePad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");  //to run an external application, we give its exe file
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");  //to run an external application, we give its exe file
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(msg.equals("Exit")){
            setVisible(false);
            new Login();
        }
        else if(msg.equals("Pay Bill")){
            new PayBill(meter);
        }
        else if(msg.equals("Generate Bill")){
            new GenerateBill(meter);
        }
    }
    
    public static void main(String[] args){
        new Project("", "");
    }
}
