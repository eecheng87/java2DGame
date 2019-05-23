package javaGame;

public class MapBuffer {
	
/*
 *  class `MapBuffer` is for storing the map which should appear next cycle
 */
	private final int bufSize = 30;
	private int[][] buf = new int[18][bufSize];
	private int start; // means which column can start to be write
	MapBuffer() {
		start = bufSize-1;
		for(int i=0; i<18; i++)
			for(int j=0; j<bufSize; j++) {
				// initialize
				buf[i][j] = -1;
			}
	}
	public void wirteBuf(Component com) {
		for(int j=start,k=0; j>=start-com.getWidth();j--,k++)
			for(int i=0; i<18; i++)
				{
				buf[i][j] = com.cmap[i][k];
				}
		start -= com.getWidth();
	}
	public void updateRMmap(int[][] m) {
		for(int i=0; i<18; i++)
			m[i][0] = buf[i][bufSize-1];
		
		// right shift buf
		for(int i=17; i>=0; i-- )
			for(int j=bufSize-1; j>0; j--) {
				buf[i][j] = buf[i][j-1];
			}
		for(int i=0; i<18;i++)
			buf[i][0] = -1; // empty
		if(start!=bufSize-1)
			start++;
	}
	public boolean isFull(int needSize) {
		/*
		 *  `int needSize` means how many size you need
		 *  eg: needSize = 1, we should check column 0 whether is empty
		 */
		for(int i=0; i<18; i++)
			for(int j=0; j<needSize; j++) {
				if(buf[i][j]>=0)
					return true;
			}
		return false;
	}
	public void clear() {
		for(int i=0;i<18;i++)
			for(int j=0;j<bufSize;j++)
				buf[i][j]=-1;
	}
}
