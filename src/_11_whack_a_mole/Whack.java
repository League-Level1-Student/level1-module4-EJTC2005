package _11_whack_a_mole;

import java.applet.AudioClip;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Whack implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	int moles = 0;
	int misses = 0;
	Date startTime;
	


	void startUp() {
		panel.setLayout(new GridLayout(8,3));
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		Random r = new Random();
		int x = r.nextInt(24);
		drawButtons(x);
		startTime= new Date();
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
		frame.pack();
	}
	private void endGame(Date timeAtStart, int molesWhacked) { 
	    Date timeAtEnd = new Date();
	    JOptionPane.showMessageDialog(null, "Your whack rate is "
	            + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
	                  + " moles per second.");
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
    private void playSound(String fileName) { 
        AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
        sound.play();
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
			moles++;
			playSound("349193__natty23__whack (3).wav");
			if(moles==10) {
				endGame(startTime, moles);
				System.exit(0);
			}
		}
		else {
			misses++;
			Random ra = new Random();
			int e = ra.nextInt(3);
			if(e==0) {
				speak("You missed!");
			}
			if(e==1) {
				speak("Try again!");
			}
			if(e==2) {
				speak("Oh no!");
			}
			if(e==3) {
				speak("You can do it!");
			}
			if(misses==5) {
				speak("You lose!");
				endGame(startTime, moles);
				System.exit(0);
			}
			
		}
		Random r = new Random();
		int x = r.nextInt(24);
		drawButtons(x);
	}
}
