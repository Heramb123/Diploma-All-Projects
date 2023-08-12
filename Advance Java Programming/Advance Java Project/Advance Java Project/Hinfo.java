import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Hinfo extends JFrame implements ActionListener{
            
            ImageIcon icon; 
            ImageIcon img5,img6;
            Dimension dimension;
            JLabel imglab5,imglab6;
            
	 Hinfo(){    
	 	        dimension = Toolkit.getDefaultToolkit().getScreenSize();      
        		int x=(int)((dimension.getWidth() - 700)/2);
        		int y=(int)((dimension.getHeight() - 500)/2);
        		setLocation(x, y);
				    setSize(700,500);
            setLayout(null);
            setUndecorated(true);
        		icon = new ImageIcon("image/reception.png");
        		setIconImage(icon.getImage());
        		setResizable(false);
            img6 = new ImageIcon("image/hospital.jpg");
            imglab6 = new JLabel(img6);
            imglab6.setSize(500,280);
            imglab6.setLocation(100,10);
            add(imglab6);
            JTextArea textarea= new JTextArea("CHI Memorial Hospital Chattanooga is a not-for-profit,faith-based hospital located in Chattanooga, Tennessee."+
                                              "The hospital opened in 1952 and has expanded to better meet the needs of our region.CHI Memorial Hospital Chattanooga"+
                                              "is part of CHI Memorial, an integrated health system with more than 3,500 employees, 661 medical staff members and 500 volunteers."+
                                              "Physicians and associates collaborate across the health system providing exceptional quality health care in the southeast Tennessee"+
                                              "and northwest Georgia region.");
            textarea.setBounds(100,300,500,133);
            textarea.setEditable(false);
            textarea.setBackground(new Color(221,231,229));
            textarea.setFont(new Font("Serif", Font.ITALIC, 14));
            textarea.setLineWrap(true);
            textarea.setWrapStyleWord(true);
            add(textarea);
            JButton clobtn= new JButton("Close");
            clobtn.setFocusPainted(false);
            clobtn.setIcon(new ImageIcon(Class.class.getResource("/image/remove.png")));
            clobtn.setBounds(500,445,100,30);
            add(clobtn);
            clobtn.addActionListener(this);
                img5 = new ImageIcon("image/blueback.jpeg");
                imglab5 = new JLabel(img5);
                imglab5.setSize(700,500);
                add(imglab5);
	 		}
       public void actionPerformed(ActionEvent ae){
                 String str =ae.getActionCommand();
                      if (str.equals("Close")) {
                            setVisible(false);    
                       } 
                     }
    public static void main(String[] args){
         Hinfo hinfo=new Hinfo();
         hinfo.setVisible(true);;
     }
  }