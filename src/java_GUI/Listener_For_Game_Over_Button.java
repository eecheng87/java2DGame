package java_GUI;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Listener_For_Game_Over_Button implements ActionListener
{
	// Reference to the Game_Over_Window.
	private Game_Over_Window ref_window;

	// Constructor.
	public Listener_For_Game_Over_Button(Game_Over_Window window)	
	{
		ref_window = window;
	}

	// Action performed when the button is clicked.
	public void actionPerformed(ActionEvent e)
	{
		// Close the Game_Over_Window.
		ref_window.setVisible(false);
		ref_window.dispose();
	}
}
