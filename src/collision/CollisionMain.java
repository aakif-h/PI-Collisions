package collision;
import collision.Block;
import processing.core.*;

public class CollisionMain extends PApplet {
	int winX = 800;
	int winY = 500;
	int groundLevel = winY - 100;
	Block block1, block2;
	
	public static void main(String[] args) {
		PApplet.main("collision.CollisionMain");
	}
	
	public void settings() {
		size(winX, winY);
	}
	
	public void setup() {
		block1 = new Block();
		block2 = new Block();
	}
	
	public void draw() {
		clear();
		drawBackground();
		drawBlock(block1);
		//block2.drawBlock();
		
		//checkBlockCollision(block1, block2);
		
		checkWallCollision(block1);
		//checkWallCollision(block2);
		
	}
	
	public void drawBackground() {
		//dark blue floor
		fill(0, 25, 51);
		rect(-1, groundLevel, winX+2, winY - groundLevel);
	}
	
	public void drawBlock(Block b) {
		
		fill(76, 153, 0);
		rect(b.getPosition(), groundLevel - b.getWidth(), b.getWidth(), b.getWidth());
		b.setPosition(b.getPosition() + b.getVelocity());
	}
	
	// simulate a perfectly elastic collision (no energy is lost to heat, noise, etc)
	public void checkBlockCollision(Block b1, Block b2) {
		if (b1.getPosition() <= b2.getPosition() - b1.getWidth() ||
			b2.getPosition() <= b1.getPosition() - b2.getWidth() ) {
			int[] temp = perfectlyElasticCollision(b1.getVelocity(), b2.getVelocity(), b1.getWidth(), b2.getWidth());
			b1.setVelocity(temp[0]);
			b2.setVelocity(temp[1]);
		}
	}
	
	public int[] perfectlyElasticCollision(int u1, int u2, int m1, int m2) {
		return new int[] { ( (m1 - m2)*u1 + 2*m2*u2 ) / (m1 + m2) , ( 2*m1*u1 + (m2 - m1)*u2 ) / (m1 + m2) };
	}
	
	// perfectly elastic collision against object of infinite mass (wall)
	public void checkWallCollision(Block b) {
		if (b.getPosition() <= 0 || b.getPosition() + b.getWidth() >= winX) {
			b.setVelocity(-b.getVelocity());
		}
	}
	
}
