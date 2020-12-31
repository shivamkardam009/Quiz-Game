package quizgame;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class SomethingWrong extends JFrame
{
	JLabel l1; 
	JButton b1;
	Container c;
	SomethingWrong()
	{
		super("SomeThing Wrong");
		setSize(400,400);
		setLayout(null);
		setVisible(true);
		c=getContentPane();
		c.setBackground(Color.YELLOW);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		l1=new JLabel("Something Wrong");
		l1.setBounds(20,30,200,20);
		l1.setFont(new Font("areal",Font.BOLD,15));
		c.add(l1);

		b1=new JButton("back");
		b1.setBounds(50,70,100,20);
		c.add(b1);

		b1.addActionListener(new ActionListener()
		{  public void actionPerformed(ActionEvent ae)
		   {
			dispose();	     
			new ChangePassword();
		   }
		});

	}
}


