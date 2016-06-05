import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	public static Map currentMap;
	public static void main(String[] args) {
		Map map = new Map(0, 0, 100, 100);
		Player Xman = new Player(0, 0);
		map.addObs(4, 5);
		map.addObs(10,4);
		map.addObs(100, 100);
		move(map, Xman, 100, 100);
		teleport(map, Xman, new Coord(10, 10));
		teleport(map, Xman, new Coord(1000, 1000));
	}
	
	
	public static void move(Map m, Player p, int x, int y) {
		//Checks if player can move right x units and up y units and if it can it does.
		Coord attemptCoord = new Coord(p.getX() + x, p.getY() + y);
		System.out.println("Moving Player to: " + attemptCoord.toString());
		if(m.inMap(attemptCoord)) {
			p.move(x, y);
		}
		System.out.println("Player is at: " + p.getLoc().toString());
	}
	public static void teleport(Map m, Player p, Coord c) {
		//Checks if player can teleport to coord c and does if it can.
		System.out.println("Moving Player to: " + c.toString());
		if(m.inMap(c)) {
			p.teleport(c);
		}
		System.out.println("Player is at: " + p.getLoc().toString());
	}
}

