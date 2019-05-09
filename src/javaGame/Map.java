package javaGame;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.sun.prism.Image;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
public class Map extends JPanel{
	private boolean init = false;
	private BufferedImage dirt;
	private BufferedImage sky;
	private BufferedImage grass;
	private final int UNITS = 50;
	private Graphics g;
	private java.awt.Image img;
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
		
	}
	public void readMap(String path){
		int j=0;
		String line=null; 
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while ((line = br.readLine()) != null) {
				if(line.length()>1)
					for(int i=0; i<line.length();i++) {
						map[i][j] = (int)line.charAt(i)-48;			 
					}
				j++;
			}			 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void autoGeneMap() {
		/*
		 *  this function is for generate map dynamically
		 */
		
		/*
		 *  right offset 1 unit
		 */
		for(int i=17; i>=0; i-- )
			for(int j=23; j>0; j--) {
				map[i][j] = map[i][j-1];
			}
		for(int i=0; i<18;i++)
			map[i][0] = 2;
		
	}
	
	public void paintComponent(Graphics g) {
		/*
		 *  call-back function
		 */
		if(!init) {
			// generate first map

			this.readMap("src/mapInfo/initMap.txt");
			super.paintComponent(g);
			for(int i=0; i<18; i++)
				for(int j=0; j<24; j++) {
					if(map[i][j]==0)
						g.drawImage(sky, j*UNITS, i*UNITS, UNITS, UNITS, this);
					else if(map[i][j]==1)
						g.drawImage(grass, j*UNITS, i*UNITS, UNITS, UNITS, this);
					else if(map[i][j]==2)
						g.drawImage(dirt, j*UNITS, i*UNITS, UNITS , UNITS, this);
				}
			init = true;
		}else {
			//this.readMap("src/mapInfo/testMap.txt");
			// general condition
			autoGeneMap();
			for(int i=0; i<18; i++)
				for(int j=0; j<24; j++) {
					if(map[i][j]==0)
						g.drawImage(sky, j*UNITS, i*UNITS, UNITS, UNITS, this);
					else if(map[i][j]==1)
						g.drawImage(grass, j*UNITS, i*UNITS, UNITS, UNITS, this);
					else if(map[i][j]==2)
						g.drawImage(dirt, j*UNITS, i*UNITS, UNITS , UNITS, this);
				}
		}
	}
	
	public void display() {
		/*
		 *  this function is for update frame
		 *  its call-back function is paintComponent()
		 *  
		 *  it is called at Game.public void run()
		 *  
		 */
		if(g==null) {
			img = this.createImage(Game.WIDTH,Game.HEIGHT);
			if(img!=null)
				g = img.getGraphics();
		}
		if(g!=null) {
			super.paint(g);
		}
		this.repaint();
	}

}
