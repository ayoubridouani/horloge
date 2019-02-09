import java.util.Date;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends Thread{
	private JFrame frame;
	private JPanel panel;
	private JLabel label1,label2;
	private Date date;
	
	Main(){
		
		frame = new JFrame("Horloge");
		frame.setSize(300, 200);
		
		label1 = new JLabel();
		label1.setBounds(100,50,100,30);
		
		label2 = new JLabel();
		label2.setBounds(100,100,100,30);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		panel.add(label1);
		panel.add(label2);
		
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panel);
	}
	
	@SuppressWarnings("deprecation")
	public void run() {
		while(!Thread.interrupted()) {
			date = new Date();
			StringTokenizer token = new StringTokenizer(String.valueOf(date.toString()));
			token.nextToken(" ");
			token.nextToken(" ");
			String day = token.nextToken(" ");
			label1.setText((date.getYear() + 1900) + "/" + (date.getMonth()+ 1) + "/" + day);
			label2.setText(date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.start();
	}
}
