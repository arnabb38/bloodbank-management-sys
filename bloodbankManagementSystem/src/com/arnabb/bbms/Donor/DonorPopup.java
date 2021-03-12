package com.arnabb.bbms.Donor;//delete donor popup


import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.event.*;
import java.sql.*;



public class DonorPopup extends JFrame implements ActionListener
{
	private JLabel nameLabel,background, numberLabel, initialBalanceLabel, idLabel, msgLabel, passwordLabel, donID, donID2, dName, oc, add, ct, sx, dob, ld, mob, bg, mail, pass, cpass, dName2, oc2, add2, ct2, sx2, dob2, ld2, mob2, bg2, mail2, pass2;
	private JTextField nameTF, numberTF, initialBalanceTF, idTF;
	private JPasswordField passwordPF;
	private JButton buttonDelete, buttonLogout, buttonInsert;
	private JPanel panel;
	

	public DonorPopup(String id, String n1, String o1, String s1, String b1, String m1, String ct1, String dob1, String ldd1, String cont1, String mail1, String pass1) 
	{
		super("Deletion Popup");
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


		donID = new JLabel("com.arnabb.bbms.Donor.Donor ID 	");
		donID.setBounds(40,100,170,30);
		panel.add(donID);
		
		donID2 = new JLabel(id);
		donID2.setBounds(170,100,170,30);
		panel.add(donID2);


		dName = new JLabel("Name 	");
		dName.setBounds(40,135,170,30);
		panel.add(dName);

		dName2 = new JLabel(n1);
		dName2.setBounds(170,135,170,30);
		panel.add(dName2);
		
		

		oc = new JLabel("Occupation		");
		oc.setBounds(380,135,170,30);
		panel.add(oc);

		oc2 = new JLabel(o1);
		oc2.setBounds(490,135,170,30);
		panel.add(oc2);
		
		
	

		sx = new JLabel("Sex	");
		sx.setBounds(40,170,170,30);
		panel.add(sx);

		sx2 = new JLabel(s1);
		sx2.setBounds(170,170,170,30);
		panel.add(sx2);

	

	

		bg = new JLabel("Blood Group	");
		bg.setBounds(380,170,170,30);
		panel.add(bg);

		bg2 = new JLabel(b1);
		bg2.setBounds(490,170,170,30);
		panel.add(bg2);

	


		add = new JLabel("Mailing Address	");
		add.setBounds(40,205,170,30);
		panel.add(add);

		add2 = new JLabel(m1);
		add2.setBounds(170,205,170,30);
		panel.add(add2);


		ct = new JLabel("City	");
		ct.setBounds(380,205,170,30);
		panel.add(ct);

		ct2 = new JLabel(ct1);
		ct2.setBounds(490,205,170,30);
		panel.add(ct2);
		
		

		
		dob = new JLabel("Date of Birth		");
		dob.setBounds(40,240,170,30);
		panel.add(dob);

		dob2 = new JLabel(dob1);
		dob2.setBounds(170,240,170,30);
		panel.add(dob2);

	

		ld = new JLabel("Last Donate DT 	");
		ld.setBounds(380,240,170,30);
		panel.add(ld);

		ld2 = new JLabel(ldd1);
		ld2.setBounds(490,240,170,30);
		panel.add(ld2);


		mob = new JLabel("Contact	");
		mob.setBounds(40,275,170,30);
		panel.add(mob);

		mob2 = new JLabel(cont1);
		mob2.setBounds(170,275,170,30);
		panel.add(mob2);



		mail = new JLabel("E-Mail	");
		mail.setBounds(380,275,170,30);
		panel.add(mail);

		mail2 = new JLabel(mail1);
		mail2.setBounds(490,275,170,30);
		panel.add(mail2);


		pass = new JLabel("Password		");
		pass.setBounds(40,310,170,30);
		panel.add(pass);

		pass2 = new JLabel(pass1);
		pass2.setBounds(170,310,170,30);
		panel.add(pass2);

		msgLabel = new JLabel("Delete Your Account");
		msgLabel.setBounds(100,350,150,30);
		panel.add(msgLabel);
		
		
		idLabel = new JLabel("Organization ID  ");
		idLabel.setBounds(100,400,150,30);
		panel.add(idLabel);
		
		idTF = new JTextField();
		idTF.setBounds(260,400,100,30);
		panel.add(idTF);
		
		passwordLabel = new JLabel("Confirm Password  ");
		passwordLabel.setBounds(100, 450, 150, 30);
		panel.add(passwordLabel);
		
		passwordPF =new JPasswordField();
		passwordPF.setBounds(260, 450, 100, 30);
		panel.add(passwordPF);
		
		buttonDelete = new JButton("Delete");
		buttonDelete.setBounds(100, 500, 80, 30);
		buttonDelete.addActionListener(this);
		panel.add(buttonDelete);

		panel.add(background);

		this.add(panel);

	}

		public void actionPerformed(ActionEvent ae){

			String buttonClicked = ae.getActionCommand();

			 if(buttonClicked.equals(buttonDelete.getText())) {

					deleteFromDB1();
					deleteFromDB2();
					deleteFromDB3();
					deleteFromDB4();
				}


		}

		public void deleteFromDB1()
		{
			String query = "DELETE from main_info where DonorID="+numberTF.getText()+";";
			System.out.println(query);
	        try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg", "root", "");
				Statement stm = con.createStatement();
				stm.execute(query);
				stm.close();
				con.close();
						
			}
	        catch(Exception ex)
			{
				System.out.println("Exception : " +ex.getMessage());
	        }
	    }

	    public void deleteFromDB2()
		{
			String query = "DELETE from contact where DonorID="+numberTF.getText()+";";
			System.out.println(query);
	        try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg", "root", "");
				Statement stm = con.createStatement();
				stm.execute(query);
				stm.close();
				con.close();
						
			}
	        catch(Exception ex)
			{
				System.out.println("Exception : " +ex.getMessage());
	        }
	    }

	    public void deleteFromDB3()
		{
			String query = "DELETE from donorpass where DonorID="+numberTF.getText()+";";
			System.out.println(query);
	        try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg", "root", "");
				Statement stm = con.createStatement();
				stm.execute(query);
				stm.close();
				con.close();
						
			}
	        catch(Exception ex)
			{
				System.out.println("Exception : " +ex.getMessage());
	        }
	    }

	    public void deleteFromDB4()
		{
			String query = "DELETE from extras where DonorID="+numberTF.getText()+";";
			System.out.println(query);
	        try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg", "root", "");
				Statement stm = con.createStatement();
				stm.execute(query);
				stm.close();
				con.close();
						
			}
	        catch(Exception ex)
			{
				System.out.println("Exception : " +ex.getMessage());
	        }
	    }

	





}
