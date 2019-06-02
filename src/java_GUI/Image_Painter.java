package java_GUI;
import javax.swing.JComponent;
import java.awt.Image;
import java.awt.Graphics;

public class Image_Painter extends JComponent
{
	private Image back_image;
	private int specified_width;
	private int specified_height;
	private int specified_location_x;
	private int specified_location_y;
	
	// Constructor.
	public Image_Painter(Image image, int width, int height, int location_x, int location_y)
	{
		this.back_image = image;
		this.specified_width = width;
		this.specified_height = height;
		this.specified_location_x = location_x;
		this.specified_location_y = location_y;
	}

	// Override the function in JComponent.
	protected void paintComponent(Graphics g)
	{
		// Paint the Image by filling the whole window.
		super.paintComponent(g);
		g.drawImage(back_image.getScaledInstance(specified_width, specified_height, Image.SCALE_SMOOTH), specified_location_x, specified_location_y, this);
	}
}
