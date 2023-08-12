import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener{
            ImageIcon icon;
            Dimension dimension; 
            ImageIcon img;
            JLabel imglab;
            Connection connection = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            JTextField usern;
            JPasswordField pass;
            String typedPassword;
	 Login(){  
        		dimension = Toolkit.getDefaultToolkit().getScreenSize();      
        		int x=(int)((dimension.getWidth() - 450)/2);
        		int y=(int)((dimension.getHeight() - 450)/2);
        		setLocation(x, y);
        		icon = new ImageIcon("image/login.png");
        		setIconImage(icon.getImage());
        		setLayout(null);
        		setSize(600,338);
        		setTitle("Administrator login");
        		setResizable(false);
        		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		JPanel panel=new JPanel();
        		panel.setBounds(0,30,600,40);
        		panel.setOpaque(true);
        		JLabel name=new JLabel("CHI Memorial Hospital");
        		name.setFont(new Font("Serif", Font.ITALIC, 18));
        		panel.setBackground(new Color(0,0,0,80));
                add(panel);
                panel.add(name);
        	    JButton button = new JButton("Login");
        	    button.setFocusPainted(false);
                button.setBounds(250,210,90,30);
                button.addActionListener(this);
                JButton button1 = new JButton("Close");
                button1.setFocusPainted(false);
                button1.setBounds(400,210,90,30);
                button.setIcon(new ImageIcon(Class.class.getResource("/image/tick.png")));
				button1.setIcon(new ImageIcon(Class.class.getResource("/image/remove.png")));
                button1.addActionListener(this);
                add(button);
                add(button1);
                JLabel label1 = new JLabel("Username");
                label1.setBounds(250,90,80,30);
                label1.setFont(new Font("Son Gothic", Font.BOLD, 16));
                JLabel label2 = new JLabel("Password");
                label2.setBounds(250,150,80,30);
                label2.setFont(new Font("Son Gothic", Font.BOLD, 16));
                add(label1);
                add(label2);
                usern = new JTextField();
                usern.setBounds(350,90,170,30); 
                usern.setFont(new Font("Son Gothic", Font.BOLD, 16));
                pass = new JPasswordField();
                pass.setEchoChar('*');
                pass.setBounds(350,150,170,30); 
                pass.setFont(new Font("Son Gothic", Font.BOLD, 16));
                add(usern);
                add(pass);           
                img = new ImageIcon("image/LoginBack1.jpg");
        		imglab = new JLabel(img);
        		imglab.setSize(600,337);
        		add(imglab);
	 		}
	 public void actionPerformed(ActionEvent ae){
           			 String str =ae.getActionCommand();
                      if (str.equals("Login")) {
        		  		try {   

        		  			     String url="jdbc:ucanaccess://Hospital.accdb";
        		  			     connection=DriverManager.getConnection(url);
        		  			     char [] tempPass = pass.getPassword();
                                 typedPassword = new String(tempPass);
        		  			     String sql="select * from Login where Usern='"+usern.getText()+"' and Userp='"+typedPassword+"'";
                                 ps=connection.prepareStatement(sql);
                                 ResultSet rs=ps.executeQuery();
                               
                                if(rs.next()){
                                	JOptionPane.showMessageDialog(null,"Login Successfull");
                                	setVisible(false);
                                	new Home().setVisible(true);
                                }
                                else{
                                	JOptionPane.showMessageDialog(null,"Invalid Username/Password");
                                	usern.setText("");
                                	pass.setText("");
                                }
           					   }catch(Exception ex){
          					     ex.printStackTrace();
          					   }
                    		    
                    	}	
                    	else{
                				   System.exit(0); 
                    	}     
            }		

    public static void main(String[] args){
        Login l=new Login();
        l.setVisible(true); 
     }
  }