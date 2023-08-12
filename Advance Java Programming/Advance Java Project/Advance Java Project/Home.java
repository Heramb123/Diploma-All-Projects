import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Home extends JFrame implements ActionListener{
            ImageIcon icon; 
            ImageIcon img2;
            JLabel imglab2;
            JButton button8;
            JButton button2;
            JButton button3;
            JButton button4;
            JButton button5;
            JButton button6;
            JButton button7;
            int i=0;
	 Home(){    
	 	        Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration()); 
        		Toolkit tk = Toolkit.getDefaultToolkit();
				int xSize = ((int) tk.getScreenSize().getWidth());
				int ySize = ((int) tk.getScreenSize().getHeight());
                                int imgsiz1=xSize;
                                int imgsiz2=ySize;
				int taskBarSize =scnMax.bottom;
				setSize(xSize,ySize-taskBarSize);
        		icon = new ImageIcon("image/home.png");
        		setIconImage(icon.getImage());
        		setLayout(null);
        		setTitle("Home");
                this.setFont(new Font("Son Gothic", Font.BOLD, 16));
        		setResizable(false);
        		setDefaultCloseOperation(EXIT_ON_CLOSE);
                button8 = new JButton();
                button8.setText("");
                button8.setFocusPainted(false);
                button8.setBounds(50,20,67,67);
                button8.setIcon(new ImageIcon(Class.class.getResource("/image/Right-Down Arrow.png")));
                button2 = new JButton("Add New Patient Record");
                button2.setIcon(new ImageIcon(Class.class.getResource("/image/medical-record.png")));
                button2.setBounds(50,100,240,54);
                button2.setFocusPainted(false);
                button3 = new JButton("Add Diagnosis Information");
                button3.setBounds(50,200,240,54);
                button3.setIcon(new ImageIcon(Class.class.getResource("/image/microscope.png")));
                button3.setFocusPainted(false);
                button4 = new JButton("Full History of the Patient");
                button4.setBounds(50,300,240,54);
                button4.setIcon(new ImageIcon(Class.class.getResource("/image/scroll.png")));
                button4.setFocusPainted(false);
                button5 = new JButton("Update Patient Record");
                button5.setBounds(50,400,240,54);
                button5.setIcon(new ImageIcon(Class.class.getResource("/image/refresh.png")));
                button5.setFocusPainted(false);
                button6 = new JButton("Hospital Information");
                button6.setBounds(50,500,240,54);
                button6.setIcon(new ImageIcon(Class.class.getResource("/image/reception.png")));
                button6.setFocusPainted(false);
                button7 = new JButton("Logout");
                button7.setBounds(50,600,240,54);
                button7.setIcon(new ImageIcon(Class.class.getResource("/image/logout.png"))); 
                button7.setFocusPainted(false); 
                add(button8);           
                add(button2);
				add(button3);
				add(button4);
				add(button5);
				add(button6);
				add(button7);
                button8.addActionListener(this);
                button2.addActionListener(this);
                button3.addActionListener(this);
                button4.addActionListener(this);
                button5.addActionListener(this);
                button6.addActionListener(this);
                button7.addActionListener(this);
                //Background image 
                
                if(imgsiz1<=1366 && imgsiz1>=1024 && imgsiz2<=960 && imgsiz2>=768){
                //Background image 
                img2 = new ImageIcon("image/home.jpg");
                imglab2 = new JLabel(img2);
                imglab2.setSize(xSize,ySize-taskBarSize);
                add(imglab2);
                 }
                 if(imgsiz1<=4128 && imgsiz1>=1920 && imgsiz2<=3096 && imgsiz2>=1440){
                //Background image 
                img2 = new ImageIcon("image/Home4128-3096.jpg");
                imglab2 = new JLabel(img2);
                imglab2.setSize(xSize,ySize-taskBarSize);
                add(imglab2);
                 }
                 if(imgsiz1<=1920  && imgsiz1>=1080 && imgsiz2<=1440 && imgsiz2>=960){
                //Background image 
                img2 = new ImageIcon("image/Home1920-1440.jpg");
                imglab2 = new JLabel(img2);
                imglab2.setSize(xSize,ySize-taskBarSize);
                add(imglab2);
                 }
}
             
               public void actionPerformed(ActionEvent ael){
                    String str1 =ael.getActionCommand();
                    if(str1.equals("")){
                     if(i==0){
                         button2.setBounds(130,20,240,54);
                         button3.setBounds(375,20,240,54);
                         button4.setBounds(620,20,240,54);
                         button5.setBounds(865,20,240,54);
                         button6.setBounds(1110,20,240,54);
                         button7.setBounds(1110,84,240,54);
                         i=1;
                        }
                     else{

                         button2.setBounds(50,100,240,54);
                         button3.setBounds(50,200,240,54);
                         button4.setBounds(50,300,240,54);
                         button5.setBounds(50,400,240,54);
                         button6.setBounds(50,500,240,54);
                         button7.setBounds(50,600,240,54);
                         i=0;
                         }
                     }
                    else if(str1.equals("Add New Patient Record")){
                         new Anpr().setVisible(true);  
                    }
                    else if(str1.equals("Add Diagnosis Information")){
                        new Adi().setVisible(true);
                    }
                    else if(str1.equals("Full History of the Patient")){
                        new Fhp().setVisible(true);
                    }
                    else if(str1.equals("Update Patient Record")){
                        new Upr().setVisible(true);
                    }
                    else if(str1.equals("Hospital Information")){
                        new Hinfo().setVisible(true);
                    }
                    else if(str1.equals("Logout")){
                         setVisible(false);
                         new Login().setVisible(true);
                    } 

            }      
    public static void main(String[] args){
        Home h=new Home();
        h.setVisible(true); 
     }
  }