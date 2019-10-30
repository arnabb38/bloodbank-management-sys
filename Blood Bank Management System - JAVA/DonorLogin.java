//donor login


import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.event.*;
import java.sql.*;

public class DonorLogin extends JFrame implements ActionListener
{
	private JLabel labelWelcome,background, labelID;
	private JButton viewButton, deleteAccButton, deleteAdminButton, UpdateButton, buttonLogout;
	private JPanel panel;
	//private String uID;
	
	public DonorLogin(String uID) 
	{
		super("Donor Panel");
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

		
		labelWelcome = new JLabel("User ID  ");
		labelWelcome.setBounds(230, 50, 120, 30);
		labelWelcome.setForeground(Color.white);
		panel.add(labelWelcome);

		
		labelID = new JLabel(uID);
		labelID.setBounds(350, 50, 200, 30);
		labelID.setForeground(Color.white);
		panel.add(labelID);

		
		viewButton = new JButton("View Profile");
		viewButton.setBounds(300, 100, 150, 30);
		viewButton.addActionListener(this);
		panel.add(viewButton);
		
		deleteAccButton = new JButton("Delete Account");
		deleteAccButton.setBounds(300, 200, 150, 30);
		deleteAccButton.addActionListener(this);
		panel.add(deleteAccButton);

		
		UpdateButton = new JButton("Update");
		UpdateButton.setBounds(300, 300, 150, 30);
		UpdateButton.addActionListener(this);
		panel.add(UpdateButton);
		
		buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(300, 500, 150, 30);
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);

		panel.add(background);

		this.add(panel);
		//this.uID=uID;
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String buttonClicked = ae.getActionCommand();
		
		if(buttonClicked.equals(viewButton.getText()))
		{

			String lID = labelID.getText();

			try{
				//Update up = new Update();//new Update(lID);
				viewDonDetails vd = new viewDonDetails(lID);
				vd.setVisible(true);
				this.setVisible(false);
			}

			catch(Exception e){
				e.printStackTrace();
			}


		}

			
		else if(buttonClicked.equals(deleteAccButton.getText()))
		{

			String lID = labelID.getText();

			try{
				DeleteAccount delAcc = new DeleteAccount(lID);
				delAcc.setVisible(true);
				this.setVisible(false);
			}

			catch(Exception e){
				e.printStackTrace();
			}
	
		}

	
		else if(buttonClicked.equals(buttonLogout.getText()))
		{
			try{
				Donor d = new Donor();
				d.setVisible(true);
				this.setVisible(false);
			}

			catch(Exception e){
				e.printStackTrace();
			}
			
		}

		else if(buttonClicked.equals(UpdateButton.getText()))
		{

			String lID = labelID.getText();

			try{
				//Update up = new Update();//new Update(lID);
				Update u = new Update(lID);
				u.setVisible(true);
				this.setVisible(false);
			}

			catch(Exception e){
				e.printStackTrace();
			}
			
		}


	}

	/*public void showData(){
    try{
        
      	Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg", "root", "");
        String query = "Select * from main_info;";
        Statement s = c.createStatement();
        ResultSet result  = s.executeQuery(query);
        System.out.println("mara khao");

        String ss1,ss2,ss3,ss4,ss5,ss6,ss7,ss8,ss9,ss10,ss11,;

       		if(result.next()) {
            

            	 id = result.getString(1);
            	 n1 = result.getString(2);
            	 o1 = result.getString(3);
            	 s1 = result.getString(4);
            	 /*ss5 = result.getString(5);
            	 ss6 = result.getString(6);
            	 ss7 = result.getString(7);
            	 ss8 = result.getString(8);
            	 ss9 = result.getString(9);
            	 ss10 = result.getString(10);
            	 ss11 = result.getString(11);

                System.out.println(id);
                System.out.println(n1);
                System.out.println(o1);

                try {
					DonorDetails dondet = new DonorDetails(id, n1, o1, s1, b1, m1, ct1, dob1, ldd1, cont1, mail1, pass1);
					dondet.setVisible(true);
					this.setVisible(false);
				}

				catch(Exception e){
					e.printStackTrace();
				}

			}

	        else {
	            JOptionPane.showMessageDialog(null,"No data to show");
	        }

    }

    catch (Exception e){
        //e.printStackTrace();
        JOptionPane.showMessageDialog(null,"Something wrong!");
    }*/


}


/*

SELECT main_info.DonorID, main_info.Name, main_info.BloodGroup, main_info.City, extras.Occupation, extras.Sex, extras.DOB, extras.Last Donate Dt., contact.Address, contact.Contact,contact.Mail, donorpass.Password
FROM ((main_info
INNER JOIN extara ON main_info.DonorID = extras.DonorID)
INNER JOIN Shippers ON main_info.ShipperID = Contact.DonorID);



SELECT Orders.OrderID, Customers.CustomerName, Shippers.ShipperName
FROM ((Orders
INNER JOIN Customers ON Orders.CustomerID = Customers.CustomerID)
INNER JOIN Shippers ON Orders.ShipperID = Shippers.ShipperID);


*/