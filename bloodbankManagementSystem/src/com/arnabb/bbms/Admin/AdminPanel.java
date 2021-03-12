package com.arnabb.bbms.Admin;//gui 5 / adminPanel


import com.arnabb.bbms.Donor.DeleteDonor;
import com.arnabb.bbms.Login.Login;
import com.arnabb.bbms.Login.Register;

import java.io.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.event.*;

public class AdminPanel extends JFrame implements ActionListener
{
	private JLabel background,labelWelcome, title, userlabel, userIDlabel;
	private JButton createAdminButton, deleteDonorButton, deleteAdminButton, RegDonorButton, buttonLogout;
	private JPanel panel;
	//private String adId;
	
	public AdminPanel(String adId) 
	{
		super("BBMS : Admin Panel");
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

		
		/*labelWelcome = new JLabel("Logged In: "+adId);
		labelWelcome.setBounds(230, 50, 200, 30);
		panel.add(labelWelcome);*/

		title  = new JLabel ("Welcome");
		title.setBounds(100, 60, 400, 100);
		title.setOpaque(false);
		title.setVisible(true);
		title.setFont(new Font("Comic Sans MS",Font.ITALIC+Font.BOLD, 54));
		title.setForeground(Color.white);
		panel.add(title);

		userlabel  = new JLabel ("Admin ID  ");
		userlabel.setBounds(100, 100, 100, 30);
		userlabel.setForeground(Color.white);
		panel.add(userlabel);

		userIDlabel = new JLabel(adId);
		userIDlabel.setBounds(100,120,50,30);
		panel.add(userIDlabel);
		
		createAdminButton = new JButton("Create Admin");
		createAdminButton.setBounds(150, 300, 150, 30);
		createAdminButton.addActionListener(this);
		panel.add(createAdminButton);
		
		deleteDonorButton = new JButton("Delete com.arnabb.bbms.Donor.Donor Acc");
		deleteDonorButton.setBounds(400, 300, 150, 30);
		deleteDonorButton.addActionListener(this);
		panel.add(deleteDonorButton);

		deleteAdminButton = new JButton("Delete Admin Acc");
		deleteAdminButton.setBounds(400, 400, 150, 30);
		deleteAdminButton.addActionListener(this);
		panel.add(deleteAdminButton);
		
		RegDonorButton = new JButton("com.arnabb.bbms.Login.Register com.arnabb.bbms.Donor.Donor");
		RegDonorButton.setBounds(150, 400, 150, 30);
		RegDonorButton.addActionListener(this);
		panel.add(RegDonorButton);
		
		buttonLogout = new JButton("Sign Out");
		buttonLogout.setBounds(290, 500, 150, 30);
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);

		panel.add(background);

		this.add(panel);
		//this.adId=adId;
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String buttonClicked = ae.getActionCommand();
		
		if(buttonClicked.equals(createAdminButton.getText()))
		{
			String aID = userIDlabel.getText();

			try{
				CreateAdmin ca = new CreateAdmin(aID);
				ca.setVisible(true);
				this.setVisible(false);
			}

			catch(Exception e){
				e.printStackTrace();
			}
			

		}

		else if(buttonClicked.equals(deleteAdminButton.getText()))
		{

			String aID = userIDlabel.getText();

			try{
				DeleteAdmin da = new DeleteAdmin(aID);
				da.setVisible(true);
				this.setVisible(false);
			}

			catch(Exception e){
				e.printStackTrace();
			}
			

		}
			
		else if(buttonClicked.equals(deleteDonorButton.getText()))
		{
			String aID = userIDlabel.getText();

			try{
				DeleteDonor dd = new DeleteDonor(aID);
				dd.setVisible(true);
				this.setVisible(false);
			}
			

			catch(Exception e){
				e.printStackTrace();
			}
		}

			

		else if(buttonClicked.equals(RegDonorButton.getText()))
		{

			/*System.out.println("hell");

			

			//
			//JFrame frame = new JFrame();
			this.add(com.arnabb.bbms.Login.Register.getRegRef().panel,BorderLayout.CENTER);
			System.out.println("again hell");
			this.remove(this.panel);
			//com.arnabb.bbms.Login.Register.getRegRef().paintALL(com.arnabb.bbms.Login.Register.getRegRef().getGraphics());*/



			try{
				Register r = new Register();
				r.setVisible(true);
				this.setVisible(false);
			}

			catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
		else if(buttonClicked.equals(buttonLogout.getText()))
		{
			try{
				Login l = new Login();
				l.setVisible(true);
				this.setVisible(false);
			}

			catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}


}