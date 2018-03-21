package animation;

import processing.core.PApplet;
import processing.core.PImage;

public class Animation extends PApplet
	{	
	
	/*
	 * Initial declarations
	 */
	
		final int atom_count = 200;
		
		Atoms[] atoms = new Atoms[atom_count];
		SliceCursor[] slices = new SliceCursor[4];
		Colors colors = new Colors();
		Cursor cursor = new Cursor(this);
		PImage logo;
		static float[] logoSize = {400,400};
		
		double rot = 0.01f;
		int next = 0;
		static boolean grav = false;
		public int[] screensize = {1200,600};
		
		public void setup() 
		{
			for (int n = 0; n < atom_count; n++) {
				atoms[n] = new Atoms();
			};
			for (int n = 0; n < 4; n++) {
				slices[n] = new SliceCursor(this);
			};
			logo = loadImage("res/ellipse_number.png");
			
		};
		
		public void settings()
		{
			size(screensize[0], screensize[1]);
			smooth(4);
		};
		
		public void draw()
		{
			background(colors.offWhite);
			if (grav)
			{ 
				for (int n = 0; n < atom_count; n++) 
				{
					pushMatrix();
					translate(atoms[n].getPosX(), atoms[n].getPosY());
					rot = rot + .001f;
					rotate((float)rot);
					noStroke();
					fill(colors.primaryPurple);
					rect(0-atoms[n].getSizeX()/2,0-atoms[n].getSizeY()/2,atoms[n].getSizeX(),atoms[n].getSizeY());
					if (grav)
					{
						atoms[n].physics(screensize[1]+atoms[n].getSizeY()+10);
					};
					popMatrix();
				}
			
			};
			
			image(logo,400,80,logoSize[0],logoSize[1]);
			if (! grav) 
			{
				for (int n = 0; n < atom_count; n++)
					if (next >= atom_count)
					{next = 0;};
					atoms[next].setPos(cursor.pointEllipse()[0],cursor.pointEllipse()[1]);
					atoms[next].setGrav();
					next++;	
				for (int n = 0; n < 4; n++) {
					slices[n].pointEllipse();
					pushMatrix();
					pushStyle();
					translate(slices[n].cursor[0], slices[n].cursor[1]);
					rotate((float)slices[n].rot);
					imageMode(CENTER);
					image(slices[n].slice,0,0,slices[n].stretch[0],slices[n].stretch[1]);
					popStyle();
					popMatrix();
				}
			};
			
			
		};
		
		public void mousePressed()
		{
			if (grav == true)
			{
				grav = false;
				return;
			};
			grav = true;
			
		};
		public void keyPressed() {
			if (key == 'c')
			{
				if (next >= atom_count)
					{next = 0;};
				atoms[next].setPos(mouseX,mouseY);
				next++;
			}
		};	
		
		/*
		 * Methods for making
		 * processing methods 
		 * compatible with int[]
		 */

		public void fill(int[] colors)
		{
			fill(colors[0],colors[1],colors[2]);
		}
		
		public void background(int[] colors)
		{
			background(colors[0],colors[1],colors[2]);
		}
		
		/*
		 * Useless main
		 */
		
		public static void main(String[] args)
		{
			String[] processingArgs = {"Animation"};
			Animation Animation = new Animation();
			PApplet.runSketch(processingArgs, Animation);
		};
	};
