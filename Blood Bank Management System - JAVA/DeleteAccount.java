//delete donor acc



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

public class DeleteAccount extends JFrame implements MouseListener, ActionListener {

	private JLabel dNum, date,background, title, datePL, dName, oc, add, ct, sx, dob, userID, labelID, ld, mob, bg, mail, pass, cpass, smk, hiv, drg, exp;
	public JPanel panel;
	private JTextField dNumTF, dateTF, dnTF, sxTF, bgTF, ocTF, passTF, dobTF, ldTF, hivTF, smkTF, expTF, drgTF, addTF, ctTF, mobTF, mailTF;
	private JPasswordField passPF, cpassPF;
	private JButton regButton, cancelButton, importButton, updateButton, DeleteButton;
	private ButtonGroup bg1, bg2, bg3, bg4;
	private JCheckBox c1EXP,c2EXP, c1SMK, c2SMK, c1HIV, c2HIV, c1DRG, c2DRG;
	private JComboBox combo1, combo2, day, month, year, lday, lmonth, lyear;
	//private JRadioButton r1, r2, r3, r4;
	private JTable table;
	private DefaultTableModel tableModel;

	public DeleteAccount(String lID) {

		super("BBMS :: Delete Account");
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


		userID = new JLabel("User ID");
		userID.setBounds(40,110,200, 40);
		userID.setForeground(Color.white);
		panel.add(userID);

		labelID = new JLabel(lID);
		labelID.setBounds(170, 110, 60, 30);
		labelID.setForeground(Color.white);
		panel.add(labelID);


		dName = new JLabel("Name");
		dName.setBounds(40,150,170,30);
		dName.setForeground(Color.white);
		panel.add(dName);
		
		dnTF = new JTextField();
		dnTF.setBounds(170,150,170,30);
		dnTF.setEditable(false);
		//dnTF.setOpaque(false);
		panel.add(dnTF);

		oc = new JLabel("Occupation");
		oc.setBounds(380,150,170,30);
		oc.setForeground(Color.white);
		panel.add(oc);
		
		ocTF = new JTextField();
		ocTF.setBounds(490,150,170,30);
		ocTF.setEditable(false);
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
		addTF.setEditable(false);
		panel.add(addTF);

		ct = new JLabel("City");
		ct.setBounds(380,230,170,30);
		ct.setForeground(Color.white);
		panel.add(ct);
		
		ctTF = new JTextField();
		ctTF.setBounds(490,230,170,30);
		ctTF.setEditable(false);
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
		mobTF.setEditable(false);
		panel.add(mobTF);

		mail = new JLabel("E-Mail");
		mail.setBounds(380,310,170,30);
		mail.setForeground(Color.white);
		panel.add(mail);

		mailTF = new JTextField();
		mailTF.setBounds(490,310,170,30);
		mailTF.setEditable(false);
		panel.add(mailTF);

		pass = new JLabel("Password");
		pass.setBounds(40,350,170,30);
		pass.setForeground(Color.white);
		panel.add(pass);

		passTF = new JTextField();
		passTF.setBounds(170,350,170,30);
		passTF.setEditable(false);
		panel.add(passTF);

		hiv = new JLabel ("HIV Status ?");
		hiv.setBounds(40, 400, 300, 30);
		panel.add(hiv);

		/*c1HIV = new JCheckBox("Positive");
		c1HIV.setBounds(380,400,80,30);
		c1HIV.setOpaque(false);
		panel.add(c1HIV);
				
		c2HIV = new JCheckBox("Negative");
		c2HIV.setBounds(490,400,80,30);
		c2HIV.setOpaque(false);
		panel.add(c2HIV);

		bg1 = new ButtonGroup();
		bg1.add(c1HIV);
		bg1.add(c2HIV);*/

		hivTF = new JTextField();
		hivTF.setBounds(380,400,170,25);
		hivTF.setEditable(false);
		panel.add(hivTF);


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
		smk.setBounds(40, 430, 300, 30);
		panel.add(smk);

		/*c1SMK = new JCheckBox("Yes");
		c1SMK.setBounds(380,430,80,30);
		c1SMK.setOpaque(false);
		panel.add(c1SMK);
				
		c2SMK = new JCheckBox("No");
		c2SMK.setBounds(490,430,80,30);
		c2SMK.setOpaque(false);
		panel.add(c2SMK);

		bg2 = new ButtonGroup();
		bg2.add(c1SMK);
		bg2.add(c2SMK);*/

		smkTF = new JTextField();
		smkTF.setBounds(380,430,170,25);
		smkTF.setEditable(false);
		panel.add(smkTF);

		drg = new JLabel("Drugs Addiction ?");
		drg.setBounds(40, 460, 300, 30);
		panel.add(drg);

		/*c1DRG = new JCheckBox("Yes");
		c1DRG.setBounds(380,460,80,30);
		c1DRG.setOpaque(false);
		panel.add(c1DRG);
				
		c2DRG = new JCheckBox("No");
		c2DRG.setBounds(490,460,80,30);
		c2DRG.setOpaque(false);
		panel.add(c2DRG);

		bg3 = new ButtonGroup();
		bg3.add(c1DRG);
		bg3.add(c2DRG);*/

		drgTF = new JTextField();
		drgTF.setBounds(380,460,100,25);
		drgTF.setEditable(false);
		panel.add(drgTF);

		exp = new JLabel ("Experience of Donating Blood ?");
		exp.setBounds(40, 490, 400, 30);
		panel.add(exp);

		/*c1EXP = new JCheckBox("Yes");
		c1EXP.setBounds(380,490,80,30);
		c1EXP.setOpaque(false);
		panel.add(c1EXP);
			
		c2EXP = new JCheckBox("No");
		c2EXP.setBounds(490,490,80,30);
		c2EXP.setOpaque(false);
		panel.add(c2EXP);

		bg4 = new ButtonGroup();
		bg4.add(c1EXP);
		bg4.add(c2EXP); */

		expTF = new JTextField();
		expTF.setBounds(380, 490, 100, 25);
		expTF.setEditable(false);
		panel.add(expTF);

		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(500,500,100,30);
		//cancelButton.addMouseListener(this);
		cancelButton.addActionListener(this);
		panel.add(cancelButton);
		
		importButton = new JButton("View");
		importButton.setBounds(200,500,100,30);
		importButton.addMouseListener(this);
		importButton.addActionListener(this);
		panel.add(importButton);
		//panel.add(cancelButton);

		DeleteButton = new JButton("Delete");
		DeleteButton.setBounds(300,500,100,30);
		//DeleteButton.addMouseListener(this);
		DeleteButton.addActionListener(this);
		panel.add(DeleteButton);
		//panel.add(cancelButton);

		this.table = new JTable();
		Object[] column = {"Name","Occupation", "Sex", "Blood Group", "Address", "City", "DOB", "Contact","E-Mail", "Password", "HIV", "Smoke", "Drugs","Experience","Last Donate Dt" };
		this.tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(column);
		this.table.setModel(tableModel);
		table.setBackground(Color.WHITE);
		//table.setFont(new Font("Serif", Font.PLAIN, 18));
		table.setRowHeight(30);
		table.setVisible(false);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(10,90,680,70);
		pane.setVisible(false);
		this.add(pane);
		panel.add(pane);

		showData();

		panel.add(background);

		this.add(panel);

		//setDate();

	}


	public void mouseEntered(MouseEvent me){ }
	public void mouseExited(MouseEvent me){ }
	public void mouseReleased(MouseEvent me){	}
	public void mousePressed(MouseEvent me){	}
	public void mouseClicked(MouseEvent me){

		String donID = labelID.getText();


		int row = table.getSelectedRow();

		//String n = table.getModel().getValueAt(row, 0).toString();
		//String query = "SELECT m.Name, x.Occupation, x.Sex, m.BloodGroup, c.Address, m.City, x.DOB, c.Contact, c.Mail, p.Password FROM main_info m JOIN extras x ON m.DonorID = x.DonorID JOIN contact c ON c.DonorID = x.DonorID JOIN donorpass p ON p.DonorID = c.DonorID where m.DonorID = ?";

		try{


			String query = "SELECT m.Name, x.Occupation, x.Sex, m.BloodGroup, c.Address, m.City, x.DOB, c.Contact, c.Mail, p.Password, ci.HIV, ci.Smoke, ci.Drugs, ci.Experience FROM main_info m JOIN extras x ON m.DonorID = x.DonorID JOIN contact c ON c.DonorID = x.DonorID JOIN donorpass p ON p.DonorID = c.DonorID JOIN check_info ci on ci.DonorID = p.DonorID where m.DonorID = ?";
			

		        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg","root","");
		        PreparedStatement p = c.prepareStatement(query);

		        p.setString(1,donID);
		        ResultSet result = p.executeQuery();				
	       
	        
	        
	            while (result.next()) {

	                Object[] rows= { result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7),result.getString(8),result.getString(9),result.getString(10),result.getString(11),result.getString(12),result.getString(13),result.getString(14) };

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
	                hivTF.setText(result.getString(11));
	                smkTF.setText(result.getString(12));
	                drgTF.setText(result.getString(13));
	                expTF.setText(result.getString(14));
	                //ldTF.setText(result.getString(15));



	                
	            }

	        
		}

	    catch (Exception e){
	        //e.printStackTrace();
	        JOptionPane.showMessageDialog(null,"Something Went Wrong!");
	    }

	}

	public void showData(){

		String donID = labelID.getText();

	    try{

	        //Class.forName("com.mysql.jdbc.Driver");
			//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg", "root", "");
			//Statement stm = con.createStatement();
	        //String query = "SELECT  main_info.Name, main_info.BloodGroup, main_info.City, contact.Contact, contact.Mail FROM main_info INNER JOIN contact ON main_info.DonorID=contact.DonorID;";

			String query = "SELECT m.Name, x.Occupation, x.Sex, m.BloodGroup, c.Address, m.City, x.DOB, c.Contact, c.Mail, p.Password, ci.HIV, ci.Smoke, ci.Drugs, ci.Experience FROM main_info m JOIN extras x ON m.DonorID = x.DonorID JOIN contact c ON c.DonorID = x.DonorID JOIN donorpass p ON p.DonorID = c.DonorID JOIN check_info ci on ci.DonorID = p.DonorID where m.DonorID = ?";
			

		        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg","root","");
		        PreparedStatement p = c.prepareStatement(query);

		        p.setString(1,donID);
		        ResultSet result = p.executeQuery();				
	       
	        
	        
	            while (result.next()) {

	                
	                Object[] rows= { result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7),result.getString(8),result.getString(9),result.getString(10),result.getString(11),result.getString(12),result.getString(13),result.getString(14) };

	                this.tableModel.addRow(rows);
	            }

	            this.table.setModel(tableModel);
	        
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

			/*else if(elementText.equals(updateButton.getText())){

				String lID = labelID.getText();

				try{

					Update up = new Update(lID);
					up.setVisible(true);
					this.setVisible(false);
				}

				catch(Exception e){
					e.printStackTrace();
				}
			}*/

			else if(elementText.equals(importButton.getText())) {


			}

			else if (elementText.equals(DeleteButton.getText())) {

				String lID = labelID.getText();

				deleteFromDB1();
				deleteFromDB2();
				deleteFromDB3();
				deleteFromDB4();
				deleteFromDB5();

				Donor d = new Donor();
				d.setVisible(true);
				this.setVisible(false);

				JOptionPane.showMessageDialog(null, "Account Deleted");



			}



		}


	public void deleteFromDB1()
	{
		String query = "DELETE from main_info where DonorID="+labelID.getText()+";";
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
		String query = "DELETE from contact where DonorID="+labelID.getText()+";";
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
		String query = "DELETE from donorpass where DonorID="+labelID.getText()+";";
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
		String query = "DELETE from extras where DonorID="+labelID.getText()+";";
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

    public void deleteFromDB5()
	{
		String query = "DELETE from check_info where DonorID="+labelID.getText()+";";
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
