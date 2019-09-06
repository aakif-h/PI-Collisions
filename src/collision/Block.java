package collision;
import processing.core.*;


public class Block extends PApplet {
	private int position, velocity, width;
	private int winY = 500;
	
	public Block() {
		position = 100;
		velocity = 5;
		width = 10;
	}
	
	public Block(int p, int v, int w) {
		position = p;
		velocity = v;
		width = w;
	}
	
	public int getPosition() {
		return position;
	}
	
	public int getVelocity() {
		return velocity;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setPosition(int p) {
		position = p;
	}
	
	public void setVelocity(int v) {
		velocity = v;
	}
	
	public void setWidth(int w) {
		width = w;
	}
}
