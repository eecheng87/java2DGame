import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Listener_For_Yes_No_Button implements ActionListener
{
	// This listener is aimed to "Yes" or "No".
	private String type_of_button;

	// Reference to the Dialog_Window.
	private Dialog_Window ref_dialog_window;	

	// Constructor.
	public Listener_For_Yes_No_Button(String type, Dialog_Window dialog_window)
	{
		// Set the type of the aimed button.
		this.type_of_button = type;

		// Set the reference to dialog_window.
		this.ref_dialog_window = dialog_window;
	}

	// Operation when the user clicks "No".
	private void no_operation()
	{
		// Close the dialog window.
		ref_dialog_window.setVisible(false);
		ref_dialog_window.dispose();
	}

	// Operation when the user clicks "Yes".
	private void yes_operation()
	{
		// Close the dialog window.
		ref_dialog_window.setVisible(false);
		ref_dialog_window.dispose();
		
		// Open a new window to register username and password.
		Register_Window register_window = new Register_Window();	
	}

	// Action performed when the button is clicked.
	public void actionPerformed(ActionEvent e)
	{
		if (this.type_of_button.equals("Yes"))
			yes_operation();
		else if (this.type_of_button.equals("No"))
			no_operation();
		else
			return;
	}
}
