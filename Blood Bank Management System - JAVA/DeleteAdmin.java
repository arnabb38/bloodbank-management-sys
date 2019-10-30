// eleminate admin



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



public class DeleteAdmin extends JFrame implements ActionListener
{
	private JLabel background,numberLabel, logID;
	private JTextField numberTF;
	private JButton buttonBack, buttonLogout, buttonDelete, buttonRefresh;
	private JPanel panel;
	private JTable table;
	private DefaultTableModel tableModel;
	public DeleteAdmin (String aID) 
	{
		super("Eliminate Admin");
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


		logID = new JLabel(aID);
		logID.setBounds(100,350,80,30);
		logID.setVisible(false);
		panel.add(logID);

		
		numberLabel = new JLabel("Enter Admin ID ");
		numberLabel.setBounds(100,400,150,30);
		numberLabel.setForeground(Color.white);
		panel.add(numberLabel);
		
		numberTF = new JTextField();
		numberTF.setBounds(250,400,150,30);
		panel.add(numberTF);
		
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
		Object[] column = {"Admin ID","Name","Password"};
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
			String id = logID.getText();

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
			//String lgNum = numberTF.getText();

			check();


		}


		else if(buttonClicked.equals(buttonRefresh.getText()))
		{

			String id = logID.getText();

			try{
				DeleteAdmin da = new DeleteAdmin(id);
				da.setVisible(true);
				this.setVisible(false);
			}

			catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}

	public void check(){

			String inNum = numberTF.getText();

			if (numberTF.getText().length()!=0){

				if (logID.getText().equals(numberTF.getText())) {

					
					JOptionPane.showMessageDialog(null, "Failed! You are logged IN!");
				}

				else {

					String query = "SELECT AdminID, FROM admin_info where AdminID = '"+inNum+"';";     
			        Connection con=null;//for connection
			        Statement st = null;//for query execution
					ResultSet rs = null;//to get row by row result from DB
					System.out.println(query);
			        try
					{
						Class.forName("com.mysql.jdbc.Driver");//load driver
						System.out.println("driver loaded");
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg","root","");
						System.out.println("connection done");//connection with database established
						st = con.createStatement();//create statement
						System.out.println("statement created");
						rs = st.executeQuery(query);//getting result
						System.out.println("results received");

						if (rs.next()){
							//System.out.println("trrrrryyyyy!!");


							deleteFromDB();
					
						}
						else{
							JOptionPane.showMessageDialog(this,"NO Match Found!");
						}
					}
				

			        catch(Exception ex)
					{
						System.out.println("Exception : " +ex.getMessage());
			        }
			        finally
					{
			            try
						{
			                if(rs!=null)
								rs.close();

			                if(st!=null)
								st.close();

			                if(con!=null)
								con.close();
			            }
			            catch(Exception ex){}
			        }
			    }

						
							
					
			}

			else {

				JOptionPane.showMessageDialog(null, "Enter ID");
			}


	}

	
	public void deleteFromDB()
	{

		
			String query = "DELETE from admin_info where AdminID="+numberTF.getText()+";";
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
	        String query = "SELECT * FROM admin_info";
	        //System.out.println("wht the hell!!");
	        ResultSet result  = stm.executeQuery(query);
	        
	            while (result.next()) {
	            	//System.out.println(result.getString(0) );
	                Object[] rows = { result.getString(1), result.getString(2), result.getString(3) };

	                this.tableModel.addRow(rows);
	                //System.out.println(result.getString(1));
	            }
	            this.table.setModel(tableModel);
	        
	        

	    }

	    catch (Exception e){
	        //e.printStackTrace();
	        JOptionPane.showMessageDialog(null,"Something wrong!");
	    }

	}


    
}
