package _08_calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
	JButton button1 = new JButton("add");
	JButton button2 = new JButton("sub");
	JButton button3 = new JButton("mul");
	JButton button4 = new JButton("div");
	JTextField field1 = new JTextField(10);
	JTextField field2 = new JTextField(10);
	JLabel label = new JLabel();
int add(int x, int y){
	 int sum = x+y;
	 return sum;
 }
int subtract(int x, int y){
	 int difference = x-y;
	 return difference;
}
int multiply(int x, int y){
	 int product = x*y;
	 return product;
}
int divide(int x, int y){
	 int quotient = x/y;
	 return quotient;
}
void startWindow() {
	JFrame frame = new JFrame("Simple Calculator");
	JPanel panel = new JPanel();
	
	button1.addActionListener(this);
	button2.addActionListener(this);
	button3.addActionListener(this);
	button4.addActionListener(this);
	
	
	panel.add(button1);
	panel.add(button2);
	panel.add(button3);
	panel.add(button4);
	panel.add(label);
	panel.add(field1);
	panel.add(field2);
	frame.add(panel);
	frame.pack();
	frame.setVisible(true);
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	String input1 = field1.getText();
	String input2 = field2.getText();
	int in1 = Integer.parseInt(input1);
	int in2 = Integer.parseInt(input2);
	if(e.getSource()==button1) {
		int z = add(in1, in2);
		label.setText(z+"");
	}
	if(e.getSource()==button2) {
		int z = subtract(in1, in2);
		label.setText(z+"");
	}
	if(e.getSource()==button3) {
		int z = multiply(in1, in2);
		label.setText(z+"");
	}
	if(e.getSource()==button4) {
		int z = divide(in1, in2);
		label.setText(z+"");
	}
}
}
