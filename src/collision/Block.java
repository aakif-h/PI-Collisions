package collision;

public class Block {
	private int position, velocity;
	
	public Block() {
		position = 100;
		velocity = 5;
	}
	
	public Block(int p, int v) {
		position = p;
		velocity = v;
	}
	
	public int getPosition() {
		return position;
	}
	
	public int getVelocity() {
		return velocity;
	}
	
	public void setPosition(int p) {
		position = p;
	}
	
	public void setVelocity(int v) {
		velocity = v;
	}
}
