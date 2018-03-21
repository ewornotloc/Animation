package animation;
import java.util.Random;

public class Atoms 
	{
/*Finals*/

/*Variables*/
		Random random = new Random();
		private float pos[] = new float[2];
		private float gravity;
		private float accel;
		private float size[] = new float[2];
		private boolean grounded;

/*Constructor*/
		Atoms(){
			pos[0] = -5;
			pos[1] = -5;
			size[0] = 10;
			size[1] = 10;
			accel = (random.nextInt(5)-2);
			gravity = (random.nextInt(20)-10);
			grounded = false;
		};
/*Getters and Setters*/
	/*Positions*/
		public float getPosX(){
			return pos[0];
		};
		public float getPosY(){
			return pos[1];
		};
		public void setPos(float x, float y) {
			pos[0] = x;
			pos[1] = y;
			grounded = false;
		};
		public void setGrounded(boolean bool)
		{
			grounded = bool;
		};
		public void setGrav()
		{
			gravity = (random.nextInt(5)-2);
		}
		public float getSizeX(){
			return size[0];
		};
		public float getSizeY(){
			return size[1];
		};
/*Fake Physics*/
		public void physics(float ground) 
		{
			if (getPosY() >= ground - size[1]){
				grounded = true;
				gravity = (random.nextInt(20)-10);
			};
			if (! grounded) {
				setPos(getPosX()+accel,getPosY()+gravity);
				gravity+=.1;
			};
		};
	};