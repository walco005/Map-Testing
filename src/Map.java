import java.util.ArrayList;
import java.util.Random;

public class Map {
	private int min_x;
	private int min_y;
	private int max_x;
	private int max_y;
	private ArrayList<Coord> obstacles = new ArrayList<Coord>();
	private Random rand = new Random();
//-----------------------------------Constructors
	public Map(int min_x, int min_y, int max_x, int max_y) {
		this.min_x = min_x;
		this.min_y = min_y;
		this.max_x = max_x;
		this.max_y = max_y;
	}
	public Map(int min, int max) {
		//Creates a square map
		this.min_x = min;
		this.min_y = min;
		this.max_x = max;
		this.max_y = max;
	}
	public Map(int max) {
		this.min_x = 0;
		this.min_y = 0;
		this.max_x = max;
		this.max_y = max;
	}
//----------------------------------Get Functions
	public int getMinX() {
		return this.min_x;
	}
	public int getMinY() {
		return this.min_y;
	}
	public int getMaxX() {
		return this.max_x;
	}
	public int getMaxY() {
		return this.max_y;
	}
	public ArrayList<Coord> getObs() {
		return this.obstacles;
	}
//---------------------------------Edit Functions
	public void addObs(Coord p) {
		this.obstacles.add(p);
	}
	public void addObs(int x, int y) {
		this.obstacles.add(new Coord(x,y,false));
	}
	public void removeObs(Coord p) {
		this.obstacles.remove(p);
	}
	public void removeObs(int x, int y) {
		this.obstacles.remove(new Coord(x,y,false));
	}
//------------------------------------------Other
	//Two versions of inMap for now, both for different possible purposes.
	public boolean inMap(Coord p) {
		//Checks if Coord p is in the map and can be moved to.
		int x = p.getX();
		int y = p.getY();
		boolean canMove = (this.min_x < x && x < this.max_x && this.min_y < y && y < this.max_y && isObs(p));
		System.out.println("You can move to this point: " + canMove);
		return canMove;
	}
	public boolean inMap(int x, int y) {
		//Checks if (x,y) is in the map and can be moved to.
		boolean canMove = (this.min_x < x && x < this.max_x && this.min_y < y && y < this.max_y && isObs(new Coord(x, y)));
		System.out.println("You can move to this point: " + canMove);
		return canMove;
	}
	public boolean isObs(Coord p) {
		//Checks if p is in the obstacles arraylist.
		for(Coord c : this.obstacles) {
			if (c.equals(p)) return false;
		}
		return true;
	}
	public void genObs(int i) {
		//Generates i obstacles randomly inside the map.
		int j = 0;
		int randX;
		int randY;
		while(j < i) {
			randX = rand.nextInt((max_x - min_x) + 1) + min_x;
			randY = rand.nextInt((max_y - min_y) + 1) + min_y;
			addObs(randX, randY);
			j++;
		}
	}
}
