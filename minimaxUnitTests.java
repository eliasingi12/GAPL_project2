package GAPL_project2;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.ggp.base.util.gdl.grammar.Gdl;
import org.ggp.base.util.gdl.grammar.GdlConstant;
import org.ggp.base.util.gdl.grammar.GdlPool;
import org.ggp.base.util.gdl.grammar.GdlTerm;
import org.ggp.base.util.gdl.grammar.GdlVariable;
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

	public static void main(String[] args) throws IOException
    {
		FileInputStream fstream = new FileInputStream("C:\\gdl/tictactoe.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;
		// Game class -> Game g =  Game.getEtheme(strLine)
		// g.getRules()
		// pass to statemachine as description to get tictactoe initialized

		while ((strLine = br.readLine()) != null)   {
			// System.out.println (strLine);
		}

		br.close();

		GdlVariable variables = GdlPool.getVariable("role");
		GdlConstant constants = GdlPool.getConstant("xplayer");

		// System.out.println("\n" + variables);
		// System.out.println("\n" + constants);

    }

	@Test
	public void test() {
		fail("Not yet implemented");
		ArrayList<Gdl> currentState= new ArrayList<Gdl>();

		GdlTerm[] terms  = new GdlTerm[4]; // B� til n�tt Gdl gildi st�r� 4
		terms[0] = GdlPool.getVariable("cell");
		terms[1] = GdlPool.getVariable("1");
		terms[2] = GdlPool.getVariable("1");
		terms[3] = GdlPool.getVariable("x");
		currentState.add(GdlPool.getFunction(GdlPool.getConstant("true"), terms));

		GdlTerm[] terms1  = new GdlTerm[4]; // B� til n�tt Gdl gildi st�r� 4
		terms1[0] = GdlPool.getVariable("cell");
		terms1[1] = GdlPool.getVariable("1");
		terms1[2] = GdlPool.getVariable("2");
		terms1[3] = GdlPool.getVariable("o");
		currentState.add(GdlPool.getFunction(GdlPool.getConstant("true"), terms1));

		GdlTerm[] terms2  = new GdlTerm[4]; // B� til n�tt Gdl gildi st�r� 4
		terms2[0] = GdlPool.getVariable("cell");
		terms2[1] = GdlPool.getVariable("1");
		terms2[2] = GdlPool.getVariable("3");
		terms2[3] = GdlPool.getVariable("o");
		currentState.add(GdlPool.getFunction(GdlPool.getConstant("true"), terms2));

		GdlTerm[] terms3  = new GdlTerm[4]; // B� til n�tt Gdl gildi st�r� 4
		terms3[0] = GdlPool.getVariable("cell");
		terms3[1] = GdlPool.getVariable("2");
		terms3[2] = GdlPool.getVariable("1");
		terms3[3] = GdlPool.getVariable("b");
		currentState.add(GdlPool.getFunction(GdlPool.getConstant("true"), terms3));

		GdlTerm[] terms4  = new GdlTerm[4]; // B� til n�tt Gdl gildi st�r� 4
		terms4[0] = GdlPool.getVariable("cell");
		terms4[1] = GdlPool.getVariable("2");
		terms4[2] = GdlPool.getVariable("2");
		terms4[3] = GdlPool.getVariable("x");
		currentState.add(GdlPool.getFunction(GdlPool.getConstant("true"), terms4));

		GdlTerm[] terms5  = new GdlTerm[4]; // B� til n�tt Gdl gildi st�r� 4
		terms5[0] = GdlPool.getVariable("cell");
		terms5[1] = GdlPool.getVariable("2");
		terms5[2] = GdlPool.getVariable("3");
		terms5[3] = GdlPool.getVariable("b");
		currentState.add(GdlPool.getFunction(GdlPool.getConstant("true"), terms5));

		GdlTerm[] terms6  = new GdlTerm[4]; // B� til n�tt Gdl gildi st�r� 4
		terms6[0] = GdlPool.getVariable("cell");
		terms6[1] = GdlPool.getVariable("3");
		terms6[2] = GdlPool.getVariable("1");
		terms6[3] = GdlPool.getVariable("b");
		currentState.add(GdlPool.getFunction(GdlPool.getConstant("true"), terms6));

		GdlTerm[] terms7  = new GdlTerm[4]; // B� til n�tt Gdl gildi st�r� 4
		terms7[0] = GdlPool.getVariable("cell");
		terms7[1] = GdlPool.getVariable("3");
		terms7[2] = GdlPool.getVariable("2");
		terms7[3] = GdlPool.getVariable("b");
		currentState.add(GdlPool.getFunction(GdlPool.getConstant("true"), terms7));

		GdlTerm[] terms8  = new GdlTerm[4]; // B� til n�tt Gdl gildi st�r� 4
		terms8[0] = GdlPool.getVariable("cell");
		terms8[1] = GdlPool.getVariable("3");
		terms8[2] = GdlPool.getVariable("3");
		terms8[3] = GdlPool.getVariable("b");
		currentState.add(GdlPool.getFunction(GdlPool.getConstant("true"), terms8));

		GdlTerm[] terms9  = new GdlTerm[2]; // B� til n�tt Gdl gildi st�r� 2
		terms9[0] = GdlPool.getVariable("control");
		terms9[1] = GdlPool.getVariable("xplayer");
		currentState.add(GdlPool.getFunction(GdlPool.getConstant("true"), terms9));

		// actionMove = // getLegalMove(s);
		// unitTest = mini_max.Minimax(s,role,actionMove);
		// assert(unitTest, mark(3,3));

	}

}
