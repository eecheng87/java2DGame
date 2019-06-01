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

public class Game_Over_Window extends JFrame
{	
	// Size of Game_Over_Window.
	public static final int WIDTH_WINDOW = 600;
	public static final int HEIGHT_WINDOW = 360;

	// Position of Game_Over_Window.
	public static final int POSITION_WINDOW_X = 650;
	public static final int POSITION_WINDOW_Y = 350;

	// The background image.
	private BufferedImage background_image;

	// The game_over_button.
	private JButton game_over_button;
	
	public Game_Over_Window()
	{
		// Set basic property.
		super("You die.");
		this.setSize(WIDTH_WINDOW, HEIGHT_WINDOW);
		this.setLocation(POSITION_WINDOW_X, POSITION_WINDOW_Y);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.DARK_GRAY);

		// Add the background image to Window.
		try
		{
			background_image = ImageIO.read(new File("src/java_GUI/pic_in_GUI/game_over_image.jpg"));
			this.setContentPane(new Image_Painter(background_image, WIDTH_WINDOW, HEIGHT_WINDOW, 0, 0));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		// Add a game_over_button to Window.
		game_over_button = new JButton();
		game_over_button.setToolTipText("CLICK to close the window.");
		game_over_button.setSize(WIDTH_WINDOW, HEIGHT_WINDOW);
		game_over_button.setLocation(0, 0);
		game_over_button.addActionListener(new Listener_For_Game_Over_Button(this));
		game_over_button.setOpaque(false);
		game_over_button.setContentAreaFilled(false);
		game_over_button.setBorderPainted(false);
		this.add(game_over_button);

		// Make the window visible by default.
		this.setVisible(true);
	}
}
