package quizgame;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class login extends JFrame 
{
	Connection con;
	Statement st;
	ResultSet rs;
	String udb,pdb;
	JLabel uid,pwd,label;
	JPasswordField value;
	JTextField uidtext,pwdtext;
	JButton b1;
	Container c;
	login()
	{
	super("LOG-IN Form");
	c=getContentPane();
	setSize(400,400);
	setLayout(null);
	setVisible(true);
	ImageIcon img=new ImageIcon("C:\\Users\\SHIVAM\\eclipse-workspace\\quizgame\\image\\log.jpg");
	label=new JLabel("",img,JLabel.CENTER);
	label.setBounds(0,0,1700,800);
	c.add(label);

	uid=new JLabel("User-ID");
	uid.setBounds(20,30,100,20);
	label.add(uid);
	uidtext=new JTextField();
	uidtext.setBounds(140,30,100,20);
	label.add(uidtext);

	pwd=new JLabel("Password");
	pwd.setBounds(20,70,100,20);
	label.add(pwd);

	value = new JPasswordField();
	value.setBounds(140,70,100,20);   
	label.add(value);

	b1=new JButton("LOGIN");
	b1.setBounds(70,100,120,20);
	label.add(b1);

	b1.addActionListener(new ActionListener()
	{ 	 	public void actionPerformed(ActionEvent ae)
			{
				 dispose();	            
				 try
				 {
					String uiddata=uidtext.getText();		
					String pwddata="";
					pwddata+=new String(value.getPassword());
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
					st=con.createStatement();
					rs=st.executeQuery("select * from reg");
					int k=1;								
					while(rs.next())
					{
					udb=rs.getString(1);
					pdb=rs.getString(2);		
					if(udb.equals(uiddata) && pdb.equals(pwddata))
					 { dispose();
					    new UserIdValid();
					    k=0;
					 }
					}
					if(k==1)
					 {  dispose();
					    new UserIdInvalid();
					 }			
					
				 }catch(Exception e) { System.out.println(e);}				
		    }
	});

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

