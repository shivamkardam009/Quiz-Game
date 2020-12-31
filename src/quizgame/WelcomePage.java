package quizgame;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class WelcomePage extends JFrame
{
	JLabel l1,label;
	JButton b1,b2,b3,b4,b5;
	Container c;
    WelcomePage()
	{
	super("Welcome Page");
	setSize(500,600);
	setLayout(null);
	setVisible(true);
	setResizable(true);
	addWindowListener(new WindowAdapter()
	{
	   public void windowClosing(WindowEvent evt)
	   { System.exit(0);  }
	});

	c=getContentPane();
	ImageIcon img=new ImageIcon("C:\\Users\\SHIVAM\\eclipse-workspace\\quizgame\\image\\3.jpg");
	label=new JLabel("",img,JLabel.CENTER);
	label.setBounds(0,0,1900,1000);
	c.add(label);

	l1=new JLabel("Welcome To Global Technology");
	l1.setFont(new Font("areal",Font.BOLD,15));
	l1.setForeground(Color.WHITE);
	l1.setBounds(100,6,400,15);
	label.add(l1);

	b1=new JButton("New User");
	b1.setFont(new Font("areal",Font.BOLD,15));
	b1.setBounds(30,30,200,20);
	label.add(b1);
	b2=new JButton("Existing User");
	b2.setBounds(250,30,200,20);
	b2.setFont(new Font("areal",Font.BOLD,15));
	label.add(b2);
	b3=new JButton("Forget Password");
	b3.setBounds(30,80,200,20);
	b3.setFont(new Font("areal",Font.BOLD,15));
	label.add(b3);
	b4=new JButton("Change Password");
	b4.setBounds(250,80,200,20);
	b4.setFont(new Font("areal",Font.BOLD,15));
	label.add(b4);
	b5=new JButton("Exit");
	b5.setBounds(120,130,200,20);
	b5.setFont(new Font("areal",Font.BOLD,15));
	label.add(b5);
	b1.addActionListener(new ActionListener()
	{
				public void actionPerformed(ActionEvent ae)
				{	dispose();	
					new Registration();
				}
	});		

	b2.addActionListener(new ActionListener()
	{
				public void actionPerformed(ActionEvent ae)
				{	dispose();	
					new login();
				}
			     }
			  );

	b3.addActionListener(new ActionListener()
    {
				public void actionPerformed(ActionEvent ae)
				{	dispose();	
					new ForgetPassword();
				}
	} );

	b4.addActionListener(new ActionListener()
	{
				public void actionPerformed(ActionEvent ae)
				{	dispose();
					new ChangePassword();
				}
	});

	b5.addActionListener(new ActionListener()
	{
				public void actionPerformed(ActionEvent ae)
				{	System.exit(0);}
	} );

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	 
	public static void main(String[] args)
	 {new WelcomePage();}
}