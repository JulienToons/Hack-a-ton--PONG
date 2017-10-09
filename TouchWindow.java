import objectdraw.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TouchWindow extends WindowController
{
	private BufferedImage pix;
	
	private Location location;
	private FilledRect background = new FilledRect(0,0,canvas.getWidth(),canvas.getHeight(),canvas);
	private Color back = new Color(255,255,255);
	
	public void begin()
	{
		pix = ImageLoader.loadImage("pongback.png");
		
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
	public static double follow(int aiX, int playerX,double maxSpeed, double speedt, double accel)
	{
		speedt= speedt * .7;
		if (speedt >= maxSpeed) speedt = maxSpeed;
		else if(aiX > playerX)speedt=speedt-accel;
		else if(aiX < playerX)speedt=speedt+accel;
		return speedt;
	}
}//pongback