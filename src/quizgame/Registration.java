package quizgame;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class Registration  extends JFrame 
{
	Connection con;
	Statement st;
	ResultSet rs;
	int a,c;
	String b,d,e,data;
	JLabel uid,pwd,name,age,qty,phone,squestion,sanswer,l1;
	JTextField uidtext,nametext,agetext,qtytext,phonetext,squestiontext,sanswertext;
	JPasswordField pwdtext;
	JButton register;
	Container conta;
	Registration ()
	{
	super("Registration Form");
	setSize(600,600);
	setLayout(null);
	setVisible(true);
	conta=getContentPane();

	uid=new JLabel("UID");
	uid.setBounds(20,30,100,20);
	uid.setFont(new Font("areal",Font.BOLD,15));
	conta.add(uid);
	uidtext=new JTextField();
	uidtext.setBounds(140,30,100,20);
	conta.add(uidtext);

	pwd=new JLabel("PWD");
	pwd.setBounds(20,70,100,20);
	pwd.setFont(new Font("areal",Font.BOLD,15));
	conta.add(pwd);
	
	pwdtext = new JPasswordField();
	pwdtext.setBounds(140,70,100,20);   
	conta.add(pwdtext);

	name=new JLabel("Name");
	name.setBounds(20,110,100,20);
	name.setFont(new Font("areal",Font.BOLD,15));
	conta.add(name);
	nametext=new JTextField();
	nametext.setBounds(140,110,100,20);
	conta.add(nametext);

	age=new JLabel("Age");
	age.setBounds(20,150,100,20);
	age.setFont(new Font("areal",Font.BOLD,15));
	conta.add(age);
	agetext=new JTextField();
	agetext.setBounds(140,150,100,20);
	conta.add(agetext);

	qty=new JLabel("QTY");
	qty.setBounds(20,190,100,20);
	qty.setFont(new Font("areal",Font.BOLD,15));
	conta.add(qty);
	qtytext=new JTextField();
	qtytext.setBounds(140,190,100,20);
	conta.add(qtytext);

	phone=new JLabel("Phone");
	phone.setBounds(20,220,100,20);
	phone.setFont(new Font("areal",Font.BOLD,15));
	conta.add(phone);
	phonetext=new JTextField();
	phonetext.setBounds(140,220,100,20);
	conta.add(phonetext);

	squestion=new JLabel("Secret Ques");
	squestion.setBounds(20,260,100,20);
	squestion.setFont(new Font("areal",Font.BOLD,15));
	conta.add(squestion);
	squestiontext=new JTextField();
	squestiontext.setBounds(140,260,100,20);
	conta.add(squestiontext);

	sanswer=new JLabel("Secret Ans");
	sanswer.setBounds(20,300,100,20);
	sanswer.setFont(new Font("areal",Font.BOLD,15));
	conta.add(sanswer);
	sanswertext=new JTextField();
	sanswertext.setBounds(140,300,100,20);
	conta.add(sanswertext);

	register=new JButton("Register");
	register.setBounds(50,340,100,20);
	register.setFont(new Font("areal",Font.BOLD,15));
	conta.add(register);

	register.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		 { 
			dispose();
			new login();
			try
			{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			st=con.createStatement();
			String ui=uidtext.getText();
			String pw=pwdtext.getText();
			String na=nametext.getText();
			int ag=Integer.parseInt(agetext.getText());
			int qt=Integer.parseInt(qtytext.getText());
			String ph=phonetext.getText();
			String sq=squestiontext.getText();
			String sa=sanswertext.getText();
			String sqlquery=String.format("insert into reg values('%s','%s','%s',%d,%d,'%s','%s','%s')",ui,pw,na,ag,qt,ph,sq,sa);
			st.executeUpdate(sqlquery);
	 		con.close();
			}
			catch(Exception e){e.printStackTrace();}			
		}
	});
				
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}






