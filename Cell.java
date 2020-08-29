import java.util.ArrayList;
import java.util.Random;

public class Cell {
	
	private Cell[] neighbourCells = new Cell[4];
	private ArrayList<Player> players = new ArrayList<Player>();
	private boolean exit = false;
	private Random rand = new Random();
	
	public Cell() {}
	
	public void addNeighbour(String place, Cell c) {
		if (place.equals("up")) {
			neighbourCells[0] = c;
		}else if (place.equals("down")) {
			neighbourCells[1] = c;
		}else if (place.equals("right")) {
			neighbourCells[2] = c;
		}else {    							//default is considered to be left  
			neighbourCells[3] = c;
		}
	}
	
	public void setExit() {
		exit = true;
	}
	
	public boolean getExit() {
		return exit;
	}
	
	public void addPlayer(Player p) {
		players.add(p);
	}
	
	public void removePlayer(Player p) {
		players.remove(p);
	}
	
	public Cell getRandomNeighbour() {
		int m = 0;
		for (int i=0; i<4; i++) {
			if (neighbourCells[i] != null) {
				m++;
			}
		}
		int randNum = rand.nextInt(m)+1;
		int index=0;
		for (int i=0; i<4; i++) {
			if (neighbourCells[i] != null) {
				index++;
				if (index == randNum) {
					return neighbourCells[i];
				}
			}
		}
		return null;
	}
	
	public int getNumOfPlayers() {
		return players.size();
	}
	
	public Cell[] getNeighbours() {
		return neighbourCells;
	}
	
	public boolean Battle() {
		int min = 100;
		int index_min = 0;
		if (players.size() > 0) {
			for (int i=0; i<players.size(); i++) {
				if (min > players.get(i).getStrength()) {
					min = players.get(i).getStrength();
					index_min = i;
				}	
			}
			Player p = players.get(index_min);
			players.remove(p);
			return p.getIsHuman();
		}else {
			System.out.println("No players in this cell");
			return false;
		}
	}

}
