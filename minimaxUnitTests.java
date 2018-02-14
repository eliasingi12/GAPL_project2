package GAPL_project2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.ggp.base.util.game.Game;
import org.ggp.base.util.statemachine.MachineState;
import org.ggp.base.util.statemachine.StateMachine;
import org.ggp.base.util.statemachine.implementation.prover.ProverStateMachine;
import org.junit.Test;

public class minimaxUnitTests {

	/******* Project description *******/
	/* Write down some test cases (e.g., as unit tests) that describe the expected behavior
	 * before you implement the search. For example, take some small games
	 * (e.g., http://ggpserver. general-game-playing.de/ggpserver/public/view_game.jsp?name=tictactoe),
	 * figure out the best move in certain states and write unit tests that checks if your player actually
	 *  finds the same moves. Don’t forget that your player may play different roles in the game
	 *  (not always the first one)! Don’t forget to test games with different numbers of roles,
	 *  games with and without simultaneous moves, etc.*/

	@Test
	public void test() {

		try {
			String prefix = System.getProperty("user.dir") + "/src/main/java/GAPL_project2/";
			String[] games = new String[] {prefix + "tictactoeXwin.txt"};
			int[] scores = new int[] {100};

			for(int i = 0; i < games.length; i++) {
				FileInputStream fstream = new FileInputStream(games[i]);
				BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
				String strLine = br.readLine();
				StringBuilder sb = new StringBuilder();
				while (strLine != null) {
					sb.append(strLine);
					strLine = br.readLine();
				}
				br.close();

				Game g = Game.createEphemeralGame(sb.toString());
				StateMachine s = new ProverStateMachine();
				MachineState ms = s.getInitialState();

				//Pair<Integer, Move> p = mini_max.Minimax(ms,s.getRoles().get(0));
				//assert(p.getKey() == scores[i]);
			}

		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
