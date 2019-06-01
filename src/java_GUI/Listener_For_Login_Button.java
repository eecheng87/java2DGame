package java_GUI;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Listener_For_Login_Button implements ActionListener
{
	
	// Path of the record file.
	private String path_of_record = "src/java_GUI/ACCOUNT.txt";

	// Scanner for input from record file.
	private Scanner record_reader;

	// StringTokenizer for identify username and pasword in a record.
	StringTokenizer st;

	// Reference to "enter_field_username" and "enter_field_password" in Login_Window.
	private JTextField ref_username;
	private JTextField ref_password;

	// Reference to the Login_Window.
	private Login_Window ref_window;

	// Constructor.
	public Listener_For_Login_Button(JTextField enter_field_username, JTextField enter_field_password, Login_Window window)
	{
		// Reference to "enter_field_username" and "enter_field_password" in the Login_Window.
		ref_username = enter_field_username;
		ref_password = enter_field_password;

		// Reference to the Login_Window.
		ref_window = window;
		
	}

	// Action performed when the "confirm_button" is clicked.
	public void actionPerformed(ActionEvent e)
	{
		// Check whether there are username and password in the JTextField.
		if (ref_username.getText().equals("") || ref_password.getText().equals(""))
			return;

		// Record read in an iteration.
		String a_record;
		String username_in_a_record;
		String password_in_a_record;

		// Create a Scanner.
		try
		{
			record_reader = new Scanner(new FileInputStream(path_of_record));
		
			// Check whether there is such specified user in the record.
			while(record_reader.hasNextLine())
			{
				// Read in a record.
				a_record = record_reader.nextLine();

				// Tokenize this record.
				st = new StringTokenizer(a_record);

				// Check username and password.
				username_in_a_record = st.nextToken();
				password_in_a_record = st.nextToken();
				if (ref_username.getText().equals(username_in_a_record) && ref_password.getText().equals(password_in_a_record))
				{
					// Show the message.
					//Message_Window message_window = new Message_Window("Login successfully.");
					
					ref_window.is_close = true;
					
					// Close the Login_Window.
					ref_window.setVisible(false);
					ref_window.dispose();	
	
					return;
				}
			}
		}
		catch(FileNotFoundException exception)
		{
			exception.printStackTrace();
		}

		// Close the scanner.
		record_reader.close();

		// Create Dialog_Window to know whether to create a new user.
		show_dialog_window(ref_username.getText());
		
		// Clean the JTextField.
		ref_username.setText("");
		ref_password.setText("");
	}

	// Show Dialog_Window if the specified user isn't found.
	private void show_dialog_window(String username)
	{
		Dialog_Window dialog_window = new Dialog_Window(username);
	}
}
