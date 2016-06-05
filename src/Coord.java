
public class Coord {
	private int x;
	private int y;
	//canMove's default state is false.
	private boolean canMove;
//-----------------------------------Constructors
	public Coord(int x, int y, boolean canMove) {
		this.x = x;
		this.y = y;
		this.canMove = canMove;
	}
	public Coord(int x, int y) {
		this.x = x;
		this.y = y;
		this.canMove = false;
	}
	public Coord(boolean canMove) {
		this.canMove = canMove;
	}
//----------------------------------Get Functions
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
//---------------------------------Edit Functions
	public void setX(int dx) {
		if(canMove) {
			this.x = dx;
		} else {
			System.out.println("This coordinate cannot be changed.");
		}
	}
	public void setY(int dy) {
		if(canMove) {
			this.y = dy;
		} else {
			System.out.println("This coordinate cannot be changed.");
		}
	}
	public void translate(int dx, int dy) {
		if (canMove) {
			this.x += dx;
			this.y += dy;
			System.out.println("Point has been moved right " + dx + " units and up " + dy + " units.");
		} else {
			System.out.println("This coordinate cannot be changed.");
		}
	}
//------------------------------------------Other
	public boolean equals(Coord ab) {
		return (this.x == ab.getX() && this.y == ab.getY());
	}
	public String toString() {
		return ("(" + this.x + "," + this.y + ")");
	}
}
