package _11_whack_a_mole;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Whack implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	


	void startUp() {
		panel.setLayout(new GridLayout(8,3));
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		Random r = new Random();
		int x = r.nextInt(24);
		drawButtons(x);
	}
	void drawButtons(int x) {
		frame.remove(panel);
		panel = new JPanel();
		panel.setLayout(new GridLayout(8,3));
		for(int x1 = 0; x1<24; x1++) {
			JButton button1 = new JButton(" ");
			if(x1==x) {
				button1.setText("mole");
			}
			button1.addActionListener(this);
			panel.add(button1);
			
		}
		frame.add(panel);
	}
    static void speak(String words) {
        if( System.getProperty( "os.name" ).contains( "Windows" ) ) {
            String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
                    + words + "');\"";
            try {
                Runtime.getRuntime().exec( cmd ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        } else {
            try {
                Runtime.getRuntime().exec( "say " + words ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        }
    }
	
	public static void main(String [] args) {
		Whack whack = new Whack();
		whack.startUp();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JButton button2 = (JButton) arg0.getSource();
		if(button2.getText().equals("mole")) {
			
		}
		else {
			speak("You missed!");
		}
		Random r = new Random();
		int x = r.nextInt(24);
		drawButtons(x);
	}
}
