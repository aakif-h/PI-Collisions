package collision;
import collision.Block;
import processing.core.*;

public class CollisionMain extends PApplet {
	//global variables
	int winX;
	int winY;
	int collisionCounter;
	int groundLevel;
	Block block1, block2;
	
	public static void main(String[] args) {
		PApplet.main("collision.CollisionMain");
	}
	
	// initializing canvas
	public void settings() {
		winX = 800;
		winY = 500;
		
		size(winX, winY);
	}
	
	// defining application conditions
	public void setup() {
		collisionCounter = 0;
		groundLevel = winY - 100;
		
		block1 = new Block(100, 0, 10);
		block2 = new Block(500, -2, 1000);
	}
	
	public void draw() {
		drawBackground();
		drawBlock(block1);
		drawBlock(block2);
		
		checkBlockCollision(block1, block2);
		
		checkWallCollision(block1);
		checkWallCollision(block2);		
	}
	
	public void drawBackground() {
		//gray background
		fill(150);
		rect(-1, -1, winX+1, winY+1);
		
		//dark blue floor
		fill(0, 25, 51);
		rect(-1, groundLevel, winX+2, winY - groundLevel);
		
		
		fill(255);
		textAlign(CENTER);
		textSize(18);
		text("Num Collisions: ", winX/2, winY - 50);
		text(collisionCounter, winX/2 + 85, winY - 50);
	}
	
	//to not only draw the Block, but also update the position of the block
	public void drawBlock(Block b) {
		
		fill(76, 153, 0);
		rect(b.getPosition(), groundLevel - b.getWidth(), b.getWidth(), b.getWidth());
		b.setPosition(b.getPosition() + b.getVelocity());
	}
	
	// simulate a perfectly elastic collision (no energy is lost to heat, noise, etc)
	public void checkBlockCollision(Block b1, Block b2) {
		if ( (b1.getPosition() >= b2.getPosition() && b1.getPosition() <= b2.getPosition() + b2.getWidth() ) ||
			 (b1.getPosition() + b1.getWidth() >= b2.getPosition() && b1.getPosition() + b1.getWidth() <= b2.getPosition() + b2.getWidth() ) 
		   ) 
		{
			int[] temp = perfectlyElasticCollision(b1.getVelocity(), b2.getVelocity(), b1.getWidth(), b2.getWidth());
			b1.setVelocity(temp[0]);
			b2.setVelocity(temp[1]);
			collisionCounter++;
		}
	}
	
	public int[] perfectlyElasticCollision(int u1, int u2, int m1, int m2) {
		return new int[] { ( (m1 - m2)*u1 + 2*m2*u2 ) / (m1 + m2) , ( 2*m1*u1 + (m2 - m1)*u2 ) / (m1 + m2) };
	}
	
	// perfectly elastic collision against object of infinite mass (wall)
	public void checkWallCollision(Block b) {
		if (b.getPosition() <= 0 && b.getVelocity() < 0) {
			b.setVelocity(-b.getVelocity());
			collisionCounter++;
		}
	}
	
}
