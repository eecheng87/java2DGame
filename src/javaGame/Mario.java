package javaGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
public class Mario implements KeyListener{
	private int cor_x;
	private int cor_y;
	private int money;
	private int state; // control which sprite will be set
	private boolean alive;
	private Map m;
	private boolean jamp ; 
	
	Mario(){
		alive = true;
		cor_x = 12;
		cor_y = 10;
		money = 0;
	}
	public void setMap(JPanel map) {
		m = (Map) map;
	}
	public int getX() {
		gravity() ;
		return cor_x;
	}
	public int getY() 
	{
		if(cor_y >= 22)
		 alive = false ; 
		else if(!block(cor_x , cor_y - 1))
		 cor_y = cor_y + 1 ;
		else if(!block(cor_x , cor_y + 1))
		 cor_y = cor_y - 1 ;
		return cor_y;
	}
	public int getMoney() 
	{
		return money;
	}
	public int getState() 
	{
		return state;
	}
	public void setState(int i) 
	{
		this.state = i;
	}
	public boolean getAlive() 
	{
		return alive;
	}
	//judge the block whether can pass
	private boolean block(int x , int y)
	{
	 if(m.getMap()[x][y] == 5)
		alive = false ; 
	 if((m.getMap()[x][y] == 1) || (m.getMap()[x][y] == 2))
	   return  false ; 
	 return true ; 
	}
	//try to simulate the gravity
    private void gravity()
    {
       switch(m.getMap()[cor_x + 1][cor_y])
       {
        	case 0:
        		 cor_x = cor_x + 1 ; 
        		break ;
        	case 3:
        	case 4:
        		 cor_x = cor_x + 1 ;
                 money  = money + 1 ;
                break ; 
        	//set the endgame condition2
        	case 5 :
        		alive = false ; 
        		if(m.getMap()[cor_x + 1][cor_y - 1] == 5)
        		 alive = false ; 
        		break ; 
        	case 1:
        	case 2:
        		jamp = false;
        	default: ; 
       
     }
     //set the endgame condition3
	 if(cor_x >= 17)
	   alive = false ;
    }
    //describe the action of jump
    private void jamp_up(boolean jamp)
    {
     int count = 0 ; 
     if(!jamp)
     {	  
       while(count < 4)   	 
       {
        if((m.getMap()[cor_x - count][cor_y] == 1) || (m.getMap()[cor_x - count][cor_y] == 2))
         break ; 
        else 
         ++ count ; 
       }
      cor_x = cor_x - count ; 
      jamp = true ; 
     }
    }
	@Override
	public void keyPressed(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		// m.getMap()[i][j] means get map[i][j] in current Map
		switch(key) 
		{
			case KeyEvent.VK_UP:
				if(cor_x > 4)
				{
				 jamp_up(jamp) ; 
				}
				break;
			case KeyEvent.VK_DOWN:
				if(block(cor_x + 1 , cor_y) && (cor_x != 16)) 
				 cor_x = cor_x + 1 ; 
				break;
			case KeyEvent.VK_RIGHT:
				cor_y = cor_y + 1 ; 
				break;
			case KeyEvent.VK_LEFT:
				 if(block(cor_x , cor_y - 1))
				  cor_y = cor_y - 1 ;
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}
}
