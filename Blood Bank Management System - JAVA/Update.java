// update info

import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
//import java.text.SimpleDateFormat;

public class Update extends JFrame implements MouseListener, ActionListener {

	private JLabel dNum, date,background, title, labelID, datePL, dName, oc, add, ct, sx, dob, ld, mob, bg, mail, pass, cpass, smk, hiv, drg, exp, userID;
	public JPanel panel;
	private JTextField bgTF, passTF, ldTF, dobTF, dateTF, sxTF, dnTF, ocTF, addTF, ctTF, mobTF, mailTF;
	//private JPasswordField passPF, cpassPF;
	private JButton updateButton, cancelButton, importButton, refButton;
	//private ButtonGroup bg1, bg2, bg3, bg4;
	//private JCheckBox c1EXP,c2EXP, c1SMK, c2SMK, c1HIV, c2HIV, c1DRG, c2DRG;
	private JComboBox combo1, combo2, day, month, year, lday, lmonth, lyear;
	private JTable table;
	private DefaultTableModel tableModel;
	//private JRadioButton r1, r2, r3, r4;
	//public static int dID = scanID();
	//public static Update regRef = null;


	public Update(String lID) {

		super("Registration");
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

		userID = new JLabel("User ID");
		userID.setBounds(340,40,200, 40);
		userID.setForeground(Color.white);
		panel.add(userID);

		labelID = new JLabel(lID);
		labelID.setBounds(350, 60, 200, 30);
		labelID.setForeground(Color.white);
		panel.add(labelID);


		dName = new JLabel("Name");
		dName.setBounds(40,150,170,30);
		dName.setForeground(Color.white);
		panel.add(dName);
		
		dnTF = new JTextField();
		dnTF.setBounds(170,150,170,30);
		//dnTF.setOpaque(false);
		dnTF.setEditable(false);
		panel.add(dnTF);

		oc = new JLabel("Occupation");
		oc.setBounds(380,150,170,30);
		oc.setForeground(Color.white);
		panel.add(oc);
		
		ocTF = new JTextField();
		ocTF.setBounds(490,150,170,30);
		panel.add(ocTF);

		sx = new JLabel("Sex");
		sx.setBounds(40,190,170,30);
		sx.setForeground(Color.white);
		panel.add(sx);

		/*String []s = {"Select...", "Female", "Male", "Other"};	
		combo1 = new JComboBox(s);
		combo1.setBounds(170,190,170,30);
		panel.add(combo1);*/

		sxTF = new JTextField();
		sxTF.setBounds(170,190,170,30);
		sxTF.setEditable(false);
		panel.add(sxTF);

		bg = new JLabel("Blood Group");
		bg.setBounds(380,190,170,30);
		bg.setForeground(Color.white);
		panel.add(bg);

		/*String []g = {"Select Group...","A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};	
		combo2 = new JComboBox(g);
		combo2.setBounds(490,190,170,30);
		panel.add(combo2);*/

		bgTF = new JTextField();
		bgTF.setBounds(490,190,170,30);
		bgTF.setEditable(false);
		panel.add(bgTF);

		add = new JLabel("Mailing Address");
		add.setBounds(40,230,170,30);
		add.setForeground(Color.white);
		panel.add(add);
		
		addTF = new JTextField();
		addTF.setBounds(170,230,170,30);
		panel.add(addTF);

		ct = new JLabel("City");
		ct.setBounds(380,230,170,30);
		ct.setForeground(Color.white);
		panel.add(ct);
		
		ctTF = new JTextField();
		ctTF.setBounds(490,230,170,30);
		panel.add(ctTF);
		
		dob = new JLabel("Date of Birth");
		dob.setBounds(40,270,170,30);
		dob.setForeground(Color.white);
		panel.add(dob);




		/*//calender part DOB
		String day_arr[]=new String[31];
		for(int i=1;i<=31;i++)
		day_arr[i-1]=Integer.toString(i); 
		day=new JComboBox(day_arr);
		day.setBounds(170,270,40,30);
		panel.add(day);
		 
		
		String month_arr[]={"Jan","Feb","March","April","May","June","July","Aug","Sept","Oct","Nov","Dec" }; 
		month=new JComboBox(month_arr);
		month.setBounds(215,270,60,30);
		panel.add(month);
			
		String year_arr[]=new String[70];
		for(int i=1951;i<=2020;i++)
		year_arr[i-1951]=Integer.toString(i);
		year=new JComboBox(year_arr);
		year.setBounds(280,270,60,30);
		panel.add(year);*/


		dobTF = new JTextField();
		dobTF.setBounds(170,270,170,30);
		dobTF.setEditable(false);
		panel.add(dobTF);

		/*ld = new JLabel("Last Donate Date");
		ld.setBounds(380,270,170,30);
		ld.setForeground(Color.white);
		panel.add(ld);*/


		/*//calender part LDD
		String lday_arr[]=new String[31];
		for(int i=1;i<=31;i++)
		lday_arr[i-1]=Integer.toString(i); 
		lday=new JComboBox(lday_arr);
		lday.setBounds(490,270,40,30);
		panel.add(lday);
		 
		
		String lmonth_arr[]={"Jan","Feb","March","April","May","June","July","Aug","Sept","Oct","Nov","Dec" }; 
		lmonth=new JComboBox(lmonth_arr);
		lmonth.setBounds(535,270,60,30);
		panel.add(lmonth);
			
		String lyear_arr[]=new String[70];
		for(int i=1951;i<=2020;i++)
		lyear_arr[i-1951]=Integer.toString(i);
		lyear=new JComboBox(lyear_arr);
		lyear.setBounds(600,270,60,30);
		panel.add(lyear);*/



		/*ldTF = new JTextField();
		ldTF.setBounds(490,270,170,30);
		panel.add(ldTF);*/

		mob = new JLabel("Contact");
		mob.setBounds(40,310,170,30);
		mob.setForeground(Color.white);
		panel.add(mob);

		mobTF = new JTextField();
		mobTF.setBounds(170,310,170,30);
		panel.add(mobTF);

		mail = new JLabel("E-Mail");
		mail.setBounds(380,270,170,30);
		mail.setForeground(Color.white);
		panel.add(mail);

		mailTF = new JTextField();
		mailTF.setBounds(490,270,170,30);
		panel.add(mailTF);

		pass = new JLabel("Password");
		pass.setBounds(40,350,170,30);
		pass.setForeground(Color.white);
		panel.add(pass);

		passTF = new JTextField();
		passTF.setBounds(170,350,170,30);
		panel.add(passTF);

		updateButton = new JButton("Update");
		updateButton.setBounds(250,500,100,30);
		updateButton.addMouseListener(this);
		updateButton.addActionListener(this);
		panel.add(updateButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(550,500,100,30);
		cancelButton.addMouseListener(this);
		cancelButton.addActionListener(this);
		panel.add(cancelButton);
		
		importButton = new JButton("Import");
		importButton.setBounds(100,500,100,30);
		importButton.addMouseListener(this);
		importButton.addActionListener(this);
		panel.add(importButton);

		refButton = new JButton("Refresh");
		refButton.setBounds(400, 500, 100, 30);
		refButton.addActionListener(this);
		panel.add(refButton);


		this.table = new JTable();
		Object[] column = {"Name","Occupation", "Sex", "Blood Group", "Address", "City", "DOB", "Contact","E-Mail", "Password" };
		this.tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(column);
		this.table.setModel(tableModel);
		table.setBackground(Color.WHITE);
		//table.setFont(new Font("Serif", Font.PLAIN, 18));
		table.setRowHeight(30);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(10,90,680,55);
		this.add(pane);
		panel.add(pane);

		showData();
		

		panel.add(background);

		this.add(panel);

	}

	public void showData(){

		String donID = labelID.getText();

	    try{

	        //Class.forName("com.mysql.jdbc.Driver");
			//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg", "root", "");
			//Statement stm = con.createStatement();
	        //String query = "SELECT  main_info.Name, main_info.BloodGroup, main_info.City, contact.Contact, contact.Mail FROM main_info INNER JOIN contact ON main_info.DonorID=contact.DonorID;";

			String query = "SELECT m.Name, x.Occupation, x.Sex, m.BloodGroup, c.Address, m.City, x.DOB, c.Contact, c.Mail, p.Password FROM main_info m JOIN extras x ON m.DonorID = x.DonorID JOIN contact c ON c.DonorID = x.DonorID JOIN donorpass p ON p.DonorID = c.DonorID where m.DonorID = ?";
			

		        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg","root","");
		        PreparedStatement p = c.prepareStatement(query);

		        p.setString(1,donID);
		        ResultSet result = p.executeQuery();				
	       
	        
	        
	            while (result.next()) {

	                Object[] rows= { result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7),result.getString(8),result.getString(9),result.getString(10) };

	                this.tableModel.addRow(rows);
	            }

	            this.table.setModel(tableModel);
	        
		}

	    catch (Exception e){
	        //e.printStackTrace();
	        JOptionPane.showMessageDialog(null,"Something Went Wrong!");
	    }


	}

	public void mouseEntered(MouseEvent me){ }
	public void mouseExited(MouseEvent me){ }
	public void mouseReleased(MouseEvent me){	}
	public void mousePressed(MouseEvent me){	}
	public void mouseClicked(MouseEvent me) {

		String donID = labelID.getText();


		int row = table.getSelectedRow();

		//String n = table.getModel().getValueAt(row, 0).toString();
		//String query = "SELECT m.Name, x.Occupation, x.Sex, m.BloodGroup, c.Address, m.City, x.DOB, c.Contact, c.Mail, p.Password FROM main_info m JOIN extras x ON m.DonorID = x.DonorID JOIN contact c ON c.DonorID = x.DonorID JOIN donorpass p ON p.DonorID = c.DonorID where m.DonorID = ?";

		try{


			String query = "SELECT m.Name, x.Occupation, x.Sex, m.BloodGroup, c.Address, m.City, x.DOB, c.Contact, c.Mail, p.Password FROM main_info m JOIN extras x ON m.DonorID = x.DonorID JOIN contact c ON c.DonorID = x.DonorID JOIN donorpass p ON p.DonorID = c.DonorID where m.DonorID = ?";
			

		        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg","root","");
		        PreparedStatement p = c.prepareStatement(query);

		        p.setString(1,donID);
		        ResultSet result = p.executeQuery();				
	       
	        
	        
	            while (result.next()) {

	                Object[] rows= { result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7),result.getString(8),result.getString(9),result.getString(10) };

	                //System.out.println(result.getString(1));


	                dnTF.setText(result.getString(1));
	                ocTF.setText(result.getString(2));
	                sxTF.setText(result.getString(3));
	                bgTF.setText(result.getString(4));
	                addTF.setText(result.getString(5));
	                ctTF.setText(result.getString(6));
	                dobTF.setText(result.getString(7));
	                mobTF.setText(result.getString(8));
	                mailTF.setText(result.getString(9));
	                passTF.setText(result.getString(10));



	                
	            }

	        
		}

	    catch (Exception e){
	        //e.printStackTrace();
	        JOptionPane.showMessageDialog(null,"Something Went Wrong!");
	    }








	}


	public void actionPerformed(ActionEvent ae) {

		String elementText = ae.getActionCommand();

		//String uuID = 

		if(elementText.equals(cancelButton.getText())){

			String lID = labelID.getText();

				try{
					//Update up = new Update();//new Update(lID);
					DonorLogin donLog = new DonorLogin(lID);
					donLog.setVisible(true);
					this.setVisible(false);
				}

				catch(Exception e){
					e.printStackTrace();
				}

		}

		else if(elementText.equals(refButton.getText())){

			try{

				clearAll();
				
				showData();
			}

			catch(Exception e){
				e.printStackTrace();
			}
		}

		else if(elementText.equals(importButton.getText())) {


		}


		else if(elementText.equals(updateButton.getText())) {

			/*String a, b, c, d, e;

			a = ocTF.getText();
			b = addTF.getText();
			c = ctTF.getText();
			d = mobTF.getText();
			e = mailTF.getText();
			f = ldTF.getText();*/


			if(ocTF.getText().length()!=0){

				if(addTF.getText().length()!=0){

					if(ctTF.getText().length()!=0){
					
						if(mobTF.getText().length()!=0 && mobTF.getText().length()==11 ) {

							if(mailTF.getText().length()!=0 && mailTF.getText().matches("(.*)@(.*).com(.*)") == true ) {  

								if(passTF.getText().length()>=5) {

									updateIntoDB_mainInfo();
									updateIntoDB_contact();
									updateIntoDB_extras();
									updateIntoDB_donorPass();

									JOptionPane.showMessageDialog(null, "Update Succeed!");

								}

								else {

									JOptionPane.showMessageDialog(null, "Password must be of length 5 or much!");
								}
							}

							else{

								JOptionPane.showMessageDialog(null, "Invalid E-Mail");
							}
						}

						else{

							JOptionPane.showMessageDialog(null, "Invalid Phone Number!");
						}
					}

					else{

						JOptionPane.showMessageDialog(null, "Insert City");
					}
				}

				else{

					JOptionPane.showMessageDialog(null, "Insert Address");
				}
			}

			else{

				JOptionPane.showMessageDialog(null, "Insert Occupation");
			}
		}


	}

	private void clearAll() {
	    tableModel.getDataVector().removeAllElements();
	  
	}


	public void updateIntoDB_mainInfo()
	{
		//String dn = dnTF.getText();
		String cty = ctTF.getText();
		//String cm = combo2.getSelectedItem().toString();
		//String id = ""+dID;
		String id = labelID.getText();

		String query = "UPDATE main_info SET City = '"+cty+"' WHERE DonorID = '"+id+"'";
		//System.out.println(query);
        try
		{
			//System.out.println("bhooooooooooooooooooooot");

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


    public void updateIntoDB_contact()
	{
		String ad = addTF.getText();
		String cont = mobTF.getText();
		String ml = mailTF.getText();
		String id = labelID.getText();
		String query = "UPDATE `contact` SET `Address`= '"+ad+"',`Contact`= '"+cont+"',`Mail`= '"+ml+"' WHERE DonorID = '"+id+"'";
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

    public void updateIntoDB_extras() {

		String occ = ocTF.getText();
		//String sxx = combo1.getSelectedItem().toString();
		//String dobb = day.getSelectedItem().toString()+" / "+month.getSelectedItem().toString()+" / "+year.getSelectedItem().toString(); //dobTF.getText();
		//String ldd = lday.getSelectedItem().toString()+" / "+lmonth.getSelectedItem().toString()+" / "+lyear.getSelectedItem().toString(); //ldTF.getText();
		//String ldd = ldTF.getText();
		String id = labelID.getText();

		String query = "UPDATE `extras` SET `Occupation`= '"+occ+"' WHERE DonorID = '"+id+"'";
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

    public void updateIntoDB_donorPass() {

		//String dn = dnTF.getText();
		String ps = passTF.getText();
		String id = labelID.getText();

		String query = "UPDATE `donorpass` SET `Password`= '"+ps+"' WHERE DonorID = '"+id+"'";
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

		
