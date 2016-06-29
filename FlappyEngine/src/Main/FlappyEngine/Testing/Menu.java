package Main.FlappyEngine.Testing;
//By Dan 

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu {
	
	private static int WIDTH = 800;
	private static int HEIGHT = 800;
	private static String TITLE = "Menu";
	
	
	public static void main(String[] args) throws IOException{
		
			ImageIcon icon = new ImageIcon("src/Main/FlappyEngine/Imgs/icon.png");
			
			final BufferedImage controlstext = ImageIO.read(new File("src/Main/FlappyEngine/Imgs/controlstext.png"));
		
		 	JFrame frame = new JFrame();
		 	frame.setSize(WIDTH, HEIGHT);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.getContentPane().setLayout(null);
		    frame.setVisible(true);
		    frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		    frame.setResizable(false);
		    frame.setTitle(TITLE);
		    frame.setIconImage(icon.getImage());
		    
			JLabel controllabl = new JLabel(new ImageIcon(controlstext));
			controllabl.setBounds(200, 200, 400,400);
			frame.getContentPane().add(controllabl);
			controllabl.setVisible(false);
		    
		    JButton controls = new JButton("Controls");
		    controls.setBounds(300, 150,200,23);
		    frame.getContentPane().add(controls);
		    controls.setBackground(Color.pink);
		    
		    controls.addMouseListener(new MouseAdapter(){
		    	public void mouseEntered(MouseEvent e){
		    		controls.setBackground(Color.pink.darker());
		    	}
		    	public void mouseExited(MouseEvent e){
		    		controls.setBackground(Color.pink);
		    		
		    	}
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
		    	public void mouseEntered(MouseEvent e){
		    		exit.setBackground(Color.pink.darker());
		    	}
		    	public void mouseExited(MouseEvent e){
		    		exit.setBackground(Color.pink);
		    		
		    	}
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
		    	public void mouseEntered(MouseEvent e){
		    		start.setBackground(Color.pink.darker());
		    	}
		    	public void mouseExited(MouseEvent e){
		    		start.setBackground(Color.pink);
		    		
		    	}
		        public void mouseReleased(MouseEvent e){
		            if ( e.getButton() == 1 ){ // 1-left, 2-middle, 3-right button
		            	FlappyEng.main(args);
		                frame.dispose();
		            }
		        }
		    });
		    

	}
}
//By Dan 
