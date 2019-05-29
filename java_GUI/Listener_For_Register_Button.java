import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Listener_For_Register_Button implements ActionListener
{
	// Path of the record file.
	private String path_of_record = "./ACCOUNT.txt";

	// StringTokenizer for checking whether username is legal.
	StringTokenizer st;

	// Scanner for input from record file.
	private Scanner record_reader;

	// PrintWriter to keep the record.
	private PrintWriter record_writer;

	// Reference to "enter_field_username" and "enter_field_password" in Register_Window.
	private JTextField ref_username;
	private JTextField ref_password;

	// Reference to the Register_Window.
	private Register_Window ref_window;

	// Constructor.
	public Listener_For_Register_Button(JTextField enter_field_username, JTextField enter_field_password, Register_Window window)
	{
		// Reference to "enter_field_username" and "enter_field_password" in the Register_Window.
		this.ref_username = enter_field_username;
		this.ref_password = enter_field_password;
		
		// Reference to the Register_Window.
		this.ref_window = window;
	}

	// Action performed when the "confirm_button" is clicked.
	public void actionPerformed(ActionEvent e)
	{
		// Check whether the user name is legal.
		if (!is_new_account_legal())
			return;

		// Append a new record in the record file.
		try
		{
			// Keep the new account.
			record_writer = new PrintWriter(new FileOutputStream(path_of_record, true));
			record_writer.println(ref_username.getText() + " " + ref_password.getText());
			record_writer.flush();
			record_writer.close();

			// Show successful message.
			Message_Window message_window = new Message_Window("Register is successful.");

			// Close the Register_Window.
			ref_window.setVisible(false);
			ref_window.dispose();
		}
		catch (FileNotFoundException exception)
		{
			exception.printStackTrace();
		}
	}

	// Check specified username.
	private boolean is_new_account_legal()
	{
		// Record read in an iteration.
		String a_record;
		String username_in_a_record;
		String password_in_a_record;

		// If the text in ref_username field is blank, it's lllegal.
		if (ref_username.getText().equals(""))
		{
			Message_Window message_window = new Message_Window("You have not entered your username.");
			return false;
		}

		// If the text in ref_password field is blank, it's lllegal.
		if (ref_password.getText().equals(""))
		{
			Message_Window message_window = new Message_Window("You have not entered your password.");
			return false;
		}

		// If the username contain blank, it's illegal.
		st = new StringTokenizer(ref_username.getText());
		if (st.countTokens() != 1)
		{
			Message_Window message_window = new Message_Window("Your username can't contain any blank.");
			return false;
		}

		// If the username is identical with existing usernames, it's illegal.
		// Create a Scanner.
		try
		{
			record_reader = new Scanner(new FileInputStream(path_of_record));
		}
		catch(FileNotFoundException exception)
		{
			exception.printStackTrace();
		}

		// Check whether there is an identical existing username.
		while(record_reader.hasNextLine())
		{
			// Read in a record.
			a_record = record_reader.nextLine();

			// Tokenize this record.
			st = new StringTokenizer(a_record);

			// Check username and password.
			username_in_a_record = st.nextToken();
			password_in_a_record = st.nextToken();
			if (ref_username.getText().equals(username_in_a_record))
			{
				Message_Window message_window = new Message_Window("The username has already existed.");
				return false;
			}
			else if (ref_password.getText().equals(password_in_a_record))
			{
				Message_Window message_window = new Message_Window("The password has already existed.");
				return false;
			}
		}

		// Close the scanner.
		record_reader.close();

		// The username is legal.
		return true;
	}
}
