package _04_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener {
	JButton button1 = new JButton("Joke");
	JButton button2 = new JButton("Punchline");
	public static void main(String [] args) {
	ChuckleClicker c = new ChuckleClicker();
	c.makeButtons();
}
void makeButtons() {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	
	button1.addActionListener(this);
	button2.addActionListener(this);
	panel.add(button1);
	panel.add(button2);
	frame.add(panel);
	frame.pack();
	frame.setVisible(true);
	
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==button1) { 
	JOptionPane.showMessageDialog(null, "What do you call a pig that does karate?");
	}
	if(e.getSource()==button2) { 
		JOptionPane.showMessageDialog(null, "A porkchop.");
	}
	}
}

