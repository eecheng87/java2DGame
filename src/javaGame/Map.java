package javaGame;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import com.sun.prism.Image;

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
	private BufferedImage coin_1;
	private BufferedImage coin_2;
	private BufferedImage needle;
	private BufferedImage mario_1;
	private BufferedImage mario_2;
	private BufferedImage mario_3;
	private BufferedImage needle_2;
	private final int UNITS = 50;
	private Graphics g;
	private int animationState=0;
	private java.awt.Image img;
	private Mario mario;
	
	///////////////////////////////
	/*
	 *  sky = 0
	 *  grass = 1
	 *  dirt = 2
	 *  coin_1 = 3
	 *  coin_2 = 4
	 *  needle = 5
	 *  mario_1 = 6
	 *  mario_2 = 7
	 *  mario_3 = 8
	 *  needle_2 = 9
	 *  
	 /////////////////////////////*/
	private int[][] map = new int[18][24];
	private MapBuffer mpbuf = new MapBuffer();
	
	/*
	 * important:
	 * if you change number of `Component.totalType
	 * you should also change `Map.totalType 
	 * 
	 */
	private final int totalType = 9;
	private int[] compoNum = new int[totalType];
	Map() {
		try {
			// set up each pixel image
			grass = ImageIO.read(new File("src/img/grass.png"));
			dirt = ImageIO.read(new File("src/img/dirt.png"));
			sky = ImageIO.read(new File("src/img/sky.png"));
			coin_1 = ImageIO.read(new File("src/img/coin_1.png"));
			coin_2 = ImageIO.read(new File("src/img/coin_2.png"));
			needle = ImageIO.read(new File("src/img/needle.png"));
			mario_1 = ImageIO.read(new File("src/img/mario_1.png"));
			mario_2 = ImageIO.read(new File("src/img/mario_2.png"));
			mario_3 = ImageIO.read(new File("src/img/mario_3.png"));
			needle_2 = ImageIO.read(new File("src/img/needle_2.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	Map(Mario m){
		mario = m;
		try {
			// set up each pixel image
			grass    = ImageIO.read(new File("src/img/grass.png"));
			dirt     = ImageIO.read(new File("src/img/dirt.png"));
			sky      = ImageIO.read(new File("src/img/sky.png"));
			coin_1   = ImageIO.read(new File("src/img/coin_1.png"));
			coin_2   = ImageIO.read(new File("src/img/coin_2.png"));
			needle   = ImageIO.read(new File("src/img/needle.png"));
			mario_1  = ImageIO.read(new File("src/img/mario_1.png"));
			mario_2  = ImageIO.read(new File("src/img/mario_2.png"));
			mario_3  = ImageIO.read(new File("src/img/mario_3.png"));
			needle_2 = ImageIO.read(new File("src/img/needle_2.png"));
				
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
		
		//  right shift 1 unit
		 
		for(int i=17; i>=0; i-- )
			for(int j=23; j>0; j--) {
				// implement animation effect
				// money animation
				if(map[i][j-1] == 3)
					map[i][j] = 4;
				else if(map[i][j-1] == 4)
					map[i][j] = 3;
				else if(map[i][j-1] == 6 || map[i][j-1] == 7|| map[i][j-1] == 8)
					// if last moment is mario, next cycle => clear
					map[i][j] = 0;
				else
					map[i][j] = map[i][j-1];
			}
		 
 
		
		mpbuf.updateRMmap(map);
	 
		Component compo = new Component();
		compoNum[compo.getType()]++;
		
		if(mpbuf.nearlyFull(4))
			mpbuf.turnOnClearMore();
		
		if(!mpbuf.isFull(compo.getWidth())) {
			// write new component into buffer
			mpbuf.wirteBuf(compo);
		}
		
	}
	
	public boolean balance(int [][]arr) {
		return true;
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
					// config corresponding image with map info.
					if(map[i][j]==0)
						g.drawImage(sky, j*UNITS, i*UNITS, UNITS, UNITS, this);
					else if(map[i][j] == 1)
						g.drawImage(grass, j*UNITS, i*UNITS, UNITS, UNITS, this);
					else if(map[i][j] == 2)
						g.drawImage(dirt, j*UNITS, i*UNITS, UNITS , UNITS, this);
					else if(map[i][j] == 3)
						g.drawImage(coin_1, j*UNITS, i*UNITS, UNITS , UNITS, this);
					else if(map[i][j] == 4)
						g.drawImage(coin_2, j*UNITS, i*UNITS, UNITS , UNITS, this);
					else if(map[i][j] == 5)
						g.drawImage(needle, j*UNITS, i*UNITS, UNITS , UNITS, this);
					else if(map[i][j] == 6)
						g.drawImage(mario_1, j*UNITS, i*UNITS, UNITS , UNITS, this);
					else if(map[i][j] == 7)
						g.drawImage(mario_2, j*UNITS, i*UNITS, UNITS , UNITS, this);
					else if(map[i][j] == 8)
						g.drawImage(mario_3, j*UNITS, i*UNITS, UNITS , UNITS, this);
					else if(map[i][j] == 9)
						g.drawImage(needle_2, j*UNITS, i*UNITS, UNITS , UNITS, this);
				}
			init = true;
		}else {
			
			// general condition
			autoGeneMap();
			// set PLAYER's image
			mario.setState(marioSprite(mario.getState()));
			map[mario.getX()][mario.getY()] = mario.getState();
			// clear last column to needle
			for(int i=0;i<18;i++)
				map[i][23] = 9;
			
			for(int i=0; i<18; i++)
				for(int j=0; j<24; j++) {
					if(map[i][j]==0)
						g.drawImage(sky, j*UNITS, i*UNITS, UNITS, UNITS, this);
					else if(map[i][j]==1)
						g.drawImage(grass, j*UNITS, i*UNITS, UNITS, UNITS, this);
					else if(map[i][j]==2)
						g.drawImage(dirt, j*UNITS, i*UNITS, UNITS , UNITS, this);
					else if(map[i][j]==3)
						g.drawImage(coin_1, j*UNITS, i*UNITS, UNITS , UNITS, this);
					else if(map[i][j]==4)
						g.drawImage(coin_2, j*UNITS, i*UNITS, UNITS , UNITS, this);
					else if(map[i][j]==5)
						g.drawImage(needle, j*UNITS, i*UNITS, UNITS , UNITS, this);
					else if(map[i][j]==6)
						g.drawImage(mario_1, j*UNITS, i*UNITS, UNITS , UNITS, this);
					else if(map[i][j]==7)
						g.drawImage(mario_2, j*UNITS, i*UNITS, UNITS , UNITS, this);
					else if(map[i][j]==8)
						g.drawImage(mario_3, j*UNITS, i*UNITS, UNITS , UNITS, this);
					else if(map[i][j]==9)
						g.drawImage(needle_2, j*UNITS, i*UNITS, UNITS , UNITS, this);
				}
		}
	}
	public int marioSprite(int state) {
		if(state==6) 
			return 7;
		else if(state==7)
			return 8;
		else
			return 6;
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
			//super.paint(g); <----- this is bug!!
			this.repaint();
		}
		
	}
	
	public int[][] getMap(){
		return map;
	}

}
