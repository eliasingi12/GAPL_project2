package GAPL_project2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.ggp.base.util.game.Game;
import org.ggp.base.util.gdl.grammar.Gdl;
import org.ggp.base.util.statemachine.MachineState;
import org.ggp.base.util.statemachine.Move;
import org.ggp.base.util.statemachine.StateMachine;
import org.ggp.base.util.statemachine.exceptions.MoveDefinitionException;
import org.ggp.base.util.statemachine.exceptions.TransitionDefinitionException;
import org.ggp.base.util.statemachine.implementation.prover.ProverStateMachine;
import org.junit.Test;

import javafx.util.Pair;

public class minimaxUnitTests {

	/******* Project description
	 * @throws TransitionDefinitionException
	 * @throws MoveDefinitionException *******/
	/* Write down some test cases (e.g., as unit tests) that describe the expected behavior
	 * before you implement the search. For example, take some small games
	 * (e.g., http://ggpserver. general-game-playing.de/ggpserver/public/view_game.jsp?name=tictactoe),
	 * figure out the best move in certain states and write unit tests that checks if your player actually
	 *  finds the same moves. Don’t forget that your player may play different roles in the game
	 *  (not always the first one)! Don’t forget to test games with different numbers of roles,
	 *  games with and without simultaneous moves, etc.*/

	@Test
	public void test() throws MoveDefinitionException, TransitionDefinitionException {

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
					if(!strLine.startsWith(";")) {
						sb.append(strLine).append("\n");
					}
					strLine = br.readLine();
				}
				br.close();
				String gd = sb.toString();
				gd = gd.replaceAll("[\n]+","\n");
				System.out.println(gd);

				Game g = Game.createEphemeralGame(gd);
				List<Gdl> rules = g.getRules();
				System.out.println(rules);
				StateMachine s = new ProverStateMachine();
				s.initialize(rules);
				MachineState ms = s.getInitialState();
				System.out.println(ms);
				Pair<Integer, Move> p = mini_max.MaxValue(ms,s.getRoles().get(0), s);
				assert(p.getKey() == scores[i]);
			}

		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
