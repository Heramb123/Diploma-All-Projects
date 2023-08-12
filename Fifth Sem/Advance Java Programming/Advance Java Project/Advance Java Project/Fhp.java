import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.TableModel; 
import javax.swing.table.DefaultTableModel;
import  net.proteanit.sql.DbUtils;
import javax.swing.table.TableColumnModel;
@SuppressWarnings("deprecation")
public class Fhp extends JFrame implements ActionListener{
            
            ImageIcon icon; 
            ImageIcon img5;
            Dimension dimension;
            JLabel imglab5;
            JTable tab1;
            Connection conn1;
            Statement st;
            ResultSet rs;
            DefaultTableModel model;
            TableColumnModel columnModel;
	 Fhp(){    
	 	        dimension = Toolkit.getDefaultToolkit().getScreenSize();      
        		int x=(int)((dimension.getWidth() - 700)/2);
        		int y=(int)((dimension.getHeight() - 500)/2);
        		setLocation(x, y);
				    setSize(700,500);
            setLayout(null);
            setUndecorated(true);
        		icon = new ImageIcon("image/Scroll.png");
        		setIconImage(icon.getImage());
        		setResizable(false);            		
            String tbcol[]={"Patient ID","Patient Name","Contact Number","Age","Gender","Blood Group","Address","Any Major Disease","patientID","Symptom","Diagnosis","Medicines","WardReq","TypeWard"};
			    	model=new DefaultTableModel(tbcol,0);
			    	tab1= new JTable(model);  
			    	tab1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			    	JScrollPane scrollPane = new JScrollPane( tab1 );
			    	scrollPane.setLocation(50,20);
		        scrollPane.setSize(600,400);
		        columnModel=tab1.getColumnModel();
		    	  columnModel.getColumn(1).setPreferredWidth(100);
		        columnModel.getColumn(2).setPreferredWidth(110);
		        columnModel.getColumn(7).setPreferredWidth(130);
				     add(scrollPane);
          
           try {
                conn1=DriverManager.getConnection("jdbc:ucanaccess://Hospital.accdb");
                st=conn1.createStatement();
                rs=st.executeQuery("select * from Patient inner join Patientreport on Patient.PatientID=Patientreport.PatientID");
                tab1.setModel(DbUtils.resultSetToTableModel(rs));
                st.close();
                columnModel=tab1.getColumnModel();
                columnModel.getColumn(1).setPreferredWidth(100);
                columnModel.getColumn(6).setPreferredWidth(130);
                  }catch(Exception ex){
                          ex.printStackTrace();
                      }   
                      JButton btncofhp=new JButton("Close");
                      btncofhp.setFocusPainted(false);
                      btncofhp.setIcon(new ImageIcon(Class.class.getResource("/image/remove.png")));
                      btncofhp.setBounds(500,435,100,30);
                      add(btncofhp);
                      btncofhp.addActionListener(this);
                img5 = new ImageIcon("image/blueback.jpeg");
                imglab5 = new JLabel(img5);
                imglab5.setSize(700,500);
                add(imglab5);
	 		}
            public void actionPerformed(ActionEvent ael){
                  String adistr =ael.getActionCommand();  
                   if(adistr.equals("Close")){
                     setVisible(false);
                   }
                }
    public static void main(String[] args){
         Fhp fhp=new Fhp();
         fhp.setVisible(true);;
     }
  }