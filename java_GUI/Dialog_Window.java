import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class Dialog_Window extends JFrame
{
	// Font size of the text in JButton.
	public static final int FONT_SIZE_BUTTON = 30;
	// Font size of the text in JTextArea.
	public static final int FONT_SIZE_REMINDER = 20;
	
	// Size of Dialog_Window.
	public static final int WIDTH_WINDOW = 600;
	public static final int HEIGHT_WINDOW = 360;

	// Position of Dialog_Window.
	public static final int POSITION_WINDOW_X = 650;
	public static final int POSITION_WINDOW_Y = 350;

	// JLabel to show the reminder_1 and reminder_2.
	private JLabel reminder_1;
	private JLabel reminder_2;

	// Size of JLabel for reminder_1.
	public static final int WIDTH_REMINDER_1 = 600;
	public static final int HEIGHT_REMINDER_1 = 60;
	
	// Position of JLabel for reminder_1.
	public static final int POSITION_REMINDER_X_1 = 0;
	public static final int POSITION_REMINDER_Y_1 = 100;
	
	// Size of JLabel for reminder_2.
	public static final int WIDTH_REMINDER_2 = 600;
	public static final int HEIGHT_REMINDER_2 = 60;
	
	// Position of JLabel for reminder_2.
	public static final int POSITION_REMINDER_X_2 = 0;
	public static final int POSITION_REMINDER_Y_2 = 140;

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
		super("Dialog");
		this.setSize(WIDTH_WINDOW, HEIGHT_WINDOW);
		this.setLocation(POSITION_WINDOW_X, POSITION_WINDOW_Y);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.GRAY);

		// Add two JLabel to Login_Window.
		reminder_1 = new JLabel();
		reminder_1.setText("Please check username \"" + username + "\" and password again.");
		reminder_1.setSize(WIDTH_REMINDER_1, HEIGHT_REMINDER_1);
		reminder_1.setLocation(POSITION_REMINDER_X_1, POSITION_REMINDER_Y_1);
		reminder_1.setFont(new Font("Courier new", Font.ITALIC + Font.BOLD, FONT_SIZE_REMINDER));
		reminder_1.setForeground(Color.WHITE);
		reminder_1.setHorizontalAlignment(JLabel.CENTER);
		this.add(reminder_1);
		
		reminder_2 = new JLabel();
		reminder_2.setText("Do you want to create a new account?");
		reminder_2.setSize(WIDTH_REMINDER_2, HEIGHT_REMINDER_2);
		reminder_2.setLocation(POSITION_REMINDER_X_2, POSITION_REMINDER_Y_2);
		reminder_2.setFont(new Font("Courier new", Font.ITALIC + Font.BOLD, FONT_SIZE_REMINDER));
		reminder_2.setForeground(Color.WHITE);
		reminder_2.setHorizontalAlignment(JLabel.CENTER);
		this.add(reminder_2);

		// Add a yes_button to Login_Window.
		yes_button = new JButton("YES");
		yes_button.setToolTipText("CLICK to create a new account");
		yes_button.setSize(WIDTH_YES_BUTTON, HEIGHT_YES_BUTTON);
		yes_button.setLocation(POSITION_YES_BUTTON_X, POSITION_YES_BUTTON_Y);
		yes_button.setFont(new Font("Courier new", Font.ITALIC + Font.BOLD, FONT_SIZE_BUTTON));
		yes_button.setBackground(Color.GREEN);
		yes_button.setForeground(Color.WHITE);
		yes_button.addActionListener(new Listener_For_Yes_No_Button("Yes", this));
		this.add(yes_button);
		
		// Add a no_button to Login_Window.
		no_button = new JButton("NO");
		no_button.setToolTipText("CLICK to end the Dialog Window");
		no_button.setSize(WIDTH_NO_BUTTON, HEIGHT_NO_BUTTON);
		no_button.setLocation(POSITION_NO_BUTTON_X, POSITION_NO_BUTTON_Y);
		no_button.setFont(new Font("Courier new", Font.ITALIC + Font.BOLD, FONT_SIZE_BUTTON));
		no_button.setBackground(Color.RED);
		no_button.setForeground(Color.WHITE);
		no_button.addActionListener(new Listener_For_Yes_No_Button("No", this));
		this.add(no_button);
		
		
		// Make the window visible by default.
		this.setVisible(true);
	}
}
