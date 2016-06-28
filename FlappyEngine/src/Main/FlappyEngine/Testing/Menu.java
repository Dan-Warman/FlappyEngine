package Main.FlappyEngine.Testing;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu {
	
	private static int WIDTH = 800;
	private static int HEIGHT = 800;
	
	public static void main(String[] args){
		 	JFrame frame = new JFrame();
		 	frame.setSize(WIDTH, HEIGHT);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.getContentPane().setLayout(null);
		    frame.setVisible(true);
		    frame.setBackground(Color.cyan);
		    frame.setResizable(false);
		    
		    JLabel credits = new JLabel();
		    
		    credits.setText("By Dan Warman");
		    credits.setBounds(10, 740, 200, 25);
		    frame.getContentPane().add(credits);

		    JButton start = new JButton("Start");
		    start.setBounds(300, 150, 200, 23);
		    frame.getContentPane().add(start);
		    start.setBackground(Color.pink);

		    
		    start.addMouseListener(new MouseAdapter() {
		        public void mouseReleased(MouseEvent e){
		            if ( e.getButton() == 1 ){ // 1-left, 2-middle, 3-right button
		                FlappyBird.main(args);
		            }
		        }
		    });
	}
}
