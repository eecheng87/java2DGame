package javaGame;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
public class Component {
	private int width;
	private final int height=18;
	public int[][]cmap;
	private int type; // type of component
	private final int totalType = 2;
	private final String[] compoName = {"empty","column"};
	Component(){
		width = 0;
		cmap = new int[18][4];
		Random rand = new Random();
		type = rand.nextInt(totalType); // 0~totalType-1
		
		
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
			//System.out.println(type);
			//System.out.println(width);
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public int getWidth() {
		return width;
	}
}
