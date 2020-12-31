package quizgame;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class ChangePassword extends JFrame
{
	String getuid,getpwd,confirmpassword1,confirmpassword2;
	Connection con;
	Statement st,st1;
	ResultSet rs,rs1;
	JLabel uid,opwd,npwd,cpwd;
	JTextField uidtext;
	JPasswordField opwdtext,npwdtext,cpwdtext;
	JButton change;
	Container container;
	int age;
	ChangePassword()
	{
	super("Change Password");
	setSize(450,400);
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

	opwd=new JLabel("Enter Old Pwd");
	opwd.setBounds(20,70,200,20);
	opwd.setFont(new Font("areal",Font.BOLD,15));
	container.add(opwd);
	opwdtext = new JPasswordField();
	opwdtext.setBounds(240,70,100,20);   
	container.add(opwdtext);
	
	npwd=new JLabel("Enter New Pwd");
	npwd.setBounds(20,110,200,20);
	npwd.setFont(new Font("areal",Font.BOLD,15));
	container.add(npwd);
	npwdtext = new JPasswordField();
	npwdtext.setBounds(240,110,100,20);   
	container.add(npwdtext);
	
	cpwd=new JLabel("Enter Confirm Pwd");
	cpwd.setBounds(20,150,200,20);
	cpwd.setFont(new Font("areal",Font.BOLD,15));
	container.add(cpwd);
	cpwdtext = new JPasswordField();
	cpwdtext.setBounds(240,150,100,20);   
	container.add(cpwdtext);
		
	change=new JButton("Change");
	change.setBounds(50,200,100,20);
	change.setFont(new Font("areal",Font.BOLD,15));
	container.add(change);

	change.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			try
		    {
			  Class.forName("oracle.jdbc.driver.OracleDriver");
			  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		      st=con.createStatement();
			  String checkuid=uidtext.getText();
			  String checkpwd=opwdtext.getText();
			  rs=st.executeQuery("select * from reg");
			  int k=1;
			  while(rs.next())
			  {          
			   	getuid=rs.getString(1);
				getpwd=rs.getString(2);
				age=rs.getInt(4);
				if(checkuid.equals(getuid) && checkpwd.equals(getpwd))
				{	dispose();
					k=0;
					confirmpassword1=npwdtext.getText();
					confirmpassword2=cpwdtext.getText();	
					st1=con.createStatement();	
					st1.executeUpdate("update reg set pwd=" + confirmpassword2 + "where age=" + age);	
					new SuccessfullyChange();	
				}							
			   }
			   if(k==1)
			   {
				dispose();
				new SomethingWrong();
			   }
									
			 }catch(Exception e){e.printStackTrace();}
		  }					
	  } );

	}
}
