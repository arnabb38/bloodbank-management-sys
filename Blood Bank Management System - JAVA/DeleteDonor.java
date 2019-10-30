//for delete donor ID

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

//Object[] rows;


public class DeleteDonor extends JFrame implements ActionListener
{
	private JLabel background,numberLabel, idLabel;
	private JTextField numberTF, tryTF;
	private JButton buttonBack, buttonLogout, buttonDelete, buttonRefresh;
	private JPanel panel;
	private JTable table;
	private DefaultTableModel tableModel;
	

	public DeleteDonor (String aID)
	{
		super("Eliminate Donor");
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

		
		numberLabel = new JLabel("Enter Donor ID ");
		numberLabel.setBounds(100,400,150,30);
		numberLabel.setForeground(Color.white);
		panel.add(numberLabel);
		
		numberTF = new JTextField();
		numberTF.setBounds(250,400,150,30);
		panel.add(numberTF);

		idLabel = new JLabel(aID);
		idLabel.setVisible(false);
		panel.add(idLabel);

	
		
		buttonBack = new JButton("Back");
		buttonBack.setBounds(200, 500, 80, 30);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		
		buttonDelete = new JButton("Delete");
		buttonDelete.setBounds(500, 400, 80, 30);
		buttonDelete.addActionListener(this);
		panel.add(buttonDelete);

		buttonRefresh = new JButton("Refresh");
		buttonRefresh.setBounds(400, 500, 80, 30);
		buttonRefresh.addActionListener(this);
		panel.add(buttonRefresh);
		
		/*buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(280, 300, 80, 30);
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);*/

		this.table = new JTable();
		Object[] column = {"Donor ID","Name","Blood Group", "City", "Contact", "Mail" };
		this.tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(column);
		this.table.setModel(tableModel);
		table.setBackground(Color.WHITE);
		//table.setFont(new Font("Serif", Font.PLAIN, 18));
		table.setRowHeight(30);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(50,20,600,250);
		this.add(pane);
		panel.add(pane);

		showData();

		panel.add(background);
		
		this.add(panel);


	}


	public void actionPerformed(ActionEvent ae)
	{
		String buttonClicked = ae.getActionCommand();
		
		if(buttonClicked.equals(buttonBack.getText()))
		{
			String id = idLabel.getText();

			try{
				AdminPanel ah = new AdminPanel(id);
				ah.setVisible(true);
				this.setVisible(false);
			}

			catch(Exception e){
				e.printStackTrace();
			}
			
		}
		else if(buttonClicked.equals(buttonDelete.getText()))
		{
			deleteFromDB1();
			deleteFromDB2();
			deleteFromDB3();
			deleteFromDB4();
			deleteFromDB5();
		}
		else if(buttonClicked.equals(buttonRefresh.getText()))
		{
			String id = idLabel.getText();

			try{
				DeleteDonor dd = new DeleteDonor(id);
				dd.setVisible(true);
				this.setVisible(false);
			}

			catch(Exception e){
				e.printStackTrace();
			}
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

    public void deleteFromDB5()
	{
		String query = "DELETE from check_info where DonorID="+numberTF.getText()+";";
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


	public void showData(){

	    try{

	        Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg", "root", "");
			Statement stm = con.createStatement();
	        String query = "SELECT main_info.DonorID, main_info.Name, main_info.BloodGroup, main_info.City, contact.Contact, contact.Mail FROM main_info INNER JOIN contact ON main_info.DonorID=contact.DonorID;";

	        ResultSet result  = stm.executeQuery(query);
	        
	            while (result.next()) {

	                Object[] rows= { result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6) };


	                //System.out.println(result.getString(1));
	                this.tableModel.addRow(rows);
	            }
	            this.table.setModel(tableModel);
	        
	        
	    }

	    catch (Exception e){
	        //e.printStackTrace();
	        JOptionPane.showMessageDialog(null,"Something wrong!");
	    }


	}






}




/* select *
from INFORMATION_SCHEMA.COLUMNS
where TABLE_NAME='tableName' 

SELECT column_name FROM   all_tab_cols 

SELECT main_info.OrderID, contact.CustomerName, main_info.OrderDate FROM main_info INNER JOIN contact ON main_info.CustomerID=contact.CustomerID;


*/
