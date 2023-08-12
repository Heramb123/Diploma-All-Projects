import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
@SuppressWarnings("deprecation")
public class Anpr extends JFrame implements ActionListener{
            ImageIcon icon; 
            ImageIcon img3;
            JLabel imglab3,label3,label4,label5,label6,label7,label8,label9,label10;
            Dimension dimension;
            JTextField pid,name,cno,age,bgrp,addr,anydis;
            JComboBox<String> gen; 
	 Anpr(){    
	 	        dimension = Toolkit.getDefaultToolkit().getScreenSize();      
        		int x=(int)((dimension.getWidth() - 650)/2);
        		int y=(int)((dimension.getHeight() - 650)/2);
        		setLocation(x, y);
				setSize(600,600);
                setLayout(null);
                setUndecorated(true);
        		icon = new ImageIcon("image/medical-record.png");
        		setIconImage(icon.getImage());
        		setResizable(false);
                label3 = new JLabel("Patient ID");
                label3.setBounds(150,50,80,30);
                label4 = new JLabel("Name");
                label4.setBounds(150,90,80,30);
                label5 = new JLabel("Contact No");
                label5.setBounds(150,130,80,30);
                label6 = new JLabel("Age");
                label6.setBounds(150,170,80,30);
                label7 = new JLabel("Gender");
                label7.setBounds(150,210,80,30);
                label8 = new JLabel("Blood Group");
                label8.setBounds(150,250,80,30);
                label9 = new JLabel("Address");
                label9.setBounds(150,290,80,30);
                label10 = new JLabel("Any Major Disease Suffered Earlier");
                label10.setBounds(150,330,200,30);
                add(label3);
                add(label4);
                add(label5);
                add(label6);
                add(label7);
                add(label8);
                add(label9);
                add(label10);
                JButton btnsa=new JButton("Save");
                btnsa.setFocusPainted(false);
                btnsa.setIcon(new ImageIcon(Class.class.getResource("/image/tick.png")));
                JButton btnco=new JButton("Close");
                btnco.setFocusPainted(false);
                btnco.setIcon(new ImageIcon(Class.class.getResource("/image/remove.png")));
                btnsa.setBounds(150,450,100,30);
                btnco.setBounds(350,450,100,30);
                add(btnsa);
                add(btnco);
                btnsa.addActionListener(this);
                btnco.addActionListener(this);
                pid = new JTextField();
                pid.setBounds(270,50,180,30);
                name = new JTextField();
                name.setBounds(270,90,180,30);
                cno = new JTextField();
                cno.setBounds(270,130,180,30);
                age = new JTextField();
                age.setBounds(270,170,180,30);
                gen = new JComboBox<String>(new String[] {"Male","Female","Other"});
                gen.setBounds(270,210,180,30);
                bgrp = new JTextField();
                bgrp.setBounds(270,250,180,30);
                addr = new JTextField();
                addr.setBounds(270,290,180,30);
                anydis = new JTextField();
                anydis.setBounds(150,370,300,30);
                 add(pid);
                 add(name);
                 add(cno);
                 add(age);
                 add(gen);
                 add(bgrp);
                 add(addr);
                 add(anydis);
                 img3 = new ImageIcon("image/bg1.jpg");
                 imglab3 = new JLabel(img3);
                 imglab3.setSize(600,600);
                 add(imglab3);
	 		}
            public void actionPerformed(ActionEvent ael){
                    String str1 =ael.getActionCommand();
                    String patientID =pid.getText();
                    String pname =name.getText();
                    String contactNumber =cno.getText();
                    String ages=age.getText();
                    String gender=(String)gen.getSelectedItem();
                    String bloodGroup=bgrp.getText();
                    String address=addr.getText();
                    String anyMajorDisease=anydis.getText(); 
                    if(str1.equals("Save")){
                    try {
                        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                        Connection conn1=DriverManager.getConnection("jdbc:ucanaccess://Hospital.accdb");
                        PreparedStatement st = conn1.prepareStatement("insert into Patient(PatientID,Pname,ContactNumber,ages,gender,bloodGroup,address,anyMajorDisease) values(?,?,?,?,?,?,?,?)");
                        st.setString(1,patientID);
                        st.setString(2,pname);
                        st.setString(3,contactNumber);
                        st.setString(4,ages);
                        st.setString(5,gender);
                        st.setString(6,bloodGroup);
                        st.setString(7,address);
                        st.setString(8,anyMajorDisease);
                        st.executeUpdate();
                       JOptionPane.showMessageDialog(null,"Added New Patient Record Successfull");
                       setVisible(false);
                       new Anpr().setVisible(true);
                        }catch(Exception ex){
                                 ex.printStackTrace();
                            }
                    }
                    else if(str1.equals("Close")){
                      setVisible(false);
                    }  
            }
    public static void main(String[] args){
         Anpr apr=new Anpr();
        apr.setVisible(true); 
     }
  }