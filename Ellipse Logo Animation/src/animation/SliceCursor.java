package animation;

import java.lang.Math;
import processing.core.PApplet;
import processing.core.PImage;

public class SliceCursor extends Cursor{

	static int slice_n = 1;
	public int this_n;
	public double rot;
	public float stretch[] = new float[2];
	public PImage slice;
	
	public SliceCursor(PApplet p) {
		super(p);
		
		if(slice_n == 1 || slice_n == 3) {
			slice = p.loadImage("res/ellipse_top_slice.png");
		}
		else {
			slice = p.loadImage("res/ellipse_side_slice.png");
		}
		
		if (slice_n == 1 || slice_n == 4)
		{
			rot = Math.PI;
		}
		if (slice_n == 1 || slice_n == 3) {
			size[0] = 180;
			size[1] = 90;
		}
		
		size[0] = 140;
		size[1] = 100;
		
		speed = 5;
		
		next = slice_n++*90;	
		this_n = slice_n;
	}
	
	
	
	
	
	@Override
	public float[] pointEllipse() {
		rot+=Math.toRadians((speed));
		speed +=.01;
//		if (rot >= 2*Math.PI)
//		{
//			rot = 0;
//		}
//		stretch[0] = (float) (Animation.logoSize[0]/4*Math.sin(PApplet.radians(next*2))+Animation.logoSize[0]*3/4);
//		stretch[1] = (float) (Animation.logoSize[1]/4*Math.sin(PApplet.radians(next*2))+Animation.logoSize[1]*3/4);
		if (this_n == 2 || this_n == 4) { ;
			stretch[0] = (float) (Animation.logoSize[0]/6*Math.sin(PApplet.radians(next*2))+Animation.logoSize[0]*5/6);
			stretch[1] = Animation.logoSize[1];
		}
		else {
			stretch[1] = Animation.logoSize[0];
			stretch[0] = (float) (Animation.logoSize[1]/4*Math.sin(PApplet.radians(next*2))+Animation.logoSize[1]*3/4);

		}
		return super.pointEllipse();
	}
	
}
