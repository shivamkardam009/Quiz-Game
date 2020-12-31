package quizgame;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class SuccessfullyChange extends JFrame
{
	JLabel l1; 
	JButton b1;
	Container c;
	SuccessfullyChange()
	{
		super("Successful change");
		setSize(400,400);
		setLayout(null);
		setVisible(true);
		c=getContentPane();
		c.setBackground(Color.YELLOW);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		l1=new JLabel("SuccessFully Changed");
		l1.setBounds(20,30,200,20);
		l1.setFont(new Font("areal",Font.BOLD,15));
		c.add(l1);

		b1=new JButton("Login");
		b1.setBounds(50,70,100,20);
		c.add(b1);

		b1.addActionListener(new ActionListener()
		{  public void actionPerformed(ActionEvent ae)
			{
			dispose();	     
			new login();
			}
		});

	}
}


