package quizgame;
import javax.swing.*;
import java.awt.*;
public class WrongAnswer extends JFrame 
{
		JLabel l1;
		Container container;
		WrongAnswer()
		{
			super("Wrong Answer");
			setSize(400,400);
			setLayout(null);
			setVisible(true);
			container=getContentPane();
			container.setBackground(Color.YELLOW);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			l1=new JLabel("WRONG ANSWER");
			l1.setBounds(20,30,200,20);
			l1.setFont(new Font("areal",Font.BOLD,15));
			container.add(l1);
		}
}
