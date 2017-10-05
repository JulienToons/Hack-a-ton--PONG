import objectdraw.*;
import java.awt.*;

public class TouchWindow extends WindowController
{
	public void begin()
	{
		EasyReader console = new EasyReader();
		FilledRect joe;
		joe = new FilledRect(10,10,100,200,canvas);
		joe.setColor(Color.blue);
		console.readLine();
	}

}