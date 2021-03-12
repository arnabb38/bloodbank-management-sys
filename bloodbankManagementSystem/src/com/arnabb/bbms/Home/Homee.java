package com.arnabb.bbms.Home;//try / gui 1 / homee

import com.arnabb.bbms.Donor.Donor;
import com.arnabb.bbms.Login.Login;
import com.arnabb.bbms.Search.SearchInfo;
import com.arnabb.bbms.Search.Stock;

import java.io.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.event.*;

public class Homee extends JFrame implements MouseListener, ActionListener {
	
	private JLabel title, title2, imgLab, background;
	private JButton b1,b2,b3,b4,b5,b6;
	private JPanel panel;
	private ImageIcon img;

	public Homee() {
		super("BBMS : Welcome");
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

		title  = new JLabel ("Welcome");
		title.setBounds(100, 60, 400, 100);
		title.setOpaque(false);
		title.setVisible(true);
		title.setFont(new Font("Comic Sans MS",Font.ITALIC+Font.BOLD, 54));
		title.setForeground(Color.white);
		panel.add(title);

		title2  = new JLabel ("Give The Gift Of Life, Donate Blood");
		title2.setBounds(180, 140, 400, 80);
		title2.setOpaque(false);
		title2.setVisible(true);
		title2.setFont(new Font("Comic Sans MS",Font.ITALIC+Font.BOLD, 20));
		title2.setForeground(Color.white);
		panel.add(title2);
		 

		b1 = new JButton ("Administration");
		b1.setBounds(250,270,200,35);
		b1.addMouseListener(this);
		b1.addActionListener(this);
		panel.add(b1);

        b2 = new JButton ("com.arnabb.bbms.Donor.Donor");
		b2.setBounds(250,320,200,35);
		//b2.setBackground(Color.green);
		b2.setVisible(true);
		b2.addMouseListener(this);
		b2.addActionListener(this);
		panel.add(b2);

		b3 = new JButton ("Search");
		b3.setBounds(250,370,200,35);
		b3.setVisible(true);
		b3.addMouseListener(this);
		b3.addActionListener(this);
		panel.add(b3);

		b4 = new JButton ("com.arnabb.bbms.Search.Stock Available");
		b4.setBounds(250,420,200,35);
		b4.setVisible(true);
		b4.addMouseListener(this);
		b4.addActionListener(this);
		panel.add(b4);

		/*b5 = new JButton ("About");
		b5.setBounds(200,400,200,35);
		b5.addMouseListener(this);
		b5.addActionListener(this);
		panel.add(b5);*/

		b6 = new JButton ("Exit");
		b6.setBounds(250,470,200,35);
		b6.addMouseListener(this);
		b6.addActionListener(this);
		panel.add(b6);

		panel.add(background);
		this.add(panel);
	}

	public void mouseEntered(MouseEvent me){ }
	public void mouseExited(MouseEvent me){ }
	public void mouseReleased(MouseEvent me){	}
	public void mousePressed(MouseEvent me){	}
	public void mouseClicked(MouseEvent me){	}

	public void actionPerformed(ActionEvent ae){

		String elementText = ae.getActionCommand();

		if(elementText.equals(b1.getText()))
		{
			try {
				Login l = new Login();
				l.setVisible(true);
				this.setVisible(false);
			}

			catch(Exception e){
				e.printStackTrace();
			}
		}	

		else if(elementText.equals(b2.getText()))
		{
			try {
				Donor d = new Donor();
				d.setVisible(true);
				this.setVisible(false);
			}

			catch(Exception e){
				e.printStackTrace();
			}
		}


		else if(elementText.equals(b3.getText()))
		{
			try {
				SearchInfo si = new SearchInfo();
				si.setVisible(true);
				this.setVisible(false);
			}

			catch(Exception e){
				e.printStackTrace();
			}
		}

		else if(elementText.equals(b4.getText()))
		{
			try {
				Stock st = new Stock();
				st.setVisible(true);
				this.setVisible(false);
			}

			catch(Exception e){
				e.printStackTrace();
			}
		}


		else if(elementText.equals(b6.getText()))
		{
			System.exit(0); 
		}

		
		else{}
	}
}







