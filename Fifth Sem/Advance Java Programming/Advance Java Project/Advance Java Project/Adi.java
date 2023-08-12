import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.TableModel; 
import javax.swing.table.DefaultTableModel;
import  net.proteanit.sql.DbUtils;
import javax.swing.table.TableColumnModel;
@SuppressWarnings("deprecation")
public class Adi extends JFrame implements ActionListener{
            int flag=0,campd=0;
            ImageIcon icon; 
            ImageIcon img4;
            Dimension dimension;
            JLabel imglab4,symp,diag,med,wr,twr,pie;
            JTable tab1;
            JTextField pidtxt,tsymp,tdiag,tmed;
            JCheckBox cwr;
            JComboBox<String> ctwr;
            Connection conn1;
            Statement st;
            ResultSet rs;
            DefaultTableModel model;
            TableColumnModel columnModel;
            String s,rcamp="no",dpid,sym,sdiag,smed,wreq,tward;
	 Adi(){    
	 	        dimension = Toolkit.getDefaultToolkit().getScreenSize();      
        		int x=(int)((dimension.getWidth() - 700)/2);
        		int y=(int)((dimension.getHeight() - 500)/2);
        		setLocation(x, y);
				setSize(700,500);
                setLayout(null);
                setUndecorated(true);
                Panel pan= new Panel();
        		icon = new ImageIcon("image/microscope.png");
        		setIconImage(icon.getImage());
        		setResizable(false);
        		JLabel plable = new JLabel("Patient ID");
        		plable.setBounds(225,50,80,30);
        		add(plable);
        		pidtxt = new JTextField();
                pidtxt.setBounds(290,50,100,30);
                add(pidtxt);
        		JButton btnshr=new JButton("Search");
        		btnshr.setFocusPainted(false);
        		btnshr.setIcon(new ImageIcon(Class.class.getResource("/image/Search.png")));
                btnshr.setBounds(400,50,100,30);
                add(btnshr);
                btnshr.addActionListener(this);
                String tbcol[]={"Patient ID","Patient Name","Contact Number","Age","Gender","Blood Group","Address","Any Major Disease"};
				model=new DefaultTableModel(tbcol,1);
				tab1= new JTable(model);  
				tab1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				JScrollPane scrollPane = new JScrollPane( tab1 );
				scrollPane.setLocation(100,125);
		    	scrollPane.setSize(500,55);
		    	columnModel=tab1.getColumnModel();
		    	columnModel.getColumn(1).setPreferredWidth(100);
		    	columnModel.getColumn(2).setPreferredWidth(110);
		    	columnModel.getColumn(7).setPreferredWidth(130);
				add(scrollPane);
                symp = new JLabel("Symptom's");
                symp.setBounds(100,225,80,30);
                diag = new JLabel("Diagnosis");
                diag.setBounds(100,275,80,30);
                med = new JLabel("Medicines");
                med.setBounds(100,325,80,30);
                add(symp);
                add(diag);
                add(med);
                tsymp = new JTextField();
                tsymp.setBounds(170,225,180,30);
                tdiag = new JTextField();
                tdiag.setBounds(170,275,180,30);
                tmed = new JTextField();
                tmed.setBounds(170,325,180,30);
                add(tsymp);
                add(tdiag);
                add(tmed);
                wr = new JLabel("Ward Required");
                wr.setBounds(425,225,100,30);
                add(wr);
                cwr = new JCheckBox("Yes");
                cwr.setLocation(550,225);
                cwr.setSize(80,30);
                add(cwr);
                cwr.addActionListener(this);
                twr = new JLabel("Type of Ward");
                twr.setBounds(425,275,100,30);
                ctwr = new JComboBox<String>(new String[] {"General","Single","Duo"});
                ctwr.setBounds(550,280,100,20);
                twr.setVisible(false);
                ctwr.setVisible(false);
                add(twr);
                add(ctwr);
                JButton btnsaadi=new JButton("Save");
                btnsaadi.setFocusPainted(false);
                btnsaadi.setIcon(new ImageIcon(Class.class.getResource("/image/tick.png")));
                JButton btncoadi=new JButton("Close");
                btncoadi.setFocusPainted(false);
                btncoadi.setIcon(new ImageIcon(Class.class.getResource("/image/remove.png")));
                btnsaadi.addActionListener(this);
                btncoadi.addActionListener(this);
                btnsaadi.setBounds(200,400,100,30);
                btncoadi.setBounds(425,400,100,30);
                add(btnsaadi);
                add(btncoadi);
                pie=new JLabel("PatientID Does not Exist!");
                pie.setLocation(270,90);
                pie.setSize(140,30);
                pie.setForeground(Color.RED);
                pie.setVisible(false);
                add(pie);
                img4 = new ImageIcon("image/back3.jpg");
                imglab4 = new JLabel(img4);
                imglab4.setSize(700,500);
                add(imglab4);
	 		}
            public void actionPerformed(ActionEvent ael){
                  String adistr =ael.getActionCommand();  
                   if(adistr.equals("Search")){
                      try {
                      
                        conn1=DriverManager.getConnection("jdbc:ucanaccess://Hospital.accdb");
                        st=conn1.createStatement();
                        rs=st.executeQuery("select * from Patient where PatientID='"+pidtxt.getText()+"'");
                        tab1.setModel(DbUtils.resultSetToTableModel(rs));
                        st.close();
                          columnModel=tab1.getColumnModel();
		    			  columnModel.getColumn(1).setPreferredWidth(100);
		    			  columnModel.getColumn(6).setPreferredWidth(130);
                        }catch(Exception ex){
                                 ex.printStackTrace();
                            }
                        try {
                      
                        conn1=DriverManager.getConnection("jdbc:ucanaccess://Hospital.accdb");
                        st=conn1.createStatement();
                        rs=st.executeQuery("select PatientID from Patient where PatientID='"+pidtxt.getText()+"'");
                        while(rs.next()){
                         rcamp=rs.getString("PatientID");
                        }
                        String pidcamp=pidtxt.getText();
                        campd=rcamp.compareToIgnoreCase(pidcamp);
                        if(campd==0){

                                	pie.setVisible(false);
                                	pidtxt.setEditable(false);
                                	flag=1;
                                }
                                else{
                                	pie.setVisible(true);
                                }
                       
                 
                                 st.close();
                          columnModel=tab1.getColumnModel();
		    			  columnModel.getColumn(1).setPreferredWidth(100);
		    			  columnModel.getColumn(6).setPreferredWidth(130);
                        }catch(Exception ex){
                                 ex.printStackTrace();
                            }


                   }
                   if(cwr.isSelected()){
                         twr.setVisible(true);
                         ctwr.setVisible(true);
                   }
                   else{
                   	     twr.setVisible(false);
                         ctwr.setVisible(false);
                   }
                   if(adistr.equals("Save")){
                         if(flag==1){
                               dpid=pidtxt.getText();
                               sym=tsymp.getText();
                               sdiag=tdiag.getText();
                               smed=tmed.getText();

                              if(cwr.isSelected()){
                              	  wreq="Yes";
                                  tward=(String)ctwr.getSelectedItem();
                                }
                               else{
                                  wreq="No"; 
                                  tward="";
                               } 
                               try {
                              Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                              Connection conn1=DriverManager.getConnection("jdbc:ucanaccess://Hospital.accdb");
                              PreparedStatement st = conn1.prepareStatement("insert into Patientreport(PatientID,Symptom,Diagnosis,Medicines,WardReq,TypeWard) values(?,?,?,?,?,?)");
                              st.setString(1,dpid);
                              st.setString(2,sym);
                              st.setString(3,sdiag);
                              st.setString(4,smed);
                              st.setString(5,wreq);
                              st.setString(6,tward);
                              st.executeUpdate();
                             JOptionPane.showMessageDialog(null,"Diagnosis Information as Added Successfull");
                             setVisible(false);
                             new Adi().setVisible(true);
                              }catch(Exception ex){
                                       ex.printStackTrace();
                                  }
                            }
                            else{
                     	          JOptionPane.showMessageDialog(null,"Patient ID Field is Empty");
                                }      
                        }
                        
                   if(adistr.equals("Close")){
                          setVisible(false);
                   }
                   
                }
    public static void main(String[] args){
         Adi adi=new Adi();
         adi.setVisible(true);;
     }
  }