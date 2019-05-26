import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class Dialog_Window extends JFrame
{
	// Font size of the text in JButton.
	public static final int FONT_SIZE_BUTTON = 30;
	// Font size of the text in JTextArea.
	public static final int FONT_SIZE_REMINDER = 20;
	
	// Title of Dialog_Window.
	public static final String TITLE = "Dialog Window";

	// Size of Dialog_Window.
	public static final int WIDTH_WINDOW = 600;
	public static final int HEIGHT_WINDOW = 360;

	// Position of Dialog_Window.
	public static final int POSITION_WINDOW_X = 650;
	public static final int POSITION_WINDOW_Y = 350;

	// JTextArea to show the reminder.
	private JTextArea reminder;

	// Size of JTextArea for reminder.
	public static final int WIDTH_REMINDER = 500;
	public static final int HEIGHT_REMINDER = 150;
	
	// Position of JTextArea for reminder.
	public static final int POSITION_REMINDER_X = 80;
	public static final int POSITION_REMINDER_Y = 100;

	// Button for user to choose.
	private JButton yes_button;
	private JButton no_button;

	// Size of yes_button.
	public static final int WIDTH_YES_BUTTON = 300;
	public static final int HEIGHT_YES_BUTTON = 40;
	
	// Position of yes_button.
	public static final int POSITION_YES_BUTTON_X = 0;
	public static final int POSITION_YES_BUTTON_Y = 290;
	
	// Size of no_button.
	public static final int WIDTH_NO_BUTTON = 300;
	public static final int HEIGHT_NO_BUTTON = 40;
	
	// Position of no_button.
	public static final int POSITION_NO_BUTTON_X = 300;
	public static final int POSITION_NO_BUTTON_Y = 290;

	public Dialog_Window(String username)
	{
		// Set basic property.
		super(TITLE);
		this.setSize(WIDTH_WINDOW, HEIGHT_WINDOW);
		this.setLocation(POSITION_WINDOW_X, POSITION_WINDOW_Y);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.GRAY);

		// Add a JTextArea to Login_Window for username.
		reminder = new JTextArea("There is no \"" + username + "\" in the record." + "\n Do you want to create a new account?");
		reminder.setSize(WIDTH_REMINDER, HEIGHT_REMINDER);
		reminder.setLocation(POSITION_REMINDER_X, POSITION_REMINDER_Y);
		reminder.setFont(new Font("Courier new", Font.ITALIC + Font.BOLD, FONT_SIZE_REMINDER));
		reminder.setBackground(Color.GRAY);
		reminder.setForeground(Color.WHITE);
		reminder.setEditable(false);
		this.add(reminder);

		// Add a yes_button to Login_Window.
		yes_button = new JButton("YES");
		yes_button.setToolTipText("CLICK to create a new account");
		yes_button.setSize(WIDTH_YES_BUTTON, HEIGHT_YES_BUTTON);
		yes_button.setLocation(POSITION_YES_BUTTON_X, POSITION_YES_BUTTON_Y);
		yes_button.setFont(new Font("Courier new", Font.ITALIC + Font.BOLD, FONT_SIZE_BUTTON));
		yes_button.setBackground(Color.GREEN);
		yes_button.setForeground(Color.WHITE);
		//yes_button.addActionListener(new Listener_For_Button(enter_field_username, enter_field_password));
		this.add(yes_button);
		
		// Add a no_button to Login_Window.
		no_button = new JButton("NO");
		no_button.setToolTipText("CLICK to end the Dialog Window");
		no_button.setSize(WIDTH_NO_BUTTON, HEIGHT_NO_BUTTON);
		no_button.setLocation(POSITION_NO_BUTTON_X, POSITION_NO_BUTTON_Y);
		no_button.setFont(new Font("Courier new", Font.ITALIC + Font.BOLD, FONT_SIZE_BUTTON));
		no_button.setBackground(Color.RED);
		no_button.setForeground(Color.WHITE);
		//no_button.addActionListener(new Listener_For_Button(enter_field_username, enter_field_password));
		this.add(no_button);
		
		// Make the window visible by default.
		this.setVisible(true);
	}
}
