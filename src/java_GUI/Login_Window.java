package java_GUI;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Login_Window extends JFrame
{
	public boolean is_close;
	
	// Property of Login_Window.
	// Size of Login_Window.
	public static final int WIDTH_WINDOW = 1000;
	public static final int HEIGHT_WINDOW = 600;

	// Position of Login_Window.
	public static final int POSITION_WINDOW_X = 450;
	public static final int POSITION_WINDOW_Y = 200;

	// Property of JTextField for username.
	// TextField for username.
	public JTextField enter_field_username;
	
	// Size of JTextField for username.
	public static final int WIDTH_ENTER_FIELD_USERNAME = 450;
	public static final int HEIGHT_ENTER_FIELD_USERNAME = 50;
	
	// Position of JTextField for username.
	public static final int POSITION_ENTER_FIELD_USERNAME_X = 250;
	public static final int POSITION_ENTER_FIELD_USERNAME_Y = 140;

	// Property of JLabel for username.
	// Label shows the poupose of JTextField.
	public JLabel label_username;	

	// Size of JLabel for username.
	public static final int WIDTH_LABEL_USERNAME = 200;
	public static final int HEIGHT_LABEL_USERNAME = 50;
	
	// Position of JLabel for username.
	public static final int POSITION_LABEL_USERNAME_X = 420;
	public static final int POSITION_LABEL_USERNAME_Y = 100;
	
	// Property of JTextField for password.
	// TextField for password.
	private JTextField enter_field_password;
	
	// Size of JTextField for password.
	public static final int WIDTH_ENTER_FIELD_PASSWORD = 450;
	public static final int HEIGHT_ENTER_FIELD_PASSWORD = 50;
	
	// Position of JTextField for password.
	public static final int POSITION_ENTER_FIELD_PASSWORD_X = 250;
	public static final int POSITION_ENTER_FIELD_PASSWORD_Y = 250;
	
	// Property of JLabel for password.
	// Label shows the poupose of JTextField.
	private JLabel label_password;	

	// Size of JLabel for password.
	public static final int WIDTH_LABEL_PASSWORD = 200;
	public static final int HEIGHT_LABEL_PASSWORD = 50;
	
	// Position of JLabel for password.
	public static final int POSITION_LABEL_PASSWORD_X = 420;
	public static final int POSITION_LABEL_PASSWORD_Y = 210;

	// Font size of the text in JLabel and JTextField.
	public static final int FONT_SIZE = 25;

	// Property of JButton.
	// Button to confirm login.
	private JButton confirm_button;
	
	// Size of JButton.
	public static final int WIDTH_BUTTON = 450;
	public static final int HEIGHT_BUTTON = 50;
	
	// Position of JButton.
	public static final int POSITION_BUTTON_X = 250;
	public static final int POSITION_BUTTON_Y = 360;

	// Constructor.
 	public Login_Window()
	{	
		// Set basic property.
		super("Right-To-Left Mario");
		this.setSize(WIDTH_WINDOW, HEIGHT_WINDOW);
		this.setLocation(POSITION_WINDOW_X, POSITION_WINDOW_Y);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.ORANGE);

		Game_Over_Window window = new Game_Over_Window();

		// Set background image.
		BufferedImage background_image;
		try
		{
			background_image = ImageIO.read(new File("src/java_GUI/pic_in_GUI/mario_background.jpg"));
			this.setContentPane(new Image_Painter(background_image, WIDTH_WINDOW, HEIGHT_WINDOW, 0, 0));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		// Add a JTextField to Login_Window for username.
		enter_field_username = new JTextField("");
		enter_field_username.setToolTipText("Enter your name here...");
		enter_field_username.setSize(WIDTH_ENTER_FIELD_USERNAME, HEIGHT_ENTER_FIELD_USERNAME);
		enter_field_username.setLocation(POSITION_ENTER_FIELD_USERNAME_X, POSITION_ENTER_FIELD_USERNAME_Y);
		enter_field_username.setFont(new Font("Courier new", Font.ITALIC + Font.BOLD, FONT_SIZE));
		this.add(enter_field_username);

		// Add a JLabel to Login_Window for username.
		label_username = new JLabel("USERNAME");
		label_username.setSize(WIDTH_LABEL_USERNAME, HEIGHT_LABEL_USERNAME);
		label_username.setLocation(POSITION_LABEL_USERNAME_X, POSITION_LABEL_USERNAME_Y);
		label_username.setFont(new Font("Courier new", Font.ITALIC + Font.BOLD, FONT_SIZE));
		label_username.setForeground(Color.WHITE);
		this.add(label_username);
		
		// Add a JTextField to Login_Window for password.
		enter_field_password = new JTextField("");
		enter_field_password.setToolTipText("Enter your password here...");
		enter_field_password.setSize(WIDTH_ENTER_FIELD_PASSWORD, HEIGHT_ENTER_FIELD_PASSWORD);
		enter_field_password.setLocation(POSITION_ENTER_FIELD_PASSWORD_X, POSITION_ENTER_FIELD_PASSWORD_Y);
		enter_field_password.setFont(new Font("Courier new", Font.ITALIC + Font.BOLD, FONT_SIZE));
		this.add(enter_field_password);

		// Add a JLabel to Login_Window for password.
		label_password = new JLabel("PASSWORD");
		label_password.setSize(WIDTH_LABEL_PASSWORD, HEIGHT_LABEL_PASSWORD);
		label_password.setLocation(POSITION_LABEL_PASSWORD_X, POSITION_LABEL_PASSWORD_Y);
		label_password.setFont(new Font("Courier new", Font.ITALIC + Font.BOLD, FONT_SIZE));
		label_password.setForeground(Color.WHITE);
		this.add(label_password);

		// Add a JButton to Login_Window.
		confirm_button = new JButton("LOGIN");
		confirm_button.setToolTipText("Make sure your name and password then CLICK");
		confirm_button.setSize(WIDTH_BUTTON, HEIGHT_BUTTON);
		confirm_button.setLocation(POSITION_BUTTON_X, POSITION_BUTTON_Y);
		confirm_button.setFont(new Font("Courier new", Font.ITALIC + Font.BOLD, FONT_SIZE));
		confirm_button.setBackground(Color.GREEN);
		confirm_button.setForeground(Color.DARK_GRAY);
		confirm_button.addActionListener(new Listener_For_Login_Button(enter_field_username, enter_field_password, this));
		this.add(confirm_button);

		// Make the window visible by default.
		this.setVisible(true);
		
		is_close = false;
	}
}


