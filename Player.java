import java.util.Random;
import java.util.Scanner;

public class Player {
	
	private int strength;
	private Random rand = new Random();
	private Cell myCell;
	Scanner scanner = new Scanner(System. in);
	private boolean isHuman = false;
    
	
	public Player() {
		strength = rand.nextInt(100);
	}
	
	public Player(int strength) {
		this.strength = strength;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public void setIsHuman() {
		isHuman = true;
	}
	
	public boolean getIsHuman() {
		return isHuman;
	}
	
	public void setCell(Cell c) {
		myCell = c;
	}
	
	public Cell getCell() {
		return myCell;
	}
	
	public void computeMove() {
		Cell newCell = myCell.getRandomNeighbour();
		myCell.removePlayer(this);
		myCell = newCell;
		myCell.addPlayer(this);
	}
	
	public void humanMove() {
		Cell[] neighbourCells = myCell.getNeighbours();
		if (neighbourCells[0] != null) {
			System.out.println("up:" + neighbourCells[0].getNumOfPlayers());
		}else {
			System.out.println("up:X");
		}
		if (neighbourCells[1] != null) {
			System.out.println("down:" + neighbourCells[1].getNumOfPlayers());
		}else {
			System.out.println("down:X");
		}
		if (neighbourCells[2] != null) {
			System.out.println("right:" + neighbourCells[2].getNumOfPlayers());
		}else {
			System.out.println("right:X");
		}
		if (neighbourCells[3] != null) {
			System.out.println("left:" + neighbourCells[3].getNumOfPlayers());
		}else {
			System.out.println("left:X");
		}
		System.out.println("Where do you want to go?");
		String inputString = scanner. nextLine();
		if (inputString.equals("up")) {
			if (neighbourCells[0] != null) {
				myCell.removePlayer(this);
				myCell = neighbourCells[0];
				myCell.addPlayer(this);
			}
		}
		if (inputString.equals("down")) {
			if (neighbourCells[1] != null) {
				myCell.removePlayer(this);
				myCell = neighbourCells[1];
				myCell.addPlayer(this);
			}
		}
		if (inputString.equals("right")) {
			if (neighbourCells[2] != null) {
				myCell.removePlayer(this);
				myCell = neighbourCells[2];
				myCell.addPlayer(this);
			}
		}
		if (inputString.equals("left")) {
			if (neighbourCells[3] != null) {
				myCell.removePlayer(this);
				myCell = neighbourCells[3];
				myCell.addPlayer(this);
			}
		}
	}
	
	public boolean reachExit() {
		return myCell.getExit();
	}

}
