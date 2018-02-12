package GAPL_project2;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.ggp.base.player.gamer.statemachine.sample.SampleGamer;
import org.ggp.base.util.statemachine.Move;
import org.ggp.base.util.statemachine.StateMachine;
import org.ggp.base.util.statemachine.exceptions.GoalDefinitionException;
import org.ggp.base.util.statemachine.exceptions.MoveDefinitionException;
import org.ggp.base.util.statemachine.exceptions.TransitionDefinitionException;

public class newerGamer extends SampleGamer {

	@Override
	public Move stateMachineSelectMove(long timeout)
			throws TransitionDefinitionException, MoveDefinitionException, GoalDefinitionException {

		StateMachine theMachine = getStateMachine();

		List<Move> moves = theMachine.getLegalMoves(getCurrentState(), getRole());

		/* we want the new gamer to select a "best" move based on the minimax search
		 * but not a random move */
		int numberOfLegalMoves = moves.size();
		int randomNum = ThreadLocalRandom.current().nextInt(numberOfLegalMoves);
		Move move = moves.get(randomNum);

		return move;
	}
}
