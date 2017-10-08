import objectdraw.*;
import java.awt.*;

public class TouchWindow extends WindowController
{
	private Location location;
	private FilledRect background = new FilledRect(0,0,canvas.getWidth(),canvas.getHeight(),canvas);
	private Color back = new Color(255,255,255);
	public void begin()
	{
		background.setColor(back);
		FilledRect start;
		start = new FilledRect(10,10,10,10,canvas);
		start.setColor(Color.white);
	}
	public void onMouseExit(Location point)
	{
		
	}
	public void onMousePress(Location pressPoint)
    {
		location = pressPoint;
	}
	// public static void button();
	// {

	// }
}//pongback