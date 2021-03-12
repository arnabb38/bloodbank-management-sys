package com.arnabb.bbms.Donor;//try / gui 4 / donor

import com.arnabb.bbms.Home.Homee;
import com.arnabb.bbms.Login.Register;

import java.io.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.event.*;
import java.sql.*;

public class Donor extends JFrame implements MouseListener, ActionListener {

	private JLabel reg,background, title, ex, userLabel, passLabel;
	private JTextField userTF;
	private JPasswordField passPF;
	private JButton regButton, exButton, backButton, loginButton;
	private JPanel panel;
	private String uID;

	public Donor() {

		super ("com.arnabb.bbms.Donor.Donor");
		this.setSize(700,600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setLayout(null);

		BufferedImage img = null;
			try {
			    img = ImageIO.read(new File("assets/Blood-Cells-1318x800.jpg"));
			    background = new JLabel( new ImageIcon(img) );
				background.setBounds(0, 0, 700, 600);
			} 
			catch (IOException e) { }


		title  = new JLabel ("com.arnabb.bbms.Donor.Donor");
		title.setBounds(300, 60, 400, 100);
		title.setOpaque(false);
		title.setVisible(true);
		title.setFont(new Font("Comic Sans MS",Font.ITALIC+Font.BOLD, 54));
		title.setForeground(Color.white);
		panel.add(title);



		userLabel = new JLabel("com.arnabb.bbms.Donor.Donor ID");
		userLabel.setBounds(310,200,200,35);
		userLabel.setForeground(Color.white);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(250,230,200,35);
		panel.add(userTF);

		passLabel = new JLabel("Password");
		passLabel.setBounds(320,260,200,35);
		passLabel.setForeground(Color.white);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(250,290,200,35);
		panel.add(passPF);

		reg = new JLabel ("com.arnabb.bbms.Login.Register Yourself As a com.arnabb.bbms.Donor.Donor");
		reg.setBounds(190, 400, 400, 40);
		reg.setForeground(Color.white);
		reg.setFont(new Font("Comic Sans MS",Font.BOLD, 24));
		panel.add(reg);

		regButton = new JButton("com.arnabb.bbms.Login.Register");
		regButton.setBounds(250,450,200,30);
		regButton.addMouseListener(this);
		regButton.addActionListener(this);
		panel.add(regButton);

		loginButton = new JButton("com.arnabb.bbms.Login.Login");
		loginButton.setBounds(250,340,200,35);
		loginButton.addMouseListener(this);
		loginButton.addActionListener(this);
		panel.add(loginButton);



		backButton = new JButton("Back");
		backButton.setBounds(300,500,100,30);
		backButton.addMouseListener(this);
		backButton.addActionListener(this);
		panel.add(backButton);

		panel.add(background);


		this.add(panel);

	}

	public void mouseEntered(MouseEvent me){ }
	public void mouseExited(MouseEvent me){ }
	public void mouseReleased(MouseEvent me){	}
	public void mousePressed(MouseEvent me){	}
	public void mouseClicked(MouseEvent me){	}

	public void actionPerformed(ActionEvent ae){

		String elementText = ae.getActionCommand();

		if(elementText.equals(regButton.getText()))
		{
			try {
				Register r = new Register();
				r.setVisible(true);
				this.setVisible(false);
			}

			catch(Exception e){
				e.printStackTrace();
			}
		}	

		/*else if(elementText.equals(ex.getText()))
		{
			try {
				com.arnabb.bbms.Login.Register r = new com.arnabb.bbms.Login.Register();
				r.setVisible(true);
				this.setVisible(false);
			}

			catch(Exception e){
				e.printStackTrace();
			}
		}*/
		
		else if(elementText.equals(backButton.getText()))
		{
			try {
				Homee h = new Homee();
				h.setVisible(true);
				this.setVisible(false);
			}

			catch(Exception e){
				e.printStackTrace();
			}
		}

		else if(elementText.equals(loginButton.getText()))
		{
			
			check();
		}


		else{}
	}


	public void check()
	{

		String donId = userTF.getText();
        String password = passPF.getText();

        if (donId.length()!=0) {

        	if (password.length()!=0) {
        	
       

		        String query = "SELECT DonorID, Password FROM donorpass where DonorID = '"+donId+"' and password = '"+password+"';";     
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

						uID = rs.getString(1);
						//System.out.println("trrrrryyyyy!!" +uID);


						try{
							
							DonorLogin dLog = new DonorLogin(uID);
							dLog.setVisible(true);
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
				JOptionPane.showMessageDialog(this,"Enter Proper Password");
			}
		}

	    else {
			JOptionPane.showMessageDialog(this,"Enter Proper ID");
		}

    } 



}
