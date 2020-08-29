import java.util.ArrayList;
import java.util.Random;

public class Maze {
	
	private ArrayList<Cell> allCells = new ArrayList<Cell>();
	private Cell firstCell;
	private int length;
	private Cell[][] maze;
	private Random rand = new Random();
	
	public Maze(int length) {
		this.length = length;
		constructMaze();
	}
	
	public void constructMaze() {
		maze = new Cell[length][length];
		firstCell = new Cell();
		maze[length-1][0] = firstCell;
		allCells.add(firstCell);
		for (int j=1; j<length; j++) {
			maze[length-1][j] = new Cell();
			allCells.add(maze[length-1][j]);
		}
		for (int i=0; i<length-1; i++) {
			maze[i][0] = new Cell();
			allCells.add(maze[i][0]);
		}
		for (int j=1; j<length; j++) {
			maze[length-2][j] = new Cell();
			allCells.add(maze[length-2][j]);
		}
		for (int i=0; i<length-2; i++) {
			maze[i][1] = new Cell();
			allCells.add(maze[i][1]);
		}
		int randNum = rand.nextInt(4);
		if (randNum == 0) {
			maze[0][0].setExit();
		}else if (randNum == 1) {
			maze[0][1].setExit();
		}else if (randNum == 1) {
			maze[length-2][length-2].setExit();
		}else {
			maze[length-1][length-1].setExit();
		}
		for (int i=0; i<length; i++) {
			for (int j=0; j<length; j++) {
				if (maze[i][j] != null) {
					if (i-1>=0 && maze[i-1][j]!=null){
						maze[i][j].addNeighbour("up",maze[i-1][j]);
					}
					if (i+1<length && maze[i+1][j]!=null){
						maze[i][j].addNeighbour("down",maze[i+1][j]);
					}
					if (j+1<length && maze[i][j+1]!=null){
						maze[i][j].addNeighbour("right",maze[i][j+1]);
					}
					if (j-1>=0 && maze[i][j-1]!=null){
						maze[i][j].addNeighbour("left",maze[i][j-1]);
					}
				}
			}
		}
	}
	
	public Cell getFirstCell() {
		return firstCell;
	}
	
	public ArrayList<Player> createPlayers(int numPlayers) {
		int randNum;
		ArrayList<Player> computerPlayers = new ArrayList<Player>();
		for (int i=0; i<numPlayers; i++) {
			Player newPlayer = new Player();
			randNum = rand.nextInt(allCells.size());
			newPlayer.setCell(allCells.get(randNum));
			allCells.get(randNum).addPlayer(newPlayer);
			computerPlayers.add(newPlayer);
		}
		return computerPlayers;
	}
	
	public void printMaze() {
		for (int i=0; i<length; i++) {
			for (int j=0; j<length; j++) {
				if (maze[i][j] != null) {
					System.out.print(maze[i][j].getNumOfPlayers()+":"+maze[i][j].getExit()+" ");
				}
			}
			System.out.println("");
		}	
	}
	
}
