package quizgame;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class CorrectAnswer extends JFrame
{
		JLabel l1,l2,l3;
		JButton b1;
		Container container;
		Connection con;
		Statement st,st1;
		ResultSet rs,rs1;
		
		CorrectAnswer(String uid,String pwd)
		{
			super("Forget Password");
			setSize(400,400);
			setLayout(null);
			setVisible(true);
			container=getContentPane();
			container.setBackground(Color.YELLOW);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			l1=new JLabel();
			l1.setBounds(20,30,200,20);
			l1.setFont(new Font("areal",Font.BOLD,15));
			container.add(l1);
		
			l2=new JLabel();
			l2.setBounds(20,70,200,20);
			l2.setFont(new Font("areal",Font.BOLD,15));
			container.add(l2);
			
			l3=new JLabel();
			l3.setBounds(20,110,200,20);
			l3.setFont(new Font("areal",Font.BOLD,15));
			container.add(l3);
			
			b1=new JButton("Login");
			b1.setBounds(50,150,100,20);
			b1.setFont(new Font("areal",Font.BOLD,15));
			container.add(b1);

			try
			{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			st=con.createStatement();
			rs=st.executeQuery("select * from reg");
			int k=1;
			while(rs.next())
			{          
				if(uid.equals(rs.getString(1)) && pwd.equals(rs.getString(2)))
				{   k=0;
					l1.setText("Correct Answer");
					l2.setText("uid is "+uid);
					l3.setText("Password is "+pwd);	
				}
			}
			if(k==1)
			{ 
				l1.setText("Wrong answer");
			    l2.setText("uid is "+uid);
			    l3.setText("Password is "+pwd);	
			}
				
			}catch(Exception e){System.out.println(e);}		
		
		
			b1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{  dispose();
				   new login();
			    }
			} );		
		}
		
}
