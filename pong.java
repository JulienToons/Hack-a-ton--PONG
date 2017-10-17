import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class pong extends Applet implements KeyListener, MouseListener, MouseMotionListener { //WindowController
	int width, height;
	int N = 25;
	Color[] spectrum;
	Vector listOfPositions;
	String s = "";
	int skip = 0;
	//
	//edit private vareables form here
	private boolean pause;
	private String key;
	private double speedt;
	private double accel;
	private boolean done;
	
	// no ball yet   --> its easy
	
	public void init() { width = getSize().width; height = getSize().height; setBackground( Color.black ); spectrum = new Color[ N ];
		for ( int i = 0; i < N; ++i ) { spectrum[i] = new Color( Color.HSBtoRGB(i/(float)N,1,1) ); }
		listOfPositions = new Vector(); addKeyListener( this ); addMouseListener( this ); addMouseMotionListener( this );
	}
	
	public void begin(){
		pause = false;
		key = " ";
		accel = 1.5;
		speedt = 0;
		done = false;
		//
		// Set stuff up and while loops avec functions
		
		//set pause button to private as well
		//
		while(done == false)
		{
			while( pause == false)
			{
				//hhyhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh
			}
		}
	}
	public void keyPressed( KeyEvent e ) { 
		key = e.paramString(); 
		// keycode stuff look on>  https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html
		if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
			speedt = speedt + accel;
            //Right arrow key code
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
			speedt = speedt - accel;
            //Left arrow key code
		} else if (e.getKeyCode() == KeyEvent.VK_UP ) {
            //Up arrow key code
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
            //Down arrow key code
		} else if (e.getKeyCode() == KeyEvent.VK_E ) {
            //e  key code
			done = true;
		} else if (e.getKeyCode() == KeyEvent.VK_P ) {
			if ( pause == false) pause = true;
			else pause = false;
		}
	}  
	public void keyReleased( KeyEvent e ) 
	{
		key = " ";
	}
	public void keyTyped( KeyEvent e ) {
		char c = e.getKeyChar();
		if ( c != KeyEvent.CHAR_UNDEFINED ) {
			s = s + c;
			repaint();
			e.consume();
		}
	}
	public void mouseEntered( MouseEvent e ) {
		pause = false;
		// show pause button
	}
	public void mouseExited( MouseEvent e ) {
		pause = true;
		// hide pause button
	}
	public void mouseClicked( MouseEvent e ) {
		s = "";
		repaint();
		e.consume();
	}
	public void mousePressed( MouseEvent e ) { }
	public void mouseReleased( MouseEvent e ) { }
	public void mouseDragged( MouseEvent e ) { }
	
	public static double follow(double aiX, double playerX,double maxSpeed, double speedt, double accel)
	{
		
		speedt= speedt * .7;
		if (speedt >= maxSpeed) speedt = maxSpeed;
		else if(aiX > playerX)speedt=speedt-accel;
		else if(aiX < playerX)speedt=speedt+accel;
		return speedt;
	}
	public static double momentum(double maxSpeed, double speedt)
	{
		speedt= (speedt)* .7;
		if (speedt >= maxSpeed) speedt = maxSpeed;
		return speedt;
	}
	
	public void mouseMoved( MouseEvent e ) {
		// only process every 5th mouse event
		if (skip > 0){
			-- skip;// this is shorthand for "skip = skip-1;"
			return;
		} else skip = 5;
		
		if (listOfPositions.size() >= N) {
//code made by Julien Owhadi
			// delete the first element in the list
			listOfPositions.removeElementAt( 0 );
		}
		
		// add the new position to the end of the list
		listOfPositions.addElement( new Point( e.getX(), e.getY() ) );
		
		repaint();
		e.consume();
	}

	public void paint( Graphics g ) { if ( s != "" ) { for ( int j = 0; j < listOfPositions.size(); ++j ) { g.setColor( spectrum[ j ] ); Point p = (Point)(listOfPositions.elementAt(j)); g.drawString( s, p.x, p.y ); } } }  // code by j_uli_en ow_had_i
}