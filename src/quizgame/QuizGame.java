package quizgame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class QuizGame extends JFrame 
{
	JLabel ques,marks,l1;
	JButton check,next;
	Container c;	
	Connection con;
	Statement st;
	ResultSet rs;
	String question,option1,option2,option3,option4,correctoption,sqlquery;
	JRadioButton r1,r2,r3,r4;
	ButtonGroup bg;
	int k=0,x=1;
	QuizGame()
	{
		super("Quiz Game");
		setSize(400,400);
		setVisible(true);
		setLayout(null);
		setResizable(false);
		addWindowListener(new WindowAdapter()
		{
		public void windowClosing(WindowEvent evt)
		{ System.exit(0);  }
  		});
		
		c=getContentPane();	
		ques=new JLabel();
		ques.setBounds(40,60,300,20);
		c.add(ques);
		marks=new JLabel();
		marks.setBounds(50,30,200,20);
		c.add(marks);
		l1=new JLabel();
		l1.setBounds(300,30,200,20);
		c.add(l1);
		check=new JButton("Check");
        check.setBounds(70,280,100,20);
	    c.add(check);
		next=new JButton("Next");
     	next.setBounds(200,280,100,20);
	    c.add(next);
		
	    r1=new JRadioButton("");
		r1.setBounds(50,100,500,20);
		r2=new JRadioButton("");
		r2.setBounds(50,140,500,20);
		r3=new JRadioButton("");
		r3.setBounds(50,180,500,20);
		r4=new JRadioButton("");
		r4.setBounds(50,220,500,20);
		bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		bg.add(r4);
		c.add(r1);
		c.add(r2);
		c.add(r3);
		c.add(r4);
		
		try
		{			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			st=con.createStatement();
			sqlquery="select * from exam";
			rs=st.executeQuery(sqlquery);
			if(rs.next())
			{
				question=rs.getString(1);
				option1=rs.getString(2);
				option2=rs.getString(3);
				option3=rs.getString(4);
				option4=rs.getString(5);
				correctoption=rs.getString(6);
				ques.setText("Q"+x+" "+question);
				//System.out.println(correctoption);
				
				r1.setText(option1);
				r2.setText(option2);
				r3.setText(option3);
				r4.setText(option4);
				
				x++;
			}  
		}catch(Exception e){e.printStackTrace();}
		
		check.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent ae)
			{	
				String s1=r1.getText();
				String s2=r2.getText();
				String s3=r3.getText();
				String s4=r4.getText();	
				if(r1.isSelected())
				{
					if(s1.equals(correctoption))
					{k=k+5;
					 l1.setText("Marks"+k);
					 marks.setText("Correct Answer");
					}
					else
					{l1.setText("Marks"+k);
					 marks.setText("Incorrect Answer");
					 bg.clearSelection();
					}
				}
					
				if(r2.isSelected())
				{
					if(s2.equals(correctoption))
					{ k=k+5;
					  l1.setText("Marks"+k);
					  marks.setText("Correct Answer");
					}
					else
					{ l1.setText("Marks"+k);
					  marks.setText("Incorrect Answer");	
					  bg.clearSelection();
					}
				}	
				if(r3.isSelected())
				{
					if(s3.equals(correctoption))
					{ k=k+5;
					  l1.setText("Marks"+k);
					  marks.setText("Correct Answer");
					}
					else
					{
					  l1.setText("Marks"+k);
					  marks.setText("Incorrect Answer");
					  bg.clearSelection();
					}
				}		
				if(r4.isSelected())
				{
					if(s4.equals(correctoption))
					{ k=k+5;
					  l1.setText("Marks"+k);
					  marks.setText("Correct Answer");
					}
					else
					{
					  l1.setText("Marks"+k);
					  marks.setText("Incorrect Answer");
					  bg.clearSelection();
					}    
				}
			}
		});
		
		next.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent ae)
			{	bg.clearSelection();
				try
				{
					  if(rs.next())
					  {
						question=rs.getString(1);
						option1=rs.getString(2);
						option2=rs.getString(3);
						option3=rs.getString(4);
						option4=rs.getString(5);
						correctoption=rs.getString(6);
						ques.setText("Q"+x+" "+question);
						r1.setText(option1);
						r2.setText(option2);
						r3.setText(option3);
						r4.setText(option4);
						x++;
					  }
					  else
					  System.exit(0);
				}catch(Exception e){System.out.println(e); }
			}  
		});		   	    	
		
	}
			
}
