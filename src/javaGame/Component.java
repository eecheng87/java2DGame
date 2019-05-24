package javaGame;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
public class Component {
	/*
	 *  only thing you need to change is 
	 *  `private int totalType 
	 *  `private String[] compoName
	 *  if you want to add more component
	 */
	private int width;
	private final int height=18;
	public int[][]cmap;
	private int type; // type of component
	private final int totalType = 7;
	private final String[] compoName = {"empty","column","coin_map_1","rand_map_1","rand_map_2","rand_map_3","rand_map_4"};
	Component(){
		width = 0;
		cmap = new int[18][10];
		Random rand = new Random();
		type = rand.nextInt(totalType); // 0~totalType-1
		read(type);
	
	}
	
	Component(int num){
		
	}
	public void read(int type) {
		width = 0;
		cmap = new int[18][10];
		
		int j=0;
		String line=null; 
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/mapInfo/"+compoName[type]+".txt"));
			while ((line = br.readLine()) != null) {
				if(line.length()>1) {
					for(int i=0; i<line.length();i++) {
						cmap[i][j] = (int)line.charAt(i)-48;			 
					}
					width++;
				}
				j++;
			}
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int getWidth() {
		return width;
	}
	
	public int getType() {
		return type;
	}
}
