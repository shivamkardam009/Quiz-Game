package quizgame;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class ForgetPassword extends JFrame 
{
		String sq,sa,correctuid,correctpwd;
		JLabel uid,secretques,secretans,notexist;
		JTextField uidtext,secretquestext,secretanstext;
		JButton click,go;
		Container container;
		Connection con;
		Statement st,st1;
		ResultSet rs,rs1;
		int x=1;
		ForgetPassword()
		{
			super("Forget Password");
			setSize(500,500);
			setLayout(null);
			setVisible(true);
			container=getContentPane();
			container.setBackground(Color.YELLOW);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			uid=new JLabel("Enter UID");
			uid.setBounds(20,30,200,20);
			uid.setFont(new Font("areal",Font.BOLD,15));
			container.add(uid);
			uidtext=new JTextField();
			uidtext.setBounds(240,30,100,20);
			container.add(uidtext);
			
			click=new JButton("Click me");
			click.setBounds(50,70,100,20);
			click.setFont(new Font("areal",Font.BOLD,15));
			container.add(click);
			
			secretques=new JLabel("Enter Secret question");
			secretques.setBounds(20,110,200,20);
			secretques.setFont(new Font("areal",Font.BOLD,15));
			container.add(secretques);
			secretquestext=new JTextField();
			secretquestext.setBounds(240,110,100,20);
			container.add(secretquestext);
			
			notexist=new JLabel();
			notexist.setBounds(360,110,200,20);
			notexist.setFont(new Font("areal",Font.BOLD,15));
			container.add(notexist);
			
			secretans=new JLabel("Enter Secret Answer");
			secretans.setBounds(20,150,200,20);
			secretans.setFont(new Font("areal",Font.BOLD,15));
			container.add(secretans);
			secretanstext=new JTextField();
			secretanstext.setBounds(240,150,100,20);
			container.add(secretanstext);
			
			go=new JButton("Go");
			go.setBounds(50,190,100,20);
			go.setFont(new Font("areal",Font.BOLD,15));
			container.add(go);
			
			click.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					try
					{
						String ui=uidtext.getText();
						Class.forName("oracle.jdbc.driver.OracleDriver");
						con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
						st=con.createStatement();
						rs=st.executeQuery("select * from reg");
						int k=1;
						while(rs.next())
						{          
							if(ui.equals(rs.getString(1)))
							{   k=0;
								x=1;
								correctuid=rs.getString(1);
								correctpwd=rs.getString(2);
								sq=rs.getString(7);
								sa=rs.getString(8);
								secretquestext.setText(sq);
								secretanstext.setText(sa);
								notexist.setText("user exist");	
							}
											
						}
							if(k==1)
							{  
								x=0;
								secretquestext.setText("");
								secretanstext.setText(""); 
								notexist.setText("user not exist");
							}
						
					}catch(Exception e)	{e.printStackTrace();}
											
				}
			} );
			
			go.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					dispose();
					if(x==1)
					new CorrectAnswer(correctuid,correctpwd);	
					if(x==0)
					new WrongAnswer();
		     	}
			} );

		}
}
