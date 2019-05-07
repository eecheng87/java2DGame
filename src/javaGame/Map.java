package javaGame;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class Map extends JPanel{
	private BufferedImage tile;
	Map() {
		try {
			tile = ImageIO.read(new File("src/img/grass.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(tile, 0, 0,50,50, this);
		g.drawImage(tile, 100, 100,50,50, this);
	}
}
