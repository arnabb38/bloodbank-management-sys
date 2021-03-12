package com.arnabb.bbms.Search;// stock



import com.arnabb.bbms.Home.Homee;

import java.io.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;



public class Stock extends JFrame implements ActionListener
{
	private JLabel title, background,numberLabel;
	private JTextField numberTF;
	private JButton buttonBack, buttonLogout, buttonDelete, buttonRefresh;
	private JPanel panel;
	private JTable table;
	private DefaultTableModel tableModel;

	public Stock () 
	{
		super("com.arnabb.bbms.Search.Stock Available");
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

		

		title  = new JLabel ("Available In com.arnabb.bbms.Search.Stock");
		title.setBounds(100, 60, 400, 100);
		title.setOpaque(false);
		title.setVisible(true);
		title.setFont(new Font("Comic Sans MS",Font.BOLD, 32));
		title.setForeground(Color.white);
		panel.add(title);
		
		
		
		buttonBack = new JButton("Back");
		buttonBack.setBounds(200, 500, 80, 30);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		
	

		buttonRefresh = new JButton("Refresh");
		buttonRefresh.setBounds(400, 500, 80, 30);
		buttonRefresh.addActionListener(this);
		panel.add(buttonRefresh);
		
	

		this.table = new JTable();
		Object[] column = {"Blood Group","In com.arnabb.bbms.Search.Stock (bags)"};
		this.tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(column);
		this.table.setModel(tableModel);
		table.setBackground(Color.WHITE);
		//table.setFont(new Font("Serif", Font.PLAIN, 18));
		table.setRowHeight(30);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(100,150,500,200);
		this.add(pane);
		panel.add(pane);

		showData1();
		showData2();
		showData3();
		showData4();
		showData5();
		showData6();
		showData7();
		showData8();

		panel.add(background);
		
		this.add(panel);
	}

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
		

		else if(buttonClicked.equals(buttonRefresh.getText()))
		{
			try{
				Stock st = new Stock();
				st.setVisible(true);
				this.setVisible(false);
			}

			catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	


    public void showData1(){

	    try{

	        Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg", "root", "");
			Statement stm = con.createStatement();
	        String query = "SELECT BloodGroup, COUNT(BloodGroup) FROM main_info WHERE BloodGroup = 'a+';";
	        //System.out.println("wht!!");
	        ResultSet result  = stm.executeQuery(query);
	        if(result.next()) {
	           // while (result.next()) {
	            	//System.out.println(result.getString(0) );
	                Object[] rows = { result.getString(1), result.getString(2) };

	                this.tableModel.addRow(rows);
	                System.out.println(result.getString(1));
	            //}
	            this.table.setModel(tableModel);
	        }
	        else {
	            JOptionPane.showMessageDialog(null,"No data to show");
	        }

	    }

	    catch (Exception e){
	        //e.printStackTrace();
	        JOptionPane.showMessageDialog(null,"Something Went Wrong!");
	    }
	}

	public void showData2(){

	    try{

	        Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg", "root", "");
			Statement stm = con.createStatement();
	        String query = "SELECT BloodGroup, COUNT(BloodGroup) FROM main_info WHERE BloodGroup = 'a-';";
	        //System.out.println("wht the hell!!");
	        ResultSet result  = stm.executeQuery(query);
	        if(result.next()) {
	            //while (result.next()) {
	            	//System.out.println(result.getString(0) );
	                Object[] rows = { result.getString(1), result.getString(2) };

	                this.tableModel.addRow(rows);
	                //System.out.println(result.getString(1));
	            //}
	            this.table.setModel(tableModel);
	        }
	        else {
	            JOptionPane.showMessageDialog(null,"No data to show");
	        }

	    }

	    catch (Exception e){
	        //e.printStackTrace();
	        JOptionPane.showMessageDialog(null,"Something wrong!");
	    }
	}

	public void showData3(){

	    try{

	        Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg", "root", "");
			Statement stm = con.createStatement();
	        String query = "SELECT BloodGroup, COUNT(BloodGroup) FROM main_info WHERE BloodGroup = 'b+';";
	        //System.out.println("wht the hell!!");
	        ResultSet result  = stm.executeQuery(query);
	        if(result.next()) {
	            //while (result.next()) {
	            	//System.out.println(result.getString(0) );
	                Object[] rows = { result.getString(1), result.getString(2) };

	                this.tableModel.addRow(rows);
	                //System.out.println(result.getString(1));
	            //}
	            this.table.setModel(tableModel);
	        }
	        else {
	            JOptionPane.showMessageDialog(null,"No data to show");
	        }

	    }

	    catch (Exception e){
	        //e.printStackTrace();
	        JOptionPane.showMessageDialog(null,"Something wrong!");
	    }
	}

	public void showData4(){

	    try{

	        Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg", "root", "");
			Statement stm = con.createStatement();
	        String query = "SELECT BloodGroup, COUNT(BloodGroup) FROM main_info WHERE BloodGroup = 'b-';";
	        //System.out.println("wht the hell!!");
	        ResultSet result  = stm.executeQuery(query);
	        if(result.next()) {
	           // while (result.next()) {
	            	//System.out.println(result.getString(0) );
	                Object[] rows = { result.getString(1), result.getString(2) };

	                this.tableModel.addRow(rows);
	                //System.out.println(result.getString(1));
	            //}
	            this.table.setModel(tableModel);
	        }
	        else {
	            JOptionPane.showMessageDialog(null,"No data to show");
	        }

	    }

	    catch (Exception e){
	        //e.printStackTrace();
	        JOptionPane.showMessageDialog(null,"Something wrong!");
	    }
	}

	public void showData5(){

	    try{

	        Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg", "root", "");
			Statement stm = con.createStatement();
	        String query = "SELECT BloodGroup, COUNT(BloodGroup) FROM main_info WHERE BloodGroup = 'o+';";
	        //System.out.println("wht the hell!!");
	        ResultSet result  = stm.executeQuery(query);
	        if(result.next()) {
	            //while (result.next()) {
	            	//System.out.println(result.getString(0) );
	                Object[] rows = { result.getString(1), result.getString(2) };

	                this.tableModel.addRow(rows);
	                //System.out.println(result.getString(1));
	            //}
	            this.table.setModel(tableModel);
	        }
	        else {
	            JOptionPane.showMessageDialog(null,"No data to show");
	        }

	    }

	    catch (Exception e){
	        //e.printStackTrace();
	        JOptionPane.showMessageDialog(null,"Something wrong!");
	    }
	}

	public void showData6(){

	    try{

	        Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg", "root", "");
			Statement stm = con.createStatement();
	        String query = "SELECT BloodGroup, COUNT(BloodGroup) FROM main_info WHERE BloodGroup = 'o-';";
	        //System.out.println("wht the hell!!");
	        ResultSet result  = stm.executeQuery(query);
	        if(result.next()) {
	            //while (result.next()) {
	            	//System.out.println(result.getString(0) );
	                Object[] rows = { result.getString(1), result.getString(2) };

	                this.tableModel.addRow(rows);
	                //System.out.println(result.getString(1));
	            //}
	            this.table.setModel(tableModel);
	        }
	        else {
	            JOptionPane.showMessageDialog(null,"No data to show");
	        }

	    }

	    catch (Exception e){
	        //e.printStackTrace();
	        JOptionPane.showMessageDialog(null,"Something wrong!");
	    }
	}

	public void showData7(){

	    try{

	        Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg", "root", "");
			Statement stm = con.createStatement();
	        String query = "SELECT BloodGroup, COUNT(BloodGroup) FROM main_info WHERE BloodGroup = 'ab+';";
	        //System.out.println("wht the hell!!");
	        ResultSet result  = stm.executeQuery(query);
	        if(result.next()) {
	            //while (result.next()) {
	            	//System.out.println(result.getString(0) );
	                Object[] rows = { result.getString(1), result.getString(2) };

	                this.tableModel.addRow(rows);
	                //System.out.println(result.getString(1));
	            //}
	            this.table.setModel(tableModel);
	        }
	        else {
	            JOptionPane.showMessageDialog(null,"No data to show");
	        }

	    }

	    catch (Exception e){
	        //e.printStackTrace();
	        JOptionPane.showMessageDialog(null,"Something wrong!");
	    }
	}

	public void showData8(){

	    try{

	        Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg", "root", "");
			Statement stm = con.createStatement();
	        String query = "SELECT BloodGroup, COUNT(BloodGroup) FROM main_info WHERE BloodGroup = 'ab-';";
	        //System.out.println("wht !!");
	        ResultSet result  = stm.executeQuery(query);
	        if(result.next()) {
	            //while (result.next()) {
	            	//System.out.println(result.getString(0) );
	                Object[] rows = { result.getString(1), result.getString(2) };

	                this.tableModel.addRow(rows);
	                //System.out.println(result.getString(1));
	            //}
	            this.table.setModel(tableModel);
	        }
	        else {
	            JOptionPane.showMessageDialog(null,"No data to show");
	        }

	    }

	    catch (Exception e){
	        //e.printStackTrace();
	        JOptionPane.showMessageDialog(null,"Something wrong!");
	    }
	}



}