package quizgame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class UserIdValid extends JFrame
{
	JLabel l1;
	JButton b1;
	Container c;
	UserIdValid()
	{
	super("Validate");
	setSize(400,400);
	setVisible(true);
	setLayout(null);
	c=getContentPane();
	JLabel l1=new JLabel("VALIDATE USER");
	l1.setBounds(40,60,150,20);
	c.add(l1);
	b1=new JButton("CONTINUE");
	b1.setBounds(50,100,100,20);
	c.add(b1);
	b1.addActionListener(new ActionListener()
	{ 
				public void actionPerformed(ActionEvent ae)
				{ dispose();
	              new QuizGame();
	            }
	});                              
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}







