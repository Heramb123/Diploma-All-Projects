import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
@SuppressWarnings("deprecation")
public class Upr extends JFrame implements ActionListener{
            ImageIcon icon; 
            ImageIcon img6;
            JLabel imglab6,label3,label4,label5,label6,label7,label8,label9,label10;
            Dimension dimension;
            JTextField pid,name,cno,age,bgrp,addr,anydis,gen; 
            Connection  conn1;
            Statement  st;
            ResultSet  rs;
            String sid;
            String patID,pname,contactNumber,ages,bloodGroup,address,anyMajorDisease,gender;
           
	 Upr(){    
                        Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration()); 
        		Toolkit tk = Toolkit.getDefaultToolkit();
	 	        dimension = Toolkit.getDefaultToolkit().getScreenSize();  
                        int xSize = ((int) tk.getScreenSize().getWidth());
			int ySize = ((int) tk.getScreenSize().getHeight());
			int imgsiz1=xSize;
			int imgsiz2=ySize;    
        		int x=(int)((dimension.getWidth() - 650)/2);
        		int y=(int)((dimension.getHeight() - 650)/2);
        		setLocation(x, y);
				setSize(600,600);
                setLayout(null);
                setUndecorated(true);
        		icon = new ImageIcon("image/refresh.png");
        		setIconImage(icon.getImage());
        		setResizable(false);
                label3 = new JLabel("Patient ID");
                label3.setBounds(150,70,80,30);
                label4 = new JLabel("Name");
                label4.setBounds(150,110,80,30);
                label5 = new JLabel("Contact No");
                label5.setBounds(150,150,80,30);
                label6 = new JLabel("Age");
                label6.setBounds(150,190,80,30);
                label7 = new JLabel("Gender");
                label7.setBounds(150,230,80,30);
                label8 = new JLabel("Blood Group");
                label8.setBounds(150,270,80,30);
                label9 = new JLabel("Address");
                label9.setBounds(150,310,80,30);
                label10 = new JLabel("Any Major Disease Suffered Earlier");
                label10.setBounds(150,350,200,30);
                add(label3);
                add(label4);
                add(label5);
                add(label6);
                add(label7);
                add(label8);
                add(label9);
                add(label10);
                JButton btnsa=new JButton("Update");
                btnsa.setFocusPainted(false);
                btnsa.setIcon(new ImageIcon(Class.class.getResource("/image/tick.png")));
                JButton btnco=new JButton("Close");
                btnco.setFocusPainted(false);
                btnco.setIcon(new ImageIcon(Class.class.getResource("/image/remove.png")));
                JButton btnsr=new JButton("Search");
                btnsr.setFocusPainted(false);
                btnsr.setIcon(new ImageIcon(Class.class.getResource("/image/Search.png")));
                btnsa.setBounds(150,470,100,30);
                btnco.setBounds(350,470,100,30);
                btnsr.setBounds(480,70,100,30);
                add(btnsa);
                add(btnco);
                add(btnsr);
                btnsa.addActionListener(this);
                btnco.addActionListener(this);
                btnsr.addActionListener(this);
                pid = new JTextField();
                pid.setBounds(270,70,180,30);
                name = new JTextField();
                name.setBounds(270,110,180,30);
                cno = new JTextField();
                cno.setBounds(270,150,180,30);
                age = new JTextField();
                age.setBounds(270,190,180,30);
                gen = new JTextField();
                gen.setBounds(270,230,180,30);
                bgrp = new JTextField();
                bgrp.setBounds(270,270,180,30);
                addr = new JTextField();
                addr.setBounds(270,310,180,30);
                anydis = new JTextField();
                if(imgsiz1<=1366 && imgsiz1>=1024 && imgsiz2<=960 && imgsiz2>=768){
                anydis.setBounds(150,350,300,30);
                 }
                if(imgsiz1<=4128 && imgsiz1>=1910 && imgsiz2<=3096 && imgsiz2>=1080){
                anydis.setBounds(150,380,300,30);
               
                 }
                 add(pid);
                 add(name);
                 add(cno);
                 add(age);
                 add(gen);
                 add(bgrp);
                 add(addr);
                 add(anydis);
                img6 = new ImageIcon("image/bg2.jpg");
                imglab6 = new JLabel(img6);
                imglab6.setSize(600,600);
                add(imglab6);
	 		}
            public void actionPerformed(ActionEvent ael){
                    String str1 =ael.getActionCommand();
                    if(str1.equals("Search")){
                       try {
                          sid=pid.getText();
                        conn1=DriverManager.getConnection("jdbc:ucanaccess://Hospital.accdb");
                        st=conn1.createStatement();
                        rs=st.executeQuery("select * from Patient where PatientID='"+sid+"'");
                        if(rs.next()){
                                 name.setText(rs.getString("pname"));
                                 cno.setText(rs.getString("contactNumber"));
                                 age.setText(rs.getString("ages"));
                                 gen.setText(rs.getString("gender"));
                                 bgrp.setText(rs.getString("bloodGroup"));
                                 addr.setText(rs.getString("address"));
                                 anydis.setText(rs.getString("anyMajorDisease"));
                                 pid.setEditable(false);
                           }
                           else{
                                JOptionPane.showMessageDialog(null,"Patient ID Does not Exist"); 
                           }
                        st.close();
                        }catch(Exception ex){
                                 ex.printStackTrace();
                            }
                    } 
                    if(str1.equals("Update")){
                    try {
                         patID =pid.getText();
                         pname =name.getText();
                         contactNumber =cno.getText();
                         ages=age.getText();
                         bloodGroup=bgrp.getText();
                         address=addr.getText();
                         gender=gen.getText();
                         anyMajorDisease=anydis.getText();
                        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                        Connection conn2=DriverManager.getConnection("jdbc:ucanaccess://Hospital.accdb");
                        PreparedStatement pst = conn1.prepareStatement("update Patient set Pname='"+pname+"',ContactNumber='"+contactNumber+"',ages='"+ages+"',gender='"+gender+"',bloodGroup='"+bloodGroup+"',address='"+address+"',anyMajorDisease='"+anyMajorDisease+"'where PatientID='"+patID+"'");
                        pst.executeUpdate();
                    
                       JOptionPane.showMessageDialog(null,"Patient Record Updated Successfull");
                       setVisible(false);
                       new Upr().setVisible(true);
                        }catch(Exception ex){
                                 ex.printStackTrace();
                            }
                    }
                    else if(str1.equals("Close")){
                      setVisible(false);
                    }  
            }
    public static void main(String[] args){
        Upr upr=new Upr();
        upr.setVisible(true); 
     }
  }