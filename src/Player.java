
public class Player {
	Coord location = new Coord(true);
//-----------------------------------Constructors
	public Player(int x, int y) {
		this.location.setX(x);
		this.location.setY(y);
	}
//----------------------------------Get Functions
	public Coord getLoc() {
		return this.location;
	}
	public int getX() {
		return this.location.getX();
	}
	public int getY() {
		return this.location.getY();
	}
//---------------------------------Edit Functions
	public void move(int x, int y) {
		//Player is moved right x units and up y units.
		this.location.translate(x, y);
	}
	public void teleport(int x, int y) {
		//Player is set to (x,y)
		this.location.setX(x);
		this.location.setY(y);
	}
	public void teleport(Coord c) {
		//Player's location is set to c
		this.location.setX(c.getX());
		this.location.setY(c.getY());
	}
//------------------------------------------Other
	public String where() {
		//Returns a basic (x,y) pair.
		return this.location.toString();
	}
}
