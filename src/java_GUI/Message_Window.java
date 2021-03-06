package java_GUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Message_Window extends JFrame
{
	// Font size of the text in JButton.
	public static final int FONT_SIZE_BUTTON = 30;
	// Font size of the text in JTextArea.
	public static final int FONT_SIZE_REMINDER = 25;
	
	// Size of Message_Window.
	public static final int WIDTH_WINDOW = 600;
	public static final int HEIGHT_WINDOW = 360;

	// Position of Message_Window.
	public static final int POSITION_WINDOW_X = 650;
	public static final int POSITION_WINDOW_Y = 350;

	// JLabel to show the reminder.
	private JLabel reminder;

	// Size of JLabel for reminder.
	public static final int WIDTH_REMINDER = 600;
	public static final int HEIGHT_REMINDER = 60;
	
	// Position of JLabel for reminder.
	public static final int POSITION_REMINDER_X = 0;
	public static final int POSITION_REMINDER_Y = 120;

	// Button for user to choose.
	private JButton ok_button;

	// Size of ok_button.
	public static final int WIDTH_OK_BUTTON = 150;
	public static final int HEIGHT_OK_BUTTON = 40;
	
	// Position of ok_button.
	public static final int POSITION_OK_BUTTON_X = 225;
	public static final int POSITION_OK_BUTTON_Y = 210;

	// The warning image.
	private BufferedImage warning_image;
	
	// Size of JLabel for warning_label.
	public static final int WIDTH_WARNING = 70;
	public static final int HEIGHT_WARNING = 70;
	
	// Position of JLabel for warning label.
	public static final int POSITION_WARNING_X = 260;
	public static final int POSITION_WARNING_Y = 30;
	
	public Message_Window(String message)
	{
		// Set basic property.
		super("Message");
		this.setSize(WIDTH_WINDOW, HEIGHT_WINDOW);
		this.setLocation(POSITION_WINDOW_X, POSITION_WINDOW_Y);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.DARK_GRAY);

		// Add the warning icon to Dialog Window.
		try
		{
			warning_image = ImageIO.read(new File("src/java_GUI/pic_in_GUI/warning_icon.jpg"));
			this.setContentPane(new Image_Painter(warning_image, WIDTH_WARNING, HEIGHT_WARNING, POSITION_WARNING_X, POSITION_WARNING_Y));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		// Add a JLabel to Message_Window for reminder.
		reminder = new JLabel();
		reminder.setText(message);
		reminder.setSize(WIDTH_REMINDER, HEIGHT_REMINDER);
		reminder.setLocation(POSITION_REMINDER_X, POSITION_REMINDER_Y);
		reminder.setFont(new Font("Courier new", Font.ITALIC + Font.BOLD, FONT_SIZE_REMINDER));
		reminder.setForeground(Color.BLACK);
		reminder.setHorizontalAlignment(JLabel.CENTER);
		this.add(reminder);

		// Add a ok_button to Login_Window.
		ok_button = new JButton("OK");
		ok_button.setToolTipText("CLICK to close the window.");
		ok_button.setSize(WIDTH_OK_BUTTON, HEIGHT_OK_BUTTON);
		ok_button.setLocation(POSITION_OK_BUTTON_X, POSITION_OK_BUTTON_Y);
		ok_button.setFont(new Font("Courier new", Font.ITALIC + Font.BOLD, FONT_SIZE_BUTTON));
		ok_button.setBackground(Color.LIGHT_GRAY);
		ok_button.setForeground(Color.BLACK);
		ok_button.addActionListener(new Listener_For_OK_Button(this));
		this.add(ok_button);
		
		// Make the window visible by default.
		this.setVisible(true);
	}
}
