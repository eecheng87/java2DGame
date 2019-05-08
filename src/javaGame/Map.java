package javaGame;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
public class Map extends JPanel{
	private BufferedImage dirt;
	private BufferedImage sky;
	private BufferedImage grass;
	/*
	 *  sky = 0
	 *  grass = 1
	 *  dirt = 2
	 */
	private int[][] map = new int[18][24];
	Map() {
		try {
			grass = ImageIO.read(new File("src/img/grass.png"));
			dirt = ImageIO.read(new File("src/img/dirt.png"));
			sky = ImageIO.read(new File("src/img/sky.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.init();
	}
	public void init(){
		char ch = 0;
		String line=null;
		 
		 
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/mapInfo/initMap.txt"));
			while ((line = br.readLine()) != null) 
				  System.out.println(line);
		}catch(Exception e) {
			e.printStackTrace();
		}
		 
		 
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(sky, 0, 0,50,50, this);
		g.drawImage(dirt, 100, 100,50,50, this);
	}
}
