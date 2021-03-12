package com.arnabb.bbms.Login;//try / gui 3 / registration

import com.arnabb.bbms.Donor.Donor;
import com.arnabb.bbms.Donor.DonorDetails;

import java.io.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.event.*;
import java.sql.*;
//import java.text.SimpleDateFormat;

public class Register extends JFrame implements MouseListener, ActionListener {

	private JLabel dNum, date,background, title, datePL, dName, oc, add, ct, sx, dob, ld, mob, bg, mail, pass, cpass, smk, hiv, drg, exp;
	public JPanel panel;
	private JTextField dNumTF, dateTF, dnTF, ocTF, addTF, ctTF, mobTF, mailTF;
	private JPasswordField passPF, cpassPF;
	private JButton regButton, cancelButton;
	private ButtonGroup bg1, bg2, bg3, bg4;
	private JCheckBox c1EXP,c2EXP, c1SMK, c2SMK, c1HIV, c2HIV, c1DRG, c2DRG;
	private JComboBox combo1, combo2, day, month, year, lday, lmonth, lyear;
	private JRadioButton r1, r2, r3, r4;
	public static int dID = scanID();
	public static Register regRef = null;

	public static int scanID(){

		int row = 0;
		try{
			//String url = "jdbc:mysql://localhost/d_reg";
			//Connection c = DBConnector.getDataBaseConnection(url);

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg", "root", "");

			String query = "SELECT MAX(DonorID) FROM main_info";

			Statement stm = con.createStatement();
			
			//Statement s = c.createStatement();
			ResultSet result = stm.executeQuery(query);
			if (result.next()){
				row = result.getInt(1);
			}
			else{
				row = 0;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return row;
	}

	public Register() {

		super("Registration");
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


		/*date = new JLabel("Date");
		date.setBounds(570,30,60,20);
		date.setForeground(Color.white);
		panel.add(date);

		datePL = new JLabel ();
		datePL.setBounds(555,45,100,20);
		panel.add(datePL);

		/*dateTF = new JTextField();
		dateTF.setBounds(490,100,170,30);
		panel.add(dateTF);*/

		/*title  = new JLabel ("Registration Form");
		title.setBounds(200, 40, 400, 100);
		title.setOpaque(false);
		title.setVisible(true);
		title.setFont(new Font("Comic Sans MS",Font.ITALIC+Font.BOLD, 32));
		title.setForeground(Color.white);
		panel.add(title);*/


		dName = new JLabel("Name");
		dName.setBounds(40,100,170,30);
		dName.setForeground(Color.white);
		panel.add(dName);
		
		dnTF = new JTextField();
		dnTF.setBounds(170,100,170,30);
		//dnTF.setOpaque(false);
		panel.add(dnTF);

		oc = new JLabel("Occupation");
		oc.setBounds(380,100,170,30);
		oc.setForeground(Color.white);
		panel.add(oc);
		
		ocTF = new JTextField();
		ocTF.setBounds(490,100,170,30);
		panel.add(ocTF);

		sx = new JLabel("Sex");
		sx.setBounds(40,140,170,30);
		sx.setForeground(Color.white);
		panel.add(sx);

		String []s = {"Select...", "Female", "Male", "Other"};	
		combo1 = new JComboBox(s);
		combo1.setBounds(170,140,170,30);
		panel.add(combo1);

		bg = new JLabel("Blood Group");
		bg.setBounds(380,140,170,30);
		bg.setForeground(Color.white);
		panel.add(bg);

		String []g = {"Select Group...","A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};	
		combo2 = new JComboBox(g);
		combo2.setBounds(490,140,170,30);
		panel.add(combo2);

		add = new JLabel("Mailing Address");
		add.setBounds(40,180,170,30);
		add.setForeground(Color.white);
		panel.add(add);
		
		addTF = new JTextField();
		addTF.setBounds(170,180,170,30);
		panel.add(addTF);

		ct = new JLabel("City");
		ct.setBounds(380,180,170,30);
		ct.setForeground(Color.white);
		panel.add(ct);
		
		ctTF = new JTextField();
		ctTF.setBounds(490,180,170,30);
		panel.add(ctTF);
		
		dob = new JLabel("Date of Birth");
		dob.setBounds(40,220,170,30);
		dob.setForeground(Color.white);
		panel.add(dob);


		//calender part DOB
		String day_arr[]=new String[31];
		for(int i=1;i<=31;i++)
		day_arr[i-1]=Integer.toString(i); 
		day=new JComboBox(day_arr);
		day.setBounds(170,220,40,30);
		panel.add(day);
		 
		
		String month_arr[]={"Jan","Feb","March","April","May","June","July","Aug","Sept","Oct","Nov","Dec" }; 
		month=new JComboBox(month_arr);
		month.setBounds(215,220,60,30);
		panel.add(month);
			
		String year_arr[]=new String[70];
		for(int i=1951;i<=2020;i++)
		year_arr[i-1951]=Integer.toString(i);
		year=new JComboBox(year_arr);
		year.setBounds(280,220,60,30);
		panel.add(year);


		/*dobTF = new JTextField();
		dobTF.setBounds(170,300,170,30);
		panel.add(dobTF);*/

		ld = new JLabel("Last Donate Date");
		ld.setBounds(380,220,170,30);
		ld.setForeground(Color.white);
		panel.add(ld);


		//calender part LDD
		String lday_arr[]=new String[31];
		for(int i=1;i<=31;i++)
		lday_arr[i-1]=Integer.toString(i); 
		lday=new JComboBox(lday_arr);
		lday.setBounds(490,220,40,30);
		panel.add(lday);
		 
		
		String lmonth_arr[]={"Jan","Feb","March","April","May","June","July","Aug","Sept","Oct","Nov","Dec" }; 
		lmonth=new JComboBox(lmonth_arr);
		lmonth.setBounds(535,220,60,30);
		panel.add(lmonth);
			
		String lyear_arr[]=new String[70];
		for(int i=1951;i<=2020;i++)
		lyear_arr[i-1951]=Integer.toString(i);
		lyear=new JComboBox(lyear_arr);
		lyear.setBounds(600,220,60,30);
		panel.add(lyear);



		/*ldTF = new JTextField();
		ldTF.setBounds(490,300,170,30);
		panel.add(ldTF);*/

		mob = new JLabel("Contact");
		mob.setBounds(40,260,170,30);
		mob.setForeground(Color.white);
		panel.add(mob);

		mobTF = new JTextField();
		mobTF.setBounds(170,260,170,30);
		panel.add(mobTF);

		mail = new JLabel("E-Mail");
		mail.setBounds(380,260,170,30);
		mail.setForeground(Color.white);
		panel.add(mail);

		mailTF = new JTextField();
		mailTF.setBounds(490,260,170,30);
		panel.add(mailTF);

		pass = new JLabel("Password");
		pass.setBounds(40,300,170,30);
		pass.setForeground(Color.white);
		panel.add(pass);

		passPF = new JPasswordField();
		passPF.setBounds(170,300,170,30);
		panel.add(passPF);

		cpass = new JLabel("Confirm Password");
		cpass.setBounds(380,300,170,30);
		cpass.setForeground(Color.white);
		panel.add(cpass);

		cpassPF = new JPasswordField();
		cpassPF.setBounds(490,300,170,30);
		panel.add(cpassPF);

		hiv = new JLabel ("HIV Status ?");
		hiv.setBounds(40, 340, 300, 30);
		hiv.setForeground(Color.white);
		panel.add(hiv);

		c1HIV = new JCheckBox("Positive");
		c1HIV.setBounds(380,340,80,30);
		c1HIV.setForeground(Color.white);
		c1HIV.setOpaque(false);
		panel.add(c1HIV);
				
		c2HIV = new JCheckBox("Negative");
		c2HIV.setBounds(490,340,80,30);
		c2HIV.setForeground(Color.white);
		c2HIV.setOpaque(false);
		panel.add(c2HIV);

		bg1 = new ButtonGroup();
		bg1.add(c1HIV);
		bg1.add(c2HIV);


		/*r2= new JRadioButton("Positive");
		r2.setBounds(380,450,80,30);
		panel.add(r2);
		
		r3= new JRadioButton("Negative");
		r3.setBounds(490,450,80,30);
		panel.add(r3);
		
		bg1 = new ButtonGroup();
		
		bg1.add(r2);
		bg1.add(r3);*/


		smk = new JLabel("Do you Smoke ?");
		smk.setBounds(40, 380, 300, 30);
		smk.setForeground(Color.white);
		panel.add(smk);

		c1SMK = new JCheckBox("Yes");
		c1SMK.setBounds(380,380,80,30);
		c1SMK.setForeground(Color.white);
		c1SMK.setOpaque(false);
		panel.add(c1SMK);
				
		c2SMK = new JCheckBox("No");
		c2SMK.setBounds(490,380,80,30);
		c2SMK.setForeground(Color.white);
		c2SMK.setOpaque(false);
		panel.add(c2SMK);

		bg2 = new ButtonGroup();
		bg2.add(c1SMK);
		bg2.add(c2SMK);

		drg = new JLabel("Drugs Addiction ?");
		drg.setBounds(40, 420, 300, 30);
		drg.setForeground(Color.white);
		panel.add(drg);

		c1DRG = new JCheckBox("Yes");
		c1DRG.setBounds(380,420,80,30);
		c1DRG.setForeground(Color.white);
		c1DRG.setOpaque(false);
		panel.add(c1DRG);
				
		c2DRG = new JCheckBox("No");
		c2DRG.setBounds(490,420,80,30);
		c2DRG.setForeground(Color.white);
		c2DRG.setOpaque(false);
		panel.add(c2DRG);

		bg3 = new ButtonGroup();
		bg3.add(c1DRG);
		bg3.add(c2DRG);

		exp = new JLabel ("Experience of Donating Blood ?");
		exp.setBounds(40, 460, 400, 30);
		exp.setForeground(Color.white);
		panel.add(exp);

		c1EXP = new JCheckBox("Yes");
		c1EXP.setBounds(380,460,80,30);
		c1EXP.setForeground(Color.white);
		c1EXP.setOpaque(false);
		panel.add(c1EXP);
			
		c2EXP = new JCheckBox("No");
		c2EXP.setBounds(490,460,80,30);
		c2EXP.setForeground(Color.white);
		c2EXP.setOpaque(false);
		panel.add(c2EXP);

		bg4 = new ButtonGroup();
		bg4.add(c1EXP);
		bg4.add(c2EXP); 

		regButton = new JButton("com.arnabb.bbms.Login.Register");
		regButton.setBounds(150,500,100,30);
		regButton.addMouseListener(this);
		regButton.addActionListener(this);
		panel.add(regButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(450,500,100,30);
		cancelButton.addMouseListener(this);
		cancelButton.addActionListener(this);
		panel.add(cancelButton);

		panel.add(background);

		this.add(panel);

		//setDate();

	}

	/*public static com.arnabb.bbms.Login.Register getRegRef(){
		if(regRef == null){

			regRef = new com.arnabb.bbms.Login.Register();
		}

		return  new com.arnabb.bbms.Login.Register();
	}*/

	/*public void setDate(){
		//String date = ""+new Date();
		SimpleDateFormat fdate = new SimpleDateFormat("dd/MM/YYYY");
		String date = fdate.format(new Date());
		datePL.setText(date);

		//this.setdate.setText(date);
	}*/

	public void mouseEntered(MouseEvent me){ }
	public void mouseExited(MouseEvent me){ }
	public void mouseReleased(MouseEvent me){	}
	public void mousePressed(MouseEvent me){	}
	public void mouseClicked(MouseEvent me){	}

	public void actionPerformed(ActionEvent ae) {

		String elementText = ae.getActionCommand();
		//String p = passPF.getText();
		//String dobTF = day.getSelectedItem().toString()+"/ "+month.getSelectedItem().toString()+"/ "+year.getSelectedItem().toString();

		int birthYear = Integer.parseInt(year.getSelectedItem().toString());
		int donYear = Integer.parseInt(lyear.getSelectedItem().toString());

		int diff = donYear - birthYear;
		//int preDiff = 2018 - birthYear;


		//System.out.println(diff);
		//System.out.println(preDiff);

		

		if(elementText.equals(regButton.getText())){


			if(dnTF.getText().length()!=0){

				if(ocTF.getText().length()!=0){

					if(addTF.getText().length()!=0){

						if(ctTF.getText().length()!=0){

							if(birthYear < 2017 && birthYear < donYear && diff >= 18 && donYear <= 2017){

								if(mobTF.getText().length()!=0 && mobTF.getText().length()==11 ) {  

									if(mailTF.getText().length()!=0 && mailTF.getText().matches("(.*)@(.*).com(.*)") == true ) { 

										if(passPF.getText().length()>=5) {

											if (c2HIV.isSelected() && c2DRG.isSelected()){



												if (passPF.getText().equals(cpassPF.getText())) {


														dID++;
														insertIntoDB_mainInfo();
														insertIntoDB_contact();
														insertIntoDB_extras();
														insertIntoDB_donorPass();
														insertIntoDB_check_info();

														String id, n1, o1, s1, b1, m1, ct1, dob1, ldd1, cont1, mail1, pass1;
														id = ""+dID;
														n1 = dnTF.getText();
														o1 = ocTF.getText();
														s1 = combo1.getSelectedItem().toString();
														b1 = combo2.getSelectedItem().toString();
														m1 = addTF.getText();
														ct1 = ctTF.getText();
														//dob1 = dobTF.getText();
														dob1 = day.getSelectedItem().toString()+" / "+month.getSelectedItem().toString()+" / "+year.getSelectedItem().toString();
														//ldd1 = ldTF.getText();
														ldd1 = lday.getSelectedItem().toString()+" / "+lmonth.getSelectedItem().toString()+" / "+lyear.getSelectedItem().toString();
														cont1 = mobTF.getText();
														mail1 = mailTF.getText();
														pass1 = passPF.getText();

														DonorDetails dondet = new DonorDetails(id, n1, o1, s1, b1, m1, ct1, dob1, ldd1, cont1, mail1, pass1);
														dondet.setVisible(true);
														this.setVisible(false);



														JOptionPane.showMessageDialog(null, "Succeed! Thanks for Registration.");

												}

												else {

														JOptionPane.showMessageDialog(null, "Password not Matched!");

												}

											}

											else {

												JOptionPane.showMessageDialog(null, "Registration Failed. Check HIV or Drugs Status!");
											}
										}

										else{
											JOptionPane.showMessageDialog(null, "Password must be of Length 5 or much!");

										}

											
									}

									else{
										JOptionPane.showMessageDialog(null, "Invalid E-Mail");
									}

								}

								else {
									JOptionPane.showMessageDialog(null, "Invalid Phone Number");
								}


							}

							else{
								JOptionPane.showMessageDialog(null, "Check Birth or Donate Year!");
							}

						}

						else{
							JOptionPane.showMessageDialog(null, "Insert City");
						}

					}

					else {
						JOptionPane.showMessageDialog(null, "Insert Address");
					}

				}

				else {
					JOptionPane.showMessageDialog(null, "Insert Occupation");
				}

			}

			else {
				JOptionPane.showMessageDialog(null, "Name Can't be Empty!");
			}
			
		}



		else if(elementText.equals(cancelButton.getText())){

			try{
				Donor d = new Donor();
				d.setVisible(true);
				this.setVisible(false);
			}

			catch(Exception e){
				//e.printStackTrace();
			}
			
		}
	}

	


	/*public void emptycheck_info() {

		if(dnTF.getText().length()!=0){

			if(ocTF.getText().length()!=0){

				if(addTF.getText().length()!=0){

					if(ctTF.getText().length()!=0){

						if(dobTF.getText().length!=0){

							if(mobTF.getText().length!=0 && mobTF.getText().length()==11){

								if(mailTF.getText().length!=0 && mailTF.getText().contains()="@" && mailTF.getText().contains()=".com" ){

									if (p.equals(cpassPF.getText())) {


											dID++;
											insertIntoDB_mainInfo();
											insertIntoDB_contact();
											insertIntoDB_extras();
											insertIntoDB_donorPass();
											//emptycheck_info();
											//insertIntoDB_check_info();

											String id, n1, o1, s1, b1, m1, ct1, dob1, ldd1, cont1, mail1, pass1;
											id = ""+dID;
											n1 = dnTF.getText();
											o1 = ocTF.getText();
											s1 = combo1.getSelectedItem().toString();
											b1 = combo2.getSelectedItem().toString();
											m1 = addTF.getText();
											ct1 = ctTF.getText();
											dob1 = dobTF.getText();
											ldd1 = ldTF.getText();
											cont1 = mobTF.getText();
											mail1 = mailTF.getText();
											pass1 = passPF.getText();

											com.arnabb.bbms.Donor.DonorDetails dondet = new com.arnabb.bbms.Donor.DonorDetails(id, n1, o1, s1, b1, m1, ct1, dob1, ldd1, cont1, mail1, pass1);
											dondet.setVisible(true);
											this.setVisible(false);



											JOptionPane.showMessageDialog(null, "Reg Succeed!");

									}

									else {

											JOptionPane.showMessageDialog(null, "Password not Matched!");

									}

										
								}

									}

									else{
										JOptionPane.showMessageDialog(null, "Invalid E-Mail");
									}

								}

								else {
									JOptionPane.showMessageDialog(null, "Invalid Phone Number");
								}


							}

							else{
								JOptionPane.showMessageDialog(null, "Invalid DOB");
							}

						}

						else{
							JOptionPane.showMessageDialog(null, "Insert City");
						}

					}

					else {
						JOptionPane.showMessageDialog(null, "Insert Address");
					}

				}

				else {
					JOptionPane.showMessageDialog(null, "Insert Occupation");
				}
			}

			else {
				JOptionPane.showMessageDialog(null, "Name Can't be Empty!");
			}
		
		}

	}*/


	public void insertIntoDB_mainInfo()
	{
		String dn = dnTF.getText();
		String cty = ctTF.getText();
		String cm = combo2.getSelectedItem().toString();
		String id = ""+dID;
		String query = "INSERT INTO main_info VALUES ('"+id+"','"+dn+"', '"+cm+"','"+cty+"');";
		//System.out.println(query);
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


    public void insertIntoDB_contact()
	{
		String ad = addTF.getText();
		String cont = mobTF.getText();
		String ml = mailTF.getText();
		String id = ""+dID;
		String query = "INSERT INTO Contact VALUES ('"+id+"','"+ad+"', '"+cont+"','"+ml+"');";
		//System.out.println(query);
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


    public void insertIntoDB_check_info() {

		String h1 = null, smk1 = null, drg1 = null, ex1 = null ;

		//String s3;

		//String h1, smk1, drg1, ex1;


		/*if(r1.isSelected())
			{s3=r1.getText();} */

			
		/* if(r2.isSelected())
			{s3=r2.getText();}
			
		else if(r3.isSelected())
			{s3=r3.getText();}
			
		else
			{s3="";}*/



		if (c1HIV.isSelected()){
			 h1 = c1HIV.getText().toString();
		}
		else if (c2HIV.isSelected()){
			 h1 = c2HIV.getText().toString();
		}
		else{}


		if (c1SMK.isSelected()){
			 smk1 = c1SMK.getText();
		}
		else if (c2SMK.isSelected()){
			 smk1 = c2SMK.getText();
		}
		else{}


		if (c1DRG.isSelected()){
			 drg1 = c1DRG.getText();
		}
		else if (c2HIV.isSelected()){
			 drg1 = c2DRG.getText();
		}
		else{}


		if (c1EXP.isSelected()){
			 ex1 = c1EXP.getText();
		}
		else if (c2EXP.isSelected()) {
			 ex1 = c2EXP.getText();
		}
		else{}

		

		String id = ""+dID;



		String query = "INSERT INTO check_info VALUES ('"+id+"','"+h1+"', '"+smk1+"','"+drg1+"','"+ex1+"');";

		//String query = "INSERT INTO check_info(DonorID, HIV, Smoke, Drugs, Experience) VALUES ('"+id+"','"+s3+"','"+s3+"','"+s3+"','"+s3+"');";
		
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query);
			stm.close();
			con.close();
			//String query = "INSERT INTO check_info VALUES ('"+id+"','"+h1+"', '"+smk1+"','"+drg1+"','"+ex1+"');";
			//String query = "INSERT INTO check_info (DonorID, HIV, Smoker, Drugs, Experience) VALUES ('?','?','?','?','?')";
			//PreparedStatement p = con.prepareStatement(query);
		//	p.setString(1,id);
		//	p.setString(2,h1);
		//	p.setString(3,smk1);
		//	p.setString(4,drg1);
		//	p.setString(5,ex1);
		//	p.execute();
		//	p.close();
					
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
			//ex.printStackTrace();
        }
    }


    public void insertIntoDB_extras() {

		String occ = ocTF.getText();
		String sxx = combo1.getSelectedItem().toString();
		String dobb = day.getSelectedItem().toString()+" / "+month.getSelectedItem().toString()+" / "+year.getSelectedItem().toString(); //dobTF.getText();
		String ldd = lday.getSelectedItem().toString()+" / "+lmonth.getSelectedItem().toString()+" / "+lyear.getSelectedItem().toString(); //ldTF.getText();
		String id = ""+dID;

		String query = "INSERT INTO extras VALUES ('"+id+"','"+occ+"', '"+sxx+"','"+dobb+"','"+ldd+"');";
		//System.out.println(query);
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


    public void insertIntoDB_donorPass() {

		String dn = dnTF.getText();
		String ps = passPF.getText();
		String id = ""+dID;

		String query = "INSERT INTO donorpass VALUES ('"+id+"','"+dn+"', '"+ps+"');";
		//System.out.println(query);
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