//gui search 


//freah copy


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



public class SearchInfo extends JFrame implements ActionListener
{
	private JLabel numberLabel,background, bgLabel, ctLabel;
	private JTextField numberTF, tryTF, bgTF, ctTF;
	private JButton buttonBack, buttonLogout, buttonSearch, buttonRefresh;
	private JPanel panel;
	private JTable table;
	private DefaultTableModel tableModel;
	private boolean flag = false;

	public SearchInfo ()
	{
		super("Search Info");
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


		bgLabel = new JLabel("Blood Group");
		bgLabel.setBounds(100,400,150,30);
		panel.add(bgLabel);
		
		bgTF = new JTextField();
		bgTF.setBounds(200,400,100,30);
		panel.add(bgTF);
		
                                 		
		ctLabel = new JLabel("City");
		ctLabel.setBounds(100,500,150,30);
		panel.add(ctLabel);
		
		ctTF = new JTextField();
		ctTF.setBounds(200,500,100,30);
		panel.add(ctTF);

		
		buttonBack = new JButton("Back");
		buttonBack.setBounds(100, 550, 80, 30);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);


		buttonRefresh = new JButton("Refresh");
		buttonRefresh.setBounds(300, 550, 80, 30);
		buttonRefresh.addActionListener(this);
		panel.add(buttonRefresh);

		buttonSearch = new JButton("Search");
		buttonSearch.setBounds(400, 450, 80, 30);
		buttonSearch.addActionListener(this);
		panel.add(buttonSearch);
		

		//tabMethod();

		this.table = new JTable();
		Object[] column = {"Name","Blood Group", "City", "Contact", "Mail" };
		this.tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(column);
		this.table.setModel(tableModel);
		table.setBackground(Color.WHITE);
		//table.setFont(new Font("Serif", Font.PLAIN, 18));
		table.setRowHeight(30);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(20,20,650,300);
		this.add(pane);
		panel.add(pane);

		showData();
		
		panel.add(background);

		this.add(panel);
	}

	/*public void tabMethod(){

		this.table = new JTable();
		Object[] column = {"Name","Blood Group", "City", "Contact", "Mail" };
		this.tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(column);
		this.table.setModel(tableModel);
		table.setBackground(Color.WHITE);
		//table.setFont(new Font("Serif", Font.PLAIN, 18));
		table.setRowHeight(30);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(20,20,650,300);
		this.add(pane);
		panel.add(pane);

		showData();
	}*/


	public void actionPerformed(ActionEvent ae)
	{
		String buttonClicked = ae.getActionCommand();
		
		if(buttonClicked.equals(buttonBack.getText()))
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


		else if(buttonClicked.equals(buttonSearch.getText()))
		{

			searchData();

			if(flag==false){

				//searchData();
				
				JOptionPane.showMessageDialog(null,"Nothing Found!!");
			}

			
			
		}


	
		else if(buttonClicked.equals(buttonRefresh.getText()))
		{

			//tabMethod();

			try{
				SearchInfo si = new SearchInfo();
				si.setVisible(true);
				this.setVisible(false);
			}

			catch(Exception e){
				e.printStackTrace();
			}
		}
	}


	public void showData(){

	    try{

	        Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg", "root", "");
			Statement stm = con.createStatement();
	        String query = "SELECT  main_info.Name, main_info.BloodGroup, main_info.City, contact.Contact, contact.Mail FROM main_info INNER JOIN contact ON main_info.DonorID=contact.DonorID;";

	        ResultSet result  = stm.executeQuery(query);
	        
	            while (result.next()) {

	                Object[] rows= { result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5) };

	                this.tableModel.addRow(rows);
	            }

	            this.table.setModel(tableModel);
	        
		}

	    catch (Exception e){
	        //e.printStackTrace();
	        JOptionPane.showMessageDialog(null,"Something Went Wrong!");
	    }


	}


	private void clearAll() {
	    tableModel.getDataVector().removeAllElements();
	  
	}


    public void searchData(){

    	String bg = bgTF.getText();
    	String cty = ctTF.getText();

    	if(bg.length()!=0 && cty.length()==0) {
        

		    try{
		        

		        String query = "SELECT  main_info.Name, main_info.BloodGroup, main_info.City, contact.Contact, contact.Mail FROM main_info INNER JOIN contact ON main_info.DonorID=contact.DonorID where BloodGroup = ?;";

		       
		        
		        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg","root","");
		        PreparedStatement p = c.prepareStatement(query);

		        p.setString(1,bg);
		        ResultSet result = p.executeQuery();
		        
		        clearAll();

		        while(result.next()) {
		            	
		        	flag = true;
		
					Object []obj = { result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5) };
		  				
					this.tableModel.addRow(obj);

			    }

			    this.table.setModel(tableModel);

		    }

			catch (Exception e){
		        //e.printStackTrace();
		        JOptionPane.showMessageDialog(null,"Query execution failed!");
			}

		}


		 else if(cty.length()!=0 && bg.length()==0) {
        

		    try{
		        

		        String query = "SELECT  main_info.Name, main_info.BloodGroup, main_info.City, contact.Contact, contact.Mail FROM main_info INNER JOIN contact ON main_info.DonorID=contact.DonorID where City = ?;";

		       
		        
		        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg","root","");
		        PreparedStatement p = c.prepareStatement(query);

		        p.setString(1,cty);
		        ResultSet result = p.executeQuery();
		        
		        clearAll();

		        while(result.next()) {
		            	
		        	flag = true;
		
					Object []obj = { result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5) };
		  				
					this.tableModel.addRow(obj);

			    }

			    this.table.setModel(tableModel);

		    }

			catch (Exception e){
		        //e.printStackTrace();
		        JOptionPane.showMessageDialog(null,"Query execution failed!");
			}

		}

	


		else if(bg.length()!=0 && cty.length()!=0) {
        

		    try{
		        

		        String query = "SELECT  main_info.Name, main_info.BloodGroup, main_info.City, contact.Contact, contact.Mail FROM main_info INNER JOIN contact ON main_info.DonorID=contact.DonorID where BloodGroup = ? and City = ?;";

		       
		        
		        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg","root","");
		        PreparedStatement p = c.prepareStatement(query);

		        p.setString(1,bg);
		        p.setString(2,cty);

		        ResultSet result = p.executeQuery();
		        
		        clearAll();

		        while(result.next()) {
		            	
		        	flag = true;
		
					Object []obj = { result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5) };
		  				
					this.tableModel.addRow(obj);

			    }

			    this.table.setModel(tableModel);

		    }

			catch (Exception e){
		        //e.printStackTrace();
		        JOptionPane.showMessageDialog(null,"Query execution failed!");
			}

		}

		

		else{

			JOptionPane.showMessageDialog(null,"Invalid Search!");
		}

	} 



}




/* select *
from INFORMATION_SCHEMA.COLUMNS
where TABLE_NAME='tableName' 

SELECT column_name FROM   all_tab_cols 

SELECT main_info.OrderID, contact.CustomerName, main_info.OrderDate FROM main_info INNER JOIN contact ON main_info.CustomerID=contact.CustomerID;

main_info.DonorID,




*/
