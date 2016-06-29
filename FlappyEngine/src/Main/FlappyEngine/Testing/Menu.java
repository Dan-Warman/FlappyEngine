package Main.FlappyEngine.Testing;
//By Dan 

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu {
	
	private static int WIDTH = 800;
	private static int HEIGHT = 800;
	private static String TITLE = "Menu";
	
	private static String CONTROLSTEXT =
			"W To Jump\n "
			+ "Space To Jump\n "
			+ "Up Arrow To Jump\n "
			+ "Left Mouse To Jump\n ";
	
	public static void main(String[] args){
		
			ImageIcon icon = new ImageIcon("src/Main/FlappyEngine/Imgs/icon.png");
		
		 	JFrame frame = new JFrame();
		 	frame.setSize(WIDTH, HEIGHT);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.getContentPane().setLayout(null);
		    frame.setVisible(true);
		    frame.setBackground(Color.cyan);
		    frame.setResizable(false);
		    frame.setTitle(TITLE);
		    frame.setIconImage(icon.getImage());
		    
			JLabel controllabl = new JLabel(CONTROLSTEXT);
			controllabl.setBounds(300, 300, 400,400);
			frame.getContentPane().add(controllabl);
			controllabl.setVisible(false);
		    
		    JButton controls = new JButton("Controls");
		    controls.setBounds(300, 150,200,23);
		    frame.getContentPane().add(controls);
		    controls.setBackground(Color.pink);
		    
		    controls.addMouseListener(new MouseAdapter(){
		    	public void mouseReleased(MouseEvent e){
		    		if(e.getButton() == 1){
		    			//System.out.println("isWorking");
		    			frame.getContentPane().add(controllabl);
		    			controllabl.setVisible(true);
		    		}
		    		if(e.getButton() == 3){
		    			frame.getContentPane().add(controllabl);
		    			controllabl.setVisible(false);
		    		}
		    		    		
		    	}
		    	
		    	
		    });
		    
		    JButton exit = new JButton("Exit");
		    exit.setBounds(300,200,200,23);
		    frame.getContentPane().add(exit);
		    exit.setBackground(Color.pink);
		    
		    exit.addMouseListener(new MouseAdapter(){
		    	public void mouseReleased(MouseEvent e){
		    		if(e.getButton() == 1){
		    			frame.dispose();
		    		}
		    	}
		    });
		    
		    JLabel credits = new JLabel();
		    
		    credits.setText("By Dan Warman");
		    credits.setBounds(10, 740, 200, 25);
		    frame.getContentPane().add(credits);

		    JButton start = new JButton("Start");
		    start.setBounds(300, 100, 200, 23);
		    frame.getContentPane().add(start);
		    start.setBackground(Color.pink);

		    
		    start.addMouseListener(new MouseAdapter() {
		        public void mouseReleased(MouseEvent e){
		            if ( e.getButton() == 1 ){ // 1-left, 2-middle, 3-right button
		                FlappyBird.main(args);
		                frame.dispose();
		            }
		        }
		    });
	}
}
//By Dan 
