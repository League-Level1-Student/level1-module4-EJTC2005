package _12_slot_machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Slots implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label;
	JLabel label2;
	JLabel label3;
	int x = 0;
	JButton button = new JButton("SPIN");
	void startUp() {
		button.addActionListener(this);
		panel.add(button);
		try {
			label=createLabelImage("cherry.jpg");
			label2=createLabelImage("orange.jpg");
			label3=createLabelImage("Lime.jpg");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel.add(label);
		panel.add(label2);
		panel.add(label3);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
		
		
}

private JLabel createLabelImage(String fileName) throws MalformedURLException{
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	Icon icon = new ImageIcon(imageURL);
	JLabel imageLabel = new JLabel(icon);
	return imageLabel;
}
    

	public static void main(String[]args) {
		Slots slots = new Slots();
		slots.startUp();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		panel.remove(label);
		panel.remove(label2);
		panel.remove(label3);
		Random r = new Random();
		int a = r.nextInt(3);
		int b = r.nextInt(3);
		int c = r.nextInt(3);
		if(a==0) {
			try {
				label=createLabelImage("cherry.jpg");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}if(a==1) {
			try {
				label=createLabelImage("orange.jpg");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}if(a==2) {
			try {
				label=createLabelImage("Lime.jpg");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}if(b==0) {
			try {
				label2=createLabelImage("cherry.jpg");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}if(b==1) {
			try {
				label2=createLabelImage("orange.jpg");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}if(b==2) {
			try {
				label2=createLabelImage("Lime.jpg");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}if(c==0) {
			try {
				label3=createLabelImage("cherry.jpg");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}if(c==1) {
			try {
				label3=createLabelImage("orange.jpg");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}if(c==2) {
			try {
				label3=createLabelImage("Lime.jpg");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		panel.add(label);	
		panel.add(label2);
		panel.add(label3);
		frame.pack();
		if(a==b&&b==c) {
			x++;
			JOptionPane.showMessageDialog(null, "You've won "+ x + " times!");
		}
	}
}
