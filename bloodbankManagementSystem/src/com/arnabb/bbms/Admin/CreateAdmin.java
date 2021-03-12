package com.arnabb.bbms.Admin;//create admin

import java.io.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.event.*;
import java.sql.*;



public class CreateAdmin extends JFrame implements ActionListener
{
	private JLabel nameLabel, title, background, numberLabel, initialBalanceLabel, idLabel, passwordLabel, addidLabel;
	private JTextField nameTF, numberTF, initialBalanceTF, idTF;
	private JPasswordField passwordPF;
	private JButton buttonBack, buttonLogout, buttonInsert;
	private JPanel panel;
	

	public CreateAdmin(String aID) 
	{
		super("BBMS : Create New Admin");
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


		addidLabel = new JLabel(aID);
		addidLabel.setVisible(false);
		panel.add(addidLabel);


		title  = new JLabel ("Introduce New Admin");
		title.setBounds(100, 60, 400, 100);
		title.setOpaque(false);
		title.setVisible(true);
		title.setFont(new Font("Comic Sans MS",Font.ITALIC+Font.BOLD, 30));
		title.setForeground(Color.white);
		panel.add(title);
		
		nameLabel = new JLabel("Enter Name");
		nameLabel.setBounds(290,200,200,35);
		nameLabel.setForeground(Color.white);
		panel.add(nameLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(220,230,200,35);
		panel.add(nameTF);
		
		
		idLabel = new JLabel("Create Org. ID");
		idLabel.setBounds(290,260,200,35);
		idLabel.setForeground(Color.white);
		panel.add(idLabel);
		
		idTF = new JTextField();
		idTF.setBounds(220,290,200,35);
		panel.add(idTF);
		
		passwordLabel = new JLabel("Create Password");
		passwordLabel.setBounds(290,320,200,35);
		passwordLabel.setForeground(Color.white);
		panel.add(passwordLabel);
		
		passwordPF =new JPasswordField();
		passwordPF.setBounds(220, 350, 200, 30);
		panel.add(passwordPF);
		
		buttonBack = new JButton("Cancel");
		buttonBack.setBounds(220, 450, 200, 30);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		
		buttonInsert = new JButton("Create");
		buttonInsert.setBounds(220, 400, 200, 30);
		buttonInsert.addActionListener(this);
		panel.add(buttonInsert);

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
		else if(buttonClicked.equals(buttonInsert.getText()))
		{
			insertIntoDB();

			
		}
	}


	public void insertIntoDB()
	{	

		String adId = idTF.getText();
        String password = passwordPF.getText();

        if (adId.length()!=0) {

        	if (password.length()!=0) {

				String query = "INSERT INTO admin_info VALUES ('"+idTF.getText()+"','"+nameTF.getText()+"','"+passwordPF.getText()+"');";
				System.out.println(query);
		        try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_reg", "root", "");
					Statement stm = con.createStatement();
					stm.execute(query);
					stm.close();
					con.close();

					JOptionPane.showMessageDialog(null, "Insertion Succeed!");
							
				}
		        catch(Exception ex)
				{
					System.out.println("Exception : " +ex.getMessage());
		        }
		    }

		    else {
				JOptionPane.showMessageDialog(this,"Invalid Password");
			}

		}

		else {
			JOptionPane.showMessageDialog(this,"Invalid ID");
		}

    }
    
}