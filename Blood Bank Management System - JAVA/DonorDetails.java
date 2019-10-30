// donor details

import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.event.*;
import java.sql.*;

public class DonorDetails extends JFrame implements ActionListener
{
	private JLabel date,background, datePL, donID, donID2, dName, oc, add, msg, ct, sx, dob, ld, mob, bg, mail, pass, cpass, dName2, oc2, add2, ct2, sx2, dob2, ld2, mob2, bg2, mail2, pass2,  smk, hiv, drg, exp;
	private JButton backButton, exitButton;
	private JPanel panel;
	
	public DonorDetails(String id, String n1, String o1, String s1, String b1, String m1, String ct1, String dob1, String ldd1, String cont1, String mail1, String pass1)
	{
		super("Donor Details");
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

		donID = new JLabel("Donor ID 	");
		donID.setBounds(40,100,170,30);
		donID.setForeground(Color.white);
		panel.add(donID);
		
		donID2 = new JLabel(id);
		donID2.setBounds(200,100,170,30);
		donID2.setForeground(Color.white);
		panel.add(donID2);



		dName = new JLabel("Name 	");
		dName.setBounds(40,135,170,30);
		dName.setForeground(Color.white);
		panel.add(dName);

		dName2 = new JLabel(n1);
		dName2.setBounds(200,135,170,30);
		dName2.setForeground(Color.white);
		panel.add(dName2);
		
		

		oc = new JLabel("Occupation		");
		oc.setBounds(380,135,170,30);
		oc.setForeground(Color.white);
		panel.add(oc);

		oc2 = new JLabel(o1);
		oc2.setBounds(500,135,170,30);
		oc2.setForeground(Color.white);
		panel.add(oc2);
		
		
	

		sx = new JLabel("Sex	");
		sx.setBounds(40,170,170,30);
		sx.setForeground(Color.white);
		panel.add(sx);

		sx2 = new JLabel(s1);
		sx2.setBounds(200,170,170,30);
		sx2.setForeground(Color.white);
		panel.add(sx2);

	

	

		bg = new JLabel("Blood Group	");
		bg.setBounds(380,170,170,30);
		bg.setForeground(Color.white);
		panel.add(bg);

		bg2 = new JLabel(b1);
		bg2.setBounds(500,170,170,30);
		bg2.setForeground(Color.white);
		panel.add(bg2);

	


		add = new JLabel("Mailing Address	");
		add.setBounds(40,205,170,30);
		add.setForeground(Color.white);
		panel.add(add);

		add2 = new JLabel(m1);
		add2.setBounds(200,205,170,30);
		add2.setForeground(Color.white);
		panel.add(add2);


		ct = new JLabel("City	");
		ct.setBounds(380,205,170,30);
		ct.setForeground(Color.white);
		panel.add(ct);

		ct2 = new JLabel(ct1);
		ct2.setBounds(500,205,170,30);
		ct2.setForeground(Color.white);
		panel.add(ct2);
		
		

		
		dob = new JLabel("Date of Birth		");
		dob.setBounds(40,240,170,30);
		dob.setForeground(Color.white);
		panel.add(dob);

		dob2 = new JLabel(dob1);
		dob2.setBounds(200,240,170,30);
		dob2.setForeground(Color.white);
		panel.add(dob2);

	

		ld = new JLabel("Last Donate DT 	");
		ld.setBounds(380,240,170,30);
		ld.setForeground(Color.white);
		panel.add(ld);

		ld2 = new JLabel(ldd1);
		ld2.setBounds(500,240,170,30);
		ld2.setForeground(Color.white);
		panel.add(ld2);


		mob = new JLabel("Contact	");
		mob.setBounds(40,275,170,30);
		mob.setForeground(Color.white);
		panel.add(mob);

		mob2 = new JLabel(cont1);
		mob2.setBounds(200,275,170,30);
		mob2.setForeground(Color.white);
		panel.add(mob2);



		mail = new JLabel("E-Mail	");
		mail.setBounds(380,275,170,30);
		mail.setForeground(Color.white);
		panel.add(mail);

		mail2 = new JLabel(mail1);
		mail2.setBounds(500,275,170,30);
		mail2.setForeground(Color.white);
		panel.add(mail2);


		pass = new JLabel("Password		");
		pass.setBounds(40,310,170,30);
		pass.setForeground(Color.white);
		panel.add(pass);

		pass2 = new JLabel(pass1);
		pass2.setBounds(200,310,170,30);
		pass2.setForeground(Color.white);
		panel.add(pass2);


		msg = new JLabel("Please Collect Your ID and Password");
		msg.setBounds(100,420,500,30);
		msg.setForeground(Color.white);
		msg.setFont(new Font("Comic Sans MS",Font.BOLD, 24));
		panel.add(msg);

		
		exitButton = new JButton("Exit");
		exitButton.setBounds(300,480,80,30);
		exitButton.addActionListener(this);
		panel.add(exitButton);

		panel.add(background);
		
		this.add(panel);
	}

	public void actionPerformed(ActionEvent ae) {

		String elementText = ae.getActionCommand();

		
		if(elementText.equals(exitButton.getText()))
		{
			Donor d = new Donor();
			d.setVisible(true);
			this.setVisible(false);
		}

		else{}
	}
	
}