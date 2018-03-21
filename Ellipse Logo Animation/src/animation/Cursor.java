package animation;

import java.lang.Math;
import processing.core.PApplet;

public class Cursor {
	
	int next = 0;
	public float size[] = new float[2];
	float pos[] = new float[2];
	float cursor[] = new float[2];
	public static double speed = 1;
	PApplet p;
	public Cursor(PApplet p) {
		
		this.p = p;
		size[0] = 200;
		size[1] = 110;
		pos[0] = 595;
		pos[1] = 200;
		
	};
	public float[] pointEllipse(){
		
		cursor[0] = (float) Math.cos(PApplet.radians(next))*size[0]+pos[0];
		cursor[1] = (float) Math.sin(PApplet.radians(next))*size[1]+pos[1];
		if (next>=360)
		{
			next = 0;
		}
		next += speed;
		
		return cursor;
	};
	public double speed(double n) {
		return speed;
	}
	
	
}
