//try / gui 2 / login

import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements MouseListener, ActionListener {

	private JLabel title, imgLab, background, userLabel, passLabel;
	private JPanel panel;
	private JTextField userTF;
	private JPasswordField passPF;
	private JButton loginButton, backButton;
	private boolean flag;
	//private JComboBox combo;

	public Login() {

		super("BBMS : Admin Login");
		this.setSize(700,600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setLayout(null);

		BufferedImage img = null;
			try {
			    img = ImageIO.read(new File("Blood-Cells-1318x800.jpg"));
			    background = new JLabel( new ImageIcon(img) );
				background.setBounds(0, 0, 700, 600);
			
			} 
			catch (IOException e) { }


		title  = new JLabel ("Adminimistration");
		title.setBounds(100, 60, 400, 100);
		title.setOpaque(false);
		title.setVisible(true);
		title.setFont(new Font("Comic Sans MS",Font.ITALIC+Font.BOLD, 32));
		title.setForeground(Color.white);
		panel.add(title);
		

		userLabel = new JLabel("Admin ID");
		userLabel.setBounds(280,200,200,35);
		userLabel.setForeground(Color.white);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(220,230,200,35);
		panel.add(userTF);

		passLabel = new JLabel("Password");
		passLabel.setBounds(290,260,200,35);
		passLabel.setForeground(Color.white);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(220,290,200,35);
		//passPF.setEchoChar('*');
		//passPF.setBackground(Color.GRAY);
		panel.add(passPF);
		
		loginButton = new JButton("Sign In");
		loginButton.setBounds(220,340,200,35);
		loginButton.addMouseListener(this);
		loginButton.addActionListener(this);
		panel.add(loginButton);
		
		backButton = new JButton("Cancel");
		backButton.setBounds(220,380,200,35);
		//backButton.setBackground(Color.RED);
		backButton.addMouseListener(this);
		backButton.addActionListener(this);
		panel.add(backButton);
		
		/*String []s = {"Adminimistrator", "Donor"};	
		combo = new JComboBox(s);
		combo.setBounds(450,250,150,35);
		panel.add(combo);*/

		panel.add(background);
		
		this.add(panel);
	}

	public void mouseEntered(MouseEvent me){ }
	public void mouseExited(MouseEvent me){ }
	public void mouseReleased(MouseEvent me){	}
	public void mousePressed(MouseEvent me){	}
	public void mouseClicked(MouseEvent me){	}

	public void actionPerformed(ActionEvent ae)
	{
		String elementText = ae.getActionCommand();


		if (elementText.equals(loginButton.getText())){

			//System.out.println("hello");
			//flag=true;
			check();

			
		}

		else if(elementText.equals(backButton.getText()))
		{
			try{
				Homee h = new Homee();
				h.setVisible(true);
				this.setVisible(false);

			}

			catch(Exception e){
				e.printStackTrace();
			}

			
		}
		else{
			//System.exit(0);
		}
	}


	public void check()
	{

		String adId = userTF.getText();
        String password = passPF.getText();

        if (adId.length()!=0) {

        	if (password.length()!=0) {
        	
       

		        String query = "SELECT AdminID, Password FROM admin_info where AdminID = '"+adId+"' and password = '"+password+"';";     
		        Connection con=null;//for connection
		        Statement st = null;//for query execution
				ResultSet rs = null;//to get row by row result from DB
				System.out.println(query);
		        try
				{
					Class.forName("com.mysql.jdbc.Driver");//load driver
					System.out.println("driver loaded");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg","root","");
					System.out.println("connection done");//connection with database established
					st = con.createStatement();//create statement
					System.out.println("statement created");
					rs = st.executeQuery(query);//getting result
					System.out.println("results received");

					if (rs.next()){
						//System.out.println("trrrrryyyyy!!");


						try{
							
							AdminPanel ah = new AdminPanel(adId);
							ah.setVisible(true);
							this.setVisible(false);
						}

						catch(Exception e){
							e.printStackTrace();
						}


					}
					else{
						JOptionPane.showMessageDialog(this,"Please Enter Proper Details");
					}
				}
			

		        catch(Exception ex)
				{
					System.out.println("Exception : " +ex.getMessage());
		        }
		        finally
				{
		            try
					{
		                if(rs!=null)
							rs.close();

		                if(st!=null)
							st.close();

		                if(con!=null)
							con.close();
		            }
		            catch(Exception ex){}
		        }
		    }

		    else {
				JOptionPane.showMessageDialog(this,"Enter Proper Pass");
			}
		}

	    else {
			JOptionPane.showMessageDialog(this,"Enter Proper ID");
		}

    } 
}

