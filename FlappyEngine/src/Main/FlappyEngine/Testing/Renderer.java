package Main.FlappyEngine.Testing;
//By Dan Warman

import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JPanel;

public class Renderer extends JPanel
{

	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		try {
			FlappyEng.flappyBird.repaint(g);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
//By Dan Warman