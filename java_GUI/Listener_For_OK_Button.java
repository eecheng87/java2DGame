import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Listener_For_OK_Button implements ActionListener
{
	// Reference to the Message_Window.
	private Message_Window message_window;

	// Constructor.
	public Listener_For_OK_Button(Message_Window window)
	{
		this.message_window = window;
	}

	// Action performed when the "ok_button" is clicked.
	public void actionPerformed(ActionEvent e)
	{
		// Simply close the window containing this ok_button.
		message_window.setVisible(false);
		message_window.dispose();
	}
}
