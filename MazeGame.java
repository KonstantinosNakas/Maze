import java.util.ArrayList;
import java.util.Scanner;

public class MazeGame {
	
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System. in);
		System.out.println("Give size of maze:");
		int length = scanner.nextInt();
		Maze maze = new Maze(length);
		Player myPlayer = new Player(50);
		myPlayer.setIsHuman();
		myPlayer.setCell(maze.getFirstCell());
		maze.getFirstCell().addPlayer(myPlayer);
		ArrayList<Player> computerPlayers;
		computerPlayers = maze.createPlayers(4*length);
		while (!myPlayer.reachExit()) {
			for (int i=0; i<computerPlayers.size(); i++) {
				computerPlayers.get(i).computeMove();
			}
			maze.printMaze();
			myPlayer.humanMove();
			if (myPlayer.getCell().Battle()) {
				System.out.println("Player is dead.");
				System.out.println("End of game!");
				System.exit(0);
			}
		}
		System.out.println("Reach in exit point.");
		System.out.println("End of game!");
	}
	
}
