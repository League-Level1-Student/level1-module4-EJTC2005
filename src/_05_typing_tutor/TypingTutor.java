package _05_typing_tutor;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TypingTutor implements KeyListener {
	char currentLetter;
	JLabel label = new JLabel();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	Date timeAtStart = new Date();
	int lettersTyped = 0;

public static void main(String[]args) {
	TypingTutor t = new TypingTutor();
	t.setup();
}
void setup(){
	
	
	currentLetter = generateRandomLetter();
	label.setText(currentLetter+"");
	label.setFont(label.getFont().deriveFont(28.0f));
	label.setHorizontalAlignment(JLabel.CENTER);
	panel.add(label);
	frame.add(panel);
	frame.addKeyListener(this);
	frame.pack();
	frame.setVisible(true);
	
}
char generateRandomLetter() {
    Random r = new Random();
    return (char) (r.nextInt(26) + 'a');
}
@Override
public void keyPressed(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}

private void showTypingSpeed(int numberOfCorrectCharactersTyped) {
    Date timeAtEnd = new Date();
    long gameDuration = timeAtEnd.getTime() - timeAtStart.getTime();
    long gameInSeconds = (gameDuration / 1000) % 60;
    double charactersPerSecond = ((double) numberOfCorrectCharactersTyped / (double) gameInSeconds);
    int charactersPerMinute = (int) (charactersPerSecond * 60);
    JOptionPane.showMessageDialog(null, "Your typing speed is " + charactersPerMinute + " characters per minute.");
} 
@Override
public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
	if(arg0.getKeyChar()==currentLetter) {
	System.out.println("correct");
	panel.setBackground(Color.GREEN);
	lettersTyped++;
	if(lettersTyped==10) {
		showTypingSpeed(lettersTyped);
	}
	}
	else {
		System.out.println("false");
		panel.setBackground(Color.RED);
	}
	currentLetter=generateRandomLetter();
	label.setText(currentLetter+"");
	frame.pack();
}
@Override
public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
}
