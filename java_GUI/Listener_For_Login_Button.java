import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Listener_For_Login_Button implements ActionListener
{
	// Path of the record file.
	private String path_of_record = "./RECORD.txt";

	// Scanner for input from record file.
	private Scanner record_reader;

	// StringTokenizer for identify username and pasword in a record.
	StringTokenizer st;

	// PrintWriter to keep the record.
	private PrintWriter record_writer;

	// Reference to "enter_field_username" and "enter_field_password" in Login_Window.
	private JTextField ref_username;
	private JTextField ref_password;

	// Constructor.
	public Listener_For_Login_Button(JTextField enter_field_username, JTextField enter_field_password)
	{
		// Reference to "enter_field_username" and "enter_field_password" in the Login_Window.
		ref_username = enter_field_username;
		ref_password = enter_field_password;

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
		}
		catch(FileNotFoundException exception)
		{
			exception.printStackTrace();
		}

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
				System.out.println("The user is found.");	
				return;
			}
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
