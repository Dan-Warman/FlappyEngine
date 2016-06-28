package Main.FlappyEngine.Testing;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

public class FlappyBird implements ActionListener, MouseListener, KeyListener
{

	public static FlappyBird flappyBird;

	public final int WIDTH = 800, HEIGHT = 800;
	public final String TITLE = "FlappyEngineTest";

	public Renderer renderer;

	public Rectangle bird;

	public ArrayList<Rectangle> pipes;

	public int ticks, yMotion, score;

	public boolean gameOver, started;

	public Random rand;

	public FlappyBird(){

		ImageIcon icon = new ImageIcon("src/Main/FlappyEngine/Imgs/icon.png");
		
		JFrame jframe = new JFrame();
		Timer timer = new Timer(20, this);

		renderer = new Renderer();
		rand = new Random();

		jframe.add(renderer);
		jframe.setTitle(TITLE);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(WIDTH, HEIGHT);
		jframe.setIconImage(icon.getImage());
		jframe.addMouseListener(this);
		jframe.addKeyListener(this);
		jframe.setResizable(false);
		jframe.setVisible(true);

		bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
		pipes = new ArrayList<Rectangle>();

		addpipe(true);
		addpipe(true);
		addpipe(true);
		addpipe(true);

		timer.start();
	}

	public void addpipe(boolean start)
	{
		int space = 300;
		int width = 100;
		int height = 50 + rand.nextInt(300);

		if (start)
		{
			pipes.add(new Rectangle(WIDTH + width + pipes.size() * 300, HEIGHT - height - 120, width, height));
			pipes.add(new Rectangle(WIDTH + width + (pipes.size() - 1) * 300, 0, width, HEIGHT - height - space));
		}
		else
		{
			pipes.add(new Rectangle(pipes.get(pipes.size() - 1).x + 600, HEIGHT - height - 120, width, height));
			pipes.add(new Rectangle(pipes.get(pipes.size() - 1).x, 0, width, HEIGHT - height - space));
		}
	}

	public void paintpipe(Graphics g, Rectangle pipe) throws IOException
	{
		final BufferedImage pipeImage = ImageIO.read(new File("src/Main/FlappyEngine/Imgs/pipeSprite.png"));
		//g.setColor(Color.green.darker());
		g.drawImage(pipeImage,pipe.x, pipe.y, pipe.width, pipe.height, null);
	}

	public void jump()
	{
		if (gameOver)
		{
			bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
			pipes.clear();
			yMotion = 0;
			score = 0;

			addpipe(true);
			addpipe(true);
			addpipe(true);
			addpipe(true);

			gameOver = false;
		}

		if (!started)
		{
			started = true;
		}
		else if (!gameOver)
		{
			if (yMotion > 0)
			{
				yMotion = 0;
			}

			yMotion -= 10;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		int speed = 10;

		ticks++;

		if (started)
		{
			for (int i = 0; i < pipes.size(); i++)
			{
				Rectangle pipe = pipes.get(i);

				pipe.x -= speed;
			}

			if (ticks % 2 == 0 && yMotion < 15)
			{
				yMotion += 2;
			}

			for (int i = 0; i < pipes.size(); i++)
			{
				Rectangle pipe = pipes.get(i);

				if (pipe.x + pipe.width < 0)
				{
					pipes.remove(pipe);

					if (pipe.y == 0)
					{
						addpipe(false);
					}
				}
			}

			bird.y += yMotion;

			for (Rectangle pipe : pipes)
			{
				if (pipe.y == 0 && bird.x + bird.width / 2 > pipe.x + pipe.width / 2 - 10 && bird.x + bird.width / 2 < pipe.x + pipe.width / 2 + 10)
				{
					score++;
				}

				if (pipe.intersects(bird))
				{
					gameOver = true;

					if (bird.x <= pipe.x)
					{
						bird.x = pipe.x - bird.width;

					}
					else
					{
						if (pipe.y != 0)
						{
							bird.y = pipe.y - bird.height;
						}
						else if (bird.y < pipe.height)
						{
							bird.y = pipe.height;
						}
					}
				}
			}

			if (bird.y > HEIGHT - 120 || bird.y < 0)
			{
				gameOver = true;
			}

			if (bird.y + yMotion >= HEIGHT - 120)
			{
				bird.y = HEIGHT - 120 - bird.height;
				gameOver = true;
			}
		}

		renderer.repaint();
	}

	public void repaint(Graphics g) throws IOException{
		
		
		final BufferedImage birdImage = ImageIO.read(new File("src/Main/FlappyEngine/Imgs/characterSprite.png"));
		final BufferedImage grassImage = ImageIO.read(new File("src/Main/FlappyEngine/Imgs/grassSprite.png"));
		final BufferedImage dirtImage = ImageIO.read(new File("src/Main/FlappyEngine/Imgs/dirtSprite.png"));
		final BufferedImage backgroundImage = ImageIO.read(new File("src/Main/FlappyEngine/Imgs/backgroundSprite.png"));
		
		//background
		g.drawImage(backgroundImage,0, 0, WIDTH, HEIGHT,null);


		//dirt(undergrass)
		g.drawImage(dirtImage,0, HEIGHT - 120, WIDTH, 120, null);

		//grass
		g.drawImage(grassImage,0, HEIGHT - 120, WIDTH, 20, null);

		//character
		g.drawImage(birdImage, bird.x, bird.y, bird.width, bird.height, null);

		for (Rectangle pipe : pipes)
		{
			paintpipe(g, pipe);
		}

		g.setColor(Color.white);
		g.setFont(new Font("Arial", 2, 100));

		if (!started)
		{
			g.drawString("Click to start!", 75, HEIGHT / 2 - 50);

		}

		if (gameOver)
		{
			g.drawString("Game Over!", 100, HEIGHT / 2 - 50);
			g.drawString("By Dan Warman!", 20, HEIGHT / 2 + 150);
		}

		if (!gameOver && started)
		{
			g.drawString(String.valueOf(score), WIDTH / 2 - 25, 100);
		}
	}

	public static void main(String[] args)
	{
		flappyBird = new FlappyBird();
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		jump();
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			jump();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP){
			jump();
		}
	}
	
	
	@Override
	public void mousePressed(MouseEvent e)
	{
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
	}

	@Override
	public void keyTyped(KeyEvent e)
	{

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
	}

}