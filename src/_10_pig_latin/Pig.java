package _10_pig_latin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pig implements ActionListener {
 JFrame frame = new JFrame();
 JTextField field1 = new JTextField(10);
 JButton button = new JButton("translate");
 JPanel panel = new JPanel();
 JTextField field2 = new JTextField(10);
 PigLatinTranslator p = new PigLatinTranslator();
	void startUp() {
	 button.addActionListener(this);
	panel.add(field1);
	 panel.add(button);
	 panel.add(field2);
	 frame.add(panel);
	 frame.pack();
	 frame.setVisible(true);
 }
	
	public static void main(String [] args) {
		Pig pig = new Pig();
		pig.startUp();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button) {
		String x = field1.getText();
		String y = p.translate(x);
		field2.setText(y);
		 
		}
	}
}

