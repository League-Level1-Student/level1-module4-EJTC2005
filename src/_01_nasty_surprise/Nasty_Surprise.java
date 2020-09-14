package _01_nasty_surprise;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Nasty_Surprise {
public static void main(String[]args) {
	JFrame frame = new JFrame();
	frame.setVisible(true);
	JPanel panel = new JPanel();
	JButton button1 = new JButton("Trick");
	JButton button2 = new JButton("Treat");
	button1.setSize(100, 100);
	button2.setSize(100, 100);
	panel.add(button1);
	panel.add(button2);
	frame.add(panel);
	frame.setVisible(true);
}
private void showPictureFromTheInternet(String imageUrl) {
    try {
        URL url = new URL(imageUrl);
        Icon icon = new ImageIcon(url);
        JLabel imageLabel = new JLabel(icon);
        JFrame frame = new JFrame();
        frame.add(imageLabel);
        frame.setVisible(true);
        frame.pack();
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }
}
}
