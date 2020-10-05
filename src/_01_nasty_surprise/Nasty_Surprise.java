package _01_nasty_surprise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Nasty_Surprise implements ActionListener{
public static void main(String[]args) {
Nasty_Surprise n = new Nasty_Surprise();

}
JButton button1 = new JButton("Trick");
JButton button2 = new JButton("Treat");
Nasty_Surprise(){
	
	JFrame frame = new JFrame();
	frame.setVisible(true);
	JPanel panel = new JPanel();
	
	button1.addActionListener(this);
	button2.addActionListener(this);
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

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	if(arg0.getSource()==button1) {
		showPictureFromTheInternet("https://hips.hearstapps.com/countryliving.cdnds.net/17/47/1511194376-cavachon-puppy-christmas.jpg"
);
	}
	if(arg0.getSource()==button2) {
		showPictureFromTheInternet("https://previews.123rf.com/images/yusakp/yusakp1410/yusakp141000012/32311986-spooky-ghost.jpg");
	}
}
}
